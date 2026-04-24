package java_learn.seven;

public class MethodLearning {
    public void publicMethod() {
        System.out.println("this is public method");
    }

    private void privateMethod() {
        System.out.println("this is private method");
    }

    protected void protectedMethod() {
        System.out.println("this is protected method");
    }

    final void defaultMethod() {
        System.out.println("this is default method");
    }

    static final int heyTakeThis = 12;

    static final int abcd(int a, int b) {
        return a + b;
    }
}

/*
 * public: can be accessed from anywhere
 * private: can only be accessed within the same class
 * protected: can be accessed within the same package and by subclasses
 * default: can be accessed within the same package
 */
