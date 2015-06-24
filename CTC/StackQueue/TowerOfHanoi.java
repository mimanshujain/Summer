package CTC.StackQueue;
import java.util.Iterator;
import java.util.Stack;

public class TowerOfHanoi {

	Tower[] tower;
	public static void main(String[] args) {
		TowerOfHanoi test = new TowerOfHanoi(4);
		System.out.println();
		test.print(test.tower[2]);
	}
	public TowerOfHanoi(int numDisk){
		tower = new Tower[3];
		for(int i = 0; i < 3; i++)
			tower[i] = new Tower();
		
		for(int i = numDisk; i > 0; i--)
			tower[0].push(i);
		
		print(tower[0]);
		tower[0].moveDisk(numDisk, tower[1], tower[2]);
	}
	
	public void print(Tower t){
		Iterator<Integer> it = t.stack.iterator();
		
		while(it.hasNext())
			System.out.print(it.next()+"-");		
		System.out.println(t.stack.peek());//To see the top of Stackf
	}

	class Tower{
		Stack<Integer> stack;
		
		public Tower(){
			stack = new Stack<Integer>();
		}
		
		public void moveDisk(int n, Tower buffer, Tower destination){
			if(n <= 0) return;
			moveDisk(n-1, destination, buffer);
			moveToTop(destination);
			buffer.moveDisk(n-1, this, destination);
		}
		
		public void moveToTop(Tower destination){
			if(!stack.isEmpty()){
				destination.push(stack.pop());
			}
		}
		public void push(int disk){
			if(!stack.isEmpty() && stack.peek() <= disk)
				System.out.println("Cant push "+disk+" disk over "+stack.peek());
			else
				stack.push(disk);
		}
		
	}
	

}
