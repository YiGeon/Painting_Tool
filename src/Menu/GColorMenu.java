package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import frame.GDrawingPanel;

public class GColorMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private GDrawingPanel drawingPanel;

	public void setDrawingPanel(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	ActionHandler ationHandler;

	public GColorMenu() {
		super("Color");
		this.ationHandler = new ActionHandler();

		JMenuItem lineColorItem = new JMenuItem("LineColor");
		lineColorItem.setActionCommand("lineColorItem");
		lineColorItem.addActionListener(this.ationHandler);
		this.add(lineColorItem);

		this.addSeparator();

		JMenuItem fillColorItem = new JMenuItem("FillColor");
		fillColorItem.setActionCommand("fillColorItem");
		fillColorItem.addActionListener(this.ationHandler);
		this.add(fillColorItem);

	}

	private void fillColor() {
	}

	private void lineColor() {
		// TODO Auto-generated method stub

	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String actionCommnand = actionEvent.getActionCommand();
			if (actionCommnand.equals("fillColorItem")) {
				fillColor();
			} else if (actionCommnand.equals("lineColorItem")) {
				lineColor();
			}
		}

	}

}
