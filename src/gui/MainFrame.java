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

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTable table;

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
		processPurchase.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUpc = new JLabel("UPC:");
		processPurchase.add(lblUpc);
		
		JTextPane textPane_1 = new JTextPane();
		processPurchase.add(textPane_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		processPurchase.add(lblQuantity);
		
		JTextPane textPane_2 = new JTextPane();
		processPurchase.add(textPane_2);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number:");
		processPurchase.add(lblCreditCardNumber);
		
		JPanel processReturn = new JPanel();
		clerkOperations.addTab("Return", null, processReturn, null);
		
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
		
		JLabel lblPrice = new JLabel("Price");
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
		gbl_dailySalesReport.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_dailySalesReport.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_dailySalesReport.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_dailySalesReport.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		dailySalesReport.setLayout(gbl_dailySalesReport);
		
		JLabel lblEnterDate = new JLabel("Enter Date:");
		GridBagConstraints gbc_lblEnterDate = new GridBagConstraints();
		gbc_lblEnterDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterDate.anchor = GridBagConstraints.EAST;
		gbc_lblEnterDate.gridx = 1;
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
		
		JPanel registerCustomer = new JPanel();
		customerOperations.add(registerCustomer, "name_1452387567243092");
		
		JPanel onlinePurchase = new JPanel();
		customerOperations.add(onlinePurchase, "name_1452390541607518");
	}
}
