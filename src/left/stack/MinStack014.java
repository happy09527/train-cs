package left.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ZhangX
 * @createDate: 2024/11/3
 * @description: 最小栈https://leetcode.cn/problems/min-stack/
 */
public class MinStack014 {
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    Deque<Integer> in ;
    Deque<Integer> minDeque ;
    public MinStack() {
        in = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    public void push(int val) {
        in.push(val);
        if(minDeque.size()== 0 || val < minDeque.peek()) {
            minDeque.push(val);
        } else {
            minDeque.push(minDeque.peek());
        }
    }

    public void pop() {
        in.pop();
        minDeque.pop();
    }

    public int top() {
        return in.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}

class MinStack1 {
    int[] in ;
    int[] minDeque ;
    int size = 0;
    public MinStack1() {
        in = new int[10000];
        minDeque = new int[10000];
    }

    public void push(int val) {
        in[size] = val;
        if( size == 0 || val < minDeque[size-1]) {
            minDeque[size] = val;
        }else {
            minDeque[size] = minDeque[size-1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return in[size-1];
    }

    public int getMin() {
        return minDeque[size-1];
    }
}