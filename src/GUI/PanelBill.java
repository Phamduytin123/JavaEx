package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DTO.Bill;
import GUI.Listener.BillListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class PanelBill extends JPanel {
	private JTextField txtID;
	private JTextField txtCus;
	private JTextField txtUser;
	private JTextField txtDate;
	private JTextField txtTotal;
	
	private DefaultTableModel dtm;
	private JTable table;
	private JButton btnAdd, btnCancel, btnUpdate, btnReset;
	private JLabel lblSearchCourse, lblScPhone,lblScHan;
	private JComboBox<String> cbbCourse,cbbDay,cbbCourseInfor;
	private JTextField textField;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	
	
	
	public PanelBill() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin hóa đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(169, 11, 276, 41);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(10, 51, 594, 162);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 21, 83, 26);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 68, 83, 26);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nhân viên");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 115, 83, 26);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Khóa tập");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(352, 21, 83, 26);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Ngày");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(352, 68, 83, 26);
		panel.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Tổng tiền");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_4.setBounds(352, 115, 83, 26);
		panel.add(lblNewLabel_1_1_4);

		txtID = new JTextField();
		txtID.setBounds(100, 21, 126, 23);
		panel.add(txtID);
		txtID.setColumns(10);

		txtCus = new JTextField();
		txtCus.setColumns(10);
		txtCus.setBounds(100, 68, 126, 23);
		panel.add(txtCus);

		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(100, 115, 126, 23);
		panel.add(txtUser);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(427, 68, 126, 23);
		panel.add(txtDate);

		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(427, 115, 126, 23);
		panel.add(txtTotal);
		
		cbbCourseInfor = new JComboBox<String>();
		cbbCourseInfor.setBounds(427, 24, 126, 24);
		panel.add(cbbCourseInfor);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setBackground(new Color(255, 128, 0));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnUpdate.setBounds(490, 224, 89, 29);
		add(btnUpdate);

		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(384, 224, 89, 29);
		add(btnAdd);

		btnCancel = new JButton("Hủy");
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(277, 224, 89, 29);
		add(btnCancel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(10, 264, 594, 48);
		add(panel_1);
		panel_1.setLayout(null);

		cbbCourse = new JComboBox<String>();
		cbbCourse.setBounds(10, 11, 77, 24);
		panel_1.add(cbbCourse);

		lblSearchCourse = new JLabel("");
		lblSearchCourse.setIcon(new ImageIcon(PanelBill.class.getResource("/photo/SearchImage1.png")));
		lblSearchCourse.setBounds(97, 11, 25, 25);
		panel_1.add(lblSearchCourse);

		JLabel lblNewLabel_2 = new JLabel("SDT");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(142, 14, 39, 19);
		panel_1.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(175, 9, 107, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		lblScPhone = new JLabel("");
		lblScPhone.setIcon(new ImageIcon(PanelBill.class.getResource("/photo/SearchImage1.png")));
		lblScPhone.setBounds(292, 11, 25, 25);
		panel_1.add(lblScPhone);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 0));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReset.setBounds(512, 9, 72, 29);
		panel_1.add(btnReset);
		
		lblNewLabel_3 = new JLabel("Hết hạn");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(337, 11, 54, 24);
		panel_1.add(lblNewLabel_3);
		
		cbbDay = new JComboBox<String>();
		cbbDay.setBounds(387, 11, 77, 24);
		panel_1.add(cbbDay);
		
		 lblScHan = new JLabel("");
		lblScHan.setBounds(474, 11, 25, 25);
		lblScHan.setIcon(new ImageIcon(PanelBill.class.getResource("/photo/SearchImage1.png")));
		panel_1.add(lblScHan);
		
		table = new JTable();
		
		String[] columnNames = { "ID","Khách hàng","Nhân viên","Khóa tập","Ngày","Tổng tiền" };

		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i < 5; i++) {

			Object [] newRow = {1,1,1,1};
			
			dtm.addRow(newRow);
		}
		table.setModel(dtm);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setBounds(10, 323, 594, 220);
		
		add(scrollPane);
		AddListener();
		SetTextUnEditable();
		btnCancel.setEnabled(false);
	}
	
	public void SetTextUnEditable() {
		txtID.setEditable(false);
		txtCus.setEditable(false);
		txtUser.setEditable(false);
		txtDate.setEditable(false);
		txtTotal.setEditable(false);
	}
	
	public void SetTextEditable() {
		cbbCourseInfor.setEnabled(true);
		txtCus.setEditable(true);
		txtDate.setEditable(true);
		txtTotal.setEditable(true);
		txtUser.setEditable(true);
	}

	public void SetTextInfor(int index) {
		txtID.setText(table.getValueAt(index, 0)+"");
		txtCus.setText(table.getValueAt(index, 1)+"");
		txtUser.setText(table.getValueAt(index, 2)+"");
		cbbCourseInfor.setSelectedItem(table.getValueAt(index, 3)+"");
		txtDate.setText(table.getValueAt(index, 4)+"");
		txtTotal.setText(table.getValueAt(index, 5)+"");
	}
	
	public void AddListener() {
		table.getSelectionModel().addListSelectionListener(new BillListener(this));
		btnAdd.addActionListener(new BillListener(this));
		btnCancel.addActionListener(new BillListener(this));
		btnUpdate.addActionListener(new BillListener(this));
	}
	
	public void PressCancel() {
		SetTextUnEditable();
		btnCancel.setEnabled(false);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnAdd.setText("Thêm");
		btnUpdate.setText("Sửa");
	}
	
	public void PressAdd() {
		SetTextEditable();
		btnUpdate.setEnabled(false);
		btnCancel.setEnabled(true);
		btnAdd.setText("Lưu");
	}
	
	public void PressSaveAdd() {
//		String cusName = txtCus.getText();
//		String staffName = txtUser.getText();
//		String courseName = cbbCourseInfor.getSelectedItem().toString();
//		String DOB = txtDate.getText();
//		int total = Integer.parseInt(txtTotal.getText());
//		
//		LocalDate date = LocalDate.now();
		
		SetTextUnEditable();
		btnUpdate.setEnabled(true);
		btnCancel.setEnabled(false);
		btnAdd.setText("Thêm");
	}
	
	public void PressUpdate() {
		SetTextEditable();
		btnAdd.setEnabled(false);
		btnCancel.setEnabled(true);
		btnUpdate.setText("Lưu");
	}
	
	public void PressSaveUpdate() {
		SetTextUnEditable();
		btnAdd.setEnabled(true);
		btnCancel.setEnabled(false);
		btnUpdate.setText("Sửa");
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtCus() {
		return txtCus;
	}

	public void setTxtCus(JTextField txtCus) {
		this.txtCus = txtCus;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}


	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JComboBox<String> getCbbCourseInfor() {
		return cbbCourseInfor;
	}

	public void setCbbCourseInfor(JComboBox<String> cbbCourseInfor) {
		this.cbbCourseInfor = cbbCourseInfor;
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public void setTxtTotal(JTextField txtTotal) {
		this.txtTotal = txtTotal;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JLabel getLblSearchCourse() {
		return lblSearchCourse;
	}

	public void setLblSearchCourse(JLabel lblSearchCourse) {
		this.lblSearchCourse = lblSearchCourse;
	}

	public JLabel getLblScPhone() {
		return lblScPhone;
	}

	public void setLblScPhone(JLabel lblScPhone) {
		this.lblScPhone = lblScPhone;
	}

	public JLabel getLblScHan() {
		return lblScHan;
	}

	public void setLblScHan(JLabel lblScHan) {
		this.lblScHan = lblScHan;
	}

	public JComboBox<String> getCbbCourse() {
		return cbbCourse;
	}

	public void setCbbCourse(JComboBox<String> cbbCourse) {
		this.cbbCourse = cbbCourse;
	}

	public JComboBox<String> getCbbDay() {
		return cbbDay;
	}

	public void setCbbDay(JComboBox<String> cbbDay) {
		this.cbbDay = cbbDay;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}
}
