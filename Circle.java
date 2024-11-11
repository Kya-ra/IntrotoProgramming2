//
// Note that this file must contain only one public class

import java.lang.Math;

interface GeometricObject {
    public abstract double getPerimeter();

    public abstract double getArea();
}

interface Resizable {
    public abstract void resize(int percent);

}

class ResizableCircle extends Circle implements Resizable
{
    private static double radius;
    public ResizableCircle(double radius) {
        super(radius);
        ResizableCircle.radius = radius;
    }
    public void resize(int percent) {
        double scale = (double) (100 - percent) /100;
        ResizableCircle.radius *= scale;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

}

public class Circle implements GeometricObject {
    private static double radius;

    public Circle(double radius) {
        Circle.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }

   public static void main(String[] args) {
        Circle circle = new Circle(100);

       System.out.println("Perimeter of the circle is " + circle.getPerimeter());
       System.out.println("Area of the circle is " + circle.getArea());
       System.out.println();

       ResizableCircle resizedCircle = new ResizableCircle(100);
        resizedCircle.resize(10);

        System.out.println("Perimeter of the resized circle is " + resizedCircle.getPerimeter());
        System.out.println("Area of the resized circle is " + resizedCircle.getArea());
    }


}
