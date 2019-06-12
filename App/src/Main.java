import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {

  private static ArrayList<Movie> ListOfMovies = new ArrayList<>();

  public static Movie makeObject(JSONObject movie){
    Movie movieObject = new Movie();


    JSONArray Cast = (JSONArray) movie.get("Cast");
    String [] CastArray = jsonArrayToNormalArray(Cast);
    JSONArray Genres = (JSONArray) movie.get("Genres");
    String [] GenreArray = jsonArrayToNormalArray(Genres);



    String MovieName = (String) movie.get("MovieName");
    String Director = (String) movie.get("Director");

    long Budget = (long) movie.get("Budget");
    long GrossRevenue = (long) movie.get("GrossRevenue");
    long NetRevenue = (long) movie.get("NetRevenue");


    movieObject.setMovieName(MovieName);
    movieObject.setCast(CastArray);
    movieObject.setDirector(Director);
    movieObject.setGenres(GenreArray);
    movieObject.setBudget(Budget);
    movieObject.setGrossRevenue(GrossRevenue);
    movieObject.setNetRevenue(NetRevenue);
/*
        System.out.println("Movie Name: " + movieObject.getMovieName());
        System.out.println("Cast: " + Arrays.toString(movieObject.getCast()));
        System.out.println("Director: " + movieObject.getDirector());
        System.out.println("Genres: " + Arrays.toString(movieObject.getGenres()));
        System.out.println("Budget: " + movieObject.getBudget());
        System.out.println("GrossRevenue: " + movieObject.getGrossRevenue());
        System.out.println("NetRevenue: " + movieObject.getNetRevenue());

*/
    return movieObject;
  }


  public static String[] jsonArrayToNormalArray(JSONArray array){
    String[] stringsArray = new String[array.size()];

    for (int i = 0; i < stringsArray.length; i++) {
      stringsArray[i] = array.get(i).toString();
    }
    return stringsArray;
  }

  public static void go() throws Exception{
    String fileNamePrefix = "App/src/data/data";
    String fileNameSuffix = ".json";
    String finalFileName;


    for(int i = 0; i < 194;i++) {
      StringBuilder stringBuilder = new StringBuilder(fileNamePrefix);
      stringBuilder.append(i);
      stringBuilder.append(fileNameSuffix);
      finalFileName = stringBuilder.toString();


      Object object = new JSONParser().parse(new FileReader(finalFileName));
      JSONObject movie = (JSONObject) object;


      Movie makeMovie = makeObject(movie);
      ListOfMovies.add(makeMovie);
    }
  }


  public static ArrayList<String> filterbyGenres(List<String> genreList) {
    HashMap<String, Attributes> actorMap = new HashMap<>();
    ArrayList<String> arraylistOfActors = new ArrayList<>();
    ArrayList<Attributes> temp = new ArrayList<>();

    for (Movie movie : ListOfMovies) {
      boolean flag = false;

      for (String movieGenre : movie.getGenres()) {
        if (genreList.contains(movieGenre)) {
          flag = true;
          break;
        }
      }

      if (flag) {
        for (String Cast : movie.getCast()) {
          if (actorMap.containsKey(Cast)) {
            actorMap.get(Cast).incrementNumberOfMovies();
            actorMap.get(Cast).incrementTotal(movie.getNetRevenue());
            actorMap.get(Cast).calculateAverage();

          } else {
            Attributes attribute = new Attributes(Cast, 1, movie.getGrossRevenue(), movie.getGrossRevenue());
            actorMap.put(Cast, attribute);

          }
        }
      }

    }

    for (Map.Entry<String, Attributes> entry : actorMap.entrySet()) {
      temp.add(entry.getValue());
    }

    Comparator<Attributes> compare = (o1, o2) -> (-1) * Long.compare(o1.average, o2.average);

    temp.sort(compare);

    for (Attributes attribute : temp) {
      arraylistOfActors.add(attribute.name);
    }

    return arraylistOfActors;
  }

  public static void main(String[] args) throws Exception {
    go();

    App window = new App();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
