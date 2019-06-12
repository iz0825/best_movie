import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Test {

    static ArrayList<Movie> ListOfMovies;


    public Movie makeObject(JSONObject movie){
        Movie movieObject = new Movie();

        String Movie_Name = (String) movie.get("Movie_Name");
        String Actors = (String) movie.get("Actors");
        String Directors = (String) movie.get("Directors");


        movieObject.setMovie_name(Movie_Name);
        movieObject.setActors(Actors);
        movieObject.setDirector(Directors);

        System.out.println(movieObject.getMovie_name());
        System.out.println(movieObject.getActors());

        return movieObject;


    }



    public static void main(String[] args) throws Exception{
        Object object = new JSONParser().parse(new FileReader("src/test_file.txt"));
        JSONObject movie = (JSONObject) object;
        Test test = new Test();
        ListOfMovies.add(test.makeObject(movie));


    }

}

