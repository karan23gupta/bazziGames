import java.util.LinkedList;
import java.util.Queue;

class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        queue1.offer(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Get the last element from queue1 (top of the stack)
        int poppedValue = queue1.poll();

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Get the last element from queue1 (top of the stack)
        int topValue = queue1.peek();

        // Move the element to queue2
        queue2.offer(queue1.poll());

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topValue;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top of the stack: " + stack.peek());  // Output: 30

        stack.pop();
        System.out.println("Top of the stack after pop: " + stack.peek());  // Output: 20

        stack.push(40);

        System.out.println("Is stack empty? " + stack.isEmpty());  // Output: false

        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after pops? " + stack.isEmpty());  // Output: true
    }
}
