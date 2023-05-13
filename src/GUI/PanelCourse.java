package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Listener.BillListener;
import GUI.Listener.CourseListener;
import GUI.Listener.CustomerListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCourse extends JPanel {
	private JTextField txtCourseID;
	private JTextField txtKind;
	private JTextField txtPrice;
	private JButton btnAdd, btnCancel, btnUpdate, btnDel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable tableCus;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public PanelCourse() {
		setBackground(new Color(102, 205, 170));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 671, 553);
		setLayout(null);

		JLabel lblThngTinKha = new JLabel("Thông tin khóa tập");
		lblThngTinKha.setBounds(20, 10, 219, 71);
		lblThngTinKha.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKha.setForeground(new Color(0, 0, 160));
		lblThngTinKha.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(lblThngTinKha);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(10, 91, 641, 153);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã khóa tập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(29, 34, 95, 30);
		panel.add(lblNewLabel_1);

		txtCourseID = new JTextField();
		txtCourseID.setColumns(10);
		txtCourseID.setBounds(125, 34, 125, 30);
		panel.add(txtCourseID);

		JLabel lblNewLabel_1_1 = new JLabel("Loại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(334, 36, 47, 26);
		panel.add(lblNewLabel_1_1);

		txtKind = new JTextField();
		txtKind.setColumns(10);
		txtKind.setBounds(411, 34, 125, 30);
		panel.add(txtKind);

		JLabel lblNewLabel_1_2 = new JLabel("Giá:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(29, 102, 83, 26);
		panel.add(lblNewLabel_1_2);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(125, 102, 125, 30);
		panel.add(txtPrice);

		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(211, 254, 89, 30);
		add(btnCancel);

		btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBounds(310, 254, 89, 30);
		add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnUpdate.setBackground(new Color(255, 128, 0));
		btnUpdate.setBounds(416, 254, 89, 30);
		add(btnUpdate);

		btnDel = new JButton("Xóa");
		btnDel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDel.setBackground(Color.RED);
		btnDel.setBounds(515, 254, 89, 30);
		add(btnDel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(234, 43, 417, 4);
		add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 43, 22, 4);
		add(panel_2);
		
		tableCus = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(new Object[] {"Mã khóa tập", "Loại", "Giá tiền"}, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		model.addRow(new Object[] {"1", "1", "1"});
		model.addRow(new Object[] {"1", "1", "1"});
		
		tableCus.setModel(model);
		
		tableCus.setBorder(new EmptyBorder(0, 0, 0, 0));
		tableCus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCus.setBounds(10, 307, 607, 236);
		
		scrollPane = new JScrollPane(tableCus);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(240, 248, 255));
		scrollPane.setBounds(10, 307, 641, 236);
		add(scrollPane);
//		SetTextEditable();
	}
	public void SetTextEditable(boolean b) {
		txtCourseID.setEditable(b);
		txtKind.setEditable(b);
		txtPrice.setEditable(b);

	}
	public void SetTextUnEditable() {
		txtCourseID.setEditable(false);
		txtKind.setEditable(false);
		txtPrice.setEditable(false);
		
	}
	
	public void SetTextEditable() {
		txtCourseID.setEnabled(true);
		txtKind.setEditable(true);
		txtPrice.setEditable(true);
		
	}

	public void SetTextInfor(int index) {
		txtCourseID.setText(tableCus.getValueAt(index, 0)+"");
		txtKind.setText(tableCus.getValueAt(index, 1)+"");
		txtPrice.setText(tableCus.getValueAt(index, 2)+"");
		
	}
	
	public void AddListener() {
		tableCus.getSelectionModel().addListSelectionListener(new CourseListener(this));
		btnAdd.addActionListener(new CourseListener(this));
		btnCancel.addActionListener(new CourseListener(this));
		btnUpdate.addActionListener(new CourseListener(this));
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
	
	public JTextField getTxtCourseID() {
		return txtCourseID;
	}
	public JTextField getTxtKind() {
		return txtKind;
	}
	public JTextField getTxtPrice() {
		return txtPrice;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public JButton getBtnDel() {
		return btnDel;
	}
	public JTable getTableCus() {
		return tableCus;
	}
	
}
