package java_learn.fourteen;

public interface InterfaceStaticMethodTest {
    default void method1(){}// possible in java 8 and above
    private void method2(){ // pssoible in java 9 and above
        System.out.println("Private method in InterfaceStaticMethodTest");
    }
    static void method3() { // possible in java 8 and above
        System.out.println("Static method in InterfaceStaticMethodTest");
    }
    static int a = 10; 
    int b = 20;// default it's public static final
    // private static int b = 10; // only public static final fields are allowed in interface

    void method4(); // abstract method, must be implemented by the class implementing the interface
}


@FunctionalInterface
interface TestFunctionalInterface {
    void method1();


}
