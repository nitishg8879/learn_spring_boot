 public class TenTest1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("The sum of a and b is: " + c);
    }
}

class InnerTenTest1 extends TenTest1 implements InnerTenTest1_1 {

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }
    

}


 interface InnerTenTest1_1 {

    void display();

    default void sayHello(){
        System.out.println("Hello from InnerTenTest1_1 interface!");
    }
}