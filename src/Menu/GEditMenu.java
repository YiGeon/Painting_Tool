package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import frame.GDrawingPanel;
import shape.GShape;

public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private GDrawingPanel drawingPanel;

	public void setDrawingPanel(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	ActionHandler ationHandler;
	private Vector<GShape> copyList = new Vector<GShape>();

	public GEditMenu() {
		super("Edit");
		this.ationHandler = new ActionHandler();

		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.setActionCommand("cutItem");
		cutItem.addActionListener(this.ationHandler);
		this.add(cutItem);

		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.setActionCommand("copyItem");
		copyItem.addActionListener(this.ationHandler);
		this.add(copyItem);

		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.setActionCommand("pasteItem");
		pasteItem.addActionListener(this.ationHandler);
		this.add(pasteItem);

		JMenuItem deleteItem = new JMenuItem("Delete");
		deleteItem.setActionCommand("deleteItem");
		deleteItem.addActionListener(this.ationHandler);
		this.add(deleteItem);

		this.addSeparator();

		JMenuItem selectAllItem = new JMenuItem("SelectAll");
		selectAllItem.setActionCommand("selectAllItem");
		selectAllItem.addActionListener(this.ationHandler);
		this.add(selectAllItem);

		this.addSeparator();

		JMenuItem doItem = new JMenuItem("Do");
		doItem.setActionCommand("doItem");
		doItem.addActionListener(this.ationHandler);
		this.add(doItem);

		JMenuItem undoItem = new JMenuItem("Undo");
		undoItem.setActionCommand("undoItem");
		undoItem.addActionListener(this.ationHandler);
		this.add(undoItem);

		this.addSeparator();

		JMenuItem groupItem = new JMenuItem("Group");
		groupItem.setActionCommand("groupItem");
		groupItem.addActionListener(this.ationHandler);
		this.add(groupItem);

		JMenuItem ungroupItem = new JMenuItem("Ungroup");
		ungroupItem.setActionCommand("ungroupItem");
		ungroupItem.addActionListener(this.ationHandler);
		this.add(ungroupItem);
	}

	private void delete() {
		for (int i = drawingPanel.drawingShapes.size(); i > 0; i--) {
			GShape shape = drawingPanel.drawingShapes.get(i - 1);
			if (shape.isSelected()) {
				drawingPanel.drawingShapes.remove(shape);
			}
		}
		repaint();
		drawingPanel.clearSelection();
	}

	private void copy() {
		for (int i = drawingPanel.drawingShapes.size(); i > 0; i--) {
			GShape shape = drawingPanel.drawingShapes.get(i - 1);
			if (shape.isSelected()) {
				copyList.add(shape);
			}
		}
		repaint();
		drawingPanel.clearSelection();
	}

	private void cut() {
		copyList.removeAllElements();
		for (int i = drawingPanel.drawingShapes.size(); i > 0; i--) {
			GShape shape = drawingPanel.drawingShapes.get(i - 1);
			if (shape.isSelected()) {
				copyList.add(shape);
			}
		}
		delete();
		repaint();
		drawingPanel.clearSelection();
	}

	private void paste() {
		for (int i = copyList.size(); i > 0; i--) {
			GShape shape = copyList.get(i - 1);
			drawingPanel.drawingShapes.add(shape);
		}
		repaint();
		drawingPanel.clearSelection();
	}

	private void selectAll() {
		for (int i = drawingPanel.drawingShapes.size(); i > 0; i--) {
			GShape shape = drawingPanel.drawingShapes.get(i - 1);
			shape.setSelected(true);
		}
		repaint();
	}

	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String actionCommnand = actionEvent.getActionCommand();
			if (actionCommnand.equals("deleteItem")) {
				delete();
			} else if (actionCommnand.equals("cutItem")) {
				cut();
			} else if (actionCommnand.equals("pasteItem")) {
				paste();
			} else if (actionCommnand.equals("copyItem")) {
				copy();
			} else if (actionCommnand.equals("selectAllItem")) {
				selectAll();
			}
		}

	}

}
