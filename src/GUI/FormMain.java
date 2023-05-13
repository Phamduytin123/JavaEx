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
import javax.swing.*;

<<<<<<< Updated upstream

public class FormMain extends JFrame implements ActionListener{
=======
public class FormMain extends JFrame implements ActionListener {
>>>>>>> Stashed changes
	private JPanel contentPane;
	private PanelCustomer panelCustomer= new PanelCustomer();;
	private PanelEquipment panelEquipment =  new PanelEquipment();
	private JPanel pnMenu;
<<<<<<< Updated upstream
	private PanelEquipment panelEquipment;
	private PanelCourse panelCourse;
	private PanelUser panelUser;
=======
>>>>>>> Stashed changes
	private JButton btnEquipment;
	private JButton btnCourse;
	private JButton btnBill;
	private JButton btnUser;
	private JButton btnSignOut;
	private JButton btnCustomer;
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
		
		
		
		
		panelCustomer.setLayout(null);
		panelCustomer.setBounds(189, 0, 671, 553);
		panelCustomer.setVisible(false);
		contentPane.add(panelCustomer);
		
		
<<<<<<< Updated upstream
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
		
		
		
		btnEquipment = new JButton("EQUIPMENT");
=======
		panelEquipment.setLayout(null);
		panelEquipment.setBounds(189, 0, 671, 553);
		panelEquipment.setVisible(false);
		contentPane.add(panelEquipment);
		
		
		
		btnEquipment = new JButton("EQUIPMENT");
		btnEquipment.setFocusPainted(false);
		btnEquipment.setBorderPainted(false);
>>>>>>> Stashed changes
		btnEquipment.addActionListener(this);
		btnEquipment.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnEquipment.setBackground(SystemColor.activeCaption);
		btnEquipment.setBounds(0, 274, 190, 57);
		pnMenu.add(btnEquipment);
		
		btnCourse = new JButton("COURSE");
		btnCourse.addActionListener(this);
<<<<<<< Updated upstream
=======
		btnCourse.setFocusPainted(false);
		btnCourse.setBorderPainted(false);
>>>>>>> Stashed changes
		btnCourse.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnCourse.setBackground(SystemColor.activeCaption);
		btnCourse.setBounds(0, 327, 190, 57);
		pnMenu.add(btnCourse);
		
		btnBill = new JButton("BILL");
		btnBill.addActionListener(this);
<<<<<<< Updated upstream
=======
		btnBill.setFocusPainted(false);
		btnBill.setBorderPainted(false);
>>>>>>> Stashed changes
		btnBill.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnBill.setBackground(SystemColor.activeCaption);
		btnBill.setBounds(0, 382, 190, 57);
		pnMenu.add(btnBill);
		
		btnUser = new JButton("USER");
		btnUser.addActionListener(this);
<<<<<<< Updated upstream
=======
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
>>>>>>> Stashed changes
		btnUser.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnUser.setBackground(SystemColor.activeCaption);
		btnUser.setBounds(0, 439, 190, 57);
		pnMenu.add(btnUser);
		
		btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(this);
<<<<<<< Updated upstream
=======
		btnSignOut.setFocusPainted(false);
		btnSignOut.setBorderPainted(false);
>>>>>>> Stashed changes
		btnSignOut.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 15));
		btnSignOut.setBackground(SystemColor.activeCaption);
		btnSignOut.setBounds(0, 496, 190, 57);
		pnMenu.add(btnSignOut);
		
		btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(this);
<<<<<<< Updated upstream
=======
		btnCustomer.setFocusPainted(false);
		btnCustomer.setBorderPainted(false);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
			
		}
		else if (e.getSource() == btnEquipment){
			panelCustomer.setVisible(false);
			panelEquipment.setVisible(true);
		}
		else if (e.getSource() == btnCourse){
			
		}
		else if (e.getSource() == btnUser){
			
		}
		else if (e.getSource() == btnSignOut){
			
>>>>>>> Stashed changes
		}
	}
}
