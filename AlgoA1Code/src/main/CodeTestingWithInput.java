package main;

import java.io.PrintWriter;

public class CodeTestingWithInput {

	public static void main(String[] args) {
		BinarySearchTreeRQ array = new BinarySearchTreeRQ();
		PrintWriter os = new PrintWriter(System.out, true);
		
		array.enqueue("P16", 6);
		array.enqueue("P15", 10);
		System.out.println(array.removeProcess("P15"));
		System.out.println(array.precedingProcessTime("P16"));
		array.enqueue("P8", 1);
		array.enqueue("P9", 7);
		System.out.println(array.dequeue());
		array.enqueue("P19", 6);
		array.printAllProcesses(os);
		array.enqueue("P6", 6);
		System.out.println(array.removeProcess("P3"));
		System.out.println(array.findProcess("P11"));
		array.printAllProcesses(os);
		System.out.println(array.findProcess("P4"));
		System.out.println(array.succeedingProcessTime("P6"));
//		System.out.println(array.removeProcess("P9"));
//		array.enqueue("P4", 9);
//		System.out.println(array.dequeue());
//		System.out.println(array.succeedingProcessTime("P16"));
//		array.printAllProcesses(os);
//		array.enqueue("P18", 10);
//		array.printAllProcesses(os);
//		array.enqueue("P1", 5);
//		array.enqueue("P14", 4);
//		array.printAllProcesses(os);
//		
		

	}

}
