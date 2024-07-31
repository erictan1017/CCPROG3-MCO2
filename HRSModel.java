import java.util.ArrayList;

/**Class that represents the Model in the MVC Hotel Reservation System
 * 
 */
public class HRSModel {
    private ArrayList<Hotel> hotelList;

    /**Creates a new HRSModel instance
     * 
     */
    public HRSModel() {
        this.hotelList = new ArrayList<>();
    }

    /**Gets the Hotel instance at a specific index
     * 
     * @param index index of Hotel instance to be returned
     * @return Hotel instance at the specific index
     */
    public Hotel getHotel(int index) {
        return this.hotelList.get(index);
    }


    /**Gets the index of a Hotel instance given the name
     * 
     * @param name name of Hotel instance 
     * @return index of Hotel instance
     */
    public int getHotelIndex(String name) {
        int index = -1;

        for (int i = 0; index == -1 && i < hotelList.size(); i++){
            if (hotelList.get(i).getName().equals(name))
                index = i;
        }

        return index;
    }

    /**Gets the number of Hotel instances
     * 
     * @return number of Hotel instances
     */
    public int getHotelCount() {
        return this.hotelList.size();
    }


    /**Gets the names of the Hotel instances
     * 
     * @return ArrayList of names of Hotel instances
     */
    public ArrayList<String> getHotelNames(){
        ArrayList<String> names = new ArrayList<String>();

        for (int i = 0; i < hotelList.size(); i++){
            names.add(hotelList.get(i).getName());
        }

        return names;
    }

    /**Checks if a Hotel instance with the name exists
     * 
     * @param name name to be checked
     * @return boolean value that determines if a Hotel instance with the name exists
     */
    public boolean doesNameExist(String name){
        boolean exist = false;

        for (int i = 0; !exist && i < hotelList.size(); i++){
            if (hotelList.get(i).getName().equals(name))
                exist = true;
        }

        return exist;
    }

    /**Checks if a name is unique
     * 
     * @param name name to be checked
     * @return boolean value that determines if the name is unique
     */
    public boolean isHotelNameUnique(String name) {
        boolean unique = true;
        
        if (name.equals(""))
            unique = false;
        else{
            for (int i = 0; unique && i < hotelList.size(); i++){
                if (hotelList.get(i).getName().equals(name))
                    unique = false;
            }
        }

        return unique;
    }

    /**Adds a new Hotel instance to the ArrayList
     * 
     * @param name name of new Hotel
     */
    public void addHotel(String name) {
        hotelList.add(new Hotel(name, name + "-1"));
    }


}
