package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormMain extends JFrame {
	private JPanel contentPane;
	private PanelBill panelBill = new PanelBill();
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
		setBounds(100, 100, 806, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(128, 255, 255));
		pnMenu.setBounds(0, 0, 190, 553);
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);
		
		contentPane.add(panelBill);
		setContentPane(contentPane);
	}

}
