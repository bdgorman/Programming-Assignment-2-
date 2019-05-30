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
// generates a new custoemr event object
//
//
// Assumptions:
// only used for This bank simulation
//
import java.util.Random;

public class NewCustomer {
    ///////////////////////////////////////////////////////////////////
    /// newCustomer                              			    	///
    /// Input : time                                      			///
    /// Output: Customer object with random arrival and service time///
    ///                                                             ///
    ///////////////////////////////////////////////////////////////////
    public static Customer newCustomer(int time){
        int arrivalTime = time + getRandom(1, 4); // change these to change arrival interval
        int serviceTime = getRandom(1, 4);

        Customer newCust = new Customer();
        newCust.setArrivalTime(arrivalTime);
        newCust.setServiceDuration(serviceTime);

        return newCust;
    }
    ///////////////////////////////////////////////////////////////////
    /// getRandom                              			    	    ///
    /// Input : min and max ints                                    ///
    /// Output: random int between min and max                      ///
    ///                                                             ///
    ///////////////////////////////////////////////////////////////////
    public static int getRandom(int min, int max){
        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }
}
