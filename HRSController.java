import java.awt.event.*;
import javax.swing.*;

/**Class that represents the controller in the MVC Hotel Reservation System
 * 
 */
public class HRSController{
    private HRSView view;
    private HRSModel model;

    /**Creates a new HRSController instance
     * 
     * @param view Class that represents the View in the MVC Hotel Reservation System
     * @param model Class that represents the Model in the MVC Hotel Reservation System
     */
    public HRSController(HRSView view, HRSModel model){
        this.view = view;
        this.model = model;

        this.view.setMainMenuBtnsListener(returnToMainMenuListener);

        this.view.setCreateBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.cards.show(view.panels, "CREATE HOTEL");
            }
        });

        this.view.setViewBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                view.hotelNames.removeAllElements();
                
                for (int i = 0; i < model.getHotelCount(); i++){
                    view.hotelNames.add(i, model.getHotelNames().get(i));
                }

                view.cards.show(view.panels, "VIEW HOTEL");
                view.highLevelInfoButton.setVisible(false);
                view.lowLevelInfoButton.setVisible(false);
            }
        });

        this.view.setCreateSubmitBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.isHotelNameUnique(view.createHotelName.getText())){
                    view.setHotelCreationText("HOTEL SUCCESSFULLY CREATED.");
                    model.addHotel(view.createHotelName.getText());
                }
                else
                    view.setHotelCreationText("HOTEL COULD NOT BE CREATED.");
            }
        });

        this.view.setViewSubmitBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.doesNameExist(view.viewHotelName.getText())){
                    view.setHotelViewText("HOTEL FOUND. PLEASE SELECT THE INFORMATION TO BE VIEWED.");
                                    
                    view.viewHotelPanel.add(view.highLevelInfoButton);
                    view.viewHotelPanel.add(view.lowLevelInfoButton);
                    view.highLevelInfoButton.setVisible(true);
                    view.lowLevelInfoButton.setVisible(true);
                }
                else{
                    view.setHotelViewText("HOTEL NOT FOUND.");
                    view.highLevelInfoButton.setVisible(false);
                    view.lowLevelInfoButton.setVisible(false);
                }
            }
        });

        this.view.highLevelInfoBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.highLevelInfo = new DefaultListModel<String>();
                int index = model.getHotelIndex(view.viewHotelName.getText());
                view.highLevelInfo.add(0, "NAME : " + model.getHotel(index).getName());
                view.highLevelInfo.add(1, "TOTAL ROOMS : " + model.getHotel(index).getRoomCount());
                view.highLevelInfo.add(2, "ESTIMATED EARNINGS FOR THE MONTH : " + model.getHotel(index).getMonthlyEarnings());
                view.addHighLevelInfo();

                view.viewHotelPanel.revalidate();
                view.viewHotelPanel.repaint();
            }
        });

        this.view.setManageBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               view.cards.show(view.panels, "MANAGE HOTEL");
            }
        });

        this.view.setManageSubmitBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.doesNameExist(view.manageHotelName.getText())){
                    view.setHotelManageText("HOTEL FOUND.");
                                    
                    view.manageHotelPanel.revalidate();
                    view.manageHotelPanel.repaint();
                }
                else{
                    view.setHotelManageText("HOTEL NOT FOUND.");

                }
            }
        });
    }

    ActionListener returnToMainMenuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cards.show(view.panels, "MAIN MENU");
            view.resethotelCreateLabel();
            view.resethotelViewLabel();

        }
    };
}