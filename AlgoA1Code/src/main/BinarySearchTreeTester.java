package main;

public class BinarySearchTreeTester {

	public static void main(String[] args) {
		BinarySearchTreeRQ binary = new BinarySearchTreeRQ();
		
		binary.enqueue("P1", 1);
		binary.enqueue("P2", 2);
		binary.enqueue("P3", 1);
		binary.enqueue("P4", 5);
		
		
		System.out.println("FINDING P1:");
		binary.findProcess("P10");
		
		binary.printAll();

	}

}
