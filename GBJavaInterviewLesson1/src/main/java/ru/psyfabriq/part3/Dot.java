package ru.psyfabriq.part3;

public class Dot extends BaseShape {
	private final int DOT_SIZE = 0;

	public Dot(int x, int y) {
		super(x, y);
	}

	@Override
	public int getWidth() {
		return DOT_SIZE;
	}

	@Override
	public int getHeight() {
		return DOT_SIZE;
	}

	@Override
	public void paint() {
		
	}
}
