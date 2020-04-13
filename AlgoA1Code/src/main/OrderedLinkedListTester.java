package main;

import java.io.PrintWriter;

public class OrderedLinkedListTester {

	public static void main(String[] args) {
		OrderedLinkedListRQ linked = new OrderedLinkedListRQ();
		
		System.out.println("Enqueue:");
		linked.enqueue("P1", 5);
		linked.enqueue("P2", 2);
		linked.enqueue("P3", 1);
		linked.enqueue("P4", 4);
		linked.enqueue("P5", 1);
		linked.printAll();
		System.out.println("\n");
		
		
		System.out.println("Dequeue:");
		linked.dequeue();
		linked.printAll();
		System.out.println("\n");
		
		
		System.out.println("Find Process:");
		System.out.println("Finding P2: " + linked.findProcess("P2"));;
		System.out.println("Finding P10: " + linked.findProcess("P10"));
		System.out.println("\n");
		
		
		System.out.println("Remove Process:");
		System.out.println("Removing P4: " + linked.removeProcess("P4"));
		System.out.println("Removing P10: " + linked.removeProcess("P10"));
		linked.printAll();
		System.out.println("\n");
		
		
		System.out.println("Preceding Process Time:");
		System.out.println(linked.precedingProcessTime("P10"));
		System.out.println(linked.precedingProcessTime("P5"));
		System.out.println(linked.precedingProcessTime("P1"));
		System.out.println("\n");
		
		
		System.out.println("Succeeding Process Time:");
		System.out.println(linked.succeedingProcessTime("P10"));
		System.out.println(linked.succeedingProcessTime("P1"));
		System.out.println(linked.succeedingProcessTime("P5"));
		System.out.println("\n");
		
		
		System.out.println("Print All Processes:");
		PrintWriter os = new PrintWriter(System.out, true);
		linked.printAllProcesses(os);
		
		
	}

}
