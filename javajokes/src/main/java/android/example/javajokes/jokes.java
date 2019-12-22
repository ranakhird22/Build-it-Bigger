package android.example.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class jokes {
    List<String> list=asList("joke 1",
            "joke2",
            "joke 3",
            "joke 4");

    public String getJoke() {

        Random random=new Random(  );
        String joke=list.get(random.nextInt(list.size())  );

        return joke ;
    }
}
