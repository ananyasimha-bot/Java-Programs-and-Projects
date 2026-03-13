class Queue {
    int front = -1;
    int rear = -1;
    int max = 5;
    int arr[] = new int[max];
    void enqueue(int value) {
        if (rear == max - 1) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1)
                front = 0;
            arr[++rear] = value;
            System.out.println(value + " inserted");
        }
    }
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(arr[front++] + " removed");
        }
    }
    void display() {
        System.out.println("Queue elements:");
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }
}
public class QueueUsingClass {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
