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
// This is a event linked list. It is used for holding events
//
// Assumptions:
// only used for events
//
// NOT ACTUALLY A QUEUE
//
public class EventQueue {

    private LinkedList<Event> events;

    ///////////////////////////////////////////////////////////////////
    /// EventQueue constructor                              		///
    /// Input : none                                      			///
    /// Output: none                                                ///
    /// creates a new LinkedList object                         	///
    ///////////////////////////////////////////////////////////////////
    public EventQueue() {
        events = new LinkedList<>();
    }
    ///////////////////////////////////////////////////////////////////
    /// pushEvent                                             		///
    /// Input : Event object                                        ///
    /// Output: none                                                ///
    /// calls Event object addToHead method passing event          	///
    ///////////////////////////////////////////////////////////////////
    public void pushEvent(Event event) {
        events.addToHead(event);
    }
    ///////////////////////////////////////////////////////////////////
    /// nextEvent                         		                    ///
    /// Input : none                                      			///
    /// Output: Event Object                                        ///
    /// gets the next event chronologicaly by calling searchLowest  ///
    /// method. It then deletes that event so it is not repeated    ///
    ///////////////////////////////////////////////////////////////////
    public Event nextEvent(){
        Node<Event> event = events.searchLowest(); // get lowest event
        Event data = event.getData(); // get event data from node
        events.deleteNode(data); // delete data so it is not used again

        return data;
    }
}
