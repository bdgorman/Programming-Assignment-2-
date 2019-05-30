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
// This is a Customer object. it is a type of event. it has setters and getters
//
// Assumptions:
// only used for This bank simulation
//

import java.util.Objects;

public class Customer implements Event{
    private int arrivalTime = 0;
    private int serviceDuration;
    ///////////////////////////////////////////////////////////////////
    /// setArrivalTime()                       			    	    ///
    /// Input : int arrivalTime                                     ///
    /// Output: void                                                ///
    /// simple setter                                               ///
    ///////////////////////////////////////////////////////////////////
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    ///////////////////////////////////////////////////////////////////
    /// getServiceDuration()                			    	    ///
    /// Input : none                                                ///
    /// Output:int serviceDuration                                  ///
    /// simple getter                                               ///
    ///////////////////////////////////////////////////////////////////
    public int getServiceDuration() {
        return serviceDuration;
    }
    ///////////////////////////////////////////////////////////////////
    /// setServiceDuration()                      			    	///
    /// Input : int serviceDuration                                 ///
    /// Output: void                                                ///
    /// simple setter                                               ///
    ///////////////////////////////////////////////////////////////////
    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    } // getters

    ///////////////////////////////////////////////////////////////////
    /// getEventTime()                      			    	    ///
    /// Input : none                                                ///
    //  Output: int arrivalTime                                     ///
    //  simple getter                                               ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public int getEventTime() {
        return arrivalTime;
    }
    ///////////////////////////////////////////////////////////////////
    /// toString()                             			    	    ///
    /// Input : none                                                ///
    /// Output: String                                              ///
    /// formats customer information                                ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Customer " +
                "arrivalTime = " + arrivalTime +
                ", serviceDuration = " + serviceDuration;
    }
    ///////////////////////////////////////////////////////////////////
    /// equals()                      			    	            ///
    /// Input :Object o                                             ///
    /// Output: boolean                                             ///
    /// checks two customer objects for equality based on arrival   ///
    /// time and duration                                           ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return arrivalTime == customer.getEventTime() &&
                serviceDuration == customer.getServiceDuration();
    }
    ///////////////////////////////////////////////////////////////////
    /// hashCode()                      			    	        ///
    /// Input : none                                                ///
    /// Output: int object hash                                     ///
    ///                                                             ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        return Objects.hash(arrivalTime, serviceDuration);
    }
}
