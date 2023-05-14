package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLBill;
import BLL.BLLCourse;
import BLL.BLLCustomer;
import DAL.DAOUser;
import DTO.BillInfor;
import DTO.Course;
import GUI.Listener.BillListener;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class PanelBill extends JPanel {
	private JTextField txtID;
	private JTextField txtCus;
	private JTextField txtUser;
	private JTextField txtDate;
	private JTextField txtTotal;
	private String IDU;

	private DefaultTableModel dtm;
	private JTable table;
	private JButton btnAdd, btnCancel, btnUpdate, btnReset;
	private JLabel lblSearchCourse, lblScPhone, lblScHan;
	private JComboBox<String> cbbCourse, cbbCourseInfor;
	private JTextField txtPhoneSc;
	private JRadioButton rdoHetHan;
	private ArrayList<BillInfor> data = BLLBill.Instance().getAllBillInfor();
	private ArrayList<Course> dataCourse = BLLCourse.Instance().selectAll();

	/**
	 * Create the panel.
	 */

	public PanelBill(String u) throws SQLException, ClassNotFoundException {
		this.IDU = u;
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

		JLabel lblNewLabel_1_1 = new JLabel("SDT Khách hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 68, 117, 26);
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
		txtID.setBounds(127, 21, 126, 23);
		panel.add(txtID);
		txtID.setColumns(10);

		txtCus = new JTextField();
		txtCus.setColumns(10);
		txtCus.setBounds(127, 68, 126, 23);
		panel.add(txtCus);

		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(127, 115, 126, 23);
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

		txtPhoneSc = new JTextField();
		txtPhoneSc.setBounds(175, 9, 107, 28);
		panel_1.add(txtPhoneSc);
		txtPhoneSc.setColumns(10);

		lblScPhone = new JLabel("");
		lblScPhone.setIcon(new ImageIcon(PanelBill.class.getResource("/photo/SearchImage1.png")));
		lblScPhone.setBounds(292, 11, 25, 25);
		panel_1.add(lblScPhone);

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 0));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReset.setBounds(512, 9, 72, 29);
		panel_1.add(btnReset);

		lblScHan = new JLabel("");
		lblScHan.setBounds(443, 11, 25, 25);
		lblScHan.setIcon(new ImageIcon(PanelBill.class.getResource("/photo/SearchImage1.png")));
		panel_1.add(lblScHan);

		rdoHetHan = new JRadioButton("Hết hạn");
		rdoHetHan.setBackground(new Color(255, 128, 128));
		rdoHetHan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdoHetHan.setBounds(351, 12, 77, 23);
		panel_1.add(rdoHetHan);

		table = new JTable();

		String[] columnNames = { "ID", "Khách hàng", "Nhân viên", "Khóa tập", "Ngày", "Tổng tiền" };

		dtm = new DefaultTableModel(columnNames, 0);

		for (int i = 0; i < data.size(); i++) {
			int ID = data.get(i).getIdBill();
			String cusName = data.get(i).getCusName();
			String staffName = data.get(i).getStaffName();
			String courseName = data.get(i).getKind();
			LocalDate Day = data.get(i).getDate();
			int Total = data.get(i).getTotal();

			Object[] newRow = { ID, cusName, staffName, courseName, Day, Total };

			dtm.addRow(newRow);
		}
		table.setModel(dtm);

		for (int i = 0; i < dataCourse.size(); i++) {
			cbbCourseInfor.addItem(dataCourse.get(i).getKind());
			cbbCourse.addItem(dataCourse.get(i).getKind());
		}

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
		cbbCourseInfor.setEnabled(false);
	}

	public void SetTextEditable() {
		cbbCourseInfor.setEnabled(true);
		txtCus.setEditable(true);
		txtTotal.setEditable(true);
	}

	public void SetTextInfor(int index) {
		txtID.setText(table.getValueAt(index, 0) + "");
		txtCus.setText(data.get(index).getPhonenum());
		txtUser.setText(table.getValueAt(index, 2) + "");
		cbbCourseInfor.setSelectedItem(table.getValueAt(index, 3) + "");
		txtDate.setText(table.getValueAt(index, 4) + "");
		txtTotal.setText(table.getValueAt(index, 5) + "");
	}

	public void SetTextNull() {
		txtID.setText("");
		txtCus.setText("");
		txtUser.setText("");
		txtDate.setText("");
		txtTotal.setText("");
	}

	public void AddListener() {
		table.getSelectionModel().addListSelectionListener(new BillListener(this));
		btnAdd.addActionListener(new BillListener(this));
		btnCancel.addActionListener(new BillListener(this));
		btnUpdate.addActionListener(new BillListener(this));
		btnReset.addActionListener(new BillListener(this));
		lblSearchCourse.addMouseListener(new BillListener(this));
		lblScPhone.addMouseListener(new BillListener(this));
		lblScHan.addMouseListener(new BillListener(this));
		cbbCourseInfor.addItemListener(new BillListener(this));
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
		SetTextNull();
		SetTextEditable();
		btnUpdate.setEnabled(false);
		btnCancel.setEnabled(true);
		btnAdd.setText("Lưu");
	}

	public void PressSaveAdd() throws ClassNotFoundException, SQLException {
		String cusName = txtCus.getText();
		String staffName = txtUser.getText();
		String courseName = cbbCourseInfor.getSelectedItem().toString();
		LocalDate date = LocalDate.now();
		int total = Integer.parseInt(txtTotal.getText());

		BLLBill.Instance().insert(BLLCustomer.Instance().selectByPhone(cusName).getID(),
				BLLCourse.Instance().selectAll(courseName).get(0).getID(), DAOUser.getInstance().selectByUserName(IDU).get(0).getID(), total);
		data = BLLBill.Instance().getAllBillInfor();
		Object[] newRow = { data.get(data.size() - 1).getIdBill(),
				BLLCustomer.Instance().selectByPhone(cusName).getName(),  DAOUser.getInstance().selectByUserName(IDU).get(0).getFullName(), courseName, date.toString(),
				total };
		dtm.addRow(newRow);
		table.revalidate();
		table.repaint();

		SetTextUnEditable();
		btnUpdate.setEnabled(true);
		btnCancel.setEnabled(false);
		btnAdd.setText("Thêm");
	}

	public void PressUpdate() {
		int indexRow = table.getSelectedRow();
		if (indexRow != -1) {

			SetTextEditable();
			btnAdd.setEnabled(false);
			btnCancel.setEnabled(true);
			btnUpdate.setText("Lưu");
		}
	}

	public void PressSaveUpdate() {
		int indexRow = table.getSelectedRow();
		if (indexRow != -1) {

			int ID = Integer.parseInt(txtID.getText());
			String cusName = txtCus.getText();
			String courseName = cbbCourseInfor.getSelectedItem().toString();
			LocalDate date = LocalDate.now();
			int total = Integer.parseInt(txtTotal.getText());

			try {
				BLLBill.Instance().update(ID, BLLCustomer.Instance().selectByPhone(cusName).getID(),
						BLLCourse.Instance().selectAll(courseName).get(0).getID(),DAOUser.getInstance().selectByUserName(IDU).get(0).getID(), date, total);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dtm.setValueAt(BLLCustomer.Instance().selectByPhone(cusName).getName(), indexRow, 1);
			dtm.setValueAt(courseName, indexRow, 3);
			dtm.setValueAt(total, indexRow, 5);

			table.revalidate();
			table.repaint();

			try {
				data = BLLBill.Instance().getAllBillInfor();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			SetTextUnEditable();
			btnAdd.setEnabled(true);
			btnCancel.setEnabled(false);
			btnUpdate.setText("Sửa");
		}

	}

	public void setTextPrice(String value) {
		System.out.println(value);
		try {
			txtTotal.setText(BLLCourse.Instance().selectAll(value).get(0).getPrice() + "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PressSearchCourse() {
		int n = dtm.getRowCount();
		for (int i = 0; i < n; i++) {
			dtm.removeRow(0);
		}
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getKind().equals(cbbCourse.getSelectedItem().toString())) {
				int ID = data.get(i).getIdBill();
				String cusName = data.get(i).getCusName();
				String staffName = data.get(i).getStaffName();
				String courseName = data.get(i).getKind();
				LocalDate Day = data.get(i).getDate();
				int Total = data.get(i).getTotal();

				Object[] newRow = { ID, cusName, staffName, courseName, Day, Total };

				dtm.addRow(newRow);
			}
		}
	}

	public void PressReset() {
		int n = dtm.getRowCount();
		for (int i = 0; i < n; i++) {
			dtm.removeRow(0);
		}
		for (int i = 0; i < data.size(); i++) {
			int ID = data.get(i).getIdBill();
			String cusName = data.get(i).getCusName();
			String staffName = data.get(i).getStaffName();
			String courseName = data.get(i).getKind();
			LocalDate Day = data.get(i).getDate();
			int Total = data.get(i).getTotal();

			Object[] newRow = { ID, cusName, staffName, courseName, Day, Total };

			dtm.addRow(newRow);
		}
	}

	public void PressSearchPhone() {
		if (!txtPhoneSc.getText().isEmpty()) {
			int n = dtm.getRowCount();
			for (int i = 0; i < n; i++) {
				dtm.removeRow(0);
			}
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPhonenum().equals(txtPhoneSc.getText())) {
					int ID = data.get(i).getIdBill();
					String cusName = data.get(i).getCusName();
					String staffName = data.get(i).getStaffName();
					String courseName = data.get(i).getKind();
					LocalDate Day = data.get(i).getDate();
					int Total = data.get(i).getTotal();

					Object[] newRow = { ID, cusName, staffName, courseName, Day, Total };

					dtm.addRow(newRow);
				}
			}
		}
	}

	public void PressSearchHetHan() {
		if(rdoHetHan.isSelected() == true) {
			int n = dtm.getRowCount();
			for (int i = 0; i < n; i++) {
				dtm.removeRow(0);
			}
			for (int i = 0; i < data.size(); i++) {
				
				int dayCount = 0;
				if (data.get(i).getKind().equals("7 ngày")) {
					dayCount = 7;
				} else if (data.get(i).getKind().equals("14 ngày")) {
					dayCount = 14;
				} else if (data.get(i).getKind().equals("1 tháng")) {
					dayCount = 30;
				} else if (data.get(i).getKind().equals("6 tháng")) {
					dayCount = 180;
				} else if (data.get(i).getKind().equals("1 năm")) {
					dayCount = 360;
				}
				
				if (LocalDate.now().compareTo(data.get(i).getDate().plus(dayCount,ChronoUnit.DAYS)) >= 0 ) {
					int ID = data.get(i).getIdBill();
					String cusName = data.get(i).getCusName();
					String staffName = data.get(i).getStaffName();
					String courseName = data.get(i).getKind();
					LocalDate Day = data.get(i).getDate();
					int Total = data.get(i).getTotal();

					Object[] newRow = { ID, cusName, staffName, courseName, Day, Total };

					dtm.addRow(newRow);
				}
			}
		}
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

	public JTextField getTextField() {
		return txtPhoneSc;
	}

	public void setTextField(JTextField textField) {
		this.txtPhoneSc = textField;
	}

	public JTextField getTxtPhoneSc() {
		return txtPhoneSc;
	}

	public void setTxtPhoneSc(JTextField txtPhoneSc) {
		this.txtPhoneSc = txtPhoneSc;
	}

}
