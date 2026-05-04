public interface INterfaceTest {
    // void test();
    default void test() {
        System.out.println("A1");
    }
}

interface A1 extends INterfaceTest {
    void test();
    // default void test2() {
    //     System.out.println("A1");
    // }
}

class A2 implements A1 {
}

class Test {
    public static void main(String[] args) {
        A2 a2 = new A2();
        a2.test();
    }
}