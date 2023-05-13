package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			model.removeRow(panelEquipment.getTableCus().getSelectedRow());
		}
		else if (e.getSource().equals(panelEquipment.getBtnSave_add())){
			DefaultTableModel model = (DefaultTableModel) panelEquipment.getTableCus().getModel();
				model.addRow(new Object[] {panelEquipment.getTxtId().getText(),
					panelEquipment.getCbName().getSelectedItem().toString(),
					panelEquipment.getTxtPrice().getText(),
					panelEquipment.getTxtQuantity().getText()});
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
			model.setValueAt(panelEquipment.getTxtId().getText(), panelEquipment.getTableCus().getSelectedRow(), 0);
			model.setValueAt(panelEquipment.getCbName().getSelectedItem().toString() , panelEquipment.getTableCus().getSelectedRow(), 1);
			model.setValueAt(panelEquipment.getTxtPrice().getText(), panelEquipment.getTableCus().getSelectedRow(), 2);
			model.setValueAt(panelEquipment.getTxtQuantity().getText(), panelEquipment.getTableCus().getSelectedRow(), 3);
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
