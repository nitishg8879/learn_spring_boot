package java_learn.four;

public class A {
    public static void main(String[] args) {
        String str1 = "Hello"; // create string literal
        String str2 = "Hello"; // reuse string literal from string pool
        String str3 = new String("Hello"); // create new string object
        System.out.println(str1.equals(str2));
    }
}