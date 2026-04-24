package java_learn.six;

import java_learn.seven.MethodLearning;

public interface CreatingInterfacePerson {
    void eat();
    void sleep();
}

class CreatingINterfaceStudent extends MethodLearning implements CreatingInterfacePerson {
    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    

    
    
    @Override
    public void eat() {
        System.out.println("Student is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Student is sleeping");
    }
}
