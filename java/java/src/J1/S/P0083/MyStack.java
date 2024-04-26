package J1.S.P0083;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    public void push(T value) {
        stackValues.add(value);
    }

    public T pop() {
        if (!isEmpty()) {
            int lastIndex = stackValues.size() - 1;
            T value = stackValues.get(lastIndex);
            stackValues.remove(lastIndex);
            return value;
        } else {
            return null; // Stack is empty
        }
    }

    public T get() {
        if (!isEmpty()) {
            int lastIndex = stackValues.size() - 1;
            return stackValues.get(lastIndex);
        } else {
            return null; // Stack is empty
        }
    }

    public boolean isEmpty() {
        return stackValues.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // Push values onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Get and print the top value of the stack
        Integer topValue = stack.get();
        System.out.println("Top value: " + topValue);

        // Pop values from the stack
        Integer poppedValue = stack.pop();
        System.out.println("Popped value: " + poppedValue);

        // Get the new top value
        topValue = stack.get();
        System.out.println("Top value after pop: " + topValue);
    }
}