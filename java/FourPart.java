package java;

public class FourPart {
    
}

class A {

    public static void main(String[] args) {
        // B b = new B();
        // b.invoke();
        Employee e = new Employee();
        Employee e2 = new Employee();
        e.member = 10;
        e.member = 20;
        Employee.staticMember = 30;
    }
}

class B {
    Integer d;
    byte c;

    void invoke() {
        System.out.println(c);
        System.out.println(d);
    }
}


class Employee {
    int member; // member variable
    static int staticMember; // class variable or static variable

    void localmethod() {
        int localVariable = 1; // local variable
    }
}