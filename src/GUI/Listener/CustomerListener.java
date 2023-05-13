package GUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< Updated upstream
=======
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
>>>>>>> Stashed changes

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GUI.PanelCustomer;

<<<<<<< Updated upstream
public class CustomerListener implements ActionListener, ListSelectionListener{
	private PanelCustomer panelCustomer;
	public CustomerListener(PanelCustomer panelCustomer) {
		// TODO Auto-generated constructor stub
		this.panelCustomer = panelCustomer;
	}
=======
public class CustomerListener implements ActionListener, MouseListener, ListSelectionListener{
	private PanelCustomer panelCustomer;
	public CustomerListener(PanelCustomer panelCustomer) {
		super();
		this.panelCustomer = panelCustomer;
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

	
>>>>>>> Stashed changes

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(panelCustomer.getBtnAdd())) {
<<<<<<< Updated upstream
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
=======
			panelCustomer.SetTextFieldEnable(true);
			panelCustomer.SetTextFieldNull();
			panelCustomer.SetButtonVisible(false);
			panelCustomer.getBtnSave_Add().setVisible(true);
			//panelCustomer.getBtnSave_Update().setVisible(false);
		}
		else if (e.getSource() == panelCustomer.getBtnDelete()) {

		}
		else if (e.getSource() == panelCustomer.getBtnUpdate()) {
			panelCustomer.SetTextFieldEnable(true);
			
			panelCustomer.SetButtonVisible(false);
			//panelCustomer.getBtnSave_Add().setVisible(false);
			panelCustomer.getBtnSave_Update().setVisible(true);
		}
		else if (e.getSource() == panelCustomer.getBtnCancel()) {
			panelCustomer.SetButtonVisible(true);
			panelCustomer.getBtnSave_Add().setVisible(false);
			panelCustomer.getBtnSave_Update().setVisible(false);
			panelCustomer.SetTextFieldNull();
			panelCustomer.SetTextFieldEnable(false);
		}
		else if (e.getSource() == panelCustomer.getBtnSave_Add()) {
			DefaultTableModel model = (DefaultTableModel) panelCustomer.getTableCus().getModel();
			Vector<String> row = new Vector<String>();
			row.add(panelCustomer.getTxtId().getText());
			row.add(panelCustomer.getTxtName().getText());
			row.add(panelCustomer.getTxtPhonenumber().getText());
			row.add(panelCustomer.getCbGender().getSelectedItem().toString());
			model.addRow(row);
			//panelCustomer.getTableCus().setModel(model);
			panelCustomer.SetTextFieldEnable(false);
			panelCustomer.SetButtonVisible(true);
			panelCustomer.getBtnSave_Add().setVisible(false);;
		}
		else if(e.getSource() == panelCustomer.getBtnSave_Update()) {
			int selectedRow = panelCustomer.getTableCus().getSelectedRow();
			//System.out.println(selectedRow);
			panelCustomer.getTableCus().setValueAt(panelCustomer.getTxtId().getText(),selectedRow, 0);
			panelCustomer.getTableCus().setValueAt(panelCustomer.getTxtName().getText(),selectedRow, 1);
			panelCustomer.getTableCus().setValueAt(panelCustomer.getTxtPhonenumber().getText(),selectedRow, 2);
			panelCustomer.getTableCus().setValueAt(panelCustomer.getCbGender().getSelectedItem().toString(),selectedRow, 3);
			//System.out.println(selectedRow);
			panelCustomer.SetTextFieldEnable(false);
			panelCustomer.SetButtonVisible(true);
			panelCustomer.getBtnSave_Update().setVisible(false);
			
		}
		
>>>>>>> Stashed changes
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
<<<<<<< Updated upstream
		if (panelCustomer.getTableCus().getSelectedRow() != -1) {
			panelCustomer.SetDataTextField(panelCustomer.getTableCus().getSelectedRow());
			
=======
		if (!e.getValueIsAdjusting()) {
			int selectedRow = panelCustomer.getTableCus().getSelectedRow();
			panelCustomer.SetTextFieldData(selectedRow);
>>>>>>> Stashed changes
		}
	}

}
