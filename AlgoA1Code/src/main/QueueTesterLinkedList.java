package main;

public class QueueTesterLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runqueue queue100 = new OrderedLinkedListRQ();
		
		//100 EN
		long startTime100 = System.nanoTime();
		for(int i=0;i<100;i++) {
			queue100.enqueue("P"+i, (int) (100.0 *Math.random()));
		}
		long endTime100 = System.nanoTime();
		double timeTaken100 = (double)(endTime100 - startTime100) / Math.pow(10, 9);
		System.out.println("Time taken for 100 EN: " + timeTaken100 + " secs");
		
		//1000 EN
		Runqueue queue1000 = new OrderedLinkedListRQ();
		long startTime1000 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			queue1000.enqueue("P"+i, (int) (100.0 *Math.random()));
		}
		long endTime1000 = System.nanoTime();
		double timeTaken1000 = (double)(endTime1000 - startTime1000) / Math.pow(10, 9);
		System.out.println("Time taken for 1000 EN: " + timeTaken1000 + " secs");
		
		
		
		//2500 EN
		Runqueue queue2500 = new OrderedLinkedListRQ();
		long startTime2500 = System.nanoTime();
		for(int i=0;i<2500;i++) {
			queue2500.enqueue("P"+i, (int) (100.0 *Math.random()));
		}
		long endTime2500 = System.nanoTime();
		double timeTaken2500 = (double)(endTime2500 - startTime2500) / Math.pow(10, 9);
		System.out.println("Time taken for 2500 EN: " + timeTaken2500 + " secs");
		
		//---------------------------------------------------------------------------------------------
		//100 PT
		long PtstartTime100 = System.nanoTime();
		for(int i=0;i<100;i++) {
			queue100.precedingProcessTime("P"+i);
		}
		long PtendTime100 = System.nanoTime();
		double PttimeTaken100 = (double)(PtendTime100 - PtstartTime100) / Math.pow(10, 9);
		System.out.println("Time taken for 100 PT: " + PttimeTaken100 + " secs");
		
		
		//1000 PT
		long PtstartTime1000 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			queue1000.precedingProcessTime("P"+i);
		}
		long PtendTime1000 = System.nanoTime();
		double PttimeTaken1000 = (double)(PtendTime1000 - PtstartTime1000) / Math.pow(10, 9);
		System.out.println("Time taken for 1000 PT: " + PttimeTaken1000 + " secs");
		
		
		//2500 PT
		long PtstartTime2500 = System.nanoTime();
		for(int i=0;i<2500;i++) {
			queue2500.precedingProcessTime("P"+i);
		}
		long PtendTime2500 = System.nanoTime();
		double PttimeTaken2500 = (double)(PtendTime2500 - PtstartTime2500) / Math.pow(10, 9);
		System.out.println("Time taken for 2500 PT: " + PttimeTaken2500 + " secs");
		//---------------------------------------------------------------------------------------------
		
		//100 DE
		long DestartTime100 = System.nanoTime();
		for(int i=0;i<100;i++) {
			queue100.dequeue();
		}
		long DeendTime100 = System.nanoTime();
		double DetimeTaken100 = (double)(DeendTime100 - DestartTime100) / Math.pow(10, 9);
		System.out.println("Time taken for 100 DE: " + DetimeTaken100 + " secs");
		
		
		//1000 DE
		long DestartTime1000 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			queue1000.dequeue();
		}
		long DeendTime1000 = System.nanoTime();
		double DetimeTaken1000 = (double)(DeendTime1000 - DestartTime1000) / Math.pow(10, 9);
		System.out.println("Time taken for 1000 DE: " + DetimeTaken1000 + " secs");
		
		
		//2500 DE
		long DestartTime2500 = System.nanoTime();
		for(int i=0;i<2500;i++) {
			queue2500.dequeue();
		}
		long DeendTime2500 = System.nanoTime();
		double DetimeTaken2500 = (double)(DeendTime2500 - DestartTime2500) / Math.pow(10, 9);
		System.out.println("Time taken for 2500 DE: " + DetimeTaken2500 + " secs");
		



	}

}
