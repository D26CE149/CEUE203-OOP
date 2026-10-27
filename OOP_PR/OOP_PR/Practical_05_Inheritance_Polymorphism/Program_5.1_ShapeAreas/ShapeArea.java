abstract class Area
{
    String shape;

    Area(String name)
    {
        this.shape = name;
    }

    abstract double calculatearea();
};

class Circle extends Area
{
    int r;

    Circle(String name, int radius)
    {
        super(name);
        this.r = radius;
    }

    @Override
    double calculatearea() {
        return 3.14 * r * r;
    }
};

class Rectangle extends Area
{
    int l, b;

    Rectangle(String name, int length, int breadth)
    {
        super(name);
        this.l = length;
        this.b = breadth;
    }

    @Override
    double calculatearea() {
        return l * b;
    }
};

class Triangle extends Area
{
    int h, w;

    Triangle(String name, int height, int width)
    {
        super(name);
        this.h = height;
        this.w = width;
    }

    @Override
    double calculatearea() {
        return (h * w * 0.5);
    }
};

public class ShapeArea
{
    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter number of shapes: ");
        int count = scanner.nextInt();

        Area[] shapes = new Area[count];

        for (int i = 0; i < count; i++)
        {
            System.out.print("Enter shape (circle, rectangle, triangle): ");
            String shape = scanner.next().toLowerCase();

            switch (shape)
            {
                case "circle":
                    System.out.print("Enter radius: ");
                    shapes[i] = new Circle("circle", scanner.nextInt());
                    break;

                case "rectangle":
                    System.out.print("Enter length and breadth: ");
                    shapes[i] = new Rectangle("rectangle", scanner.nextInt(), scanner.nextInt());
                    break;

                case "triangle":
                    System.out.print("Enter height and width: ");
                    shapes[i] = new Triangle("triangle", scanner.nextInt(), scanner.nextInt());
                    break;

                default:
                    System.out.println("Invalid shape. Try again.");
                    i--;
            }
        }

        double totalArea = 0;

        for (Area a : shapes)
        {
            System.out.println("Class name :- " + a.getClass().getSimpleName());
            System.out.println("Area :- " + a.calculatearea());
            totalArea = totalArea + a.calculatearea();
            System.out.println();
        }

        System.out.println("Total Area :- " + totalArea);

        scanner.close();
    }
}
