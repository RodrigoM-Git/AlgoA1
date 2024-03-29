package main;

import java.io.PrintWriter;

public class OrderedArrayTester {

	public static void main(String[] args) {
		OrderedArrayRQ oarq = new OrderedArrayRQ();
		
		System.out.println("Enqueue:");
		oarq.enqueue("P1", 5);
		oarq.enqueue("P2", 3);
		oarq.enqueue("P3", 2);
		oarq.enqueue("P4", 4);
		oarq.enqueue("P5", 1);
		System.out.println("\n");
		
		System.out.println("Dequeue:");
		oarq.dequeue();
		System.out.println("\n");
		
		System.out.println("Remove Process:");
		System.out.println("Removing P1: " + oarq.removeProcess("P1"));
		System.out.println("Removing P10: " + oarq.removeProcess("P10"));
		System.out.println("\n");
		
		System.out.println("Find Process:");
		System.out.println("Finding process P1: " + oarq.findProcess("P1"));
		System.out.println("Finding process P4: " + oarq.findProcess("P4"));
		System.out.println("\n");
		
		System.out.println("Preceding Process Time:");
		System.out.println(oarq.precedingProcessTime("P6"));
		System.out.println(oarq.precedingProcessTime("P3"));
		System.out.println(oarq.precedingProcessTime("P4"));
		System.out.println("\n");
		
		System.out.println("Succeeding Process Time:");
		System.out.println(oarq.succeedingProcessTime("P6"));
		System.out.println(oarq.succeedingProcessTime("P4"));
		System.out.println(oarq.succeedingProcessTime("P3"));
		System.out.println("\n");
		
		System.out.println("Print All Processes:");
		PrintWriter os = new PrintWriter(System.out, true);
		oarq.printAllProcesses(os);

	}

}
