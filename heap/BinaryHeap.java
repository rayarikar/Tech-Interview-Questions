package heap;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryHeap {

    int[] heap;
    int size;
    int currentHeapSize;
    final int numChildren = 2;

    public BinaryHeap(int size) {
        this.size = size;
        // we always insert the first element at index 1
        this.heap = new int[this.size + 1];
        Arrays.fill(this.heap, -1);
        this.currentHeapSize = 1;

    }

    private int getParent(int k) {
        return k / this.numChildren;
    }

    private int getLeftChild(int k) {
        return 2*k;
    }

    private int getRightChild(int k) {
        return 2*k + 1;
    }

    public void addElement(int elem) {
        if (isHeapFull()) {
            System.out.println("Heap is full. Cannot insert: " + elem);
        }
        this.heap[this.currentHeapSize] = elem;
        int index = this.currentHeapSize;
        this.currentHeapSize++;

        // ensure that we heapify the heap
        while (index > 0 && this.heap[index] < this.heap[getParent(index)]) {
            int parentIndex = getParent(index);
            int temp = this.heap[parentIndex];
            this.heap[parentIndex] = this.heap[index];
            this.heap[index] = temp;
            index = parentIndex;
        }
    }

    public int removeElement() {
        return 0;
    }

    public int getMinElement() {
        return 0;
    }

    public int getMaxElement() {
        return 0;
    }

    public boolean isHeapFull() {
        return this.currentHeapSize == this.size;
    }

    public boolean isHeapEmpty() {
        return  this.currentHeapSize == 0;
    }

    public void printHeap() {
        System.out.println("Heap:\n");
        for (int index = 0; index < this.heap.length; index++) {
            System.out.print(" " + this.heap[index]);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");
        /** Make object of BinaryHeap **/
        BinaryHeap bh = new BinaryHeap(scan.nextInt());

        char ch;
        /**  Perform Binary Heap operations  **/
        do
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");
            System.out.println("4. check empty");
            System.out.println("5. clear");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    try
                    {
                        System.out.println("Enter integer element to insert");
                        bh.addElement( scan.nextInt());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage() );
                    }
                    break;
//                case 2 :
//                    try
//                    {
//                        System.out.println("Min Element : "+ bh.deleteMin());
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.println(e.getMessage() );
//                    }
//                    break;
//                case 3 :
//                    System.out.println("Full status = "+ bh.isFull());
//                    break;
//                case 4 :
//                    System.out.println("Empty status = "+ bh.isEmpty());
//                    break;
//                case 5 :
//                    bh.makeEmpty();
//                    System.out.println("Heap Cleared\n");
//                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /** Display heap **/
            bh.printHeap();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
