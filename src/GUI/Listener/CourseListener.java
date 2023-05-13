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
		
	}

	public CourseListener(PanelCourse panelCourse) {
		super();
		this.panelCourse = panelCourse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
