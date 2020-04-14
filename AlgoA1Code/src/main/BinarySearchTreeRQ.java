package main;
import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the Runqueue interface using a Binary Search Tree.
 *
 * Your task is to complete the implementation of this class.
 * You may add methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan
 */
public class BinarySearchTreeRQ implements Runqueue {

	private BinaryNode root;
	
	
    /**
     * Constructs empty queue
     */
    public BinarySearchTreeRQ() {
        root = new BinaryNode(null);

    }  // end of BinarySearchTreeRQ()


    @Override
    public void enqueue(String procLabel, int vt) {
        Proc process = new Proc(procLabel, vt);
        BinaryNode node = new BinaryNode(process);
        //if no root
        if(root.getProcess() == null) {
        	//new node becomes root
        	root = node;
        }else {
        	//temporary storer
        	BinaryNode current = root;
        	BinaryNode before;
        	
        	while(true) {
        		//set before to the current node
        		before = current;
        		//if runtime of new node is less than current node
        		if(node.getProcess().getvRuntime() < current.getProcess().getvRuntime()) {
        			//go left of the current node
        			current = current.getLeft();
        			//if the left of the current node is null
        			if(current == null) {
        				//set new node to the left of the current node
        				before.setLeft(node);
        				return;
        			}
        		}else {
        			//move to the right of current node
        			current = current.getRight();
        			//if null
        			if(current == null) {
        				//set new node to right node
        				before.setRight(node);
        				return;
        			}
        		}
        	}
        }

    } // end of enqueue()


    @Override
    public String dequeue() {

        return ""; // placeholder, modify this
    } // end of dequeue()


    @Override
    public boolean findProcess(String procLabel) {
    	return iterateNode(root,procLabel);
    } // end of findProcess()
    
    public boolean iterateNode(BinaryNode node,String procLabel) {
    	//if node procLabel matches
    	if(node.getProcess().getProcLabel().matches(procLabel)) {
    		return true;
    	}
    	//if left node not null
    	if(node.getLeft() != null) {
    		//recursion to iterate through the left node
    		if (iterateNode(node.getLeft(),procLabel) == true) {
    			return true;
    		}
    	}
    	if(node.getRight() != null) {
    		//recursion to iterate through the right node
    		if(iterateNode(node.getRight(),procLabel) == true) {
    			return true;
    		}
    	}
    	return false;
    }
    

    @Override
    public boolean removeProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // end of removeProcess()


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
       //implement me

    } // end of printAllProcess()
    
    
    
    //METHODS TO REMOVE
  public void iterateInOrder(BinaryNode current) {
    	
    	if(current != null) {
    		iterateInOrder(current.getLeft());
    		System.out.println(current.getProcess().getProcLabel());
    		iterateInOrder(current.getRight());
    	}
    }

    public void printAll() {
    	iterateInOrder(root);
    }

} // end of class BinarySearchTreeRQ



//Node class for BinarySearchTree Nodes
class BinaryNode {
	private Proc process;
	private BinaryNode rightNode;
	private BinaryNode leftNode;

	public BinaryNode(Proc process) {
		this.process = process;
		this.rightNode = null;
		this.leftNode = null;
	}

	public Proc getProcess() {
		return this.process;
	}

	public BinaryNode getLeft() {
		return this.leftNode;
	}
	
	public BinaryNode getRight() {
		return this.rightNode;
	}

	public void setLeft(BinaryNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public void setRight(BinaryNode rightNode) {
		this.rightNode = rightNode;
	}
}// end of Node class

