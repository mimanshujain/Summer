package CTC.StackQueue;
import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	ArrayList<Stack<Integer>> list;
	int currentSize = 0;
	int threashold = 3;
	
	public static void main(String[] args) {
		SetOfStacks test = new SetOfStacks();
		test.push(1);
		test.push(3);
		test.push(2);		
		test.push(4);
		System.out.println(test.pop());
		System.out.println(test.pop());
		test.push(5);
		test.push(3);
		test.push(6);
		test.push(7);
		test.push(8);
		System.out.println(test.pop());
		System.out.println(test.pop());
	}
	public SetOfStacks(){
		list = new ArrayList<Stack<Integer>>();
	}
	
	public void push(int value){
		if(currentSize == 0)
		{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(value);
			list.add(stack);
			currentSize++;			
		}
		else{
			Stack<Integer> stack = list.get(currentSize-1);
			if(stack.size() == threashold){
				stack = new Stack<Integer>();
				stack.push(value);
				list.add(stack);
				currentSize++;
				return;
			}
			stack.push(value);
		}
	}

	public int pop(){
		if(currentSize == 0)
			return Integer.MAX_VALUE;
		
		Stack<Integer> stack = list.get(currentSize-1);
		if(stack.isEmpty()){
			list.remove(currentSize-1);
			currentSize--;
			return pop();
		}
		
		return stack.pop();
	}
	
	public int popAt(int index){
		if(index < 0 || index > currentSize-1)
			return Integer.MAX_VALUE;
		
		Stack<Integer> stack = list.get(index);
		if(stack.isEmpty()) return Integer.MAX_VALUE;
		return stack.pop();
	}

}
