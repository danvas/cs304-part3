package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		setTitle("AMS Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(10, 5, 0, 0));
		
		JSeparator separator = new JSeparator();
		login.add(separator);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		login.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		login.add(textPane);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		login.add(lblPassword);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(login, "name_1441150054636723");
		
		passwordField = new JPasswordField();
		login.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Specify Your Access Level:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		login.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Clerk", "Manager"}));
		login.add(comboBox);
		
		JSeparator separator_1 = new JSeparator();
		login.add(separator_1);
		
		JButton btnSubmit = new JButton("Submit");
		login.add(btnSubmit);
		
		JTabbedPane clerkOperations = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(clerkOperations, "name_1442560847488307");
		
		JPanel processPurchase = new JPanel();
		processPurchase.setBorder(new EmptyBorder(10, 10, 10, 10));
		clerkOperations.addTab("Purchase", null, processPurchase, null);
		GridBagLayout gbl_processPurchase = new GridBagLayout();
		gbl_processPurchase.columnWidths = new int[]{32, 99, 82, 0, 105, 125, 0};
		gbl_processPurchase.rowHeights = new int[]{20, 35, 0, 20, 0, 27, 20, 35, 23, 35, 23, 0};
		gbl_processPurchase.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_processPurchase.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		processPurchase.setLayout(gbl_processPurchase);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.fill = GridBagConstraints.BOTH;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 1;
		gbc_lblQuantity.gridy = 0;
		processPurchase.add(lblQuantity, gbc_lblQuantity);
		
		JLabel lblUpc = new JLabel("UPC:");
		GridBagConstraints gbc_lblUpc = new GridBagConstraints();
		gbc_lblUpc.anchor = GridBagConstraints.EAST;
		gbc_lblUpc.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpc.gridx = 1;
		gbc_lblUpc.gridy = 2;
		processPurchase.add(lblUpc, gbc_lblUpc);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		processPurchase.add(textField_3, gbc_textField_3);
		
		JLabel label = new JLabel("Credit Card Number:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		processPurchase.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		processPurchase.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number:");
		GridBagConstraints gbc_lblCreditCardNumber = new GridBagConstraints();
		gbc_lblCreditCardNumber.anchor = GridBagConstraints.EAST;
		gbc_lblCreditCardNumber.fill = GridBagConstraints.VERTICAL;
		gbc_lblCreditCardNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditCardNumber.gridx = 1;
		gbc_lblCreditCardNumber.gridy = 4;
		processPurchase.add(lblCreditCardNumber, gbc_lblCreditCardNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		processPurchase.add(textField_1, gbc_textField_1);
		
		JLabel lblCardExpiryDate = new JLabel("Card Expiry Date");
		GridBagConstraints gbc_lblCardExpiryDate = new GridBagConstraints();
		gbc_lblCardExpiryDate.anchor = GridBagConstraints.EAST;
		gbc_lblCardExpiryDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblCardExpiryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardExpiryDate.gridx = 1;
		gbc_lblCardExpiryDate.gridy = 5;
		processPurchase.add(lblCardExpiryDate, gbc_lblCardExpiryDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		processPurchase.add(textField_2, gbc_textField_2);
		
		JButton btnAddItem_1 = new JButton("Add Item");
		GridBagConstraints gbc_btnAddItem_1 = new GridBagConstraints();
		gbc_btnAddItem_1.gridwidth = 3;
		gbc_btnAddItem_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddItem_1.gridx = 2;
		gbc_btnAddItem_1.gridy = 6;
		processPurchase.add(btnAddItem_1, gbc_btnAddItem_1);
		
		JButton btnCompletePurchase = new JButton("Complete Purchase");
		GridBagConstraints gbc_btnCompletePurchase = new GridBagConstraints();
		gbc_btnCompletePurchase.gridwidth = 3;
		gbc_btnCompletePurchase.insets = new Insets(0, 0, 5, 5);
		gbc_btnCompletePurchase.gridx = 2;
		gbc_btnCompletePurchase.gridy = 9;
		processPurchase.add(btnCompletePurchase, gbc_btnCompletePurchase);
		
		JPanel processReturn = new JPanel();
		clerkOperations.addTab("Return", null, processReturn, null);
		GridBagLayout gbl_processReturn = new GridBagLayout();
		gbl_processReturn.columnWidths = new int[]{0, 0, 0, 0};
		gbl_processReturn.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_processReturn.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
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
		
		JTextPane textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 4;
		processReturn.add(textField_6, gbc_textField_6);
		
		JButton btnProcessReturn = new JButton("Process Return");
		GridBagConstraints gbc_btnProcessReturn = new GridBagConstraints();
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
		
		JTextField textPane_3 = new JTextField();
		GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
		gbc_textPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_textPane_3.fill = GridBagConstraints.BOTH;
		gbc_textPane_3.gridx = 1;
		gbc_textPane_3.gridy = 0;
		addItem.add(textPane_3, gbc_textPane_3);
		
		JLabel lblQuantity_1 = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity_1 = new GridBagConstraints();
		gbc_lblQuantity_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity_1.gridx = 0;
		gbc_lblQuantity_1.gridy = 1;
		addItem.add(lblQuantity_1, gbc_lblQuantity_1);
		
		JTextField textPane_4 = new JTextField();
		GridBagConstraints gbc_textPane_4 = new GridBagConstraints();
		gbc_textPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_textPane_4.fill = GridBagConstraints.BOTH;
		gbc_textPane_4.gridx = 1;
		gbc_textPane_4.gridy = 1;
		addItem.add(textPane_4, gbc_textPane_4);
		
		JLabel lblPrice = new JLabel("Price (Optional):");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 2;
		addItem.add(lblPrice, gbc_lblPrice);
		
		JTextField textPane_5 = new JTextField();
		GridBagConstraints gbc_textPane_5 = new GridBagConstraints();
		gbc_textPane_5.insets = new Insets(0, 0, 5, 0);
		gbc_textPane_5.fill = GridBagConstraints.BOTH;
		gbc_textPane_5.gridx = 1;
		gbc_textPane_5.gridy = 2;
		addItem.add(textPane_5, gbc_textPane_5);
		
		JButton btnAddItem = new JButton("Add Item");
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
		
		JLabel lblNewLabel_2 = new JLabel("Enter ReceiptID for Order:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		processDelivery.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.BOTH;
		gbc_formattedTextField.gridx = 1;
		gbc_formattedTextField.gridy = 0;
		processDelivery.add(formattedTextField, gbc_formattedTextField);
		
		JLabel lblEnterDeliveryDate = new JLabel("Enter Delivery Date:");
		GridBagConstraints gbc_lblEnterDeliveryDate = new GridBagConstraints();
		gbc_lblEnterDeliveryDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterDeliveryDate.fill = GridBagConstraints.BOTH;
		gbc_lblEnterDeliveryDate.gridx = 0;
		gbc_lblEnterDeliveryDate.gridy = 1;
		processDelivery.add(lblEnterDeliveryDate, gbc_lblEnterDeliveryDate);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_1.fill = GridBagConstraints.BOTH;
		gbc_formattedTextField_1.gridx = 1;
		gbc_formattedTextField_1.gridy = 1;
		processDelivery.add(formattedTextField_1, gbc_formattedTextField_1);
		
		JButton btnNewButton = new JButton("Set Delivery Date");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		processDelivery.add(btnNewButton, gbc_btnNewButton);
		
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
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField_2 = new GridBagConstraints();
		gbc_formattedTextField_2.gridwidth = 2;
		gbc_formattedTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_2.gridx = 2;
		gbc_formattedTextField_2.gridy = 0;
		dailySalesReport.add(formattedTextField_2, gbc_formattedTextField_2);
		
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
		
		JPanel customerOperations = new JPanel();
		contentPane.add(customerOperations, "name_1452058092586835");
		customerOperations.setLayout(new CardLayout(0, 0));
		
		JPanel customerLogin = new JPanel();
		customerOperations.add(customerLogin, "name_1546903163253674");
		
		JPanel registerCustomer = new JPanel();
		customerOperations.add(registerCustomer, "name_1452387567243092");
		
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
		GridBagConstraints gbc_btnSubmitOrder = new GridBagConstraints();
		gbc_btnSubmitOrder.gridwidth = 2;
		gbc_btnSubmitOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmitOrder.gridx = 3;
		gbc_btnSubmitOrder.gridy = 10;
		onlinePurchase.add(btnSubmitOrder, gbc_btnSubmitOrder);
	}
}
