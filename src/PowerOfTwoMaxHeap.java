import java.util.Arrays;
import java.util.Scanner;

public class PowerOfTwoMaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public PowerOfTwoMaxHeap() {
        this.capacity = 1; // Start with a capacity of 1
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size >= capacity) {
            // Double the capacity if the heap is full
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }

        heap[size] = value;
        int currentIndex = size;
        size++;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (heap[currentIndex] > heap[parentIndex]) {
                // Swap the current element with its parent
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = temp;

                // Move up the tree
                currentIndex = parentIndex;
            } else {
                // The heap property is satisfied
                break;
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PowerOfTwoMaxHeap maxHeap = new PowerOfTwoMaxHeap();

        while (true) {
            System.out.print("Enter an integer to insert into the Max Heap (or 'q' to quit): ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                maxHeap.insert(value);
                System.out.print("Max Heap: ");
                maxHeap.printHeap();
            } else {
                String input = scanner.next();
                if (input.equals("q")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or 'q' to quit.");
                }
            }
        }

        scanner.close();
    }
}
