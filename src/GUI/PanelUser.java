package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.User;
import GUI.Listener.EquipmentListener;
import GUI.Listener.UserListener;

public class PanelUser extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txtId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JComboBox cbRole;
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
	private JTextField txtName;
	private JTextField txtAddress;
	private ArrayList<User> rows;
	//private JPanel panelDecor;
	/**
	 * Create the panel.
	 */
	public PanelUser() {
		setBackground(new Color(255, 218, 185));
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(115, 109, 125, 30);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lbEquipment = new JLabel("Nhân viên");
		lbEquipment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lbEquipment.setBounds(20, 10, 111, 69);
		add(lbEquipment);
		
		JPanel panelDecor = new JPanel();
		panelDecor.setBackground(new Color(0, 128, 128));
		panelDecor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDecor.setBounds(125, 43, 530, 4);
		add(panelDecor);
		panelDecor.setLayout(null);
		
		JLabel lbId = new JLabel("ID: ");
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setBounds(29, 109, 76, 30);
		add(lbId);
		
		JLabel lblUsername = new JLabel("Tài khoản:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(29, 193, 76, 30);
		add(lblUsername);
		
		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(326, 109, 98, 30);
		add(lblName);
		
		JLabel lbPassword = new JLabel("Mật khẩu:");
		lbPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPassword.setBounds(306, 193, 132, 30);
		add(lbPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		txtUsername.setBounds(115, 194, 125, 30);
		add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(448, 193, 125, 30);
		add(txtPassword);
		
		cbRole = new JComboBox(new Object[] {"Admin", "Nhân viên "});
		cbRole.setBackground(SystemColor.textHighlightText);
		cbRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbRole.setBounds(115, 154, 125, 30);
		add(cbRole);
		
		
		
		tableCus = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[] {"ID", "Tên", "Chức vụ", "Địa chỉ", "Tài khoản", "Mật khẩu"}, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		try {
			rows = BLL.BLLUser.Instance().selecAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for (int i = 0; i < rows.size(); i ++) {
			int id = rows.get(i).getID();
			String username = rows.get(i).getUserName();
			String password = rows.get(i).getPassword();
			String address = rows.get(i).getAddress();
			String role = rows.get(i).getRole();
			String name = rows.get(i).getFullName();
			model.addRow(new Object[] {id, name, role, address, username, password});
		}

		
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
		panelDecor_1.setBounds(7, 43, 15, 4);
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
		this.txtId.setEnabled(false);
		
		JLabel lbRole = new JLabel("Chức vụ:");
		lbRole.setHorizontalAlignment(SwingConstants.CENTER);
		lbRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbRole.setBounds(29, 153, 76, 30);
		add(lbRole);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(448, 109, 125, 30);
		add(txtName);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(448, 154, 125, 30);
		add(txtAddress);
		
		JLabel lbAddress = new JLabel("Địa chỉ:");
		lbAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbAddress.setBounds(306, 154, 132, 30);
		add(lbAddress);
		
		panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(10, 91, 641, 153);
		add(panel);
		AddListener();
		SetTextEnable(false);
	}
	public ArrayList<User> getRows() {
		return rows;
	}
	public void setRows(ArrayList<User> rows) {
		this.rows = rows;
	}
	public void AddListener() {
		btnSave_update.addActionListener(new UserListener(this));
		btnSave_add.addActionListener(new UserListener(this));
		tableCus.getSelectionModel().addListSelectionListener(new UserListener(this));
		btnCancel.addActionListener(new UserListener(this));
		btnUpdate.addActionListener(new UserListener(this));
		btnAdd.addActionListener(new UserListener(this));
		btnDelete.addActionListener(new UserListener(this));
	}
	public void SetTextFieldNull() {
		this.txtId.setText(null);
		this.txtName.setText(null);
		this.txtUsername.setText(null);
		this.txtAddress.setText(null);
		this.txtPassword.setText(null);
		
		
	}
	public void SetTextEnable(boolean b) {
		//this.txtId.setEnabled(b);
		this.txtId.setEnabled(b);
		this.txtName.setEnabled(b);
		this.txtUsername.setEnabled(b);
		this.txtAddress.setEnabled(b);
		this.txtPassword.setEnabled(b);
		this.cbRole.setEnabled(b);
	}
	public void SetButtonVisibile(boolean b) {
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
	}
	public void SetDataTextField(int row) {
		this.txtId.setText(this.tableCus.getValueAt(row, 0).toString());
		this.txtName.setText(this.tableCus.getValueAt(row, 1).toString());
		this.cbRole.setSelectedItem(this.tableCus.getValueAt(row, 2).toString());
		this.txtAddress.setText(this.tableCus.getValueAt(row, 3).toString());
		this.txtUsername.setText(this.tableCus.getValueAt(row, 4).toString());
		this.txtPassword.setText(this.tableCus.getValueAt(row, 5).toString());
		
		
	}
	public JTextField getTxtId() {
		return txtId;
	}
	public JTextField getTxtUsername() {
		return txtUsername;
	}
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	public JComboBox getCbRole() {
		return cbRole;
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
	public JTextField getTxtName() {
		return txtName;
	}
	public JTextField getTxtAddress() {
		return txtAddress;
	}
}
