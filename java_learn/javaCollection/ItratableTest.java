package java_learn.javaCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItratableTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Iterator<String> iterator = list.iterator();
        // System.out.println("Itrating using iterator:");
        // while (iterator.hasNext()) {
        //     list.add("2");
        //     System.out.println(iterator.next());
        // }

        // System.out.println("Itrating using for-each loop:");
        // for (String string : list) {
        //     System.out.println(string);
        // }
        System.out.println("Itrating using for loop:");    
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.add("2");
        }
    }
}
