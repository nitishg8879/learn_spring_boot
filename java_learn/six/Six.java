package java_learn.six;

import java_learn.seven.MethodLearning;

//? once the string is created it's immutable 
public class Six {

    static final int x = 10; // this is a constant variable, it cannot be changed
    public static void main(String[] args) {
        MethodLearning methodLearning = new MethodLearning();
        methodLearning.publicMethod(); // this is allowed
        String str1 = "Hello"; // create string literal
        String str2 = "Hello"; // reuse string literal from string pool
        String str3 = new String("Hello"); // create new string object
        System.out.println(str1.equals(str3)); // here checking the value of the string
        System.out.println(str1 == str3); // here checking the refrecen

        int a[] = new int[3];
        int b[] = new int[5];

        // Six.x = 20; // this will throw a compile-time error because x is final

        int d = Integer.valueOf(2);

        b[6] = 10; // this will throw ArrayIndexOutOfBoundsException

        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        CreatingInterfacePerson cr = new CreatingINterfaceStudent();
        cr.eat();
    }
}
