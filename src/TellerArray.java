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
// holds both teller objects
//
//
// Assumptions:
// only used for This bank simulation
//
public class TellerArray {

    private Teller[] tellers;
    ///////////////////////////////////////////////////////////////////
    /// TellerArray (Constructor)                       			///
    /// Input : None 												///
    /// Output: None 												///
    /// Creates two teller objects and places them in array			///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    TellerArray(){
        tellers = new Teller[2];
        tellers[0] = new Teller(0);
        tellers[1] = new Teller(1);
    }
    ///////////////////////////////////////////////////////////////////
    /// checkFreeTeller                                 			///
    /// Input : none 												///
    /// Output: Teller object or null 								///
    /// Returns Teller object if free or null if not free			///
    /// 															///
    ///////////////////////////////////////////////////////////////////
    public Teller checkFreeTeller() {
        for (int i = 0; i<2; i++) {
            if (tellers[i].isFree()) {
                return tellers[i];
            }
        }
        return null;
    }
}
