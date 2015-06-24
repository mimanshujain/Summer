package CTC.StackQueue;
import java.util.Queue;
import java.util.LinkedList;

public class AnimalQueue {

	Queue<Dog> dogQ;
	Queue<Cat> catQ;
	int order;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public AnimalQueue(){
		dogQ = new LinkedList<Dog>();
		catQ = new LinkedList<Cat>();
		order = 0;
	}
	
	public Animal getAnyAnimal(){
		
		if(dogQ.size() == 0) return catQ.poll();
		if(catQ.size() == 0) return dogQ.poll();
		
		Dog d = dogQ.peek();
		Cat c = catQ.peek();
		
		if(d.isOlderThan(c))
			return dogQ.poll();
		return catQ.poll();
	}	
	
	public void addAnimal(Animal a){
		a.setOrder(order++);
		
		if(a instanceof Dog) dogQ.add((Dog)a);
		else catQ.add((Cat)a);
	}

}

abstract class Animal{
	String name;
	int order;
	public Animal(String name){
		this.name = name;
	}	
	
	public boolean isOlderThan(Animal a){
		return this.order > a.order;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public int getOrder(){
		return order;
	}
}

class Dog extends Animal{

	public Dog(String name) {
		super(name);		
	}
	
}

class Cat extends Animal{

	public Cat(String name) {
		super(name);
	}
	
}
