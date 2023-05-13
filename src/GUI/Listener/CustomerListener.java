package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
			model.removeRow(panelCustomer.getTableCus().getSelectedRow());
		}
		else if (e.getSource().equals(panelCustomer.getBtnSave_add())){
			DefaultTableModel model = (DefaultTableModel) panelCustomer.getTableCus().getModel();
			model.addRow(new Object[] {panelCustomer.getTxtId().getText(),
					panelCustomer.getTxtName().getText(),
					panelCustomer.getCbGender().getSelectedItem().toString(),
					panelCustomer.getTxtPhonenumber().getText()});
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
			model.setValueAt(panelCustomer.getTxtId().getText(), panelCustomer.getTableCus().getSelectedRow(), 0);
			model.setValueAt(panelCustomer.getTxtName().getText(), panelCustomer.getTableCus().getSelectedRow(), 1);
			model.setValueAt(panelCustomer.getCbGender().getSelectedItem().toString(), panelCustomer.getTableCus().getSelectedRow(), 2);
			model.setValueAt(panelCustomer.getTxtPhonenumber().getText(), panelCustomer.getTableCus().getSelectedRow(), 3);
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
