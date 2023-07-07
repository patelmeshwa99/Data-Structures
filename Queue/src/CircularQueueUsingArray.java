public class CircularQueueUsingArray {

    public static void main(String[] args) {
        System.out.println("=============== Implementing Circular Queue using Array ================ \n");

        Queue queue = new Queue(3);

        // Adding elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("\n");

        // Verify addition of element in circular way
        System.out.println(queue.peek());
        queue.remove();
        queue.add(4);

        // Print the queue
        System.out.println("\nPrinting the queue");
        for (int i = 0; i < queue.size; i++) {
            System.out.println("Element " + i + " is: " + queue.arr[i]);
        }

        // Having a peek and removing the elements one by one
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }

        System.out.println("\n ==================== Queue is empty finally! =====================");
    }

    private static class Queue {
        int[] arr;
        int size;
        int front;
        int rear;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
            front = -1;
            rear = -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public void add(int data) {
            System.out.println("Adding element: " + data);

            if (isFull()) {
                System.out.println("Uh oh! Queue is full!");
                return;
            }

            if (front == -1) {
                front++;
            }

            // Increment rear and set data there
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public void remove() {
            System.out.println("Removing the same!");

            if (isEmpty()) {
                System.out.println("Uh oh! Queue is empty! No elements to remove!");
            }

            if (rear == front) {
                rear = front = -1;
            } else {
                // Increment front to make sure that it still points to the very first element
                front = (front + 1) % size;
            }
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Uh oh! Queue is empty! No element to peek!");
                return -1;
            }

            System.out.println("Doing a little sneak peek here: ");
            return arr[front];
        }
    }
}
