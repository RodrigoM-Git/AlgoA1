package main;

import java.io.PrintWriter;

public class Tester {

	public static void main(String[] args) {
		OrderedArrayRQ oarq = new OrderedArrayRQ();
		
		oarq.enqueue("P1", 5);
		oarq.enqueue("P2",3);
		oarq.enqueue("P3", 2);
		oarq.enqueue("P4", 4);
		oarq.enqueue("P5", 1);
		System.out.println(oarq.getIndex());
		oarq.dequeue();
		System.out.println(oarq.getIndex());
		oarq.printAll();

	}

}
