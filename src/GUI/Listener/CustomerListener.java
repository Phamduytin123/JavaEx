package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAL.DAOCustomer;
import DTO.Customer;
import GUI.PanelCustomer;

public class CustomerListener implements ActionListener, ListSelectionListener{
	private PanelCustomer panelCustomer;
	public CustomerListener(PanelCustomer panelCustomer) {
		// TODO Auto-generated constructor stub
		this.panelCustomer = panelCustomer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelCustomer.getBtnAdd())) {
			panelCustomer.SetTextFieldNull();
			panelCustomer.SetButtonVisibile(false);
			panelCustomer.SetTextEnable(true);
			panelCustomer.getBtnCancel().setVisible(true);
			panelCustomer.getBtnSave_add().setVisible(true);
			panelCustomer.getBtnSave_update().setVisible(false);
		}
		else if (e.getSource().equals(panelCustomer.getBtnUpdate())) {
			//panelEquipment.SetTextFieldNull();
			panelCustomer.SetButtonVisibile(false);
			panelCustomer.SetTextEnable(true);
			panelCustomer.getBtnCancel().setVisible(true);
			panelCustomer.getBtnSave_update().setVisible(true);
			panelCustomer.getBtnSave_add().setVisible(false);
		}
		else if (e.getSource().equals(panelCustomer.getBtnDelete())) {
			DefaultTableModel model = (DefaultTableModel) panelCustomer.getTableCus().getModel();
			int indexRow = panelCustomer.getTableCus().getSelectedRow();
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa khách hàng này?",null,JOptionPane.YES_NO_OPTION);
			int size = panelCustomer.getRows().size();
			if(choice == JOptionPane.YES_OPTION) {
				if (BLL.BLLCustomer.Instance().delete(Integer.parseInt(panelCustomer.getTableCus().getValueAt(panelCustomer.getTableCus().getSelectedRow(),0).toString()))) {
					try {
						model.removeRow(panelCustomer.getTableCus().getSelectedRow());
						panelCustomer.setRows(BLL.BLLCustomer.Instance().selectAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
			
		}
		else if (e.getSource().equals(panelCustomer.getBtnSave_add())){
			DefaultTableModel model = (DefaultTableModel) panelCustomer.getTableCus().getModel();
			
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn thêm khách hàng này?",null,JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				if (BLL.BLLCustomer.Instance().insert(panelCustomer.getTxtName().getText(), panelCustomer.getTxtPhonenumber().getText(), panelCustomer.getCbGender().getSelectedItem().toString())) {
					try {
						panelCustomer.setRows(BLL.BLLCustomer.Instance().selectAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int size = panelCustomer.getRows().size();
					model.addRow(new Object[] {panelCustomer.getRows().get(size - 1).getID(),
							panelCustomer.getTxtName().getText(),
							panelCustomer.getCbGender().getSelectedItem().toString(),
							panelCustomer.getTxtPhonenumber().getText()});
				}
				
			}
			//panelCustomer.getRows();
			
			
			
			panelCustomer.getBtnCancel().setVisible(false);
			panelCustomer.getBtnSave_update().setVisible(false);
			panelCustomer.getBtnSave_add().setVisible(false);
			panelCustomer.SetButtonVisibile(true);
			panelCustomer.SetTextFieldNull();
			panelCustomer.SetTextEnable(false);
		}
		else if (e.getSource().equals(panelCustomer.getBtnSave_update())) {
			if (panelCustomer.getTableCus().getSelectedRow() != -1) {
			DefaultTableModel model = (DefaultTableModel) panelCustomer.getTableCus().getModel();
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn cập nhật khách hàng này?",null,JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				int id = Integer.parseInt(panelCustomer.getTableCus().getValueAt(panelCustomer.getTableCus().getSelectedRow(),0).toString());
				String name = panelCustomer.getTableCus().getValueAt(panelCustomer.getTableCus().getSelectedRow(),1).toString();
				String gender = panelCustomer.getTableCus().getValueAt(panelCustomer.getTableCus().getSelectedRow(),3).toString();
				String sdt = panelCustomer.getTableCus().getValueAt(panelCustomer.getTableCus().getSelectedRow(),2).toString();
				if (BLL.BLLCustomer.Instance().update(id, name, sdt, gender)) {
					try {
						model.setValueAt(panelCustomer.getTxtId().getText(), panelCustomer.getTableCus().getSelectedRow(), 0);
						model.setValueAt(panelCustomer.getTxtName().getText(), panelCustomer.getTableCus().getSelectedRow(), 1);
						model.setValueAt(panelCustomer.getCbGender().getSelectedItem().toString(), panelCustomer.getTableCus().getSelectedRow(), 2);
						model.setValueAt(panelCustomer.getTxtPhonenumber().getText(), panelCustomer.getTableCus().getSelectedRow(), 3);
						panelCustomer.setRows(BLL.BLLCustomer.Instance().selectAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
			
			
			
			panelCustomer.getBtnCancel().setVisible(false);
			panelCustomer.getBtnSave_update().setVisible(false);
			panelCustomer.getBtnSave_add().setVisible(false);
			panelCustomer.SetButtonVisibile(true);
			//panelEquipment.SetTextFieldNull();
			panelCustomer.SetTextEnable(false);
			}
		}
		else if (e.getSource().equals(panelCustomer.getBtnCancel())) {
			panelCustomer.SetTextFieldNull();
			panelCustomer.SetTextEnable(false);
			panelCustomer.SetButtonVisibile(true);
			panelCustomer.getBtnCancel().setVisible(false);
			panelCustomer.getBtnSave_add().setVisible(false);
			panelCustomer.getBtnSave_update().setVisible(false);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (panelCustomer.getTableCus().getSelectedRow() != -1) {
			panelCustomer.SetDataTextField(panelCustomer.getTableCus().getSelectedRow());
			
		}
	}
	

}
