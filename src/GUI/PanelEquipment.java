package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
<<<<<<< Updated upstream
import javax.swing.table.DefaultTableModel;

=======

import GUI.Listener.CustomerListener;
>>>>>>> Stashed changes
import GUI.Listener.EquipmentListener;

import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class PanelEquipment extends JPanel {
	private JTextField txtId;
<<<<<<< Updated upstream
	private JTextField txtPrice;
=======
>>>>>>> Stashed changes
	private JTextField txtQuantity;
	private JComboBox cbName;
	private JTable tableCus;
	private JScrollPane scrollPane;
	private JPanel panelDecor_1;
<<<<<<< Updated upstream
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnSave_add;
	private JButton btnSave_update;
	private JPanel panel;
=======
	private JTextField txtPrice;
	
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSave_Update;
	private JButton btnSave_Add;
	private JButton btnCancel;
>>>>>>> Stashed changes
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
		
<<<<<<< Updated upstream
		JLabel lbEquipment = new JLabel("Thiết bị");
		lbEquipment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lbEquipment.setBounds(20, 10, 76, 69);
		add(lbEquipment);
=======
		JLabel lbCustomer = new JLabel("EQUIPMENT");
		lbCustomer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomer.setBounds(10, 10, 137, 69);
		add(lbCustomer);
>>>>>>> Stashed changes
		
		JPanel panelDecor = new JPanel();
		panelDecor.setBackground(new Color(0, 128, 128));
		panelDecor.setBorder(new EmptyBorder(0, 0, 0, 0));
<<<<<<< Updated upstream
		panelDecor.setBounds(95, 43, 550, 4);
=======
		panelDecor.setBounds(139, 43, 515, 4);
>>>>>>> Stashed changes
		add(panelDecor);
		panelDecor.setLayout(null);
		
		JLabel lbId = new JLabel("ID: ");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
<<<<<<< Updated upstream
		lbId.setBounds(29, 122, 76, 30);
		add(lbId);
		
		JLabel lblGender = new JLabel("Giá: ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(29, 193, 76, 30);
		add(lblGender);
=======
		lbId.setBounds(45, 124, 39, 30);
		add(lbId);
		
		JLabel lbPrice = new JLabel("Price:");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPrice.setBounds(29, 193, 76, 30);
		add(lbPrice);
>>>>>>> Stashed changes
		
		JLabel lblName = new JLabel("Tên thiết bị:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
<<<<<<< Updated upstream
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
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(448, 193, 125, 30);
		add(txtQuantity);
		
		cbName = new JComboBox(new Object[] {"Sản phẩm 1", "Sản phầm 2"});
=======
		lblName.setBounds(324, 124, 76, 30);
		add(lblName);
		
		JLabel lbQuantity = new JLabel("Quantity:");
		lbQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbQuantity.setBounds(306, 193, 132, 30);
		add(lbQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(448, 193, 125, 30);
		add(txtQuantity);
		
		cbName = new JComboBox(new Object[] {"Sản phẩm 1", "Sản phẩm 2"});
>>>>>>> Stashed changes
		cbName.setBackground(SystemColor.textHighlightText);
		cbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbName.setBounds(448, 124, 125, 30);
		add(cbName);
		
		
<<<<<<< Updated upstream
		
		tableCus = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[] {"ID", "Name", "Price", "Quantiy"}, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		model.addRow(new Object[] {"1", "1", "1", "1"});
		model.addRow(new Object[] {"1", "1", "1", "1"});
		
		tableCus.setModel(model);
=======
		dataTable.add(rows);
		dataTable.add(rows);
		dataTable.add(rows);
		dataTable.add(rows);
		dataTable.add(rows);
		
		
		Vector columns = new Vector();
		columns.add("ID");
		columns.add("Name");
		columns.add("Price");
		columns.add("Quantity");
		tableCus = new JTable(dataTable, columns);
>>>>>>> Stashed changes
		tableCus.setBorder(new EmptyBorder(0, 0, 0, 0));
		tableCus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCus.setBounds(10, 307, 607, 236);
		tableCus.setRowHeight(25);
		
		
		scrollPane = new JScrollPane(tableCus);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(SystemColor.info);
		
		scrollPane.setBounds(10, 307, 641, 236);
		add(scrollPane);
		
		panelDecor_1 = new JPanel();
		panelDecor_1.setLayout(null);
		panelDecor_1.setBorder(new EmptyBorder(0, 0, 0, 0));
<<<<<<< Updated upstream
		panelDecor_1.setBackground(new Color(0, 128, 128));
		panelDecor_1.setBounds(7, 43, 10, 4);
		add(panelDecor_1);
		
		btnAdd = new JButton("Thêm");
=======
		panelDecor_1.setBackground(SystemColor.desktop);
		panelDecor_1.setBounds(10, 43, 5, 4);
		add(panelDecor_1);
		
		btnAdd = new JButton("ADD");
>>>>>>> Stashed changes
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(254, 254, 85, 30);
		btnAdd.setBorder(null);
		add(btnAdd);
		
<<<<<<< Updated upstream
		btnUpdate = new JButton("Sửa");
=======
		btnUpdate = new JButton("UPDATE");
>>>>>>> Stashed changes
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(390, 254, 85, 30);
		add(btnUpdate);
		
<<<<<<< Updated upstream
		btnDelete = new JButton("Xóa");
=======
		btnDelete = new JButton("DELETE");
>>>>>>> Stashed changes
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBorder(null);
		btnDelete.setBounds(517, 254, 85, 30);
		add(btnDelete);
		
<<<<<<< Updated upstream
		btnCancel = new JButton("Hủy");
=======
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(115, 193, 125, 30);
		add(txtPrice);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new EquipmentListener(this));
>>>>>>> Stashed changes
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(0, 128, 128));
		btnCancel.setBounds(390, 254, 85, 30);
		add(btnCancel);
<<<<<<< Updated upstream
=======
		
		btnSave_Add = new JButton("SAVE");
		btnSave_Add.addActionListener(new EquipmentListener(this));
		btnSave_Add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_Add.setFocusPainted(false);
		btnSave_Add.setBorderPainted(false);
		btnSave_Add.setBorder(null);
		btnSave_Add.setBackground(Color.YELLOW);
		btnSave_Add.setBounds(517, 254, 85, 30);
		add(btnSave_Add);
		
		btnSave_Update = new JButton("SAVE");
		btnSave_Update.addActionListener(new EquipmentListener(this));
		btnSave_Update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_Update.setFocusPainted(false);
		btnSave_Update.setBorderPainted(false);
		btnSave_Update.setBorder(null);
		btnSave_Update.setBackground(Color.YELLOW);
		btnSave_Update.setBounds(517, 254, 85, 30);
		add(btnSave_Update);
		
>>>>>>> Stashed changes
		
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
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 91, 641, 153);
		add(panel);
		//scrollPane.add(table);
		AddListener();
		this.txtId.setEnabled(false);
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
		this.txtPrice.setText(null);
		this.txtQuantity.setText(null);
		
	}
	public void SetTextEnable(boolean b) {
		//this.txtId.setEnabled(b);
		this.txtPrice.setEnabled(b);
		this.txtQuantity.setEnabled(b);
		this.cbName.setEnabled(b);
	}
	public void SetButtonVisibile(boolean b) {
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
	}
	public void SetDataTextField(int row) {
		this.txtId.setText(this.tableCus.getValueAt(row, 0).toString());
		this.cbName.setSelectedItem(this.tableCus.getValueAt(row, 1).toString());
		this.txtPrice.setText(this.tableCus.getValueAt(row, 2).toString());
		this.txtQuantity.setText(this.tableCus.getValueAt(row, 3).toString());
		
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
	public JComboBox getCbName() {
		return cbName;
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
	public void SetTextFieldEnable(boolean b) {
		this.txtId.setEnabled(b);
		this.cbName.setEnabled(b);
		this.txtPrice.setEnabled(b);
		this.txtQuantity.setEnabled(b);
	}
	public void SetTextFieldData(int row) {
		this.txtId.setText(this.tableCus.getValueAt(row, 0).toString());
		this.cbName.setSelectedItem(this.tableCus.getValueAt(row, 1).toString());
		this.txtPrice.setText(this.tableCus.getValueAt(row, 2).toString());
		this.txtQuantity.setText(this.tableCus.getValueAt(row, 3).toString());
	}
	
	public void SetButtonVisible(boolean b) {
		this.btnAdd.setEnabled(b);
		this.btnUpdate.setEnabled(b);
		this.btnDelete.setEnabled(b);
		this.btnCancel.setEnabled(!b);
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
		this.btnCancel.setVisible(!b);
		
	}
	public void SetTextFieldNull() {
		this.txtId.setText("");
		this.txtPrice.setText("");
		this.txtQuantity.setText("");
	}	
	public JComboBox getCbName() {
		return cbName;
	}
	public void setCbName(JComboBox cbName) {
		this.cbName = cbName;
	}
	public JTextField getTxtId() {
		return txtId;
	}
	public JTextField getTxtQuantity() {
		return txtQuantity;
	}
	public JTable getTableCus() {
		return tableCus;
	}
	public JTextField getTxtPrice() {
		return txtPrice;
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
	public JButton getBtnSave_Update() {
		return btnSave_Update;
	}
	public JButton getBtnSave_Add() {
		return btnSave_Add;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
