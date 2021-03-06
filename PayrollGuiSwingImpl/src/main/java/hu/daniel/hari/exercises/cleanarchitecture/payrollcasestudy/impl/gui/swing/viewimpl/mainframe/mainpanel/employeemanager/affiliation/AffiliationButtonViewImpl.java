package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.impl.gui.swing.viewimpl.mainframe.mainpanel.employeemanager.affiliation;

import javax.swing.JButton;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.admin.gui.views_controllers_uis.mainframe.mainpanel.employeemanager.affiliationbutton.AffiliationButtonView;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class AffiliationButtonViewImpl extends JButton implements AffiliationButtonView
	
{
	private AffiliationButtonViewListener listener;
	
	public AffiliationButtonViewImpl() {
		initUI();
	}

	private void initUI() {
		setText(" ");
		setPreferredSize(new Dimension(190, getPreferredSize().height));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.onActionPerformed();
			}
		});
	}
	@Override
	public void setModel(AffiliationButtonViewModel viewModel) {
		setText(viewModel.buttonText);
		setEnabled(viewModel.enabled);
	}

	@Override
	public void setViewListener(AffiliationButtonViewListener listener) {
		this.listener = listener;
	}
	
}
