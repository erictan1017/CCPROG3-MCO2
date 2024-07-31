/**Class that represents a date and time 
 * 
 */
public class DateTime{
    private int day;
    private int hour;
    private int minute;
    private boolean startOrEnd;

    /**Creates a new DateTime instance
     * 
     * @param day day of date
     * @param hour hour of time
     * @param minute minute of time
     * @param startOrEnd boolean value representing if instance is a startDate (true) or an endDate (false)
     */
    public DateTime(int day, int hour, int minute, boolean startOrEnd){
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.startOrEnd = startOrEnd;
    }

    /**Gets day of date
     * 
     * @return day of date
     */
    public int getDay(){
        return this.day;
    }

    /**Gets hour of time
     * 
     * @return hour of time
     */
    public int getHour(){
        return this.hour;
    }

    /**Gets minute of time
     * 
     * @return minute of time
     */
    public int getMinute(){
        return this.minute;
    }

    /**Checks if DateTime instance is a startDate (true) or an endDate (false)  
     * 
     * @return boolean value representing if DateTime instance is a startDate (true) or an endDate (false)  
     */
    public boolean getStartOrEnd(){
        return this.startOrEnd;
    }

    /**Changes day of date
     * 
     * @param day day of date
     */
    public void setDay(int day){
        this.day = day;
    }

    /**Changes hour of time
     * 
     * @param hour hour of time
     */
    public void setHour(int hour){
        this.hour = hour;
    }

    /**Changes minute of time
     * 
     * @param minute minute of time
     */
    public void setMinute(int minute){
        this.minute = minute;
    }
}