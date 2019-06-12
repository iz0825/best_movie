public class Movie {
    public String MovieName;
    public String[] Cast;
    public String Director;
    public String[] Genres;
    public Number Budget;
    public Number GrossRevenue;
    public Number NetRevenue;


    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String[] getCast() {
        return Cast;
    }

    public void setCast(String[] cast) {
        Cast = cast;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String[] getGenres() {
        return Genres;
    }

    public void setGenres(String[] genres) {
        Genres = genres;
    }

    public Number getBudget() {
        return Budget;
    }

    public void setBudget(Number budget) {
        Budget = budget;
    }

    public Number getGrossRevenue() {
        return GrossRevenue;
    }

    public void setGrossRevenue(Number grossRevenue) {
        GrossRevenue = grossRevenue;
    }

    public Number getNetRevenue() {
        return NetRevenue;
    }

    public void setNetRevenue(Number netRevenue) {
        NetRevenue = netRevenue;
    }

    Movie(){

    }



}
