package ru.psyfabriq.part3;

 abstract class BaseShape implements Shape{
	 
	    public int x;
	    public int y;
	    
	    BaseShape(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    
		@Override
		public int getX() {
			return x;
		}
		@Override
		public int getY() {
			return y;
		}
		@Override
		public int getWidth() {
			return 0;
		}
		@Override
		public int getHeight() {
			return 0;
		}
		@Override
		public boolean isInsideBounds(int x, int y) {
	        return x > getX() && x < (getX() + getWidth()) &&
	                y > getY() && y < (getY() + getHeight());
		}
		@Override
		public void paint() {
			// TODO Auto-generated method stub
			
		}
	    
}
