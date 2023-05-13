package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


public class FormMain extends JFrame implements ActionListener{
	private JPanel contentPane;
	private PanelCustomer panelCustomer;
	private JPanel pnMenu;
	private PanelEquipment panelEquipment;
	private PanelCourse panelCourse;
	private PanelUser panelUser;
	private JButton btnEquipment;
	private JButton btnCourse;
	private JButton btnBill;
	private JButton btnUser;
	private JButton btnSignOut;
	private JButton btnCustomer;
	private PanelBill panelBill;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		
		pnMenu = new JPanel();
		pnMenu.setLayout(null);
		pnMenu.setBackground(new Color(128, 255, 255));
		pnMenu.setBounds(0, 0, 189, 553);
		contentPane.add(pnMenu);
		
		
		
		panelCustomer = new PanelCustomer();
		panelCustomer.setLayout(null);
		panelCustomer.setBounds(189, 0, 671, 553);
		contentPane.add(panelCustomer);
		
		
		panelEquipment = new PanelEquipment();
		panelEquipment.setLayout(null);
		panelEquipment.setBounds(189, 0, 671, 553);
		contentPane.add(panelEquipment);
		
		panelCourse = new PanelCourse();
		panelCourse.setLayout(null);
		panelCourse.setBounds(189, 0, 671, 553);
		contentPane.add(panelCourse);
		
		panelUser = new PanelUser();
		panelUser.setLayout(null);
		panelUser.setBounds(189, 0, 671, 553);
		contentPane.add(panelUser);
		
//		panelBill = new PanelBill();
//		panel.setLayout(null);
//		panelUser.setBounds(189, 0, 671, 553);
//		contentPane.add(panelUser);
		
		
		
		btnEquipment = new JButton("EQUIPMENT");
		btnEquipment.addActionListener(this);
		btnEquipment.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnEquipment.setBackground(SystemColor.activeCaption);
		btnEquipment.setBounds(0, 274, 190, 57);
		pnMenu.add(btnEquipment);
		
		btnCourse = new JButton("COURSE");
		btnCourse.addActionListener(this);
		btnCourse.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnCourse.setBackground(SystemColor.activeCaption);
		btnCourse.setBounds(0, 327, 190, 57);
		pnMenu.add(btnCourse);
		
		btnBill = new JButton("BILL");
		btnBill.addActionListener(this);
		btnBill.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnBill.setBackground(SystemColor.activeCaption);
		btnBill.setBounds(0, 382, 190, 57);
		pnMenu.add(btnBill);
		
		btnUser = new JButton("USER");
		btnUser.addActionListener(this);
		btnUser.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnUser.setBackground(SystemColor.activeCaption);
		btnUser.setBounds(0, 439, 190, 57);
		pnMenu.add(btnUser);
		
		btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(this);
		btnSignOut.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnSignOut.setBackground(SystemColor.activeCaption);
		btnSignOut.setBounds(0, 496, 190, 57);
		pnMenu.add(btnSignOut);
		
		btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(this);
		btnCustomer.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnCustomer.setBackground(SystemColor.activeCaption);
		btnCustomer.setBounds(0, 219, 190, 57);
		pnMenu.add(btnCustomer);
		
		JPanel panelAvatar = new JPanel();
		panelAvatar.setBackground(Color.PINK);
		panelAvatar.setBounds(0, 0, 190, 190);
		pnMenu.add(panelAvatar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCustomer) {
			panelCustomer.setVisible(true);
			panelEquipment.setVisible(false);
			panelCourse.setVisible(false);
			panelUser.setVisible(false);
		}
		else if (e.getSource() == btnEquipment) {
			panelCustomer.setVisible(false);
			panelEquipment.setVisible(true);
			panelCourse.setVisible(false);
			panelUser.setVisible(false);
		}
		else if (e.getSource() == btnCourse) {
			panelCustomer.setVisible(false);
			panelEquipment.setVisible(false);
			panelCourse.setVisible(true);
			panelUser.setVisible(false);
		}
		else if (e.getSource() == btnUser) {
			panelCustomer.setVisible(false);
			panelEquipment.setVisible(false);
			panelCourse.setVisible(false);
			panelUser.setVisible(true);
		}
	}
}