/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearraydemo;

/**
 *
 * @author 174110J
 */
public class QueueArrayDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QueueArray q1 = new QueueArray(5);
        q1.enqueue(9);
        q1.enqueue(12);
        q1.enqueue(11);
        q1.enqueue(10);
        q1.enqueue(18);

        q1.display();
        try {
            q1.dequeue();
            q1.dequeue();
            q1.dequeue();
            q1.dequeue();
            //q1.dequeue();
            q1.enqueue(14);
            q1.enqueue(4);
            int peekValue = q1.peek();
            System.out.println(peekValue);
        } catch (Exception e) {
            System.out.println(e);
        }
        q1.display();

    }
}

class QueueArray {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int s) {   //s means size of the array
        this.queArray = new int[s];
        this.maxSize = s;
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.nItems == 0;
    }

    public boolean isFull() {
        return this.nItems == maxSize;
    }

    public int size() {
        return this.nItems;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, can't enqueue.");
            return;
        }
        if (this.rear == this.maxSize - 1) {
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.queArray[rear] = value;
        this.nItems++;
        System.out.println(value + " inserted...");
    }

    public int dequeue() throws Exception {   //return what is the value you delete
        if (isEmpty()) {
            throw new Exception("Queue is empty cannot remove");
        }
        int temp = this.front;
        if (this.front == maxSize - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
        this.nItems--;
        return temp;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty, can not get peek/front element");
        }
        return this.queArray[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty, nothing to print.");
            return;
        }
        int i = this.front;
        while (true) {
            System.out.print(this.queArray[i] + " ");
            if (i == this.rear) {
                break;
            }
            if (i == this.maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }
//        System.out.print(this.queArray[rear]);
        System.out.println("");
    }
}
