package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< Updated upstream

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
=======
import java.util.Vector;

>>>>>>> Stashed changes
import javax.swing.table.DefaultTableModel;

import GUI.PanelEquipment;

<<<<<<< Updated upstream
public class EquipmentListener implements ActionListener, ListSelectionListener{
	private PanelEquipment panelEquipment;
	public EquipmentListener(PanelEquipment panelEquipment) {
		// TODO Auto-generated constructor stub
		this.panelEquipment = panelEquipment;
	}

=======
public class  EquipmentListener implements ActionListener{
	private PanelEquipment panelEquipment;
	public EquipmentListener(PanelEquipment panelEquipment) {
		super();
		this.panelEquipment = panelEquipment;
	}
>>>>>>> Stashed changes
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelEquipment.getBtnAdd())) {
<<<<<<< Updated upstream
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
	
	
=======
			panelEquipment.SetTextFieldEnable(true);
			panelEquipment.SetTextFieldNull();
			panelEquipment.SetButtonVisible(false);
			panelEquipment.getBtnSave_Add().setVisible(true);
			//panelCustomer.getBtnSave_Update().setVisible(false);
		}
		else if (e.getSource() == panelEquipment.getBtnDelete()) {

		}
		else if (e.getSource() == panelEquipment.getBtnUpdate()) {
			panelEquipment.SetTextFieldEnable(true);
			
			panelEquipment.SetButtonVisible(false);
			//panelCustomer.getBtnSave_Add().setVisible(false);
			panelEquipment.getBtnSave_Update().setVisible(true);
		}
		else if (e.getSource() == panelEquipment.getBtnCancel()) {
			panelEquipment.SetButtonVisible(true);
			panelEquipment.getBtnSave_Add().setVisible(false);
			panelEquipment.getBtnSave_Update().setVisible(false);
			panelEquipment.SetTextFieldNull();
			panelEquipment.SetTextFieldEnable(false);
		}
		else if (e.getSource() == panelEquipment.getBtnSave_Add()) {
			DefaultTableModel model = (DefaultTableModel) panelEquipment.getTableCus().getModel();
			Vector<String> row = new Vector<String>();
			row.add(panelEquipment.getTxtId().getText());
			row.add(panelEquipment.getCbName().getSelectedItem().toString());
			row.add(panelEquipment.getTxtPrice().getText());
			row.add(panelEquipment.getTxtQuantity().toString());
			model.addRow(row);
			//panelCustomer.getTableCus().setModel(model);
			panelEquipment.SetTextFieldEnable(false);
			panelEquipment.SetButtonVisible(true);
			panelEquipment.getBtnSave_Add().setVisible(false);;
		}
		else if(e.getSource() == panelEquipment.getBtnSave_Update()) {
			int selectedRow = panelEquipment.getTableCus().getSelectedRow();
			//System.out.println(selectedRow);
			panelEquipment.getTableCus().setValueAt(panelEquipment.getTxtId().getText(),selectedRow, 0);
			panelEquipment.getTableCus().setValueAt(panelEquipment.getCbName().getSelectedItem().toString(),selectedRow, 1);
			panelEquipment.getTableCus().setValueAt(panelEquipment.getTxtPrice().getText(),selectedRow, 2);
			panelEquipment.getTableCus().setValueAt(panelEquipment.getTxtQuantity().getText(),selectedRow, 3);
			//System.out.println(selectedRow);
			panelEquipment.SetTextFieldEnable(false);
			panelEquipment.SetButtonVisible(true);
			panelEquipment.getBtnSave_Update().setVisible(false);
			
		}
	}

>>>>>>> Stashed changes
}
