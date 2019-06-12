import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Test {

    static ArrayList<Movie> ListOfMovies = new ArrayList<>();

    public Movie makeObject(JSONObject movie){
        Movie movieObject = new Movie();


        JSONArray Cast = (JSONArray) movie.get("Cast");
        String [] CastArray = jsonArrayToNormalArray(Cast);
        JSONArray Genres = (JSONArray) movie.get("Genres");
        String [] GenreArray = jsonArrayToNormalArray(Genres);



        String MovieName = (String) movie.get("MovieName");
        String Director = (String) movie.get("Director");

        Number Budget = (Number) movie.get("Budget");
        Number GrossRevenue = (Number) movie.get("GrossRevenue");
        Number NetRevenue = (Number) movie.get("NetRevenue");


        movieObject.setMovieName(MovieName);
        movieObject.setCast(CastArray);
        movieObject.setDirector(Director);
        movieObject.setGenres(GenreArray);
        movieObject.setBudget(Budget);
        movieObject.setGrossRevenue(GrossRevenue);
        movieObject.setNetRevenue(NetRevenue);

        System.out.println("Movie Name: " + movieObject.getMovieName());
        System.out.println("Cast: " + Arrays.toString(movieObject.getCast()));
        System.out.println("Director: " + movieObject.getDirector());
        System.out.println("Genres: " + Arrays.toString(movieObject.getGenres()));
        System.out.println("Budget: " + movieObject.getBudget());
        System.out.println("GrossRevenue: " + movieObject.getGrossRevenue());
        System.out.println("NetRevenue: " + movieObject.getNetRevenue());


        return movieObject;
    }


    static public String[] jsonArrayToNormalArray(JSONArray array){
        String[] stringsArray = new String[array.size()];

        for (int i = 0; i < stringsArray.length; i++) {
            stringsArray[i] = array.get(i).toString();
        }
        return stringsArray;
    }



    public static void main(String[] args) throws Exception{

        String fileNamePrefix = "src/data";
        String fileNameSuffix = ".json";
        String finalFileName;


        for(int i = 0; i < 3;i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder = stringBuilder.append(fileNamePrefix);
            stringBuilder = stringBuilder.append(i);
            stringBuilder = stringBuilder.append(fileNameSuffix);
            finalFileName = stringBuilder.toString();


            Object object = new JSONParser().parse(new FileReader(finalFileName));
            JSONObject movie = (JSONObject) object;


            Test test = new Test();
            Movie makeMovie = test.makeObject(movie);
            ListOfMovies.add(makeMovie);

        }

    }

}

