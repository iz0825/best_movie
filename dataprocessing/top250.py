import imdb
import json
import requests

ia = imdb.IMDb()

def get_money(movieID):
    url = "https://www.imdb.com/title/tt" + movieID + "/"
    r = requests.get(url)
    budgetstring = "Budget:</h4>$"
    index_add = len(budgetstring)
    index_start = r.text.find("Budget:</h4>$")
    if index_start == -1:
        budget = 0
        gross_revenue = 0
        return budget, gross_revenue
    number_start = index_start+index_add
    index_end= number_start
    while True:
        if r.text[index_end] != "." and r.text[index_end] != "," and not r.text[index_end].isdigit():
            break
        index_end +=1
    budget= r.text[number_start:index_end]
    # print(budget)
    gross_revenue_string = "Cumulative Worldwide Gross:</h4> $"
    index_add= len(gross_revenue_string)
    index_start = r.text.find("Cumulative Worldwide Gross:</h4> $")
    if index_start == -1:
        gross_revenue_string ="Gross USA:</h4> $"
        index_start = r.text.find("Gross USA:</h4> $")
        if index_start== -1:
            gross_revenue = 0
            return budget, gross_revenue
        index_add = len(gross_revenue_string)
    number_start = index_start+index_add
    index_end= number_start
    while True:
        if r.text[index_end] != "." and r.text[index_end] != "," and not r.text[index_end].isdigit():
            break
        index_end +=1
    gross_revenue= r.text[number_start:index_end]
    # print(gross_revenue)
    return budget, gross_revenue



class MovieData:
    def __init__(self, movie_name, cast, director, genre, gross_revenue, budget):
        print(movie_name,gross_revenue, budget, director, genre,cast )
        self.MovieName = movie_name
        self.Cast = cast
        self.Director = director
        self.Genres = genre
        self.GrossRevenue = int(gross_revenue.replace(",",""))
        self.Budget = int(budget.replace(",",""))
        self.NetRevenue = self.GrossRevenue - self.Budget


counter = 0
top250 = ia.get_bottom100_movies()
for entry in top250:
    list_of_actors = []
    name_of_director= ""
    movie = ia.get_movie(entry.movieID)
    movie_title= movie.get('title')
    summary = movie.summary()
    cast = movie.get('cast')
    director = movie.get('director')
    genre = movie.get('genre')
    movie_id = movie.movieID
    budget, gross_revenue = get_money(movie_id)
    if gross_revenue == 0:
        continue
    for person in cast:
        name_of_actor = person.get('name')
        list_of_actors.append(name_of_actor)
    for person in director:
        name_of_director = person.get('name')
    movie_for_saving = MovieData(movie_title, list_of_actors[:15],name_of_director, genre, gross_revenue, budget)
    with open('bottomdata/data{}.json'.format(counter), 'w') as outfile:
        file_text = json.dumps(movie_for_saving.__dict__, indent=4)
        outfile.write(file_text)
    counter += 1
