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
import javax.swing.table.DefaultTableModel;

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
	private JComboBox cbName;
	private JTable tableCus;
	private JScrollPane scrollPane;
	private JPanel panelDecor_1;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnSave_add;
	private JButton btnSave_update;
	//private JPanel panelDecor;
	/**
	 * Create the panel.
	 */
	public PanelEquipment() {
		setBackground(SystemColor.info);
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(115, 125, 125, 30);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lbEquipment = new JLabel("EQUIPMENT");
		lbEquipment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lbEquipment.setBounds(10, 10, 137, 69);
		add(lbEquipment);
		
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
		
		JLabel lblGender = new JLabel("Price: ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(29, 193, 76, 30);
		add(lblGender);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(326, 124, 76, 30);
		add(lblName);
		
		JLabel lblPhonenumber = new JLabel("Quantity:");
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
		cbName.setBackground(SystemColor.textHighlightText);
		cbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbName.setBounds(448, 124, 125, 30);
		add(cbName);
		
		
		
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
		
		tableCus.getSelectionModel().addListSelectionListener(new EquipmentListener(this));
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
		panelDecor_1.setBackground(SystemColor.desktop);
		panelDecor_1.setBounds(10, 43, 10, 4);
		add(panelDecor_1);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new EquipmentListener(this));
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(254, 254, 85, 30);
		btnAdd.setBorder(null);
		add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new EquipmentListener(this));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(390, 254, 85, 30);
		add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new EquipmentListener(this));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBorder(null);
		btnDelete.setBounds(517, 254, 85, 30);
		add(btnDelete);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new EquipmentListener(this));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(0, 128, 128));
		btnCancel.setBounds(390, 254, 85, 30);
		add(btnCancel);
		
		btnSave_add = new JButton("SAVE");
		btnSave_add.addActionListener(new EquipmentListener(this));
		btnSave_add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_add.setFocusPainted(false);
		btnSave_add.setBorderPainted(false);
		btnSave_add.setBorder(null);
		btnSave_add.setBackground(new Color(255, 255, 0));
		btnSave_add.setBounds(517, 254, 85, 30);
		add(btnSave_add);
		
		btnSave_update = new JButton("SAVE");
		btnSave_update.addActionListener(new EquipmentListener(this));
		btnSave_update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave_update.setFocusPainted(false);
		btnSave_update.setBorderPainted(false);
		btnSave_update.setBorder(null);
		btnSave_update.setBackground(new Color(255, 255, 0));
		btnSave_update.setBounds(517, 254, 85, 30);
		add(btnSave_update);
		//scrollPane.add(table);
		SetTextEnable(false);
	}
	public void SetTextFieldNull() {
		this.txtId.setText(null);
		this.txtPrice.setText(null);
		this.txtQuantity.setText(null);
		
	}
	public void SetTextEnable(boolean b) {
		this.txtId.setEnabled(b);
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
}
