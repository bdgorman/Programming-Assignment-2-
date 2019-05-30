public class Teller implements Event {

    private boolean isFree;
    private int nextFree;
    private int tellerNumber;

    ///////////////////////////////////////////////////////////////////
    /// Teller constructor                      		    	    ///
    /// Input : int num                                             ///
    /// Output: none                                                ///
    /// sets isFree method to true, sets the next                   ///
    /// free to 0 sets teller num to num                            ///
    ///////////////////////////////////////////////////////////////////
    public Teller(int num) {
        isFree = true;
        nextFree = 0;
        tellerNumber = num;
    }
    ///////////////////////////////////////////////////////////////////
    /// isFree                              			    	    ///
    /// Input : none                                                ///
    /// Output: boolean                                             ///
    /// returns boolean isFree                                      ///
    ///////////////////////////////////////////////////////////////////
    public boolean isFree() {
        return isFree;
    }
    ///////////////////////////////////////////////////////////////////
    /// setIsFree                              			    	    ///
    /// Input :boolean free                                         ///
    /// Output: none                                                ///
    /// setIsFree to free                                                            ///
    ///////////////////////////////////////////////////////////////////
    public void setIsFree(boolean free) {
        isFree = free;
    }
    ///////////////////////////////////////////////////////////////////
    /// setNextFree                              			        ///
    /// Input : int nextFree                                        ///
    /// Output: none                                                ///
    /// sets this nextFree to passed int nextFree                   ///
    ///////////////////////////////////////////////////////////////////
    public void setNextFree(int nextFree) {
        this.nextFree = nextFree;
    }
    ///////////////////////////////////////////////////////////////////
    /// getTellerNumber                              			    ///
    /// Input : none                                                ///
    /// Output: tellerNumber                                        ///
    /// simple getter                                               ///
    ///////////////////////////////////////////////////////////////////
    public int getTellerNumber() {
        return tellerNumber;
    }
    ///////////////////////////////////////////////////////////////////
    /// getEventTime                              		            ///
    /// Input : none                                                ///
    /// Output: nextFree                                            ///
    /// simple getter                                               ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public int getEventTime() {
        return nextFree;
    }
    ///////////////////////////////////////////////////////////////////
    /// toString                              			    	    ///
    /// Input : none                                                ///
    /// Output: String                                              ///
    ///  returns a string with all teller info, used for testing    ///
    ///////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Teller{" +
                "isFree=" + isFree +
                ", nextFree=" + nextFree +
                ", tellerNumber=" + tellerNumber +
                '}';
    }
}