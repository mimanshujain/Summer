package CTC.StackQueue;
import java.util.Stack;
import java.util.Iterator;

public class StackSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackSorting test = new StackSorting();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(31);
		stack.push(13);
		stack.push(76);
		stack.push(32);
		stack.push(23);
		stack.push(43);
		stack.push(54);
		stack.push(22);
		
		test.print(stack);
		test.print(test.sortStack(stack));
		
	}
	
	public Stack<Integer> sortStack(Stack<Integer> stack){
		if(stack.size() == 0) return stack;		
		Stack<Integer> buffer = new Stack<Integer>();
		buffer.push(stack.pop());
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			
			if(top < buffer.peek()){
				while(!buffer.isEmpty() && buffer.peek() > top)
					stack.push(buffer.pop());
			}
			buffer.push(top);			
		}
		
		return buffer;
	}
	
	public void print(Stack<Integer> stack){
		Iterator<Integer> it = stack.iterator();
		while(it.hasNext())
			System.out.print(it.next()+"-");
		System.out.println();
	}

}
