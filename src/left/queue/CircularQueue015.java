package left.queue;

/**
 * @author: ZhangX
 * @createDate: 2024/11/3
 * @description: 双端队列、循环队列https://leetcode.cn/problems/design-circular-deque/
 * 数组实现
 * **
 * * Your MyCircularDeque object will be instantiated and called as such:
 * * MyCircularDeque obj = new MyCircularDeque(k);
 * * boolean param_1 = obj.insertFront(value);
 * * boolean param_2 = obj.insertLast(value);
 * * boolean param_3 = obj.deleteFront();
 * * boolean param_4 = obj.deleteLast();
 * * int param_5 = obj.getFront();
 * * int param_6 = obj.getRear();
 * * boolean param_7 = obj.isEmpty();
 * * boolean param_8 = obj.isFull();
 * @description:
 * @param: ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * @return:
 * @date: 2024/11/3 23:35
 */
public class CircularQueue015 {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(2);
        obj.insertFront(7);

        obj.deleteLast();
        obj.insertLast(5);
        obj.insertFront(0);
        System.out.println(obj.getRear());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.getRear());
    }
}

class MyCircularDeque {
    int[] deque;
    int size, head, tail;

    public MyCircularDeque(int k) {
        size = 0;
        deque = new int[k];
        head = 0;
        tail = 0;
    }

    public boolean insertFront(int value) {
        if (size == deque.length) {
            return false;
        }
        if(size ==0 ){
            deque[head] = value;
            size++;
            return true;
        }
        if (head != deque.length - 1) {
            deque[++head] = value;
        } else {
            head = 0;
            deque[head] = value;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == deque.length) {
            return false;
        }
        if(size ==0 ){
            deque[tail] = value;
            size++;
            return true;
        }
        if (tail != 0) {
            deque[--tail] = value;
        } else {
            tail = deque.length - 1;
            deque[tail] = value;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (head == tail ){
            size--;
        }
        if (head != 0) {
            head--;
        } else {
            head = deque.length - 1;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (head == tail ){
            size--;
            return true;
        }
        if (tail == deque.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) return -1;
        return deque[head];
    }

    public int getRear() {
        if (size == 0) return -1;
        return deque[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }
}
