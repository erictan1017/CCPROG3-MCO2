import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**Class that represents the View in the MVC Hotel Reservation System
 * 
 */
public class HRSView{
    private JFrame mainFrame;
	private JLabel hotelNameLabel, hotelCreateSuccessLabel, hotelViewSuccessLabel, hotelManageSuccessLabel;
	private JButton createHotelButton, viewHotelButton, manageHotelButton, bookReservationButton;
    private JButton createSubmitButton, viewSubmitButton, manageSubmitButton;

    private ArrayList<JButton> mainMenuButtons;
    protected JButton highLevelInfoButton, lowLevelInfoButton;
    protected CardLayout cards;
    protected JPanel panels, mainMenuPanel, createHotelPanel, viewHotelPanel, manageHotelPanel, bookReservationPanel;
    protected JTextField createHotelName, viewHotelName, manageHotelName;
    protected DefaultListModel<String> hotelNames, highLevelInfo;
    protected JList<String> viewHotels, highLevelInfoList, manageHotels;
    protected JScrollPane viewHotelNamePane, highLevelInfoPane, manageHotelNamePane;
    
    /**Creates a new HRSView instance
     * 
     */
    public HRSView(){
        //Create main frame
        this.mainFrame = new JFrame("HOTEL RESERVATION SYSTEM");
        this.cards = new CardLayout();
        this.panels = new JPanel(cards);

        // Create panels
        this.mainMenuPanel = new JPanel();
        this.createHotelPanel = new JPanel();
        this.viewHotelPanel = new JPanel();
        this.manageHotelPanel = new JPanel(cards);
        this.bookReservationPanel = new JPanel();
    
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new BorderLayout());
		this.mainFrame.setSize(465, 750);

        // Create panel buttons and add labels to panels
        this.createHotelButton = new JButton("CREATE HOTEL");
		this.createHotelButton.setPreferredSize(new Dimension(170, 30));
        this.createHotelPanel.add(new JLabel("CREATE HOTEL"));

        this.viewHotelButton = new JButton("VIEW HOTEL");
		this.viewHotelButton.setPreferredSize(new Dimension(170, 30));
        this.viewHotelPanel.add(new JLabel("VIEW HOTEL"));

        this.manageHotelButton = new JButton("MANAGE HOTEL");
		this.manageHotelButton.setPreferredSize(new Dimension(170, 30));
        this.manageHotelPanel.add(new JLabel("MANAGE HOTEL"));
        
        this.bookReservationButton = new JButton("BOOK RESERVATION");
		this.bookReservationButton.setPreferredSize(new Dimension(170, 30));
        this.bookReservationPanel.add(new JLabel("BOOK RESERVATION"));

        //Add hotel buttons to main menu
        this.mainMenuPanel.add(this.createHotelButton);
		this.mainMenuPanel.add(this.viewHotelButton);
		this.mainMenuPanel.add(this.manageHotelButton);
		this.mainMenuPanel.add(this.bookReservationButton);

        //Add return to main menu buttons to panels
        this.mainMenuButtons = new ArrayList<JButton>();

        for (int i = 0; i < 10; i++){
            this.mainMenuButtons.add(new JButton("RETURN TO MAIN MENU"));
            this.mainMenuButtons.get(i).setPreferredSize(new Dimension(200, 30));
        }

        this.createHotelPanel.add(this.mainMenuButtons.get(0), BorderLayout.SOUTH);
        this.viewHotelPanel.add(this.mainMenuButtons.get(1), BorderLayout.SOUTH);
        this.manageHotelPanel.add(this.mainMenuButtons.get(2), BorderLayout.SOUTH);
        this.bookReservationPanel.add(this.mainMenuButtons.get(3), BorderLayout.SOUTH);

        //Add GUI for each panel
        addCreateHotelGUI();
        addViewHotelGUI();
        addManageHotelGUI();

        //Add all panels to layout
        this.panels.add(mainMenuPanel, "MAIN MENU");
        this.panels.add(createHotelPanel, "CREATE HOTEL");
        this.panels.add(viewHotelPanel, "VIEW HOTEL");
        this.panels.add(manageHotelPanel, "MANAGE HOTEL");
        this.panels.add(bookReservationPanel, "BOOK RESERVATION");

		this.mainFrame.add(this.panels);
        
        this.mainFrame.setVisible(true);
    }

    /**Sets the text to be displayed if a hotel creation is successfully created
     * 
     * @param text text to be displayed
     */
    public void setHotelCreationText(String text){
        this.hotelCreateSuccessLabel.setText(text);
    }

    /**Adds GUI elements to createHotelPanel
     * 
     */
    public void addCreateHotelGUI(){
        JLabel hotelNameLabel = new JLabel("ENTER NEW HOTEL NAME: ");
        this.createHotelName = new JTextField();
        this.hotelCreateSuccessLabel = new JLabel();

        createHotelName.setColumns(15);
        createHotelPanel.add(hotelNameLabel, BorderLayout.NORTH);
        createHotelPanel.add(createHotelName, BorderLayout.NORTH); 

        createSubmitButton = new JButton("SUBMIT");
        createSubmitButton.setPreferredSize(new Dimension(100, 30));

        createHotelPanel.add(createSubmitButton, BorderLayout.NORTH);
        createHotelPanel.add(hotelCreateSuccessLabel, BorderLayout.NORTH);
    }
    
    /**Resets the text to be displayed if a hotel creation is successfully created
     * 
     */
    public void resethotelCreateLabel(){
        this.hotelCreateSuccessLabel.setText("");
        this.createHotelName.setText("");
    }

    /**Adds GUI elements to viewHotelPanel
     * 
     */
    public void addViewHotelGUI(){
        hotelNames = new DefaultListModel<String>();
        viewHotels = new JList<>(hotelNames);
        viewHotelNamePane = new JScrollPane(viewHotels);
        viewHotelPanel.add(viewHotelNamePane, BorderLayout.EAST);

        hotelNameLabel = new JLabel("ENTER VIEW HOTEL NAME: ");

        this.viewHotelName = new JTextField();
        this.hotelViewSuccessLabel = new JLabel();

        viewHotelName.setColumns(15);
        viewHotelPanel.add(hotelNameLabel);
        viewHotelPanel.add(viewHotelName); 

        viewSubmitButton = new JButton("SUBMIT");
        viewSubmitButton.setPreferredSize(new Dimension(100, 30));

        viewHotelPanel.add(viewSubmitButton, BorderLayout.CENTER);
        viewHotelPanel.add(hotelViewSuccessLabel);

        highLevelInfoButton = new JButton("HIGH LEVEL INFORMATION");
        highLevelInfoButton.setPreferredSize(new Dimension(250, 30));
        lowLevelInfoButton = new JButton("LOW LEVEL INFORMATION");
        lowLevelInfoButton.setPreferredSize(new Dimension(250, 30));
    }

    /**Sets the text to be displayed if a hotel can be viewed
     * 
     * @param text text to be displayed if a hotel can be viewed
     */
    public void setHotelViewText(String text){
        this.hotelViewSuccessLabel.setText(text);
    }

    /**Adds the high-level information of a Hotel instance to the panel
     * 
     */
    public void addHighLevelInfo(){
        highLevelInfoList = new JList<>(highLevelInfo);
        highLevelInfoPane = new JScrollPane(highLevelInfoList);
        viewHotelPanel.add(highLevelInfoPane, BorderLayout.CENTER);
    }

    /**Resets the text to be displayed if a hotel can be viewed
     * 
     */
    public void resethotelViewLabel(){
        this.hotelViewSuccessLabel.setText("");
        this.viewHotelName.setText("");
    }

    /**Adds GUI elements to manageHotelPanel
     * 
     */
    public void addManageHotelGUI(){
        manageHotels = new JList<>(hotelNames);
        manageHotelNamePane = new JScrollPane(manageHotels);
        manageHotelPanel.add(manageHotelNamePane);

        hotelNameLabel = new JLabel("ENTER MANAGING HOTEL NAME: ");

        manageHotelName = new JTextField();
        hotelManageSuccessLabel = new JLabel();

        manageHotelName.setColumns(15);
        manageHotelPanel.add(hotelNameLabel);
        manageHotelPanel.add(manageHotelName); 

        manageSubmitButton = new JButton("SUBMIT");
        manageSubmitButton.setPreferredSize(new Dimension(100, 30));
        
        manageHotelPanel.add(manageSubmitButton);
        manageHotelPanel.add(hotelManageSuccessLabel);
    }

    /**Sets the text to be displayed if a hotel can be managed
     * 
     * @param text text to be displayed if a hotel can be managed
     */
    public void setHotelManageText(String text){
        this.hotelManageSuccessLabel.setText(text);
    }
    
    /**Assigns an action to the main menu buttons
     * 
     * @param actionListener action to be assigned 
     */
    public void setMainMenuBtnsListener(ActionListener actionListener) {
		for (int i = 0; i < this.mainMenuButtons.size(); i++){
            this.mainMenuButtons.get(i).addActionListener(actionListener);
        }
	}

    /**Assigns an action to the Create Hotel button
     * 
     * @param actionListener action to be assigned 
     */
    public void setCreateBtnListener(ActionListener actionListener) {
		this.createHotelButton.addActionListener(actionListener);
	}

    /**Assigns an action to the createSubmitbutton
     * 
     * @param actionListener action to be assigned 
     */
    public void setCreateSubmitBtnListener(ActionListener actionListener) {
		this.createSubmitButton.addActionListener(actionListener);
	}

    /**Assigns an action to the View Hotel button
     * 
     * @param actionListener action to be assigned 
     */
	public void setViewBtnListener(ActionListener actionListener) {
		this.viewHotelButton.addActionListener(actionListener);
	}
    
    /**Assigns an action to the viewSubmitbutton
     * 
     * @param actionListener action to be assigned 
     */
    public void setViewSubmitBtnListener(ActionListener actionListener) {
		this.viewSubmitButton.addActionListener(actionListener);
	}

    /**Assigns an action to the highLevelInfoButton
     * 
     * @param actionListener action to be assigned 
     */
    public void highLevelInfoBtnListener(ActionListener actionListener) {
		this.highLevelInfoButton.addActionListener(actionListener);
	}

    /**Assigns an action to the highLevelInfoButton
     * 
     * @param actionListener action to be assigned 
     */
    public void lowLevelInfoBtnListener(ActionListener actionListener) {
		this.lowLevelInfoButton.addActionListener(actionListener);
	}

    /**Assigns an action to the Manage Button button
     * 
     * @param actionListener action to be assigned 
     */
    public void setManageBtnListener(ActionListener actionListener) {
		this.manageHotelButton.addActionListener(actionListener);
	}
    
    /**Assigns an action to the manageSubmitbutton
     * 
     * @param actionListener action to be assigned 
     */
    public void setManageSubmitBtnListener(ActionListener actionListener) {
		this.manageSubmitButton.addActionListener(actionListener);
	}

    /**Assigns an action to the Book Reservation button
     * 
     * @param actionListener action to be assigned 
     */
    public void setBookReservationBtnListener(ActionListener actionListener) {
		this.bookReservationButton.addActionListener(actionListener);
	} 

}