//---------------------------------------------------------------------------
//
// The Bank Simulation
// Simulates a Bank with a queue
//
// Author: Benjamin Gorman
// Date: 04/02/2019
// Class: MET CS342
// Issues:
//
// Description:
// Takes an event off of the event queue and handles it as
// needed. returns the time of event to keep time up to date
//
// Assumptions:
// only used for This bank simulation
//

public class Handler {

    ///////////////////////////////////////////////////////////////////
    /// handle                              				    	///
    /// Input : EventQueue, TellerArray, CustomerQueue  			///
    /// Output: time of event being handled (current relative time) ///
    /// Takes an event off of the event queue and handles it as 	///
    /// needed. returns the time of event to keep time up to date	///
    ///////////////////////////////////////////////////////////////////
    public static int handle(EventQueue events, TellerArray tellers, CustomerQueue custQueue){
        Event tempEvent;

        tempEvent = events.nextEvent(); // get the next event
        int time = tempEvent.getEventTime();

        //// if event is customer arriving to bank////
        if (tempEvent instanceof Customer){
            Event newCustomer = NewCustomer.newCustomer(time); // gen new customer arrival event
            events.pushEvent(newCustomer); // add new customer arrival event to event list
            Teller openTeller = tellers.checkFreeTeller();

            if (openTeller == null){ // null result means no free teller
                custQueue.add((Customer) tempEvent); // add customer to customer queue
                System.out.printf("\nCustomer arrived at %d min, no open teller, customer sent to queue", tempEvent.getEventTime());

            }else{
                System.out.printf("\nCustomer arrived at %d min, being helped by teller %d", tempEvent.getEventTime(), openTeller.getTellerNumber());
                int tellerBusy = ((Customer) tempEvent).getServiceDuration(); // get customer service duration
                openTeller.setNextFree(time + tellerBusy); // set the time when teller free event is handled
                openTeller.setIsFree(false); // mark teller busy
                events.pushEvent(openTeller); // push event into event cue
            }

        }
        ////teller event indicates a teller has opened up ////
        else if (tempEvent instanceof Teller){
           System.out.printf("\nTeller %s finished helping customer at %d", ((Teller) tempEvent).getTellerNumber(), time);

           // if customer queue is not empty then customer is removed from queue and teller is set as busy (setIsFree(false))
           if(!custQueue.isEmpty()) {
               Customer nextCustomer = custQueue.remove(); //remove from queue
               // this calculates customer wait time and sends it to customer queue
               int waitTime;
               int customerArrives = nextCustomer.getEventTime();
               waitTime = time - customerArrives;
               custQueue.submitWaitTime(waitTime);
               // get this customer service duration and set the time free
               // value for the teller based on this number plus time
               int duration = nextCustomer.getServiceDuration();
               ((Teller) tempEvent).setIsFree(false);
               ((Teller) tempEvent).setNextFree(time + duration);
               events.pushEvent(tempEvent);
               return time;
           }else {
               ((Teller) tempEvent).setIsFree(true); // if the queue is free, then the teller is set to setIsFree(true)
           }
        }
        return time;
    }
}
