public class Attributes {

    public String name;
    public long noOfMovies;
    public long total;
    public long average;

    public Attributes(String name, long noOfMovies, long total, long average){
        this.name = name;
        this.noOfMovies = noOfMovies;
        this.total = total;
        this.average = average;
    }


    public void incrementNumberOfMovies() {
        noOfMovies++;
    }

    public void incrementTotal(long revenue){
        total+= revenue;
    }

    public void calculateAverage(){
        average = total / noOfMovies;
    }


}
