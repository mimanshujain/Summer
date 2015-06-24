package CTC.StackQueue;
import java.util.Stack;

public class QueueOfStack {

	Stack<Integer> sNew;
	Stack<Integer> sOld;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueOfStack test = new QueueOfStack();
		test.enqueue(2);
		test.enqueue(3);
		System.out.println(test.dequeue());
		test.enqueue(7);
		test.enqueue(1);
		test.enqueue(6);
		test.enqueue(4);
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.peek());
	}
	public QueueOfStack(){
		sNew = new Stack<Integer>();
		sOld = new Stack<Integer>();
	}
	
	public void enqueue(int value){
		if(sOld.isEmpty())
			shiftToOld();
		
		sNew.push(value);
	}
	
	private void shiftToOld(){
		while(!sNew.isEmpty()){
			sOld.push(sNew.pop());
		}
	}
	
	public int dequeue(){
		if(!sOld.isEmpty())
			return sOld.pop();
		else if(!sNew.isEmpty())
			shiftToOld();
		return sOld.pop();
	}
	
	public int peek(){
		if(!sOld.isEmpty()) return sOld.peek();
		return Integer.MAX_VALUE;
	}

}
