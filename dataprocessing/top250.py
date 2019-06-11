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
    index_end= r.text.find("\n", index_start)
    budget= r.text[index_start+index_add:index_end]
    # print(budget)
    gross_revenue_string = "Cumulative Worldwide Gross:</h4> $"
    index_add= len(gross_revenue_string)
    index_start = r.text.find("Cumulative Worldwide Gross:</h4> $")
    index_end= r.text.find("\n", index_start)
    gross_revenue= r.text[index_start+index_add:index_end]
    # print(gross_revenue)
    return budget, gross_revenue



class MovieData:
    def __init__(self, cast, director, genre, gross_revenue, budget):
        self.cast = cast
        self.director = director
        self.genre = genre
        self.gross_revenue = gross_revenue
        self.budget = budget

counter = 0
top250 = ia.get_top250_movies()
for entry in top250:
    list_of_actors = []
    name_of_director= ""
    movie = ia.get_movie(entry.movieID)
    summary = movie.summary()
    cast = movie.get('cast')
    director = movie.get('director')
    genre = movie.get('genre')
    movie_id = movie.get('movieID')
    print()
    #budget, gross_revenue = get_money(movie_id)
    break
    for person in cast:
        name_of_actor = person.get('name')
        list_of_actors.append(name_of_actor)
    for person in director:
        name_of_director = person.get('name')

    movie_for_saving = MovieData(list_of_actors[:15],name_of_director, genre, gross_revenue, budget)
    with open('data{}.json'.format(counter), 'w') as outfile:
        file_text = json.dumps(movie_for_saving.__dict__, indent=4)
        outfile.write(file_text)
    counter += 1
