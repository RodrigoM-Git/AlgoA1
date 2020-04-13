package main;
import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the run queue interface using an Ordered Link List.
 *
 * Your task is to complete the implementation of this class.
 * You may add methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan.
 */
public class OrderedLinkedListRQ implements Runqueue {

	
	private Node head;
	private Node tail;
	
    /**
     * Constructs empty linked list
     */
    public OrderedLinkedListRQ() {
        head = new Node(null);
        tail = new Node(null);

    }  // end of OrderedLinkedList()


    @Override
    public void enqueue(String procLabel, int vt) {
    	Proc process = new Proc(procLabel, vt);
    	if(head == null) {
    		head = new Node(process);
    	}else {
    		Node node = new Node(process);
    		head.setNext(node);
    	}
    	

    } // end of enqueue()


    @Override
    public String dequeue() {
        // Implement me

        return ""; // placeholder, modify this
    } // end of dequeue()


    @Override
    public boolean findProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // end of findProcess()


    @Override
    public boolean removeProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // End of removeProcess()


    @Override
    public int precedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    } // end of precedingProcessTime()


    @Override
    public int succeedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    } // end of precedingProcessTime()


    @Override
    public void printAllProcesses(PrintWriter os) {
        //Implement me

    } // end of printAllProcess()

} // end of class OrderedLinkedListRQ


//Node class for LinkedList Nodes
class Node{
	private Proc process;
	private Node nextNode;
	
	public Node(Proc process) {
		this.process = process;
		this.nextNode = null;
	}
	
	public Proc getProcess() {
		return this.process;
	}
	
	public Node getNext() {
		return this.nextNode;
	}
	
	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public void setProcess(Proc process) {
		this.process = process;
	}
}//end of Node class
