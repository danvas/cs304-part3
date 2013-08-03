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

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

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
		managerOperations.addTab("Process Delivery", null, processDelivery, null);
		
		JPanel dailySalesReport = new JPanel();
		managerOperations.addTab("Daily Sales Report", null, dailySalesReport, null);
		
		JPanel topSellingItems = new JPanel();
		managerOperations.addTab("Top Selling Items", null, topSellingItems, null);
	}
}
