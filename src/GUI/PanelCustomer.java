package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLCustomer;
import DTO.Customer;

import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class PanelCustomer extends JPanel {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhonenumber;
	private JComboBox<String> cbGender;
	private ArrayList<Customer> data = BLLCustomer.Instance().GetAll();
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panelDecor_1;
	//private JPanel panelDecor;
	/**
	 * Create the panel.
	 */
	public PanelCustomer() throws SQLException, ClassNotFoundException  {
		setBackground(SystemColor.info);
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(115, 125, 125, 30);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lbCustomer = new JLabel("CUSTOMER");
		lbCustomer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomer.setBounds(10, 10, 137, 69);
		add(lbCustomer);
		
		JPanel panelDecor = new JPanel();
		panelDecor.setBackground(SystemColor.desktop);
		panelDecor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor.setBounds(135, 43, 526, 4);
		add(panelDecor);
		panelDecor.setLayout(null);
		
		JLabel lbId = new JLabel("ID: ");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setBounds(29, 122, 55, 30);
		add(lbId);
		
		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(29, 193, 76, 30);
		add(lblGender);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(306, 122, 76, 30);
		add(lblName);
		
		JLabel lblPhonenumber = new JLabel("Phone number:");
		lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonenumber.setBounds(306, 193, 132, 30);
		add(lblPhonenumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(448, 122, 125, 30);
		add(txtName);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setBounds(448, 193, 125, 30);
		add(txtPhonenumber);
		
		cbGender = new JComboBox<String>();
		cbGender.addItem("Nam");
		cbGender.addItem("Nữ");
		cbGender.setBackground(SystemColor.textHighlightText);
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbGender.setBounds(115, 193, 125, 30);
		add(cbGender);
		
		table = new JTable();
		
		String[] columnNames = { "ID","Tên","SDT","Giới tính" };

		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i < 5; i++) {
//			int ID = data.get(i).getID();
//			String Name = data.get(i).getName();
//			String Phone = data.get(i).getPhoneNumber();
//			String Gender = data.get(i).getGender();
//			Object[] newRow = {ID,Name,Phone,Gender};
			
			Object [] newRow = {1,1,1,1};
			
			dtm.addRow(newRow);
		}
		table.setModel(dtm);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setBounds(10, 307, 651, 236);
		
		add(scrollPane);
		
		panelDecor_1 = new JPanel();
		panelDecor_1.setLayout(null);
		panelDecor_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor_1.setBackground(SystemColor.desktop);
		panelDecor_1.setBounds(10, 43, 10, 4);
		add(panelDecor_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(254, 254, 85, 30);
		btnAdd.setBorder(null);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(390, 254, 85, 30);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBorder(null);
		btnDelete.setBounds(517, 254, 85, 30);
		add(btnDelete);
		
		
		//scrollPane.add(table);

	}
}
