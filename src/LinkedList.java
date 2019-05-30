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
// Linked list used by event queue
//
// Assumptions:
// only used for customers
//
public class LinkedList<Event> {

    private Node<Event> head;
    private int count;

     LinkedList() {
        head = null;
        count = 0;
    }

    void addToHead(Event data) {
        Node<Event> ng = new Node<>();
        ng.setData(data);

        ng.setNext(head);

        head = ng;
        count++;
    }


     Node<Event> searchLowest() {

        Node<Event> pointer = head;
        int min = Integer.MAX_VALUE;
        Node<Event> tmpNode = new Node<>();
        while (pointer != null)
        {
           Event tmpEvent = pointer.getData();

           if (tmpEvent instanceof Customer){
               Customer tmpCustEvent = (Customer) tmpEvent;
               if (tmpCustEvent.getEventTime() < min) {
                   min = tmpCustEvent.getEventTime();
                   tmpNode.setData((Event) tmpCustEvent);
               }
           }
            if (tmpEvent instanceof Teller) {
                Teller tmpCustEvent = (Teller) tmpEvent;
                if (tmpCustEvent.getEventTime() < min) {
                    min = tmpCustEvent.getEventTime();
                    tmpNode.setData((Event) tmpCustEvent);

                }
            }

            pointer = pointer.getNext();
        }

        return  tmpNode;
    }


    public void deleteNode(Event event) {
        Node<Event> tmp = head;
        Node<Event> prev = null;


        if (tmp != null && tmp.getData() == event) {
            head = tmp.getNext(); // Changed head
            return;
        }


        while (tmp != null && tmp.getData() != event) {
            prev = tmp;
            tmp = tmp.getNext();
        }

        if (tmp == null){
            return;
        }

        if (prev != null) {
            prev.setNext(tmp.getNext());
        }
        count--;
    }



    public String toString() {
        String rtn = "";

        if (head == null) {
            return "<Empty>";
        }

        Node<Event> tmp = head;

        while (tmp != null) {
            rtn += "<" + tmp.getData() + ">";
            tmp = tmp.getNext();
            if (tmp != null) {
                rtn += " -> ";
            } else {
                rtn += " -> null";
            }
        }

        return rtn;
    }

}