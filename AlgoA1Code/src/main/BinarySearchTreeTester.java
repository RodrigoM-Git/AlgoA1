package main;

public class BinarySearchTreeTester {

	public static void main(String[] args) {
		BinarySearchTreeRQ binary = new BinarySearchTreeRQ();
		
		
		System.out.println("Enqueue:");
		binary.enqueue("P1", 4);
		binary.enqueue("P2", 1);
		binary.enqueue("P3", 5);
		binary.enqueue("P4", 2);
		binary.enqueue("P5", 6);
		binary.enqueue("P6", 7);
		binary.enqueue("P7", 9);
		binary.printAll();
		System.out.println("\n");
		
		
		System.out.println("Dequeue:");
		//binary.dequeue();
		binary.printAll();
		System.out.println("\n");
		
		
		System.out.println("Find Process:");
		System.out.println("FINDING P1: " + binary.findProcess("P1"));
		System.out.println("FINDING P4: " + binary.findProcess("P4"));
		System.out.println("FINDING P6: " + binary.findProcess("P6"));
		System.out.println("\n");
		
		
		System.out.println("Remove Process:");
		System.out.println("REMOVING P3: " + binary.removeProcess("P3"));
		System.out.println("REMOVING P5: " + binary.removeProcess("P5"));
		System.out.println("REMOVING P7: " + binary.removeProcess("P7"));
		System.out.println("REMOVING P10: " + binary.removeProcess("P10"));
		binary.printAll();
		System.out.println("\n");
		
		
		System.out.println("Preceeding Process Time:");
		System.out.println(binary.precedingProcessTime("P4"));
		System.out.println(binary.precedingProcessTime("P1"));
		System.out.println(binary.precedingProcessTime("P6"));
		System.out.println(binary.precedingProcessTime("P10"));
		System.out.println("\n");
		
		
	}

}
