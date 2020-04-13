package main;

public class OrderedLinkedListTester {

	public static void main(String[] args) {
		OrderedLinkedListRQ linked = new OrderedLinkedListRQ();
		
		linked.enqueue("P1", 2);
		linked.enqueue("P2", 4);
		linked.enqueue("P3", 4);
		linked.enqueue("P4", 3);
		linked.printAll();

	}

}
