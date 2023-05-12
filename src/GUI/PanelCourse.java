package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
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

	/**
	 * Create the panel.
	 */
	public PanelCourse() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);

		JLabel lblThngTinKha = new JLabel("Thông tin khóa tập");
		lblThngTinKha.setBounds(169, 11, 276, 41);
		lblThngTinKha.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKha.setForeground(new Color(0, 0, 160));
		lblThngTinKha.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(lblThngTinKha);

		JPanel panel = new JPanel();
		panel.setBounds(20, 68, 584, 133);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã khóa tập");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 27, 83, 26);
		panel.add(lblNewLabel_1);

		txtCourseID = new JTextField();
		txtCourseID.setColumns(10);
		txtCourseID.setBounds(100, 27, 126, 23);
		panel.add(txtCourseID);

		JLabel lblNewLabel_1_1 = new JLabel("Loại");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(322, 27, 83, 26);
		panel.add(lblNewLabel_1_1);

		txtKind = new JTextField();
		txtKind.setColumns(10);
		txtKind.setBounds(412, 27, 126, 23);
		panel.add(txtKind);

		JLabel lblNewLabel_1_2 = new JLabel("Giá");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 79, 83, 26);
		panel.add(lblNewLabel_1_2);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(100, 79, 126, 23);
		panel.add(txtPrice);

		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(211, 235, 89, 29);
		add(btnCancel);

		btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBounds(310, 235, 89, 29);
		add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnUpdate.setBackground(new Color(255, 128, 0));
		btnUpdate.setBounds(416, 235, 89, 29);
		add(btnUpdate);

		btnDel = new JButton("Xóa");
		btnDel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDel.setBackground(Color.RED);
		btnDel.setBounds(515, 236, 89, 29);
		add(btnDel);
	}
	public void SetTextEditable() {
		txtCourseID.setEditable(false);
		txtKind.setEditable(false);
		txtPrice.setEditable(false);

	}
	
	public void SetTextUnEditable() {
		txtKind.setEditable(true);
		txtPrice.setEditable(true);
	}
	
	public void SetTextInfor(int index) {
		
	}
}
