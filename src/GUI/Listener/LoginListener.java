package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import BLL.BLLUser;
import GUI.FormMain;
import GUI.formLogin;

public class LoginListener implements  ActionListener{
	private static formLogin login ;
	public LoginListener(formLogin l) {
		this.login = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login.btnLogin) {
			String username = this.login.txtUserName.getText();
			String pass = this.login.txtPassword.getText();
			if(BLLUser.Instance().selectByUserNameAndPass( username, pass) == true) {
				// show form tiếp theo
				FormMain formMain = new FormMain();
				formMain.setVisible(true);
				login.setVisible(false);
			}
			else 
				JOptionPane.showMessageDialog(null,"Sai tên đăng nhập hoặc mật khẩu");
		}
		else if(e.getSource() == login.btnCancel) {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn thoát",null,JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				this.login.setVisible(false);				
			}
		}
	}

}