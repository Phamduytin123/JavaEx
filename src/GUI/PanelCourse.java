package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DTO.Course;
import GUI.Listener.BillListener;
import GUI.Listener.CourseListener;
import GUI.Listener.CustomerListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCourse extends JPanel {
	private JTextField txtCourseID;
	private JTextField txtKind;
	private JTextField txtPrice;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable tableCus;
	private JScrollPane scrollPane;
	private JButton btnCancel, btnSave_add, btnSave_update;
	private ArrayList<Course> rows;
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

		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(515, 254, 89, 30);
		add(btnDelete);
		
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
		try {
			rows = BLL.BLLCourse.Instance().selectAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < rows.size(); i++) {
			int id = rows.get(i).getID();
			String kind = rows.get(i).getKind();
			int price = rows.get(i).getPrice();
			model.addRow(new Object[] {id, kind, price});
		}
		
		tableCus.setModel(model);
		
		tableCus.setBorder(new EmptyBorder(0, 0, 0, 0));
		tableCus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCus.setBounds(10, 307, 607, 236);
		
		scrollPane = new JScrollPane(tableCus);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(240, 248, 255));
		scrollPane.setBounds(10, 307, 641, 236);
		add(scrollPane);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(416, 254, 89, 30);
		add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBackground(Color.PINK);
		
		btnSave_add = new JButton("Lưu");
		btnSave_add.setBounds(515, 254, 89, 30);
		add(btnSave_add);
		btnSave_add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSave_add.setBackground(Color.YELLOW);
		
		btnSave_update = new JButton("Lưu");
		btnSave_update.setBounds(515, 254, 89, 30);
		add(btnSave_update);
		btnSave_update.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSave_update.setBackground(Color.YELLOW);
//		SetTextEditable();
		AddListener();
	}

	public ArrayList<Course> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Course> rows) {
		this.rows = rows;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnSave_add() {
		return btnSave_add;
	}

	public JButton getBtnSave_update() {
		return btnSave_update;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public void AddListener() {
		tableCus.getSelectionModel().addListSelectionListener(new CourseListener(this));
		btnSave_add.addActionListener(new CourseListener(this));
		btnSave_update.addActionListener(new CourseListener(this));
		btnCancel.addActionListener(new CourseListener(this));
		btnAdd.addActionListener(new CourseListener(this));
		btnDelete.addActionListener(new CourseListener(this));
		btnUpdate.addActionListener(new CourseListener(this));
	}
	public void SetTextFieldNull() {
		this.txtCourseID.setText(null);
		this.txtKind.setText(null);
		this.txtPrice.setText(null);
		
	}
	public void SetTextEnable(boolean b) {
		//this.txtId.setEnabled(b);
		this.txtCourseID.setEnabled(b);
		this.txtKind.setEnabled(b);
		this.txtPrice.setEnabled(b);
	}
	public void SetButtonVisibile(boolean b) {
		this.btnAdd.setVisible(b);
		this.btnUpdate.setVisible(b);
		this.btnDelete.setVisible(b);
	}
	public void SetDataTextField(int row) {
		this.txtCourseID.setText(this.tableCus.getValueAt(row, 0).toString());
		this.txtKind.setText(this.tableCus.getValueAt(row, 1).toString());
		this.txtPrice.setText(this.tableCus.getValueAt(row, 2).toString());
		
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
		return btnDelete;
	}
	public JTable getTableCus() {
		return tableCus;
	}
}
