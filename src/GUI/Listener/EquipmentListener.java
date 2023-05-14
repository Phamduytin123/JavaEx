package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GUI.PanelEquipment;

public class EquipmentListener implements ActionListener, ListSelectionListener{
	private PanelEquipment panelEquipment;
	public EquipmentListener(PanelEquipment panelEquipment) {
		// TODO Auto-generated constructor stub
		this.panelEquipment = panelEquipment;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelEquipment.getBtnAdd())) {
			panelEquipment.SetTextFieldNull();
			panelEquipment.SetButtonVisibile(false);
			panelEquipment.SetTextEnable(true);
			panelEquipment.getBtnCancel().setVisible(true);
			panelEquipment.getBtnSave_add().setVisible(true);
			panelEquipment.getBtnSave_update().setVisible(false);
		}
		else if (e.getSource().equals(panelEquipment.getBtnUpdate())) {
			//panelEquipment.SetTextFieldNull();
			if (panelEquipment.getTableCus().getSelectedRow() != -1) {
				panelEquipment.SetButtonVisibile(false);
				panelEquipment.SetTextEnable(true);
				panelEquipment.getBtnCancel().setVisible(true);
				panelEquipment.getBtnSave_update().setVisible(true);
				panelEquipment.getBtnSave_add().setVisible(false);
			}
		}
		else if (e.getSource().equals(panelEquipment.getBtnDelete())) {
			DefaultTableModel model = (DefaultTableModel) panelEquipment.getTableCus().getModel();
			
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa khách hàng này?",null,JOptionPane.YES_NO_OPTION);
			
			if(choice == JOptionPane.YES_OPTION) {
				if (BLL.BLLEquipment.Instance().delete(Integer.parseInt(panelEquipment.getTableCus().getValueAt(panelEquipment.getTableCus().getSelectedRow(),0).toString()))) {
					try {
						model.removeRow(panelEquipment.getTableCus().getSelectedRow());
						panelEquipment.setRows(BLL.BLLEquipment.Instance().GetAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		}
		else if (e.getSource().equals(panelEquipment.getBtnSave_add())){
			DefaultTableModel model = (DefaultTableModel) panelEquipment.getTableCus().getModel();
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn thêm thiết bị này?",null,JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					if (BLL.BLLEquipment.Instance().insert(panelEquipment.getTxtName().getText(), Integer.parseInt(panelEquipment.getTxtPrice().getText()),Integer.parseInt(panelEquipment.getTxtQuantity().getText()))) {
						try {
							panelEquipment.setRows(BLL.BLLEquipment.Instance().GetAll());
						} catch (ClassNotFoundException  | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int size = panelEquipment.getRows().size();
						model.addRow(new Object[] {panelEquipment.getRows().get(size - 1).getID(),
							panelEquipment.getTxtName().getText(),
								panelEquipment.getTxtPrice().getText(),
								panelEquipment.getTxtQuantity().getText()});
					}
					
				}	
				
				
			panelEquipment.getBtnCancel().setVisible(false);
			panelEquipment.getBtnSave_update().setVisible(false);
			panelEquipment.getBtnSave_add().setVisible(false);
			panelEquipment.SetButtonVisibile(true);
			panelEquipment.SetTextFieldNull();
			panelEquipment.SetTextEnable(false);
		}
		else if (e.getSource().equals(panelEquipment.getBtnSave_update())) {
			if (panelEquipment.getTableCus().getSelectedRow() != -1) {
			DefaultTableModel model = (DefaultTableModel) panelEquipment.getTableCus().getModel();
			
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn cập nhật khách hàng này?",null,JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				int id = Integer.parseInt(panelEquipment.getTxtId().getText());
				String name = panelEquipment.getTxtName().getText();
				int price = Integer.parseInt(panelEquipment.getTxtPrice().getText());
				int quantity =Integer.parseInt(panelEquipment.getTxtQuantity().getText());
				if (BLL.BLLEquipment.Instance().update(id, name, price, quantity)) {
					try {
						model.setValueAt(id, panelEquipment.getTableCus().getSelectedRow(), 0);
						model.setValueAt(name, panelEquipment.getTableCus().getSelectedRow(), 1);
						model.setValueAt(price, panelEquipment.getTableCus().getSelectedRow(), 2);
						model.setValueAt(quantity, panelEquipment.getTableCus().getSelectedRow(), 3);
						panelEquipment.setRows(BLL.BLLEquipment.Instance().GetAll());
					} catch (ClassNotFoundException  | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
				panelEquipment.getBtnCancel().setVisible(false);
				panelEquipment.getBtnSave_update().setVisible(false);
				panelEquipment.getBtnSave_add().setVisible(false);
				panelEquipment.SetButtonVisibile(true);
				//panelEquipment.SetTextFieldNull();
				panelEquipment.SetTextEnable(false);
			}
		}
		else if (e.getSource().equals(panelEquipment.getBtnCancel())) {
			panelEquipment.SetTextFieldNull();
			panelEquipment.SetTextEnable(false);
			panelEquipment.SetButtonVisibile(true);
			panelEquipment.getBtnCancel().setVisible(false);
			panelEquipment.getBtnSave_add().setVisible(false);
			panelEquipment.getBtnSave_update().setVisible(false);
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (panelEquipment.getTableCus().getSelectedRow() != -1) {
			panelEquipment.SetDataTextField(panelEquipment.getTableCus().getSelectedRow());
			
		}
	}
	
	
}
