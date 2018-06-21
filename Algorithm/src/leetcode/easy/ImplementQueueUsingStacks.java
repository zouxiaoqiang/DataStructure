package leetcode.easy;

import java.util.Stack;

/**
 * @author xiaoq
 * @date 18-6-21
 */
public class ImplementQueueUsingStacks {
    private class MyQueue {
        private Stack<Integer> pushS;
        private Stack<Integer> popS;

        /** Initialize your data structure here. */
        public MyQueue() {
            pushS = new Stack<>();
            popS = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushS.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (popS.isEmpty()) {
                while (!pushS.isEmpty()) {
                    popS.push(pushS.pop());
                }
            }
            return popS.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (popS.isEmpty()) {
                while (!pushS.isEmpty()) {
                    popS.push(pushS.pop());
                }
            }
            return popS.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushS.isEmpty() && popS.isEmpty();
        }
    }
}
