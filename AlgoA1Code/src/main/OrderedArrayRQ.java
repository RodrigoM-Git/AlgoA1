package main;
import java.io.PrintWriter;
import java.lang.String;


/**
 * Implementation of the Runqueue interface using an Ordered Array.
 *
 * Your task is to complete the implementation of this class.
 * You may add methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan
 */
public class OrderedArrayRQ implements Runqueue {

	Proc orderedArray[];
	int length = 20;
	int index = 0;
    /**
     * Constructs empty queue
     */
    public OrderedArrayRQ() {
    	orderedArray = new Proc[length];

    }  // end of OrderedArrayRQ()


    @Override
    public void enqueue(String procLabel, int vt) {
        Proc proc = new Proc(procLabel, vt);
        orderedArray[index] = proc;
        index++;
        //Sort the array
        orderedArray = sortArray(orderedArray);
        
        if(index >= length) {
        	//Increase array size
        	orderedArray = IncreaseArraySize(orderedArray);
        	//Change to new length
        	length = orderedArray.length;
        }

    } // end of enqueue()
    
    public Proc[] IncreaseArraySize(Proc[] initialArray) {
    	//Increase length of array
    	int new_length = initialArray.length * 2;
    	Proc[] newArray = new Proc[new_length];
    	
    	//Populate new Array with old array values
    	for(int i=0;i<initialArray.length;i++) {
    		newArray[i] = initialArray[i];
    	}
    	return newArray;
    }
    
    public Proc[] sortArray(Proc[] orderedArray) {
    	//Using bubblesort
    	for(int i=0;i<orderedArray.length-1;i++) {
    		for(int j=0;j<orderedArray.length-i-1;j++) {
    			if(orderedArray[j].getvRuntime() > orderedArray[j+1].getvRuntime()) {
    				Proc temp = orderedArray[j];
    				orderedArray[j] = orderedArray[j+1];
    				orderedArray[j+1] = temp;
    			}
    		}
    	}
    	return orderedArray;
    }

    @Override
    public String dequeue() {
    	orderedArray[0] = null;

        return ""; // placeholder,modify this
    } // end of dequeue()


    @Override
    public boolean findProcess(String procLabel){
    	//Find if process exist by procLabel
        for(int i=0;i<orderedArray.length;i++) {
        	if((orderedArray[i].getProcLabel()).matches(procLabel)) {
        		return true;
        	}
        }
        
        return false; // placeholder, modify this
    } // end of findProcess()


    @Override
    public boolean removeProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // end of removeProcess()


    @Override
    public int precedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    }// end of precedingProcessTime()


    @Override
    public int succeedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    } // end of precedingProcessTime()


    @Override
    public void printAllProcesses(PrintWriter os) {
        //Implement me

    } // end of printAllProcesses()

} // end of class OrderedArrayRQ