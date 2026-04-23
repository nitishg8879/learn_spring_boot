package java_learn.six;

public interface CreatingInterfacePerson {
    void eat();
    void sleep();
}

class CreatingINterfaceStudent implements CreatingInterfacePerson {
    @Override
    public void eat() {
        System.out.println("Student is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Student is sleeping");
    }
}
