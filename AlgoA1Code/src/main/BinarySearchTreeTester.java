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
		
		System.out.println("FINDING P1:");
		System.out.println(binary.findProcess("P1"));
		System.out.println("FINDING P2:");
		System.out.println(binary.findProcess("P2"));
		System.out.println("FINDING P3:");
		System.out.println(binary.findProcess("P3"));
		System.out.println("FINDING P4:");
		System.out.println(binary.findProcess("P4"));
		System.out.println("FINDING P5:");
		System.out.println(binary.findProcess("P5"));
		
		binary.printAll();
		
		

	}

}
