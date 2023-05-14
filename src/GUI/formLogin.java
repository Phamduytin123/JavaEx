package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Listener.LoginListener;

import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class formLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtPassword;
	public JTextField txtUserName;
	public JButton btnLogin;
	public JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formLogin frame = new formLogin();
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
	public formLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(272, 113, 109, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(157, 177, 119, 21);
		contentPane.add(btnLogin);
		
		btnCancel = new JButton("Hủy ");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(307, 177, 85, 21);
		contentPane.add(btnCancel);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(272, 71, 109, 19);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Tên đăng nhập:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setBounds(157, 71, 98, 16);
		contentPane.add(lblUserName);
		
		JLabel lbPass = new JLabel("Mật khẩu:");
		lbPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbPass.setBounds(157, 113, 98, 16);
		contentPane.add(lbPass);
		btnLogin.addActionListener(new LoginListener(this));
		btnCancel.addActionListener(new LoginListener(this));
	}
}