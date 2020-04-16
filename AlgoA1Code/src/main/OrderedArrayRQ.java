package main;

import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the Runqueue interface using an Ordered Array.
 *
 * Your task is to complete the implementation of this class. You may add
 * methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan
 */
public class OrderedArrayRQ implements Runqueue {

	private Proc orderedArray[];
	private int length = 10;
	private int index = 0;

	/**
	 * Constructs empty queue
	 */
	public OrderedArrayRQ() {
		orderedArray = new Proc[length];

	} // end of OrderedArrayRQ()

	
	@Override
	public void enqueue(String procLabel, int vt) {
		Proc proc = new Proc(procLabel, vt);
		orderedArray[index] = proc;
		index++;
		// Sort the array
		orderedArray = sortArray(orderedArray);

		if (index >= length) {
			// Increase array size
			orderedArray = IncreaseArraySize(orderedArray);
			// Change to new length
			length = orderedArray.length;
		}

	} // end of enqueue()

	
	public Proc[] IncreaseArraySize(Proc[] initialArray) {
		// Increase length of array
		int new_length = initialArray.length * 2;
		Proc[] newArray = new Proc[new_length];

		// Populate new Array with old array values
		for (int i = 0; i < initialArray.length; i++) {
			newArray[i] = initialArray[i];
		}
		return newArray;
	}

	
	public Proc[] sortArray(Proc[] orderedArray) {
		// Using bubblesort
		for (int i = 0; i < index - 1; i++) {
			for (int j = 0; j < index - i - 1; j++) {

				if (orderedArray[j].getvRuntime() > orderedArray[j + 1].getvRuntime()) {
					Proc temp = orderedArray[j];
					orderedArray[j] = orderedArray[j + 1];
					orderedArray[j + 1] = temp;
				}

			}
		}
		return orderedArray;
	}

	
	@Override
	public String dequeue() {
		
		String procLabel = orderedArray[0].getProcLabel();
		orderedArray[0] = null;
		Proc[] tempArray;

		if(index < length) {
			tempArray = new Proc[length];
		}else {
			tempArray = new Proc[length * 2];
		}
		

		for (int i = 1; i < index; i++) {
			if(orderedArray[i] != null)
			tempArray[i - 1] = orderedArray[i];
		}

		orderedArray = tempArray;

		index--;
		
		return procLabel; 
	} // end of dequeue()

	
	@Override
	public boolean findProcess(String procLabel) {
		// Find if process exist by procLabel
		for (int i = 0; i < index; i++) {

			if ((orderedArray[i].getProcLabel()).matches(procLabel)) {
				return true;
			}
		}

		return false; 
	} // end of findProcess()

	
	@Override
	public boolean removeProcess(String procLabel) {
		int removed = -1;
		for(int i = 0; i < index; i++) {
			if(orderedArray[i].getProcLabel().matches(procLabel)) {
				orderedArray[i] = null;
				removed = i;
			}
		}
		
		if(removed != -1) {
			Proc tempArray[] = new Proc[length];
			for(int i = 0; i < removed; i++) {
				tempArray[i] = orderedArray[i];
			}
			
			for(int i = removed+1; i < index; i++) {
				tempArray[i-1] = orderedArray[i];
			}
			
			orderedArray = tempArray;
			
			index--;
			
			
			return true;
		}
		
		
		return false;
	} // end of removeProcess()

	
	@Override
	public int precedingProcessTime(String procLabel) {
		int current = -1;
		int time = -1;
		
		for(int i = 0; i < index; i++) {
			if(orderedArray[i] != null) {
				if(orderedArray[i].getProcLabel().matches(procLabel)) {
					current = i;
				}
			}	
		}
		
		if(current != -1) {
			time = 0;
			for(int i = 0; i < current; i++) {
				time += orderedArray[i].getvRuntime();
			}
		}

		return time;
	}// end of precedingProcessTime()

	
	@Override
	public int succeedingProcessTime(String procLabel) {
		int current = -1;
		int time = -1;
		
		for(int i = 0; i < index; i++) {
			if(orderedArray[i] != null) {
				if(orderedArray[i].getProcLabel().matches(procLabel)) {
					current = i;
				}
			}
		}
		
		if(current != -1) {
			time = 0;
			for(int i = current+1; i < index; i++) {
				time += orderedArray[i].getvRuntime();
			}
		}

		return time;
	} // end of precedingProcessTime()

	
	@Override
	public void printAllProcesses(PrintWriter os) {
		for(int i=0;i<index;i++) {
			if(orderedArray[i] != null) {
				os.print(orderedArray[i].getProcLabel() + " ");
			}
		}
		os.println();

	} // end of printAllProcesses()

} // end of class OrderedArrayRQ