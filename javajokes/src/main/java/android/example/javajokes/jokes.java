package android.example.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class jokes {

    private static String[] jokes={"joke 1", "joke2", "joke 3", "joke 4"};
    private static int i=0;
    public static String  getJoke(){
        if(i>=jokes.length){
            i=0;
        }
        return jokes[i++];
    }

/*  private static List<String> list=asList("joke 1",
            "joke2",
            "joke 3",
            "joke 4");

    public static String getJoke() {

        Random random=new Random(  );
        String joke=list.get(random.nextInt(list.size()) );

        return joke ;
    }*/
}
