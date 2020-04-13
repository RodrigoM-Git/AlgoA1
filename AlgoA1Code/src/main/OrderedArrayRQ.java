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
        
        if(index >= length) {
        	//increase size of array I'm too stupid rn cause i didn't do milestone 4 like Winston did
        }

    } // end of enqueue()


    @Override
    public String dequeue() {
    	orderedArray[orderedArray.length-1] = null;

        return ""; // placeholder,modify this
    } // end of dequeue()


    @Override
    public boolean findProcess(String procLabel){
        // Implement me

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
