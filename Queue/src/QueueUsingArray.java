public class QueueUsingArray {
    public static void main(String[] args) {
        System.out.println("=============== Implementing Queue using Array ================ \n");

        Queue queue = new Queue(3);

        // Adding elements
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Having a peek and removing the elements one by one
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();

        System.out.println("\n ============== Queue is empty finally! ================");
    }

    public static class Queue {
        private final int[] arr;
        private final int size;
        private int rear = -1;

        public Queue(int size) {
            this.size = size;
            arr = new int[this.size];
        }

        public void add(int data) {
            System.out.println("Adding element: " + data);

            if (isFull()) {
                System.out.println("Uh oh! Queue is full!");
            }

            // Increment rear and set data there
            rear++;
            arr[rear] = data;
        }

        public void remove() {
            System.out.println("Removing the same!");

            if (isEmpty()) {
                System.out.println("Uh oh! Queue is empty! No elements to remove!");
            }

            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }

            // Now that we have moved elements left by 1 position, decrement rear as well
            rear--;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Uh oh! Queue is empty! No element to peek!");
            }

            System.out.println("Doing a little sneak peek here: ");
            return arr[0];
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public boolean isFull() {
            return rear == size - 1;
        }
    }
}
