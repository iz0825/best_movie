import imdb
import json

ia = imdb.IMDb()


class MovieData:
    def __init__(self, cast, director, genre, gross_revenue, budget):
        self.cast = cast
        self.director = director
        self.genre = genre
        self.gross_revenue = gross_revenue
        self.budget = budget

counter =0
top250 = ia.get_top250_movies()
for entry in top250:
    list_of_actors = []
    name_of_director= ""
    movie = ia.get_movie(entry.movieID)
    summary = movie.summary()
    cast = movie.get('cast')
    director = movie.get('director')
    genre = movie.get('genre')
    for person in cast:
        name_of_actor = person.get('name')
        list_of_actors.append(name_of_actor)
    for person in director:
        name_of_director = person.get('name')

    movie_for_saving = MovieData(list_of_actors[:10],name_of_director, genre, 0, 0)
    with open('data{}.json'.format(counter), 'w') as outfile:
        file_text = json.dumps(movie_for_saving.__dict__, indent=4)
        outfile.write(file_text)
    counter += 1
