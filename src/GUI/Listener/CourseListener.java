package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.PanelCourse;

public class CourseListener implements ActionListener, ListSelectionListener{
	private PanelCourse panelCourse;
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (! e.getValueIsAdjusting()) {
			int indexRow = panelCourse.getTableCus().getSelectedRow();
			if(indexRow == -1) return;
			panelCourse.SetTextInfor(indexRow);
		}
	}

	public CourseListener(PanelCourse panelCourse) {
		super();
		this.panelCourse = panelCourse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String t = e.getActionCommand();
		Object tmp = e.getSource();
		if (t.equals("Thêm")) {
			panelCourse.PressAdd();
		} else
		if (tmp == panelCourse.getBtnAdd()) {
			if (t.equals("Lưu")) {
				panelCourse.PressSaveAdd();
			}
		} else
		if (t.equals("Hủy")) {
			panelCourse.PressCancel();
		} else
		if (t.equals("Sửa")) {
			panelCourse.PressUpdate();
		} else
		if (tmp == panelCourse.getBtnUpdate()) {
			if (t.equals("Lưu")) {
				panelCourse.PressSaveUpdate();
			}
		}
	}

}
