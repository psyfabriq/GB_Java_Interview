package ru.psyfabriq.part3;

public class Circle extends BaseShape  {
    public int radius;
    
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }
    
    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    @Override
    public void paint() {
        super.paint();
        System.out.println("########Circle########");
        System.out.printf("X : %s%n", x);
        System.out.printf("Y : %s%n", y);
        System.out.printf("Width : %s%n", getWidth());
        System.out.printf("Height : %s%n", getHeight());
        System.out.printf("Radius : %s%n", radius);


        //graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }
}
