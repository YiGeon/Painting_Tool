package frame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Menu.GColorMenu;
import Menu.GEditMenu;
import Menu.GFileMenu;

public class GMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private GDrawingPanel drawingPanel;

	public void setDrawingPanel(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;

	}

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu colorMenu;

	public GMenuBar() {

		super();

		this.fileMenu = new GFileMenu();
		this.add(this.fileMenu);
		this.editMenu = new GEditMenu();
		this.add(this.editMenu);
		this.colorMenu = new GColorMenu();
		this.add(this.colorMenu);

	}

	public void initialize() {
		((GFileMenu) this.fileMenu).setDrawingPanel(this.drawingPanel);
		((GEditMenu) this.editMenu).setDrawingPanel(this.drawingPanel);
		((GColorMenu) this.colorMenu).setDrawingPanel(this.drawingPanel);
	}

}
