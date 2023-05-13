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

import GUI.Listener.CustomerListener;
import GUI.Listener.EquipmentListener;

import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class PanelCustomer extends JPanel {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhonenumber;
	private JComboBox cbGender;
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
	public PanelCustomer() {
		setBackground(SystemColor.info);
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(115, 125, 125, 30);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lbCustomer = new JLabel("Khách Hàng");
		lbCustomer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomer.setBounds(20, 10, 125, 69);
		add(lbCustomer);
		
		JPanel panelDecor = new JPanel();
		panelDecor.setBackground(SystemColor.desktop);
		panelDecor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor.setBounds(140, 43, 526, 4);
		add(panelDecor);
		panelDecor.setLayout(null);
		
		JLabel lbId = new JLabel("ID: ");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setBounds(29, 122, 55, 30);
		add(lbId);
		
		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(29, 193, 76, 30);
		add(lblGender);
		
		JLabel lblName = new JLabel("Tên khách hàng:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(306, 124, 119, 30);
		add(lblName);
		
		JLabel lblPhonenumber = new JLabel("Số điện thoại:");
		lblPhonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonenumber.setBounds(290, 193, 148, 30);
		add(lblPhonenumber);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(448, 125, 125, 30);
		add(txtName);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setBounds(448, 193, 125, 30);
		add(txtPhonenumber);
		
		cbGender = new JComboBox(new Object[] {"Male", "Female"});
		cbGender.setBackground(SystemColor.textHighlightText);
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbGender.setBounds(115, 193, 125, 30);
		add(cbGender);
		
		
		
		tableCus = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[] {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại"}, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		model.addRow(new Object[] {"1", "1", "1", "1"});
		model.addRow(new Object[] {"1", "1", "1", "1"});
		
		tableCus.setModel(model);
		
		tableCus.setBorder(new EmptyBorder(0, 0, 0, 0));
		tableCus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCus.setBounds(10, 307, 607, 236);
		
		scrollPane = new JScrollPane(tableCus);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(240, 248, 255));
		scrollPane.setBounds(10, 307, 641, 236);
		add(scrollPane);
		
		panelDecor_1 = new JPanel();
		panelDecor_1.setLayout(null);
		panelDecor_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor_1.setBackground(SystemColor.desktop);
		panelDecor_1.setBounds(10, 43, 10, 4);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(10, 91, 641, 153);
		add(panel);
		this.txtId.setEnabled(false);
		AddListener();

		//scrollPane.add(table);
		SetTextEnable(false);
	}
	public void AddListener() {
		tableCus.getSelectionModel().addListSelectionListener(new CustomerListener(this));
		btnAdd.addActionListener(new CustomerListener(this));
		btnUpdate.addActionListener(new CustomerListener(this));
		btnDelete.addActionListener(new CustomerListener(this));
		btnCancel.addActionListener(new CustomerListener(this));
		btnSave_add.addActionListener(new CustomerListener(this));
		btnSave_update.addActionListener(new CustomerListener(this));
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
	public JTextField getTxtId() {
		return txtId;
	}
	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}
	public JTextField getTxtName() {
		return txtName;
	}
	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}
	public JTextField getTxtPhonenumber() {
		return txtPhonenumber;
	}
	public void setTxtPhonenumber(JTextField txtPhonenumber) {
		this.txtPhonenumber = txtPhonenumber;
	}
	public JComboBox getCbGender() {
		return cbGender;
	}
	public void setCbGender(JComboBox cbGender) {
		this.cbGender = cbGender;
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
	public void SetTextFieldNull() {
		this.txtId.setText(null);
		this.txtName.setText(null);
		this.txtPhonenumber.setText(null);
		
	}
	public void SetTextEnable(boolean b) {
		//this.txtId.setEnabled(b);
		this.txtName.setEnabled(b);
		this.txtPhonenumber.setEnabled(b);
		this.cbGender.setEnabled(b);
	}
	public void SetButtonVisibile(boolean b) {
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
	}
	public void SetDataTextField(int row) {
		this.txtId.setText(this.tableCus.getValueAt(row, 0).toString());
		this.txtName.setText(this.tableCus.getValueAt(row, 1).toString());
		this.cbGender.setSelectedItem(this.tableCus.getValueAt(row, 2).toString());
		this.txtPhonenumber.setText(this.tableCus.getValueAt(row, 3).toString());
		
	}
}