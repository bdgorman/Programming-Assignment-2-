//---------------------------------------------------------------------------
//
// The Bank Simulation
// Simulates a Bank with a queue
//
// Author: Benjamin Gorman
// Date: 04/02/2019
// Class: MET CS342
// Issues: none
//
// Description:
// This is a Customer linked list Queue. It is used for holding customer events
//
// Assumptions:
// only used for customers
//

public class CustomerQueue {

    private Node<Event> head;
    private Node<Event> tail;
    private int count;
    private int longestQueue = 0;
    private int longestWait = 0;

    ///////////////////////////////////////////////////////////////////
    /// remove (pop a customer event from the queue)    			///
    /// Input : none 							                    ///
    /// Output: Customer object        								///
    ///                                                      		///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    public Customer remove() {
        if (isEmpty()) {
            return null;
        } else {
            Customer tmp = (Customer) head.getData();
            if (count == 1) {   //if queue has one element make head and tail null (empty)
                head = tail = null;
                count = 0;
            } else {
                head = head.getNext();
                if (count > longestQueue) longestQueue = count;  //determine longest queue
                count--;
            }
            return tmp;
        }
    }
    ///////////////////////////////////////////////////////////////////
    /// add (add a customer event to queue) 			            ///
    /// Input : Customer object 							        ///
    /// Output: void        										///
    /// adds a new node to queue                                    ///
    ///////////////////////////////////////////////////////////////////
    public void add(Customer data) {

        Node<Event> n = new Node<>();
        n.setData(data);
        n.setNext(null);

        if (count == 0) {
            head = tail = n;
            count = 1;
        } else {
            tail.setNext(n);
            tail = n;
            count++;
        }
    }
    ///////////////////////////////////////////////////////////////////
    /// isEmpty (Are there Nodes on the queue?) 					///
    /// Input : None 												///
    /// Output: boolean 											///
    /// Returns true if empty, false otherwise 						///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    public boolean isEmpty() {
        return (count == 0);
    }


    public int getLongestWait() {
        return longestWait;
    }
    ///////////////////////////////////////////////////////////////////
    /// submitWaitTime (setter for wait time) 				    	///
    /// Input : wait 												///
    /// Output: none     											///
    /// If input wait time is larger than current wait,     		///
    /// then current wait is is updated								///
    ///////////////////////////////////////////////////////////////////
    public void submitWaitTime(int wait){
        if (wait > longestWait){
            longestWait = wait;
        }
}
    ///////////////////////////////////////////////////////////////////
    /// getLongestQueue (getter for longest queue variable) 		///
    /// Input : none 												///
    /// Output: longestQueue        								///
    /// If input wait time is larger than current wait,     		///
    /// then current wait is is updated								///
    ///////////////////////////////////////////////////////////////////
    public int getLongestQueue() {
        return longestQueue;
    }

    public String toString(){
        String tmpString = "";

        if (head == null) {
            return "<Empty>";
        }

        Node tmpNode = head;

        while (tmpNode != null) {
            tmpString +=  tmpNode.getData() ;
            tmpNode = tmpNode.getNext();

        }

        return tmpString;
    }

}