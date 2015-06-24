package CTC.StackQueue;
import java.util.Stack;

@SuppressWarnings("serial")
public class MinStack2 extends Stack<Integer>{
	Stack<Integer> minStack;
	
	public static void main(String[] args) {
		MinStack2 test = new MinStack2();
		test.push(2);
		test.push(3);
		System.out.println(test.min());
		test.push(1);
		test.push(4);
		System.out.println(test.min());
		test.pop(); test.pop();
		System.out.println(test.min());
		test.pop(); test.pop();
		System.out.println(test.min());
	}
	public MinStack2(){
	    minStack = new Stack<Integer>();
	}
	private void push(int value){
		if(value <= min())
		    minStack.push(value);
	    super.push(value);
	}
	
	public Integer pop(){
	    Integer result = super.pop();
	    if(result == min())
	        minStack.pop();
        return result;
	}
	
	private int min(){
	    if(minStack.isEmpty())
	        return Integer.MAX_VALUE;
        else
            return minStack.peek();
	}

}

