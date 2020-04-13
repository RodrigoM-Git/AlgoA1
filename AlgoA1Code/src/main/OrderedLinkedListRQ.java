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
	private int size = 0;
	
    /**
     * Constructs empty linked list
     */
    public OrderedLinkedListRQ() {
        head = new Node(null);
        tail = new Node(null);

    }  // end of OrderedLinkedList()

    @Override
    public void enqueue(String procLabel, int vt) {
    	//create process
    	Proc process = new Proc(procLabel, vt);
    	
    	//if list is empty, make it the head
    	if(head.getProcess() == null) {
    		head = new Node(process);
    		size++;
    	}else {
    		//Create nodes for iteration
    		Node node = new Node(process);
    		Node next = head;
    		Node before = new Node(null);
    		
    		//go through whole list
    		while(next != null) {
    			
    			//if new node is smaller than next
    			if(node.getProcess().getvRuntime() <= next.getProcess().getvRuntime()) {
    				
    				//if new node is smaller than head node
    				if(next == head) {
    					
    					//set new node as head, set head as next after new node
    					node.setNext(head);
    					head = node;
    					
    					//if only head in list
    					if(size == 1) {
    						tail = node.getNext();
    					}
    					size++;
    					break;
    				}else{
    					
    					//if only head in list
    					if(size == 1) {
    						head.setNext(node);
    						tail = node;
    						size++;
    						break;
    					}
    					
    					//set new node as next for previous node, and set next node as next
    					before.setNext(node);
    					node.setNext(next);
    					size++;
    					break;
    				}
    			}else {
    				
    				//make next node the before node, and make the node after next the new next node
    				before = next;
    				next = next.getNext();
    			}
    			
    			if(size >= 2) {
    				if(tail.getProcess().getvRuntime() <= node.getProcess().getvRuntime()) {
        				Node temp = tail;
        				temp.setNext(node);
        				tail = node;
        				size++;
        				break;
        			}
    			}
    			
    		}
    		
    		
    		
    		
    		
    		
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
    
    
    public void printAll() {
    	String string = "";
    	Node curr = head;
    	for(int i = 0; i < size; i++) {
    		string += curr.getProcess().getProcLabel() + " ";
    		curr = curr.getNext();
    	}
    	System.out.println(string);
    }

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
