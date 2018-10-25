package ru.psyfabriq.part2;

//class Lorry extends Car, Moveable, Stopable { // Пытаемся унаследоваться от интерфейсов Moveable, Stopable  (вторя ошибка)
class Lorry extends Car implements Moveable, Stopable {
	
	public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }

    
	@Override  // не был реализован абстракный метод родительского класа Car
	void open() {
		System.out.println("Car is open");
		
	}


}
