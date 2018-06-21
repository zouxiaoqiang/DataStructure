package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoq
 * @date 18-6-20
 */
public class ImplementStackUsingQueues {
    private static class MyStack {
        private Queue<Integer> s;
        private Queue<Integer> tmpS;

        private void swap() {
            Queue<Integer> t = s;
            s = tmpS;
            tmpS = t;
        }

        /** Initialize your data structure here. */
        public MyStack() {
            s = new LinkedList<>();
            tmpS = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            s.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (s.size() > 1) {
                tmpS.add(s.remove());
            }
            int res = s.remove();
            swap();
            return res;
        }

        /** Get the top element. */
        public int top() {
            if (empty()) {
                return 0;
            }
            while (s.size() > 1) {
                tmpS.add(s.remove());
            }
            int res = s.peek();
            tmpS.add(s.remove());
            swap();
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return s.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }
}
