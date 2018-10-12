package ru.psyfabriq.part3;

public class Triangle extends BaseShape {
	public int width;
	public int height;
	private Dot a, b, c;

	public Triangle( Dot a, Dot b, Dot c) {
		super((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
		this.a = a;
		this.b = b;
		this.c = c;
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
		System.out.println("########Triangle########");
		System.out.printf("X : %s%n", x);
		System.out.printf("Y : %s%n", y);
		System.out.printf("Width : %s%n", getWidth());
		System.out.printf("Height : %s%n", getHeight());
	}
}
