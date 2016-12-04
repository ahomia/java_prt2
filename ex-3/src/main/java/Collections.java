import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahomia on 27.11.2016.
 */
public class Collections {
    public static void main(String args[]){
        String[] langs= new String[4];
        langs[0]="mama0";
        langs[1]="mama1";
        langs[2]="mama2";
        langs[3]="mama3";

        List<String> languages=new ArrayList<String>();
        languages.add("Java");
        for(String l: langs){
            System.out.println(l);
        }
    }

}
