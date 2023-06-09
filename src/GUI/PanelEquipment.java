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

import DTO.Customer;
import DTO.Equipment;
import GUI.Listener.EquipmentListener;

import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class PanelEquipment extends JPanel {
	private JTextField txtId;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTable tableCus;
	private JScrollPane scrollPane;
	private JPanel panelDecor_1;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnSave_add;
	private JButton btnSave_update;
	private JPanel panel;
	private ArrayList<Equipment> rows;
	private JTextField txtName;
	//private JPanel panelDecor;
	/**
	 * Create the panel.
	 */
	public PanelEquipment() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(115, 125, 125, 30);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lbEquipment = new JLabel("Thiết bị");
		lbEquipment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lbEquipment.setBounds(20, 10, 76, 69);
		add(lbEquipment);
		
		JPanel panelDecor = new JPanel();
		panelDecor.setBackground(new Color(0, 128, 128));
		panelDecor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor.setBounds(95, 43, 550, 4);
		add(panelDecor);
		panelDecor.setLayout(null);
		
		JLabel lbId = new JLabel("ID: ");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setBounds(29, 122, 76, 30);
		add(lbId);
		
		JLabel lblGender = new JLabel("Giá: ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(29, 193, 76, 30);
		add(lblGender);
		
		JLabel lblName = new JLabel("Tên thiết bị:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(326, 124, 98, 30);
		add(lblName);
		
		JLabel lblPhonenumber = new JLabel("Số Lượng:");
		lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonenumber.setBounds(306, 193, 132, 30);
		add(lblPhonenumber);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(115, 194, 125, 30);
		add(txtPrice);
		
		tableCus = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[] {"Mã thiết bị", "Tên Thiết bị", "Giá tiền", "Số lượng"}, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		try {
			rows = BLL.BLLEquipment.Instance().GetAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for (int i = 0; i < rows.size(); i ++) {
			int id = rows.get(i).getID();
			String name = rows.get(i).getName();
			int price = rows.get(i).getPrice();
			int quantity = rows.get(i).getQuantity();
			model.addRow(new Object[] {id, name, price,quantity});
		}
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(448, 193, 125, 30);
		add(txtQuantity);
		
		

		
		tableCus.setModel(model);
		tableCus.setBorder(new EmptyBorder(0, 0, 0, 0));
		tableCus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCus.setBounds(10, 307, 607, 236);
		
		scrollPane = new JScrollPane(tableCus);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setBounds(10, 307, 641, 236);
		add(scrollPane);
		
		panelDecor_1 = new JPanel();
		panelDecor_1.setLayout(null);
		panelDecor_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor_1.setBackground(new Color(0, 128, 128));
		panelDecor_1.setBounds(7, 43, 10, 4);
		add(panelDecor_1);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(254, 254, 85, 30);
		btnAdd.setBorder(null);
		add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(390, 254, 85, 30);
		add(btnUpdate);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBorder(null);
		btnDelete.setBounds(517, 254, 85, 30);
		add(btnDelete);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(0, 128, 128));
		btnCancel.setBounds(390, 254, 85, 30);
		add(btnCancel);
		
		btnSave_add = new JButton("Lưu");
		btnSave_add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_add.setFocusPainted(false);
		btnSave_add.setBorderPainted(false);
		btnSave_add.setBorder(null);
		btnSave_add.setBackground(new Color(255, 255, 0));
		btnSave_add.setBounds(517, 254, 85, 30);
		add(btnSave_add);
		
		btnSave_update = new JButton("Lưu");
		btnSave_update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_update.setFocusPainted(false);
		btnSave_update.setBorderPainted(false);
		btnSave_update.setBorder(null);
		btnSave_update.setBackground(new Color(255, 255, 0));
		btnSave_update.setBounds(517, 254, 85, 30);
		add(btnSave_update);
		//scrollPane.add(table);
		AddListener();
		this.txtId.setEnabled(false);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setEnabled(false);
		txtName.setColumns(10);
		txtName.setBounds(448, 122, 125, 30);
		add(txtName);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 91, 641, 153);
		add(panel);
		SetTextEnable(false);
	}
	public void AddListener() {
		btnSave_update.addActionListener(new EquipmentListener(this));
		btnSave_add.addActionListener(new EquipmentListener(this));
		tableCus.getSelectionModel().addListSelectionListener(new EquipmentListener(this));
		btnCancel.addActionListener(new EquipmentListener(this));
		btnUpdate.addActionListener(new EquipmentListener(this));
		btnAdd.addActionListener(new EquipmentListener(this));
		btnDelete.addActionListener(new EquipmentListener(this));
	}
	public void SetTextFieldNull() {
		this.txtId.setText(null);
		this.txtName.setText(null);
		this.txtPrice.setText(null);
		this.txtQuantity.setText(null);
		
	}
	public void SetTextEnable(boolean b) {
		//this.txtId.setEnabled(b);
		this.txtPrice.setEnabled(b);
		this.txtQuantity.setEnabled(b);
		this.txtName.setEnabled(b);
	}
	public void SetButtonVisibile(boolean b) {
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
	}
	public void SetDataTextField(int row) {
		this.txtId.setText(this.tableCus.getValueAt(row, 0).toString());
		this.txtName.setText(this.tableCus.getValueAt(row, 1).toString());
		this.txtPrice.setText(this.tableCus.getValueAt(row, 2).toString());
		this.txtQuantity.setText(this.tableCus.getValueAt(row, 3).toString());
		
	}
	public ArrayList<Equipment> getRows(){
		return rows;
	}
	public JTextField getTxtId() {
		return txtId;
	}
	public JTextField getTxtPrice() {
		return txtPrice;
	}
	public JTextField getTxtQuantity() {
		return txtQuantity;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}
	public JTable getTableCus() {
		return tableCus;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JButton getBtnSave_add() {
		return btnSave_add;
	}
	public JButton getBtnSave_update() {
		return btnSave_update;
	}
	public void setRows(ArrayList<Equipment> rows) {
		this.rows = rows;
	}
}
