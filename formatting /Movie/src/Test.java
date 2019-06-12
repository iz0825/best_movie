import java.io.FileReader;
import java.util.*;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Test {



    private class Compare implements Comparator<Attributes> {

        private final Compare instance = new Compare();

        public Compare getInstance() {
            return instance;
        }

        @Override
        public int compare(Attributes o1, Attributes o2) {
            return (-1) * Long.compare(o1.average, o2.average);
        }
    }

    static ArrayList<Movie> ListOfMovies = new ArrayList<>();

    static public Movie makeObject(JSONObject movie){
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


    static public String[] jsonArrayToNormalArray(JSONArray array){
        String[] stringsArray = new String[array.size()];

        for (int i = 0; i < stringsArray.length; i++) {
            stringsArray[i] = array.get(i).toString();
        }
        return stringsArray;
    }

    public void go() throws Exception{
        String fileNamePrefix = "src/data/data";
        String fileNameSuffix = ".json";
        String finalFileName;


        for(int i = 0; i < 194;i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder = stringBuilder.append(fileNamePrefix);
            stringBuilder = stringBuilder.append(i);
            stringBuilder = stringBuilder.append(fileNameSuffix);
            finalFileName = stringBuilder.toString();


            Object object = new JSONParser().parse(new FileReader(finalFileName));
            JSONObject movie = (JSONObject) object;


            Movie makeMovie = makeObject(movie);
            ListOfMovies.add(makeMovie);
        }

        Test test = new Test();
        ArrayList<String> List = new ArrayList<String>();
        List.add("Drama");
        test.filterbyGenres(List);

    }


    public ArrayList<String> filterbyGenres(ArrayList<String> genreList) {
        HashMap<String, Attributes> actorMap = new HashMap<>();
        ArrayList<String> arraylistOfActors = new ArrayList<>();
        ArrayList<Attributes> temp = new ArrayList<>();

        for (Movie movie : ListOfMovies) {
            Boolean flag = false;

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
        System.out.println(Arrays.toString(temp.toArray()));

        Comparator<Attributes> compare = new Comparator<Attributes>() {
            @Override
            public int compare(Attributes o1, Attributes o2) {
                return (-1) * Long.compare(o1.average, o2.average);
            }
        };

        temp.sort(compare);

        for (Attributes attribute : temp) {
            arraylistOfActors.add(attribute.name);
            System.out.println(attribute.average);
        }
        //System.out.println(Arrays.toString(arraylistOfActors.toArray()));

        return arraylistOfActors;
    }
            //return an ArrayList of Actor names sorted



    public static void main(String[] args) throws Exception{
        new Test().go();





    }

}

