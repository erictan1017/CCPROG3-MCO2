public class Main{
    public static void main(String[] args){
        HRSModel hotelModel = new HRSModel();
        HRSView hotelView = new HRSView();

        HRSController hotelController = new HRSController(hotelView, hotelModel);
    }
}