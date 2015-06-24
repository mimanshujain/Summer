package Stack;

public class StackQueue {

}

class Stack {
    Queue q1, q2;
    
    public Stack(){
        q1 = new Queue();
        q2 = new Queue();
    }
    // Push element x onto stack.
    public void push(int x) {
        q1.enqueue(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(empty()) return;
        
        while(true)
        {
            int val = q1.dequeue();
            if(q1.peek() != -1)
                q2.enqueue(val);
            else
            {
                Queue temp = q1;
                q1 = q2;
                q2 = temp;
                break;
            }
        }
    }

    // Get the top element.
    public int top() {
        return q1.top();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.empty();
    }
}

class Queue{
    Node front;
    Node rear;
    public Queue()
    {
        front = null;
        rear = null;
    }
    public void enqueue(int val)
    {
        Node temp = new Node(val);
        if(empty()){
            rear = temp;
            front = rear;
            return;
        }
        rear.next = temp;
        rear = temp;
    }
    public int dequeue()
    {
        if(empty()){
            return -1;
        }
        int val = front.val;
        front = front.next;
        return val;
    }
    
    public boolean empty()
    {
        return rear == null;
    }
    public int peek()
    {
        if(empty()) return -1;
        
        return front.val;
    }
    
    public int top() {
        if(empty()) return -1;
        return rear.val;
    }
}

class Node {
    int val;
    Node next = null;
    public Node(int val)
    {
        this.val = val;
    }
}
