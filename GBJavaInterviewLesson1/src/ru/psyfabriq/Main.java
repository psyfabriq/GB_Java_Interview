package ru.psyfabriq;

import ru.psyfabriq.exeption.BuilderExeption;
import ru.psyfabriq.part1.Person;
import ru.psyfabriq.part3.Circle;
import ru.psyfabriq.part3.CompoundShape;
import ru.psyfabriq.part3.Dot;
import ru.psyfabriq.part3.Rectangle;
import ru.psyfabriq.part3.Triangle;

public class Main {

	public static void main(String[] args) {
		//Part 1
		try {
			Person p = Person.getBuilder()
					.setFirstName("Ilia")
					.setLastName("Podstavkov")
					.setPhone("89999883267")
					.build();
			System.out.println(p.toString());
			Person.getBuilder(p).setAge(29).build();
			System.out.println(p.toString()); 
		} catch (BuilderExeption e) {
			e.printStackTrace();
		}
		
		//Part 2
		
		
		
		//Part 3
		
		CompoundShape figure = new  CompoundShape();
		
		figure.add(new Circle(2,3,10));
		figure.add(new Rectangle(20,34,10,10));
		figure.add(new Triangle(new Dot(50, 10),new Dot(60, 50),new Dot(70, 70))); // не точные показания (((
		
		figure.paint();
		
	}

}
