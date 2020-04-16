package main;

import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the Runqueue interface using a Binary Search Tree.
 *
 * Your task is to complete the implementation of this class. You may add
 * methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan
 */
public class BinarySearchTreeRQ implements Runqueue {

	private BinaryNode root;
	private int totalRunTime;

	/**
	 * Constructs empty queue
	 */
	public BinarySearchTreeRQ() {
		root = new BinaryNode(null);

	} // end of BinarySearchTreeRQ()

	@Override
	public void enqueue(String procLabel, int vt) {
		Proc process = new Proc(procLabel, vt);
		BinaryNode node = new BinaryNode(process);
		// if no root
		if (root.getProcess() == null) {
			// new node becomes root
			root = node;
		} else {
			// temporary storer
			BinaryNode current = root;
			BinaryNode before;

			while (true) {
				// set before to the current node
				before = current;
				// if runtime of new node is less than current node
				if (node.getProcess().getvRuntime() < current.getProcess().getvRuntime()) {
					// go left of the current node
					current = current.getLeft();
					// if the left of the current node is null
					if (current == null) {
						// set new node to the left of the current node
						before.setLeft(node);
						return;
					}
				} else {
					// move to the right of current node
					current = current.getRight();
					// if null
					if (current == null) {
						// set new node to right node
						before.setRight(node);
						return;
					}
				}
			}
		}

	} // end of enqueue()

	@Override
	public String dequeue() {

		BinaryNode current = root;
		BinaryNode before = root;

		while (current.getLeft() != null) {
			before = current;
			current = current.getLeft();
		}

		if (current.getRight() == null) {
			before.setLeft(null);
		} else {
			before.setLeft(current.getRight());
		}

		return null;
	} // end of dequeue()

	@Override
	public boolean findProcess(String procLabel) {
		return iterateNode(root, procLabel);
	} // end of findProcess()

	public boolean iterateNode(BinaryNode node, String procLabel) {
		// if node procLabel matches
		if (node.getProcess().getProcLabel().matches(procLabel)) {
			return true;
		}
		// if left node not null
		if (node.getLeft() != null) {
			// recursion to iterate through the left node
			if (iterateNode(node.getLeft(), procLabel) == true) {
				return true;
			}
		}
		if (node.getRight() != null) {
			// recursion to iterate through the right node
			if (iterateNode(node.getRight(), procLabel) == true) {
				return true;
			}
		}
		return false;
	}
	//Find current node that contains proc label
	public BinaryNode findNode(BinaryNode node, String procLabel) {
		// if node procLabel matches
		if (node.getProcess().getProcLabel().matches(procLabel)) {
			return node;
		}
		// if left node not null
		if (node.getLeft() != null) {
			// recursion to iterate through the left node
			if (findNode(node.getLeft(), procLabel) != null) {
				return findNode(node.getLeft(), procLabel);
			}
		}
		if (node.getRight() != null) {
			// recursion to iterate through the right node
			if (findNode(node.getRight(), procLabel) != null) {
				return findNode(node.getRight(), procLabel);
			}
		}
		return null;
	}

	@Override
	public boolean removeProcess(String procLabel) {

		BinaryNode current = root;
		BinaryNode before = root;
		BinaryNode step = root;
		boolean isLeft = true;

		// check if procLabel exist
		if(iterateNode(root,procLabel) != true) {
			return false;
		}else {
			//get the current node
			current = findNode(root,procLabel);
			System.out.println("Current:" +current.getProcess().getProcLabel());
			//the new step is not eequal to current
			while(step != current) {
				//search for before
				//if its lest than the run time of root
				if(current.getProcess().getvRuntime() < root.getProcess().getvRuntime()) {
					//search the left
					if(step.getLeft() != null) {
						before = step;
						step = step.getLeft();
						isLeft = true;
					}
				}else {
					//search the right
					if(step.getRight() != null) {
						before = step;
						step = step.getRight();
						isLeft = false;
					}
				}
			}
		}

		// if found node has no children
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			} else if (isLeft) {
				before.setLeft(null);
			} else {
				before.setRight(null);
			}

			// if found node has no right child
		} else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeft) {
				before.setLeft(current.getLeft());
			} else {
				before.setRight(current.getLeft());
			}

			// if found node has no left child
		} else if (current.getLeft() == null) {
			if (current == root) {
				root = null;
			} else if (isLeft) {
				before.setLeft(current.getRight());
			} else {
				before.setRight(current.getRight());
			}

			// if found node has 2 children
		} else {
			BinaryNode replacement = getReplacement(current);

			if (current == root) {
				root = replacement;
			} else if (isLeft) {
				before.setLeft(replacement);
			} else {
				before.setRight(replacement);
			}

			replacement.setLeft(current.getLeft());
		}

		return true;
	} // end of removeProcess()

	// method to get node that replaces removed node
	public BinaryNode getReplacement(BinaryNode toReplace) {
		BinaryNode before = toReplace;
		BinaryNode replacement = toReplace;

		BinaryNode current = toReplace.getRight();

		// iterates left until the end
		while (current != null) {
			before = replacement;
			replacement = current;
			current = current.getLeft();
		}

		// if the replacement node isnt the right child of removed node
		if (replacement != toReplace.getRight()) {

			// replace removed node with replacement node
			before.setLeft(replacement.getRight());
			replacement.setRight(toReplace.getRight());
		}

		return replacement;
	}

	@Override
	public int precedingProcessTime(String procLabel) {
		int vRunTimeAcc = 0;
		if(iterateNode(root,procLabel) != true) {
			return -1;
		}else {
			//Target Node
			BinaryNode procNode = findNode(root,procLabel);
			BinaryNode current = root;
			//if target node is root
			if(procNode == root) {
				//get all vRuntime of its left subtree
				vRunTimeAcc = getAllVrunTime(root.getLeft());
			}else {
				//get all runtime of nodes that have less runtime that target node
				vRunTimeAcc =  inorderTraversal(root,procNode);
			}
			
		}

		return vRunTimeAcc; // placeholder, modify this
	} // end of precedingProcessTime()
	
	
	public int inorderTraversal(BinaryNode root, BinaryNode target) {
		int vRunTimeAcc = 0;
			if(root.getLeft() != null) {
				//get the runtime of left subtree
				if (inorderTraversal(root.getLeft(),target) != 0) {
					vRunTimeAcc += inorderTraversal(root.getLeft(),target);
				}
			}
			//add the runtime of current node
			if(root.getProcess().getvRuntime() < target.getProcess().getvRuntime()) {
				vRunTimeAcc += root.getProcess().getvRuntime();
			}
			if (root.getRight() != null) {
				//get runtime of right subtree
				if (inorderTraversal(root.getRight(),target) != 0) {
					vRunTimeAcc += inorderTraversal(root.getRight(),target);
				}
			}
			
		return vRunTimeAcc;
	}
	
	
	public int getAllVrunTime(BinaryNode root) {
		int vRunTimeAcc = 0;
		if (root != null) {
			if(getAllVrunTime(root.getLeft()) != 0){
				vRunTimeAcc += getAllVrunTime(root.getLeft());
			}
			vRunTimeAcc += root.getProcess().getvRuntime();
			if(getAllVrunTime(root.getRight()) != 0) {
				vRunTimeAcc += getAllVrunTime(root.getRight());
			}
		}
		return vRunTimeAcc;
	}
	

	@Override
	public int succeedingProcessTime(String procLabel) {
		int vRunTimeAcc = 0;
		
		if(iterateNode(root,procLabel) != true) {
			return -1;
		}else {
			BinaryNode procNode = findNode(root,procLabel);
			vRunTimeAcc += getAllVrunTime(root);
			vRunTimeAcc -= precedingProcessTime(procLabel);
			vRunTimeAcc -= procNode.getProcess().getvRuntime();
		}
		return vRunTimeAcc; 
	} // end of succeededProcessTime()
	

	@Override
	public void printAllProcesses(PrintWriter os) {
		iterateInOrder(root, os);
		os.println();
	} // end of printAllProcess()

	
	public void iterateInOrder(BinaryNode current, PrintWriter os) {
		if(current != null) {
			iterateInOrder(current.getLeft(), os);
			os.print(current.getProcess().getProcLabel() + " ");
			iterateInOrder(current.getRight(), os);
		}
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
