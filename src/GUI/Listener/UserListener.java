package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GUI.PanelUser;

public class UserListener implements ActionListener, ListSelectionListener{
	private PanelUser panelUser;
	public UserListener(PanelUser panelUser) {
		super();
		this.panelUser = panelUser;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (panelUser.getTableCus().getSelectedRow() != -1) {
			panelUser.SetDataTextField(panelUser.getTableCus().getSelectedRow());
					
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelUser.getBtnAdd())) {
			panelUser.SetTextFieldNull();
			panelUser.SetButtonVisibile(false);
			panelUser.SetTextEnable(true);
			panelUser.getBtnCancel().setVisible(true);
			panelUser.getBtnSave_add().setVisible(true);
			panelUser.getBtnSave_update().setVisible(false);
		}
		else if (e.getSource().equals(panelUser.getBtnUpdate())) {
			//panelEquipment.SetTextFieldNull();
			if (panelUser.getTableCus().getSelectedRow() != -1) {
			panelUser.SetButtonVisibile(false);
			panelUser.SetTextEnable(true);
			panelUser.getBtnCancel().setVisible(true);
			panelUser.getBtnSave_update().setVisible(true);
			panelUser.getBtnSave_add().setVisible(false);
			}
		}
		else if (e.getSource().equals(panelUser.getBtnDelete())) {
			DefaultTableModel model = (DefaultTableModel) panelUser.getTableCus().getModel();
			model.removeRow(panelUser.getTableCus().getSelectedRow());
		}
		else if (e.getSource().equals(panelUser.getBtnSave_add())){
			
				DefaultTableModel model = (DefaultTableModel) panelUser.getTableCus().getModel();
				model.addRow(new Object[] {panelUser.getTxtId().getText(),
					panelUser.getTxtName().getText(),
					panelUser.getCbRole().getSelectedItem().toString(),
					panelUser.getTxtAddress().getText(),
					panelUser.getTxtUsername().getText(),
					panelUser.getTxtPassword().getText()
					});
				panelUser.getBtnCancel().setVisible(false);
				panelUser.getBtnSave_update().setVisible(false);
				panelUser.getBtnSave_add().setVisible(false);
				panelUser.SetButtonVisibile(true);
				panelUser.SetTextFieldNull();
				panelUser.SetTextEnable(false);
			
		}
		else if (e.getSource().equals(panelUser.getBtnSave_update())) {
			if (panelUser.getTableCus().getSelectedRow() != -1) {
				DefaultTableModel model = (DefaultTableModel) panelUser.getTableCus().getModel();
				
				
				model.setValueAt(panelUser.getTxtId().getText(), panelUser.getTableCus().getSelectedRow(), 0);
				model.setValueAt(panelUser.getTxtName().getText(), panelUser.getTableCus().getSelectedRow(), 1);
				model.setValueAt(panelUser.getCbRole().getSelectedItem().toString(), panelUser.getTableCus().getSelectedRow(), 2);
				model.setValueAt(panelUser.getTxtAddress().getText(), panelUser.getTableCus().getSelectedRow(), 3);
				model.setValueAt(panelUser.getTxtUsername().getText(), panelUser.getTableCus().getSelectedRow(), 4);
				model.setValueAt(panelUser.getTxtPassword().getText(), panelUser.getTableCus().getSelectedRow(), 5);
				
				
				panelUser.getBtnCancel().setVisible(false);
				panelUser.getBtnSave_update().setVisible(false);
				panelUser.getBtnSave_add().setVisible(false);
				panelUser.SetButtonVisibile(true);
				//panelEquipment.SetTextFieldNull();
				panelUser.SetTextEnable(false);
			}
		}
		else if (e.getSource().equals(panelUser.getBtnCancel())) {
			panelUser.SetTextFieldNull();
			panelUser.SetTextEnable(false);
			panelUser.SetButtonVisibile(true);
			panelUser.getBtnCancel().setVisible(false);
			panelUser.getBtnSave_add().setVisible(false);
			panelUser.getBtnSave_update().setVisible(false);
		}
	}
	

}
