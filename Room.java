/**Class that represents a hotel room and its properties
 * 
 */
public class Room{
    private String roomName;
    private boolean isReserved;
    private int reservationCount;

    /**Creates a new Room instance
     * 
     * @param name name of new room
     */
    public Room(String name){
        this.roomName = name;
        this.isReserved = false;
        this.reservationCount = 0;
    }
    
    /**Gets the name of room
     * 
     * @return name of room
     */
    public String getName(){
        return this.roomName;
    }

    /**Gets the number of reservations for the room
     * 
     * @return number of reservations for the room
     */
    public int getReservationCount(){
        return this.reservationCount;
    }

    /**Checks if room has a reservation
     * 
     * @return boolean value representing if room has a reservation
     */
    public boolean checkReservation(){
        return this.isReserved;
    }

    /**Changes name of room
     * 
     * @param name new name of room
     */
    public void setName(String name){
        this.roomName = name;
    }
    
    /**Changes reservation status based on number of reservations
     * 
     */
    public void setReservationStatus(){
        if (this.reservationCount == 0) 
            this.isReserved = false;
        else
            this.isReserved = true;
    }

    /**Adds to the reservation count
     * 
     * @param add number to be aded to reservation count
     */
    public void addReservationCount(int add){
        this.reservationCount += add;
    }

}