package medium;

public class DesignCircularQueue {


    /*
    Medium

    Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

    One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

    Implementation the MyCircularQueue class:

    MyCircularQueue(k) Initializes the object with the size of the queue to be k.
    int Front() Gets the front item from the queue. If the queue is empty, return -1.
    int Rear() Gets the last item from the queue. If the queue is empty, return -1.
    boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
    boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
    boolean isEmpty() Checks whether the circular queue is empty or not.
    boolean isFull() Checks whether the circular queue is full or not.

    You must solve the problem without using the built-in queue data structure in your programming language.
     */

    class MyCircularQueue {

        int elems = 0;
        int enqptr=-1;
        int deqptr=0;
        int[]arr;
        int k;
        public MyCircularQueue(int k) {
            arr=new int[k];
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            enqptr = (enqptr+1)%k;
            arr[enqptr]=value;
            elems++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            deqptr = (deqptr+1)%k;
            elems--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return arr[deqptr];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return arr[enqptr];
        }

        public boolean isEmpty() {
            return elems==0;
        }

        public boolean isFull() {
            return elems==k;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
