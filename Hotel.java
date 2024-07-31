import java.util.ArrayList;

/**Class that represents a hotel and its properties
 * 
 */
public class Hotel{
    private String name;
    private double roomPrice;
    private int reservationCount;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservationList;

    /**Creates a new Hotel instance
     * 
     * @param hotelName name of hotel
     * @param roomName name of first room
     */
    public Hotel(String hotelName, String roomName){
        this.name = hotelName;
        this.roomPrice = 1299;
        this.reservationCount = 0;
        this.roomList = new ArrayList<Room>();
        this.roomList.add(new Room(roomName));
        this.reservationList = new ArrayList<Reservation>();
    }

    /**Gets the name of hotel
     * 
     * @return name of hotel
     */
    public String getName(){
        return this.name;
    }

    /**Gets the price of a room
     * 
     * @return room price
     */
    public double getRoomPrice(){
        return this.roomPrice;
    }
    
    /**Gets the number of reservations in a hotel
     * 
     * @return number of reservations in a hotel
     */
    public int getReservationCount(){
        return this.reservationCount;
    }

    /**Gets room instance of roomList at a specific index
     * 
     * @param index index of room in roomList
     * @return Room instance at index
     */
    public Room getRoom(int index){
        return this.roomList.get(index);
    }

    /**Gets the number of rooms present
     * 
     * @return number of rooms present
     */
    public int getRoomCount(){
        return this.roomList.size();
    }

    /**Gets the monthly earnings for the hotel
     * 
     * @return monthly earnings
     */
    public double getMonthlyEarnings(){
        double total = 0;

        for (int i = 0; i < this.reservationList.size(); i++){
            total += reservationList.get(i).getTotalPrice();
        }

        return total;
    }

    /**Changes the name of the hotel
     * 
     * @param name new name to replace old name
     */
    public void changeName(String name){
        this.name = name;
    }
   
    /**Gets the number of rooms that are booked
     * 
     * @return number of rooms that are booked
     */
    public int getBookedRooms(){
        int booked = 0;

        for (int i = 0; i < this.getRoomCount(); i++){
            if (roomList.get(i).checkReservation()){
                booked += 1;
            }
        }

        return booked;
    }

    /**Checks if new price can replace old price
     * 
     * @param newPrice new price 
     * @return boolean value representing if newPrice can replace old price
     */

    public boolean isNewPriceValid(double newPrice){
        boolean isChangeValid = true;
        
        if (newPrice < 100 || this.getReservationCount() > 0){
            isChangeValid = false;
        }

        return isChangeValid;
    }


    /**Changes the price of a room
     * 
     * @param newPrice new price of a room
     */
    public void setRoomPrice(double newPrice){
        this.roomPrice = newPrice;
    }

    /**Gets a Reservation instance at a specific index
     * 
     * @param index index of reservation
     * @return Reservation instance at index
     */
    public Reservation getReservation(int index){
        return this.reservationList.get(index);
    }

    /**Adds a new reservation
     * 
     * @param guestName name of guest
     * @param startTime check-in time
     * @param endTime check-out time
     * @param roomIndex index of room to be booked
     * @param price price of reservation
     */
    public void addReservation(String guestName, DateTime startTime, DateTime endTime, int roomIndex, double price){
        this.reservationList.add(new Reservation(guestName, startTime, endTime, this.roomList.get(roomIndex).getName(), price));
        this.reservationCount = this.reservationList.size();
    } 

    /**Removes a reservation at a specific index
     * 
     * @param index index of reservation to be removed
     */
    public void removeReservation(int index){
        this.reservationList.remove(index);
        this.reservationCount = this.reservationList.size();
    }

}