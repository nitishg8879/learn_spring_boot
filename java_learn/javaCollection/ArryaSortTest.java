package java_learn.javaCollection;

import java.util.Arrays;

public class ArryaSortTest {
    public static void main(String[] args) {
        int i = 0;
        int[] arr = { 5, 2, 8 };
        for (i = 0; i < 3; i++) {
            System.out.println(arr[i]); // ArrayIndexOutOfBoundsException
        }
        // i=3
        // Arrays.sort(arr);
        // System.out.print(Arrays.toString(arr));
        // Car[] cars = {new Car("BMW"), new Car("Audi"), new Car("Mercedes")};
        // Arrays.sort(cars);
        // for (Car car : cars) {
        // System.out.println(car.getName());
        // }
    }
}

class Car implements Comparable<Car> {
    private String name;

    public String getName() {
        return name;
    }

    Car(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return this.name.compareTo(o.name);
    }
}
