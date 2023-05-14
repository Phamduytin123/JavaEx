package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GUI.PanelCourse;

public class CourseListener implements ActionListener, ListSelectionListener{
	private PanelCourse panelCourse;
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (panelCourse.getTableCus().getSelectedRow() != -1) {
			panelCourse.SetDataTextField(panelCourse.getTableCus().getSelectedRow());
			
		}
	}

	public CourseListener(PanelCourse panelCourse) {
		super();
		this.panelCourse = panelCourse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelCourse.getBtnAdd())) {
			panelCourse.SetTextFieldNull();
			panelCourse.SetButtonVisibile(false);
			panelCourse.SetTextEnable(true);
			panelCourse.getBtnCancel().setVisible(true);
			panelCourse.getBtnSave_add().setVisible(true);
			panelCourse.getBtnSave_update().setVisible(false);
		}
		else if (e.getSource().equals(panelCourse.getBtnUpdate())) {
			//panelEquipment.SetTextFieldNull();
			if (panelCourse.getTableCus().getSelectedRow() != -1) {
				panelCourse.SetButtonVisibile(false);
				panelCourse.SetTextEnable(true);
				panelCourse.getBtnCancel().setVisible(true);
				panelCourse.getBtnSave_update().setVisible(true);
				panelCourse.getBtnSave_add().setVisible(false);
			}
		}
		else if (e.getSource().equals(panelCourse.getBtnDelete())) {
			DefaultTableModel model = (DefaultTableModel) panelCourse.getTableCus().getModel();
			
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa khóa này?",null,JOptionPane.YES_NO_OPTION);
			
			if(choice == JOptionPane.YES_OPTION) {
				if (BLL.BLLCourse.Instance().Delete(Integer.parseInt(panelCourse.getTableCus().getValueAt(panelCourse.getTableCus().getSelectedRow(),0).toString()))) {
					
					try {
						model.removeRow(panelCourse.getTableCus().getSelectedRow());
						panelCourse.setRows(BLL.BLLCourse.Instance().selectAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		}
		else if (e.getSource().equals(panelCourse.getBtnSave_add())){
			DefaultTableModel model = (DefaultTableModel) panelCourse.getTableCus().getModel();
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn thêm khóa  này?",null,JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					if (BLL.BLLCourse.Instance().insert(panelCourse.getTxtKind().getText(), Integer.parseInt(panelCourse.getTxtPrice().getText()))) {
						try {
							panelCourse.setRows(BLL.BLLCourse.Instance().selectAll());
						} catch (ClassNotFoundException  | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int size = panelCourse.getRows().size();
						model.addRow(new Object[] {panelCourse.getRows().get(size - 1).getID(),
							panelCourse.getTxtKind().getText(),
								panelCourse.getTxtPrice().getText()});
					}
					
				}	
				
				
			panelCourse.getBtnCancel().setVisible(false);
			panelCourse.getBtnSave_update().setVisible(false);
			panelCourse.getBtnSave_add().setVisible(false);
			panelCourse.SetButtonVisibile(true);
			panelCourse.SetTextFieldNull();
			panelCourse.SetTextEnable(false);
		}
		else if (e.getSource().equals(panelCourse.getBtnSave_update())) {
			if (panelCourse.getTableCus().getSelectedRow() != -1) {
				DefaultTableModel model = (DefaultTableModel) panelCourse.getTableCus().getModel();
				
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn cập nhật khóa này?",null,JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					int id = Integer.parseInt(panelCourse.getTxtCourseID().getText());
					String kind = panelCourse.getTxtKind().getText();
					int price =Integer.parseInt(panelCourse.getTxtPrice().getText());
					if (BLL.BLLCourse.Instance().update(id, kind, price)) {
						try {
							
							panelCourse.setRows(BLL.BLLCourse.Instance().selectAll());
						} catch (ClassNotFoundException  | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						model.setValueAt(id, panelCourse.getTableCus().getSelectedRow(), 0);
						model.setValueAt(kind, panelCourse.getTableCus().getSelectedRow(), 1);
						model.setValueAt(price, panelCourse.getTableCus().getSelectedRow(), 2);
						
					}
			}
				panelCourse.getBtnCancel().setVisible(false);
				panelCourse.getBtnSave_update().setVisible(false);
				panelCourse.getBtnSave_add().setVisible(false);
				panelCourse.SetButtonVisibile(true);
				//panelEquipment.SetTextFieldNull();
				panelCourse.SetTextEnable(false);
				//System.out.println(model.getDataVector().get(4));
			
		}
		else if (e.getSource().equals(panelCourse.getBtnCancel())) {
			panelCourse.SetTextFieldNull();
			panelCourse.SetTextEnable(false);
			panelCourse.SetButtonVisibile(true);
			panelCourse.getBtnCancel().setVisible(false);
			panelCourse.getBtnSave_add().setVisible(false);
			panelCourse.getBtnSave_update().setVisible(false);
		}
		}}

}
