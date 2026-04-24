package java_learn.seven;

public class Method2Learning {
    public static void main(String[] args) {
        MethodLearning methodLearning = new MethodLearning();
        methodLearning.publicMethod(); // this is allowed
        // methodLearning.privateMethod(); // this is not allowed, it will throw a compile-time error
        methodLearning.protectedMethod(); // this is not allowed, it will throw a

        methodLearning.defaultMethod();
    }
}
