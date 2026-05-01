package java_learn.six;

import java_learn.seven.MethodLearning;

public interface CreatingInterfacePerson {
    void eat();
    void sleep();
}

class BC{
    int ac = 45;
}

class CreatingINterfaceStudent extends MethodLearning implements CreatingInterfacePerson {

    private static final int a = 10;
    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    

    
    
    @Override
    public void eat() {
        BC df = new BC(){
            
        };
        int as = df.ac;
        System.out.println("Student is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Student is sleeping");
    }
}
