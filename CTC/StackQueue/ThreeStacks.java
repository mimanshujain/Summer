package CTC.StackQueue;

public class ThreeStacks {

	int[] buffer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStacks test = new ThreeStacks();
		Stack stack = test.new Stack(4,3);
		stack.push(2, 1);
		stack.push(5, 2);
		stack.push(4, 3);
		stack.push(4, 1);
		stack.push(1, 3);
		stack.push(3, 3);
		stack.push(3, 2);
		
		stack.print(1);
		stack.print(2);
		stack.print(3);
		stack.pop(1);
		stack.print(1);
		stack.pop(2);
		stack.print(2);
		stack.pop(3);
		stack.print(3);
	}

	class Stack{
		int[] top;
		int size;
		int num;
		public Stack(int size, int num){
			this.num = num;
			this.size = size;
			buffer = new int[num*size];
			top = new int[num];
			for(int i = 0; i < top.length; i++){
				top[i] = i*size;
			}
		}
		
		private boolean push(int val, int stackNum){
			if(stackNum > num || stackNum <= 0) return false;
			int pointer = top[stackNum-1];
			if(isFull(stackNum))	return false;
			buffer[pointer] = val;
			top[stackNum-1] = pointer+1;
			return true;
		}
		
		private int pop(int stackNum){
			if(stackNum > num || stackNum <= 0) return -2;
			int pointer = top[stackNum-1];
			if(isEmpty(stackNum)) return -1;
			int result = buffer[pointer-1];
			top[stackNum-1] = pointer - 1;
			return result;
		}
		
		private int peek(int stackNum){
			if(stackNum > num || stackNum <= 0) return -2;
			if(isEmpty(stackNum)) return -1;
			return buffer[top[stackNum-1]-1];
		}
		
		private void print(int stackNum){
			if(stackNum > num || stackNum <= 0) return;
			if(isEmpty(stackNum)) System.out.println("Stack is Empty");
			else{
				for(int i = (stackNum-1)*size; i < top[stackNum-1]; i++)
					System.out.print(buffer[i]+"-");
			}
			System.out.println();
		}
		
		private boolean isFull(int stackNum){
			return top[stackNum-1] >= stackNum*size;
		}
		private boolean isEmpty(int stackNum){
			return top[stackNum-1] == (stackNum-1)*size;
		}
	}
}
