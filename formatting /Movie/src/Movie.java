public class Movie {
    public String MovieName;
    public String[] Cast;
    public String Director;
    public String[] Genres;
    public long Budget;
    public long GrossRevenue;
    public long NetRevenue;


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

    public long getBudget() {
        return Budget;
    }

    public void setBudget(long budget) {
        Budget = budget;
    }

    public long getGrossRevenue() {
        return GrossRevenue;
    }

    public void setGrossRevenue(long grossRevenue) {
        GrossRevenue = grossRevenue;
    }

    public long getNetRevenue() {
        return NetRevenue;
    }

    public void setNetRevenue(long netRevenue) {
        NetRevenue = netRevenue;
    }

    Movie(){

    }



}
