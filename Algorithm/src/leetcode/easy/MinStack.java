package leetcode.easy;

import java.util.Stack;

/**
 * @author xiaoq
 * @date 18-6-6
 */
class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(s.peek())) {
            minStack.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
