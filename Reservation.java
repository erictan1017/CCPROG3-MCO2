/**Class that represents a hotel reservation and its properties
 * 
 */
public class Reservation{
    private String guestName;
    private DateTime startTime;
    private DateTime endTime;
    private String roomName;
    private double totalPrice;
    private int nightCount;

    /**Creates new Reservation instance
     * 
     * @param name name of guest
     * @param startTime check-in time
     * @param endTime check-out time
     * @param roomName name of room
     * @param price price of room per night
     */
    public Reservation(String name, DateTime startTime, DateTime endTime, String roomName, double price){
        this.guestName = name;
        this.startTime = new DateTime(startTime.getDay(), startTime.getHour(), startTime.getMinute(), true);
        this.endTime = new DateTime(endTime.getDay(), endTime.getHour(), endTime.getMinute(), false);
        this.roomName = roomName; 
        this.nightCount = (endTime.getDay() - startTime.getDay()) + 1;
        this.totalPrice += this.nightCount * price;
    }

    /**Gets name of guest
     * 
     * @return name of guest
     */
    public String getGuestName(){
        return this.guestName;
    }

    /**Gets check-in time
     * 
     * @return check-in time
     */
    public DateTime getStartTime(){
        return this.startTime;
    }

    /**Gets check-out time
     * 
     * @return check-out time
     */
    public DateTime getEndTime(){
        return this.endTime;
    }

    /**Gets name of reserved room
     * 
     * @return name of reserved room
     */
    public String getRoomName(){
        return this.roomName;
    }

    /**Gets total price for whole reservation
     * 
     * @return total price for whole reservation
     */
    public double getTotalPrice(){
        return this.totalPrice;
    }

    /**Gets number of nights stayed 
     * 
     * @return number of nights stayed 
     */
    public int getNightCount(){
        return this.nightCount;
    }

    /**Checks if a reservation time overlaps
     * 
     * @param startTime check-in time
     * @param endTime check-in time
     * @return boolean value representing if the times overlap
     */
    public boolean doesReservationOverlap(DateTime startTime, DateTime endTime){
        boolean overlap = false;

        if (endTime.getDay() > this.startTime.getDay()){
            if (this.endTime.getDay() > startTime.getDay()){
                overlap = true;
            }
            else if (this.endTime.getDay() == startTime.getDay()){
                if (this.endTime.getHour() > startTime.getHour())
                    overlap = true;
                else if (this.endTime.getHour() == startTime.getHour()){
                    if (this.endTime.getMinute() > startTime.getMinute())
                        overlap = true;
                }
            }
        }
        else if (endTime.getDay() == this.startTime.getDay()){
            if (endTime.getHour() > this.startTime.getHour())
                    overlap = true;
            else if (endTime.getHour() == this.startTime.getHour()){
                if (endTime.getMinute() > this.startTime.getMinute())
                    overlap = true;
            }
        }
        
        return overlap;
    }

}