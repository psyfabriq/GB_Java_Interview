package ru.psyfabriq.part2;


abstract class Car {
    public Engine engine; // В домашнем задание не было объекта Engine (первая ошибка)
    private String color;
    private String name;
    
    protected void start(){
        System.out.println("Car starting");
    }
    
    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
