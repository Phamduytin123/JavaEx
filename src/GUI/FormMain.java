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
import java.sql.SQLException;

import javax.swing.SwingConstants;


public class FormMain extends JFrame {
	private JPanel contentPane;
	private PanelCustomer panelCustomer;
	private JPanel pnMenu;
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
		
		
		
		try {
			panelCustomer = new PanelCustomer();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCustomer.setLayout(null);
		panelCustomer.setBounds(189, 0, 671, 553);
		contentPane.add(panelCustomer);
		
		
		JButton btnEquipment = new JButton("EQUIPMENT");
		btnEquipment.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnEquipment.setBackground(SystemColor.activeCaption);
		btnEquipment.setBounds(0, 274, 190, 57);
		pnMenu.add(btnEquipment);
		
		JButton btnCourse = new JButton("COURSE");
		btnCourse.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnCourse.setBackground(SystemColor.activeCaption);
		btnCourse.setBounds(0, 327, 190, 57);
		pnMenu.add(btnCourse);
		
		JButton btnBill = new JButton("BILL");
		btnBill.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnBill.setBackground(SystemColor.activeCaption);
		btnBill.setBounds(0, 382, 190, 57);
		pnMenu.add(btnBill);
		
		JButton btnUser = new JButton("USER");
		btnUser.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnUser.setBackground(SystemColor.activeCaption);
		btnUser.setBounds(0, 439, 190, 57);
		pnMenu.add(btnUser);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnSignOut.setBackground(SystemColor.activeCaption);
		btnSignOut.setBounds(0, 496, 190, 57);
		pnMenu.add(btnSignOut);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnCustomer.setBackground(SystemColor.activeCaption);
		btnCustomer.setBounds(0, 219, 190, 57);
		pnMenu.add(btnCustomer);
		
		JPanel panelAvatar = new JPanel();
		panelAvatar.setBackground(Color.PINK);
		panelAvatar.setBounds(0, 0, 190, 190);
		pnMenu.add(panelAvatar);
		
	}
}
