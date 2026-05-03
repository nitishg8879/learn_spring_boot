package java_learn;
import sun.misc.Unsafe;

public class TestHashcodeAndEquals {
    public static void main(String[] args) {
        Pen pen1 = new Pen(10, "red");
        Pen pen2 = new Pen(10, "red");
        System.out.println(pen1);
        System.out.println(pen2);
        System.out.println(pen1.equals(pen2));
        System.out.println(pen1 == pen2);
    }
}


class Pen{
    int price;
    String color;

    Pen(int price, String color){
        this.price = price;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Pen pen = (Pen) obj;
        return price == pen.price && color.equals(pen.color);
    }

    @Override
    public int hashCode() {
        return price + color.hashCode();
    }
}