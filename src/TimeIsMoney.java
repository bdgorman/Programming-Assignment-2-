//---------------------------------------------------------------------------
//
// The Bank Simulation
// Simulates a Bank with a queue
//
// Author: Benjamin Gorman
// Date: 04/02/2019
// Class: MET CS342
// Issues: results have a lower number of customers arriving than there should be.
//
// Description:
// The simulation starts at a time of 0 and the first customer arrives in 1-4 minutes.
// There are two kinds of events: customer arriving, and teller free. When a customer arrives, a new customer is
// generated with an arrival time between 1 and 4 minutes from current time. If a customer arrives and
// no tellers are free, then they are added to the customer queue. when a teller is free, this causes a customer
// to be removed from the queue and they begin service
//
// Assumptions:
// Customers arrive every 1-4 min and spend 1-4min at the teller. This can be altered by changing the min and max
// varriables in the NewCustomer class


public class TimeIsMoney {

    ///////////////////////////////////////////////////////////////////
    /// main program entry point									///
    /// Input : arguments.  (these are ignored for this program)	///
    /// Output: None 												///
    /// Returns nothing												///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        TimeIsMoney me = new TimeIsMoney();
        me.andMoneyIsPizza();


    }
    ///////////////////////////////////////////////////////////////////
    /// andMoneyIsPizza (Worker method called from main)			///
    /// Input : None 												///
    /// Output: None 												///
    /// Returns Nothing												///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    private void andMoneyIsPizza(){
        int time = 0;
        TellerArray tellers = new TellerArray(); // array of 2 tellers, w/ method to check for free teller
        CustomerQueue customerQueue = new CustomerQueue(); // queue for waiting customers
        EventQueue eventQueue = new EventQueue(); // eventQueue (really a linkedList

        Customer firstCustomer = NewCustomer.newCustomer(time);
        eventQueue.pushEvent(firstCustomer);


        while (time < 480){
            time = Handler.handle(eventQueue, tellers, customerQueue);

        }
        System.out.printf("\nMax customers in queue %d", customerQueue.getLongestQueue());
        System.out.printf("\nLongest wait time in queue %d min", customerQueue.getLongestWait());

    }
}
