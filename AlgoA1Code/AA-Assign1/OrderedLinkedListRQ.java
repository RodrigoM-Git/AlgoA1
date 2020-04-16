import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the run queue interface using an Ordered Link List.
 *
 * Your task is to complete the implementation of this class. You may add
 * methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan.
 */
public class OrderedLinkedListRQ implements Runqueue {

	private Node head;
	private int size = 0;

	/**
	 * Constructs empty linked list
	 */
	public OrderedLinkedListRQ() {
		head = new Node(null);

	} // end of OrderedLinkedList()
	

	@Override
	public void enqueue(String procLabel, int vt) {
		//Make new node
		Node newNode = new Node(new Proc(procLabel, vt));
		
		head = insertNode(newNode);
		size++;

	} // end of enqueue()
	

	public Node insertNode(Node newNode) {
		
		//If empty list or new node < head node
		if(head.getProcess() == null || head.getProcess().getvRuntime() > newNode.getProcess().getvRuntime()) {
			newNode.setNext(head);
			head = newNode;
			return head;
		}
		
		Node current = head;
		
		//while there is a next, and while current < new node, iterate to next until new < current
		while(current.getNext().getProcess() != null && current.getNext().getProcess().getvRuntime()
				<= newNode.getProcess().getvRuntime()) {
			current = current.getNext();
		}
		
		//insert new node where new < current
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		
		return head;
	}//end of insertNode
	

	@Override
	public String dequeue() {
		String procLabel = head.getProcess().getProcLabel();
		head = head.getNext();
		size--;

		return procLabel;
	} // end of dequeue()

	
	@Override
	public boolean findProcess(String procLabel) {
		
		//set current node
		Node current = head;
		
		
		//iterate through nodes until match is found
		for(int i = 0; i < size; i++) {
			if(current.getProcess().getProcLabel().matches(procLabel)) {
				return true;
			}
			
			//iterate to next node
			current = current.getNext();
		}

		return false; // placeholder, modify this
	} // end of findProcess()

	
	@Override
	public boolean removeProcess(String procLabel) {
		
		//set current and before nodes
		Node current = head;
		Node before = new Node(null);
		
		
		//iterate through nodes until match is found
		for(int i = 0; i < size; i++) {
			if(current.getProcess().getProcLabel().matches(procLabel)) {
				//point node before to node next and remove current
				before.setNext(current.getNext());
				size--;
				return true;
			}else {
				//iterate to next node
				before = current;
				current = current.getNext();
			}
		}

		return false;
	} // End of removeProcess()

	
	@Override
	public int precedingProcessTime(String procLabel) {
		
		//set current node and time
		Node current = head;
		int time = 0;
		
		//iterate through nodes
		for(int i = 0; i < size; i++) {
			if(current.getProcess().getProcLabel().matches(procLabel)) {
				//stop adding time when node is found
				return time;
			}else {
				//if node not yet found add time and iterate to next node
				time += current.getProcess().getvRuntime();
				current = current.getNext();
			}
		}

		return -1; 
	} // end of precedingProcessTime()

	
	@Override
	public int succeedingProcessTime(String procLabel) {
		
		//set index, time, and current node
		Node current = head;
		int index = 0;
		int time = 0;
		
		//iterate through nodes until match is found
		for(int i = 0; i < size; i++) {
			if(current.getProcess().getProcLabel().matches(procLabel)) {
				//when match is found, iterate through remaining nodes and add time
				current = current.getNext();
				for(int j = index+1; j < size; j++) {
					time += current.getProcess().getvRuntime();
					current = current.getNext();
				}
				return time;
			}else {
				//if no match yet, iterate to next node
				current = current.getNext();
				index++;
			}
		}

		return -1; // placeholder, modify this
	} // end of precedingProcessTime()

	
	@Override
	public void printAllProcesses(PrintWriter os) {
		Node current = head;
		for(int i = 0; i < size; i++) {
			os.print(current.getProcess().getProcLabel() + " ");
			current = current.getNext();
		}
		
		os.println();

	} // end of printAllProcess()

} // end of class OrderedLinkedListRQ



//Node class for LinkedList Nodes
class Node {
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
}// end of Node class
