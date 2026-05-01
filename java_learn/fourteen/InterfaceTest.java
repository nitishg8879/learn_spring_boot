package java_learn.fourteen;

public interface InterfaceTest {

}

interface InterfaceTest333{}
interface InterfaceTest3331{}
interface InterfaceTest3332{}

interface InterfaceTest333223 extends InterfaceTest333, InterfaceTest3331, InterfaceTest3332 {

}


interface InterfaceTest2 {
    int a = 10;// deafult field are static and final

    void method1();

    default void method2() {
        System.out.println("Default method in InterfaceTest2");
    }
}

interface InterfaceTest3 {

    int rt = 90;

    private void method3() {
        System.out.println("Private method in InterfaceTest3");
    }
    default void method2() {
        method3();
        System.out.println("Default method in InterfaceTest3");
    }

    static void method4() {
        method5();
        System.out.println("Static method in InterfaceTest3");
    }

    private static void method5() {
        System.out.println("Private static method in InterfaceTest3");
    }

    void method1();


}



class Test55 implements InterfaceTest3{

    @Override
    public void method1() {
        int jh = rt;
        throw new UnsupportedOperationException("Unimplemented method 'method1'");
    }

}

// interface InnerInterfaceTest4 implements InterfaceTest2, InterfaceTest3 {
// }/// Can't

class InterfcaeImplTest implements InterfaceTest2 {

    

    @Override
    public void method1() {
        // new InterfaceTest2(); // can't create object of interface
        InterfaceTest2 as = new InterfcaeImplTest();// can hold the reference of interface
        method2();
        System.out.println(a);
        System.out.println(InterfaceTest2.a); // defult field are static and final
        // InterfaceTest2.a = 4;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'method1'");
    }

}