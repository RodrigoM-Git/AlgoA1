package main;

public class BinarySearchTreeTester {

	public static void main(String[] args) {
		BinarySearchTreeRQ binary = new BinarySearchTreeRQ();
		
		binary.enqueue("P1", 3);
		binary.enqueue("P2", 1);
		binary.enqueue("P3", 4);
		binary.enqueue("P4", 5);
		binary.enqueue("P5", 1);
		
		binary.printAll();
		
		System.out.println("\n");
		binary.dequeue();
		binary.printAll();
		
		

	}

}
