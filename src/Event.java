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
// Event interface
//
//
// Assumptions:
// only used for This bank simulation
//
public interface Event {
    ///////////////////////////////////////////////////////////////////
    /// getEventTime                              				    ///
    /// Input : none 			                                    ///
    /// Output: int time                                            ///
    /// gets the time of customer event or teller event depending   ///
    /// on implementing class                                      	///
    ///////////////////////////////////////////////////////////////////
    int getEventTime();
}
