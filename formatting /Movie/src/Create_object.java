import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Create_object{

    ArrayList<Movie> ListOfMovies;

public ArrayList<Movie> createListOfMovies(String json) {
    ListOfMovies = new ArrayList<Movie>();
    Gson g = new Gson();
    Movie movie = g.fromJson(json, Movie.class);
    ListOfMovies.add(movie);
    return ListOfMovies;

}


public String readFile(String filename) throws IOException{
    BufferedReader reader = new BufferedReader(new FileReader(filename));
  // BufferedReader reader = Files.newBufferedReader(Paths.get("filename"));
    String line = null;
    StringBuilder stringBuilder = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
    }

    return stringBuilder.toString();
}

public static void main(String [] arg){

    Create_object object = new Create_object();
    try {
        String jsonAsString = object.readFile("src/test_file.txt");
       System.out.println(object.createListOfMovies(jsonAsString));


    }
    catch (IOException e){
        System.out.println(e.getStackTrace());
    }

}

}
