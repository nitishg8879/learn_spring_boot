package java_learn;
public class SealedPermitTest {
    
}

/*

                        Shape
                       /     \
                    Circle   Square
                               \
                               Cube
*/

sealed class Shape permits Circle, Square {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

final class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

non-sealed class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}

final class Cube extends Square {
    
}
