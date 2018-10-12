package ru.psyfabriq.part3;

public interface Shape {
	
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public boolean isInsideBounds(int x, int y);
    public void paint();

}
