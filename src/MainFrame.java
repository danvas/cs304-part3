//GREAT JORB! (this wasn't including in commit)

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private AMSOracleConnection con = null;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTable table;
	private JTextField instorepurchqty;
	private JTextField instorecardexpd;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField custUName;
	private JTextField custPW;
	private JTextField custRegId;
	private JTextField custRegPW;
	private JTextField custRegName;
	private JTextField custRegAddr;
	private JTextField custPNum;
	private JTable instorePurchaseItems;
	private JTextField instPurchUPC;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		con = AMSOracleConnection.getInstance();
		setTitle("AMS Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		JPanel login = new JPanel();
		login.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_login = new GridBagLayout();
		gbl_login.columnWidths = new int[]{0, 414, 0};
		gbl_login.rowHeights = new int[]{24, 24, 24, 24, 24, 24, 24, 0, 24, 24, 0};
		gbl_login.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_login.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		login.setLayout(gbl_login);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		login.add(lblNewLabel, gbc_lblNewLabel);
		
		final JTextField userName = new JTextField();
		GridBagConstraints gbc_userName = new GridBagConstraints();
		gbc_userName.fill = GridBagConstraints.BOTH;
		gbc_userName.insets = new Insets(0, 0, 5, 0);
		gbc_userName.gridx = 1;
		gbc_userName.gridy = 2;
		login.add(userName, gbc_userName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		login.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		login.add(passwordField, gbc_passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Specify Your Access Level:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		login.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		final JComboBox AccessLevel = new JComboBox();
		AccessLevel.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Clerk", "Manager"}));
		GridBagConstraints gbc_AccessLevel = new GridBagConstraints();
		gbc_AccessLevel.fill = GridBagConstraints.BOTH;
		gbc_AccessLevel.insets = new Insets(0, 0, 5, 0);
		gbc_AccessLevel.gridx = 1;
		gbc_AccessLevel.gridy = 6;
		login.add(AccessLevel, gbc_AccessLevel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (con.connect(userName.getText(), 
					     String.valueOf(passwordField.getPassword()))){
					String access = (String) AccessLevel.getSelectedItem();
					switchToNextCard(access);
					// select next card based on accesslevel
					
					
				}
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 7;
		login.add(btnSubmit, gbc_btnSubmit);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 0, 5);
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 9;
		login.add(separator_3, gbc_separator_3);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(login, "name_1441150054636723");
		
		JTabbedPane clerkOperations = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(clerkOperations, "name_1442560847488307");
		
		JPanel processPurchase = new JPanel();
		processPurchase.setBorder(new EmptyBorder(10, 10, 10, 10));
		clerkOperations.addTab("Purchase", null, processPurchase, null);
		GridBagLayout gbl_processPurchase = new GridBagLayout();
		gbl_processPurchase.columnWidths = new int[]{32, 99, 82, 0, 0, 0, 0, 0, 0, 0, 0, 105, 0, 0, 0, 0, 125, 0};
		gbl_processPurchase.rowHeights = new int[]{20, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 27, 20, 0, 0, 35, 23, 35, 0, 0, 23, 0};
		gbl_processPurchase.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_processPurchase.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		processPurchase.setLayout(gbl_processPurchase);
		
		JLabel label = new JLabel("UPC:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 8;
		processPurchase.add(label, gbc_label);
		
		instPurchUPC = new JTextField();
		GridBagConstraints gbc_instPurchUPC = new GridBagConstraints();
		gbc_instPurchUPC.gridwidth = 8;
		gbc_instPurchUPC.insets = new Insets(0, 0, 5, 5);
		gbc_instPurchUPC.fill = GridBagConstraints.HORIZONTAL;
		gbc_instPurchUPC.gridx = 8;
		gbc_instPurchUPC.gridy = 8;
		processPurchase.add(instPurchUPC, gbc_instPurchUPC);
		
		JButton addpurchitem = new JButton("Add Item");
		GridBagConstraints gbc_addpurchitem = new GridBagConstraints();
		gbc_addpurchitem.gridwidth = 6;
		gbc_addpurchitem.insets = new Insets(0, 0, 5, 0);
		gbc_addpurchitem.gridx = 16;
		gbc_addpurchitem.gridy = 8;
		processPurchase.add(addpurchitem, gbc_addpurchitem);
		
		JLabel lblQuantity_5 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity_5 = new GridBagConstraints();
		gbc_lblQuantity_5.gridwidth = 4;
		gbc_lblQuantity_5.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity_5.gridx = 4;
		gbc_lblQuantity_5.gridy = 9;
		processPurchase.add(lblQuantity_5, gbc_lblQuantity_5);
		
		instorepurchqty = new JTextField();
		GridBagConstraints gbc_instorepurchqty = new GridBagConstraints();
		gbc_instorepurchqty.gridwidth = 8;
		gbc_instorepurchqty.insets = new Insets(0, 0, 5, 5);
		gbc_instorepurchqty.fill = GridBagConstraints.HORIZONTAL;
		gbc_instorepurchqty.gridx = 8;
		gbc_instorepurchqty.gridy = 9;
		processPurchase.add(instorepurchqty, gbc_instorepurchqty);
		instorepurchqty.setColumns(10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridheight = 2;
		gbc_scrollPane_4.gridwidth = 13;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 4;
		gbc_scrollPane_4.gridy = 10;
		processPurchase.add(scrollPane_4, gbc_scrollPane_4);
		
		instorePurchaseItems = new JTable();
		scrollPane_4.setViewportView(instorePurchaseItems);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number:");
		GridBagConstraints gbc_lblCreditCardNumber = new GridBagConstraints();
		gbc_lblCreditCardNumber.gridwidth = 5;
		gbc_lblCreditCardNumber.anchor = GridBagConstraints.EAST;
		gbc_lblCreditCardNumber.fill = GridBagConstraints.VERTICAL;
		gbc_lblCreditCardNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditCardNumber.gridx = 4;
		gbc_lblCreditCardNumber.gridy = 12;
		processPurchase.add(lblCreditCardNumber, gbc_lblCreditCardNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 11;
		gbc_textField.gridy = 12;
		processPurchase.add(textField, gbc_textField);
		
		JButton btnCompletePurchase = new JButton("Complete Purchase");
		GridBagConstraints gbc_btnCompletePurchase = new GridBagConstraints();
		gbc_btnCompletePurchase.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompletePurchase.gridwidth = 8;
		gbc_btnCompletePurchase.gridx = 14;
		gbc_btnCompletePurchase.gridy = 12;
		processPurchase.add(btnCompletePurchase, gbc_btnCompletePurchase);
		
		JLabel lblCardExpiryDate = new JLabel("Card Expiry Date");
		GridBagConstraints gbc_lblCardExpiryDate = new GridBagConstraints();
		gbc_lblCardExpiryDate.gridwidth = 5;
		gbc_lblCardExpiryDate.anchor = GridBagConstraints.EAST;
		gbc_lblCardExpiryDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblCardExpiryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardExpiryDate.gridx = 4;
		gbc_lblCardExpiryDate.gridy = 13;
		processPurchase.add(lblCardExpiryDate, gbc_lblCardExpiryDate);
		
		instorecardexpd = new JTextField();
		instorecardexpd.setColumns(10);
		GridBagConstraints gbc_instorecardexpd = new GridBagConstraints();
		gbc_instorecardexpd.gridwidth = 5;
		gbc_instorecardexpd.insets = new Insets(0, 0, 5, 5);
		gbc_instorecardexpd.fill = GridBagConstraints.HORIZONTAL;
		gbc_instorecardexpd.gridx = 9;
		gbc_instorecardexpd.gridy = 13;
		processPurchase.add(instorecardexpd, gbc_instorecardexpd);
		
		JPanel processReturn = new JPanel();
		clerkOperations.addTab("Return", null, processReturn, null);
		GridBagLayout gbl_processReturn = new GridBagLayout();
		gbl_processReturn.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_processReturn.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_processReturn.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_processReturn.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		processReturn.setLayout(gbl_processReturn);
		
		JLabel lblReceiptid = new JLabel("ReceiptID:");
		GridBagConstraints gbc_lblReceiptid = new GridBagConstraints();
		gbc_lblReceiptid.insets = new Insets(0, 0, 5, 5);
		gbc_lblReceiptid.anchor = GridBagConstraints.EAST;
		gbc_lblReceiptid.gridx = 1;
		gbc_lblReceiptid.gridy = 1;
		processReturn.add(lblReceiptid, gbc_lblReceiptid);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 1;
		processReturn.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUpc_2 = new JLabel("UPC:");
		GridBagConstraints gbc_lblUpc_2 = new GridBagConstraints();
		gbc_lblUpc_2.anchor = GridBagConstraints.EAST;
		gbc_lblUpc_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpc_2.gridx = 1;
		gbc_lblUpc_2.gridy = 2;
		processReturn.add(lblUpc_2, gbc_lblUpc_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 2;
		processReturn.add(textField_5, gbc_textField_5);
		
		JLabel lblQuantity_3 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity_3 = new GridBagConstraints();
		gbc_lblQuantity_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity_3.gridx = 1;
		gbc_lblQuantity_3.gridy = 3;
		processReturn.add(lblQuantity_3, gbc_lblQuantity_3);
		
		JTextField textPane_1 = new JTextField();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 2;
		gbc_textPane_1.gridy = 3;
		processReturn.add(textPane_1, gbc_textPane_1);
		
		JLabel lblAmount = new JLabel("Amount:");
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.anchor = GridBagConstraints.EAST;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 1;
		gbc_lblAmount.gridy = 4;
		processReturn.add(lblAmount, gbc_lblAmount);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 4;
		processReturn.add(textField_6, gbc_textField_6);
		
		JButton btnProcessReturn = new JButton("Process Return");
		GridBagConstraints gbc_btnProcessReturn = new GridBagConstraints();
		gbc_btnProcessReturn.insets = new Insets(0, 0, 0, 5);
		gbc_btnProcessReturn.gridx = 2;
		gbc_btnProcessReturn.gridy = 5;
		processReturn.add(btnProcessReturn, gbc_btnProcessReturn);
		
		JTabbedPane managerOperations = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(managerOperations, "name_1449473464875310");
		
		JPanel addItem = new JPanel();
		addItem.setBorder(new EmptyBorder(15, 15, 15, 15));
		managerOperations.addTab("Add Item to Store", null, addItem, null);
		GridBagLayout gbl_addItem = new GridBagLayout();
		gbl_addItem.columnWidths = new int[] {0, 10};
		gbl_addItem.rowHeights = new int[] {0, 10, 0, 0, 0};
		gbl_addItem.columnWeights = new double[]{0.0, 1.0};
		gbl_addItem.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0};
		addItem.setLayout(gbl_addItem);
		
		JLabel lblUpc_1 = new JLabel("UPC:");
		GridBagConstraints gbc_lblUpc_1 = new GridBagConstraints();
		gbc_lblUpc_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpc_1.gridx = 0;
		gbc_lblUpc_1.gridy = 0;
		addItem.add(lblUpc_1, gbc_lblUpc_1);
		
		JTextField additemupc = new JTextField();
		GridBagConstraints gbc_additemupc = new GridBagConstraints();
		gbc_additemupc.insets = new Insets(0, 0, 5, 0);
		gbc_additemupc.fill = GridBagConstraints.BOTH;
		gbc_additemupc.gridx = 1;
		gbc_additemupc.gridy = 0;
		addItem.add(additemupc, gbc_additemupc);
		
		JLabel lblQuantity_1 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity_1 = new GridBagConstraints();
		gbc_lblQuantity_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity_1.gridx = 0;
		gbc_lblQuantity_1.gridy = 1;
		addItem.add(lblQuantity_1, gbc_lblQuantity_1);
		
		JTextField additemqty = new JTextField();
		GridBagConstraints gbc_additemqty = new GridBagConstraints();
		gbc_additemqty.insets = new Insets(0, 0, 5, 0);
		gbc_additemqty.fill = GridBagConstraints.BOTH;
		gbc_additemqty.gridx = 1;
		gbc_additemqty.gridy = 1;
		addItem.add(additemqty, gbc_additemqty);
		
		JLabel lblPrice = new JLabel("Price (Optional):");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 2;
		addItem.add(lblPrice, gbc_lblPrice);
		
		JTextField additemprice = new JTextField();
		GridBagConstraints gbc_additemprice = new GridBagConstraints();
		gbc_additemprice.insets = new Insets(0, 0, 5, 0);
		gbc_additemprice.fill = GridBagConstraints.BOTH;
		gbc_additemprice.gridx = 1;
		gbc_additemprice.gridy = 2;
		addItem.add(additemprice, gbc_additemprice);
		
		JButton btnAddItem = new JButton("Add Item");
		//TODO: Manager AddItem button
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
		gbc_btnAddItem.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddItem.gridx = 1;
		gbc_btnAddItem.gridy = 3;
		addItem.add(btnAddItem, gbc_btnAddItem);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 4;
		addItem.add(separator_2, gbc_separator_2);
		
		JPanel processDelivery = new JPanel();
		processDelivery.setBorder(new EmptyBorder(15, 15, 15, 15));
		managerOperations.addTab("Process Delivery", null, processDelivery, null);

		GridBagLayout gbl_processDelivery = new GridBagLayout();
		gbl_processDelivery.columnWidths = new int[]{1, 0, 0, 0, 0, 0};
		gbl_processDelivery.rowHeights = new int[]{1, 0, 0, 0, 0};
		gbl_processDelivery.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_processDelivery.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		processDelivery.setLayout(gbl_processDelivery);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Order ReceiptID:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		processDelivery.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		final JTextField delivReceiptId = new JTextField();
		GridBagConstraints gbc_delivReceiptId = new GridBagConstraints();
		gbc_delivReceiptId.insets = new Insets(0, 0, 5, 5);
		gbc_delivReceiptId.fill = GridBagConstraints.BOTH;
		gbc_delivReceiptId.gridx = 1;
		gbc_delivReceiptId.gridy = 0;
		processDelivery.add(delivReceiptId, gbc_delivReceiptId);
		
		JLabel lblEnterDeliveryDate = new JLabel("Enter Delivery Date:");
		GridBagConstraints gbc_lblEnterDeliveryDate = new GridBagConstraints();
		gbc_lblEnterDeliveryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterDeliveryDate.fill = GridBagConstraints.BOTH;
		gbc_lblEnterDeliveryDate.gridx = 0;
		gbc_lblEnterDeliveryDate.gridy = 1;
		processDelivery.add(lblEnterDeliveryDate, gbc_lblEnterDeliveryDate);
		
		final JTextField delivDate = new JTextField();
		GridBagConstraints gbc_delivDate = new GridBagConstraints();
		gbc_delivDate.insets = new Insets(0, 0, 5, 5);
		gbc_delivDate.fill = GridBagConstraints.BOTH;
		gbc_delivDate.gridx = 1;
		gbc_delivDate.gridy = 1;
		processDelivery.add(delivDate, gbc_delivDate);
		
		JButton setdelivdate = new JButton("Set Delivery Date");
		setdelivdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseOperations p = new PurchaseOperations();
				String stringdate = delivDate.getText().trim();
				String ridstring = delivReceiptId.getText();
				int ridint = Integer.parseInt(ridstring);
				p.updateDeliveryDate(ridint, stringdate);
			}
		});
		
		JLabel lblUseFormatDdmmyy = new JLabel("Use Format dd/MM/yy");
		GridBagConstraints gbc_lblUseFormatDdmmyy = new GridBagConstraints();
		gbc_lblUseFormatDdmmyy.insets = new Insets(0, 0, 5, 5);
		gbc_lblUseFormatDdmmyy.gridx = 2;
		gbc_lblUseFormatDdmmyy.gridy = 1;
		processDelivery.add(lblUseFormatDdmmyy, gbc_lblUseFormatDdmmyy);
		GridBagConstraints gbc_setdelivdate = new GridBagConstraints();
		gbc_setdelivdate.insets = new Insets(0, 0, 0, 5);
		gbc_setdelivdate.fill = GridBagConstraints.BOTH;
		gbc_setdelivdate.gridx = 1;
		gbc_setdelivdate.gridy = 3;
		processDelivery.add(setdelivdate, gbc_setdelivdate);
		
		JPanel dailySalesReport = new JPanel();
		dailySalesReport.setBorder(new EmptyBorder(15, 15, 15, 15));
		managerOperations.addTab("Daily Sales Report", null, dailySalesReport, null);
		GridBagLayout gbl_dailySalesReport = new GridBagLayout();
		gbl_dailySalesReport.columnWidths = new int[]{0, 54, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_dailySalesReport.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_dailySalesReport.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_dailySalesReport.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		dailySalesReport.setLayout(gbl_dailySalesReport);
		
		JLabel lblEnterDate = new JLabel("Enter Date:");
		GridBagConstraints gbc_lblEnterDate = new GridBagConstraints();
		gbc_lblEnterDate.gridwidth = 2;
		gbc_lblEnterDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterDate.anchor = GridBagConstraints.EAST;
		gbc_lblEnterDate.gridx = 0;
		gbc_lblEnterDate.gridy = 0;
		dailySalesReport.add(lblEnterDate, gbc_lblEnterDate);
		
		JFormattedTextField dailysalesdate = new JFormattedTextField();
		GridBagConstraints gbc_dailysalesdate = new GridBagConstraints();
		gbc_dailysalesdate.gridwidth = 2;
		gbc_dailysalesdate.insets = new Insets(0, 0, 5, 5);
		gbc_dailysalesdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dailysalesdate.gridx = 2;
		gbc_dailysalesdate.gridy = 0;
		dailySalesReport.add(dailysalesdate, gbc_dailysalesdate);
		
		JButton btnRetrieveSalesData = new JButton("Retrieve Sales Data");
		GridBagConstraints gbc_btnRetrieveSalesData = new GridBagConstraints();
		gbc_btnRetrieveSalesData.insets = new Insets(0, 0, 5, 5);
		gbc_btnRetrieveSalesData.gridx = 2;
		gbc_btnRetrieveSalesData.gridy = 1;
		dailySalesReport.add(btnRetrieveSalesData, gbc_btnRetrieveSalesData);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		dailySalesReport.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 5;
		dailySalesReport.add(lblTotal, gbc_lblTotal);
		
		JLabel lblQuantity_2 = new JLabel("Quantity");
		GridBagConstraints gbc_lblQuantity_2 = new GridBagConstraints();
		gbc_lblQuantity_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuantity_2.gridx = 3;
		gbc_lblQuantity_2.gridy = 5;
		dailySalesReport.add(lblQuantity_2, gbc_lblQuantity_2);
		
		JTextPane textArea = new JTextPane();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 5;
		dailySalesReport.add(textArea, gbc_textArea);
		
		JLabel lblSales = new JLabel("Sales");
		GridBagConstraints gbc_lblSales = new GridBagConstraints();
		gbc_lblSales.gridwidth = 2;
		gbc_lblSales.insets = new Insets(0, 0, 0, 5);
		gbc_lblSales.gridx = 6;
		gbc_lblSales.gridy = 5;
		dailySalesReport.add(lblSales, gbc_lblSales);
		
		JTextPane textPane_6 = new JTextPane();
		GridBagConstraints gbc_textPane_6 = new GridBagConstraints();
		gbc_textPane_6.gridwidth = 2;
		gbc_textPane_6.insets = new Insets(0, 0, 0, 5);
		gbc_textPane_6.fill = GridBagConstraints.BOTH;
		gbc_textPane_6.gridx = 8;
		gbc_textPane_6.gridy = 5;
		dailySalesReport.add(textPane_6, gbc_textPane_6);
		
		JPanel topSellingItems = new JPanel();
		managerOperations.addTab("Top Selling Items", null, topSellingItems, null);
		
		final JPanel customerOperations = new JPanel();
		contentPane.add(customerOperations, "name_1452058092586835");
		customerOperations.setLayout(new CardLayout(0, 0));
		
		JPanel customerLogin = new JPanel();
		customerLogin.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		customerOperations.add(customerLogin, "name_1546903163253674");
		GridBagLayout gbl_customerLogin = new GridBagLayout();
		gbl_customerLogin.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_customerLogin.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_customerLogin.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_customerLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		customerLogin.setLayout(gbl_customerLogin);
		
		JLabel lblCustomerLogin = new JLabel("Customer Login");
		lblCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCustomerLogin = new GridBagConstraints();
		gbc_lblCustomerLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerLogin.gridx = 1;
		gbc_lblCustomerLogin.gridy = 1;
		customerLogin.add(lblCustomerLogin, gbc_lblCustomerLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 4;
		customerLogin.add(lblUsername, gbc_lblUsername);
		
		custUName = new JTextField();
		GridBagConstraints gbc_custUName = new GridBagConstraints();
		gbc_custUName.gridwidth = 2;
		gbc_custUName.insets = new Insets(0, 0, 5, 5);
		gbc_custUName.fill = GridBagConstraints.HORIZONTAL;
		gbc_custUName.gridx = 3;
		gbc_custUName.gridy = 4;
		customerLogin.add(custUName, gbc_custUName);
		custUName.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.anchor = GridBagConstraints.EAST;
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridx = 2;
		gbc_lblPassword_1.gridy = 5;
		customerLogin.add(lblPassword_1, gbc_lblPassword_1);
		
		custPW = new JTextField();
		GridBagConstraints gbc_custPW = new GridBagConstraints();
		gbc_custPW.gridwidth = 2;
		gbc_custPW.insets = new Insets(0, 0, 5, 5);
		gbc_custPW.fill = GridBagConstraints.HORIZONTAL;
		gbc_custPW.gridx = 3;
		gbc_custPW.gridy = 5;
		customerLogin.add(custPW, gbc_custPW);
		custPW.setColumns(10);
		
		JButton btnSubmit_1 = new JButton("Submit");
		
			//TODO: submit operations to login customer
			btnSubmit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Submit was pressed")	;	
					CustomerOperations c = new CustomerOperations();
					if (c.login(custUName.getText().trim(), custPW.getText().trim())){
						CardLayout cl = (CardLayout) customerOperations.getLayout();
						 cl.show(customerOperations, "name_1452390541607518");
					}
				}
			});
			GridBagConstraints gbc_btnSubmit_1 = new GridBagConstraints();
			gbc_btnSubmit_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnSubmit_1.gridx = 3;
			gbc_btnSubmit_1.gridy = 6;
			customerLogin.add(btnSubmit_1, gbc_btnSubmit_1);
		
		JLabel lblNotRegistered = new JLabel("Not Registered?");
		GridBagConstraints gbc_lblNotRegistered = new GridBagConstraints();
		gbc_lblNotRegistered.insets = new Insets(0, 0, 5, 0);
		gbc_lblNotRegistered.gridx = 7;
		gbc_lblNotRegistered.gridy = 7;
		customerLogin.add(lblNotRegistered, gbc_lblNotRegistered);
		
		JButton btnRegisterNow = new JButton("Register Now");
		btnRegisterNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) customerOperations.getLayout();
				cl.show(customerOperations,"name_1452387567243092");
			}
		});
		GridBagConstraints gbc_btnRegisterNow = new GridBagConstraints();
		gbc_btnRegisterNow.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegisterNow.gridx = 7;
		gbc_btnRegisterNow.gridy = 8;
		customerLogin.add(btnRegisterNow, gbc_btnRegisterNow);
		
		JPanel registerCustomer = new JPanel();
		registerCustomer.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		customerOperations.add(registerCustomer, "name_1452387567243092");
		GridBagLayout gbl_registerCustomer = new GridBagLayout();
		gbl_registerCustomer.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_registerCustomer.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_registerCustomer.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_registerCustomer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		registerCustomer.setLayout(gbl_registerCustomer);
		
		JLabel lblCustomerRegistration = new JLabel("Customer Registration");
		lblCustomerRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCustomerRegistration = new GridBagConstraints();
		gbc_lblCustomerRegistration.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerRegistration.gridx = 2;
		gbc_lblCustomerRegistration.gridy = 0;
		registerCustomer.add(lblCustomerRegistration, gbc_lblCustomerRegistration);
		
		JLabel lblNewLabel_6 = new JLabel("Customer ID:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		registerCustomer.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		custRegId = new JTextField();
		GridBagConstraints gbc_custRegId = new GridBagConstraints();
		gbc_custRegId.insets = new Insets(0, 0, 5, 5);
		gbc_custRegId.fill = GridBagConstraints.HORIZONTAL;
		gbc_custRegId.gridx = 2;
		gbc_custRegId.gridy = 2;
		registerCustomer.add(custRegId, gbc_custRegId);
		custRegId.setColumns(10);
		
		JLabel lblPassword_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword_2 = new GridBagConstraints();
		gbc_lblPassword_2.anchor = GridBagConstraints.EAST;
		gbc_lblPassword_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_2.gridx = 1;
		gbc_lblPassword_2.gridy = 3;
		registerCustomer.add(lblPassword_2, gbc_lblPassword_2);
		
		custRegPW = new JTextField();
		GridBagConstraints gbc_custRegPW = new GridBagConstraints();
		gbc_custRegPW.insets = new Insets(0, 0, 5, 5);
		gbc_custRegPW.fill = GridBagConstraints.HORIZONTAL;
		gbc_custRegPW.gridx = 2;
		gbc_custRegPW.gridy = 3;
		registerCustomer.add(custRegPW, gbc_custRegPW);
		custRegPW.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		registerCustomer.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		custRegName = new JTextField();
		GridBagConstraints gbc_custRegName = new GridBagConstraints();
		gbc_custRegName.insets = new Insets(0, 0, 5, 5);
		gbc_custRegName.fill = GridBagConstraints.HORIZONTAL;
		gbc_custRegName.gridx = 2;
		gbc_custRegName.gridy = 4;
		registerCustomer.add(custRegName, gbc_custRegName);
		custRegName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 5;
		registerCustomer.add(lblAddress, gbc_lblAddress);
		
		custRegAddr = new JTextField();
		GridBagConstraints gbc_custRegAddr = new GridBagConstraints();
		gbc_custRegAddr.insets = new Insets(0, 0, 5, 5);
		gbc_custRegAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_custRegAddr.gridx = 2;
		gbc_custRegAddr.gridy = 5;
		registerCustomer.add(custRegAddr, gbc_custRegAddr);
		custRegAddr.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		registerCustomer.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		custPNum = new JTextField();
		GridBagConstraints gbc_custPNum = new GridBagConstraints();
		gbc_custPNum.insets = new Insets(0, 0, 5, 5);
		gbc_custPNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_custPNum.gridx = 2;
		gbc_custPNum.gridy = 6;
		registerCustomer.add(custPNum, gbc_custPNum);
		custPNum.setColumns(10);
		
		JButton btnRegisterNow_1 = new JButton("Register Now");
		btnRegisterNow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerOperations c = new CustomerOperations();
				if (c.insert(custRegId.getText(), custRegPW.getText(), custRegName.getText(), custRegAddr.getText(), custPNum.getText())){
					System.out.println("Insert attempted");
					goToOnlinePurchase();
					System.out.println("Customer Insertion Successful");
				}
				else System.out.println("Customer Insertion Error");
			}

			private void goToOnlinePurchase() {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) customerOperations.getLayout();
				 cl.show(customerOperations, "name_1452390541607518");
			}
		});
		GridBagConstraints gbc_btnRegisterNow_1 = new GridBagConstraints();
		gbc_btnRegisterNow_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegisterNow_1.gridx = 2;
		gbc_btnRegisterNow_1.gridy = 8;
		registerCustomer.add(btnRegisterNow_1, gbc_btnRegisterNow_1);
		
		JPanel onlinePurchase = new JPanel();
		onlinePurchase.setBorder(new EmptyBorder(10, 10, 10, 10));
		customerOperations.add(onlinePurchase, "name_1452390541607518");
		GridBagLayout gbl_onlinePurchase = new GridBagLayout();
		gbl_onlinePurchase.columnWidths = new int[] {0, 62, 59, 92, 0, 0, 0, 0, 20};
		gbl_onlinePurchase.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gbl_onlinePurchase.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_onlinePurchase.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		onlinePurchase.setLayout(gbl_onlinePurchase);
		
		JLabel lblNewLabel_3 = new JLabel("Item Search");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		onlinePurchase.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblTitle = new JLabel("Title:");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		onlinePurchase.add(lblTitle, gbc_lblTitle);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 1;
		onlinePurchase.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblQuantity_4 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity_4 = new GridBagConstraints();
		gbc_lblQuantity_4.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity_4.gridx = 2;
		gbc_lblQuantity_4.gridy = 1;
		onlinePurchase.add(lblQuantity_4, gbc_lblQuantity_4);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 3;
		gbc_textField_10.gridy = 1;
		onlinePurchase.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 2;
		onlinePurchase.add(lblCategory, gbc_lblCategory);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 2;
		onlinePurchase.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblLeadingSingers = new JLabel("Leading Singers:");
		GridBagConstraints gbc_lblLeadingSingers = new GridBagConstraints();
		gbc_lblLeadingSingers.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeadingSingers.gridx = 0;
		gbc_lblLeadingSingers.gridy = 3;
		onlinePurchase.add(lblLeadingSingers, gbc_lblLeadingSingers);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 3;
		onlinePurchase.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JButton btnAddItem_2 = new JButton("Add Item");
		GridBagConstraints gbc_btnAddItem_2 = new GridBagConstraints();
		gbc_btnAddItem_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddItem_2.gridx = 3;
		gbc_btnAddItem_2.gridy = 3;
		onlinePurchase.add(btnAddItem_2, gbc_btnAddItem_2);
		
		JLabel lblShoppingCart = new JLabel("Shopping Cart");
		GridBagConstraints gbc_lblShoppingCart = new GridBagConstraints();
		gbc_lblShoppingCart.insets = new Insets(0, 0, 5, 5);
		gbc_lblShoppingCart.gridx = 0;
		gbc_lblShoppingCart.gridy = 5;
		onlinePurchase.add(lblShoppingCart, gbc_lblShoppingCart);
		
		JLabel lblSearchResults = new JLabel("Search Results");
		GridBagConstraints gbc_lblSearchResults = new GridBagConstraints();
		gbc_lblSearchResults.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchResults.gridx = 3;
		gbc_lblSearchResults.gridy = 5;
		onlinePurchase.add(lblSearchResults, gbc_lblSearchResults);
		
		table_1 = new JTable();
		JScrollPane scrollPane_2 = new JScrollPane(table_1);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 6;
		onlinePurchase.add(scrollPane_2, gbc_scrollPane_2);
		
		table_2 = new JTable();	
		JScrollPane scrollPane_1 = new JScrollPane(table_2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 6;
		onlinePurchase.add(scrollPane_1, gbc_scrollPane_1);
		
		JLabel label_1 = new JLabel("Card Expiry Date");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 9;
		onlinePurchase.add(label_1, gbc_label_1);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 9;
		onlinePurchase.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JLabel lblCardExpiryDate_1 = new JLabel("Card Expiry Date");
		GridBagConstraints gbc_lblCardExpiryDate_1 = new GridBagConstraints();
		gbc_lblCardExpiryDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblCardExpiryDate_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblCardExpiryDate_1.gridx = 0;
		gbc_lblCardExpiryDate_1.gridy = 10;
		onlinePurchase.add(lblCardExpiryDate_1, gbc_lblCardExpiryDate_1);
		
		textField_12 = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 0, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 10;
		onlinePurchase.add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		
		//TODO: Submit Online Purchase Button
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSubmitOrder = new GridBagConstraints();
		gbc_btnSubmitOrder.gridwidth = 2;
		gbc_btnSubmitOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmitOrder.gridx = 3;
		gbc_btnSubmitOrder.gridy = 10;
		onlinePurchase.add(btnSubmitOrder, gbc_btnSubmitOrder);
	}
	public void switchToNextCard(String accesslevel){
		CardLayout cl = (CardLayout) (contentPane.getLayout());
		switch (accesslevel){
		case ("Clerk"):
			cl.show(contentPane, "name_1442560847488307");
			break;
			
		case ("Customer" ):
			cl.show(contentPane, "name_1452058092586835");
			break;
		
		case ("Manager"):
			cl.show(contentPane, "name_1449473464875310");
			break;
			
				
		}
	}
}
