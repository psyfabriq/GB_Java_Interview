package ru.psyfabriq.part3;

public class Rectangle extends BaseShape{
    public int width;
    public int height;
    
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void paint() {
        super.paint();
        System.out.println("########Rectangle########");
        System.out.printf("X : %s%n", x);
        System.out.printf("Y : %s%n", y);
        System.out.printf("Width : %s%n", getWidth());
        System.out.printf("Height : %s%n", getHeight());
    }
}
