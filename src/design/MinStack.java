package design;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if ( minStack.isEmpty() ) {
            minStack.push(x);
        } else {
            if ( minStack.peek() >= x ) {
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals( minStack.peek()) ) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
    }
}
