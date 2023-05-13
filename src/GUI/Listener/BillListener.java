package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.PanelBill;

public class BillListener implements ActionListener, ListSelectionListener,MouseListener {

	private PanelBill panelBill;
	public BillListener(PanelBill panelBill) {
		super();
		this.panelBill = panelBill;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = panelBill.getTable().getSelectedRow();
			if(indexRow == -1) return;
			panelBill.SetTextInfor(indexRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String t = e.getActionCommand();
		Object tmp = e.getSource();
		if (t.equals("Thêm")) {
			panelBill.PressAdd();
		} else
		if (tmp == panelBill.getBtnAdd()) {
			if (t.equals("Lưu")) {
				panelBill.PressSaveAdd();
			}
		} else
		if (t.equals("Hủy")) {
			panelBill.PressCancel();
		} else
		if (t.equals("Sửa")) {
			panelBill.PressUpdate();
		} else
		if (tmp == panelBill.getBtnUpdate()) {
			if (t.equals("Lưu")) {
				panelBill.PressSaveUpdate();
			}
		}

	}

}
