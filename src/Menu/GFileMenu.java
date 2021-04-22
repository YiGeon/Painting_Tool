package Menu;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import frame.GDrawingPanel;
import shape.GShape;

public class GFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private GDrawingPanel drawingPanel;

	public void setDrawingPanel(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	ActionHandler ationHandler;

	public GFileMenu() {
		super("File");
		this.ationHandler = new ActionHandler();

		JMenuItem newItem = new JMenuItem("New");
		newItem.setActionCommand("newItem");
		newItem.addActionListener(this.ationHandler);
		this.add(newItem);

		JMenuItem openItem = new JMenuItem("Open");
		openItem.setActionCommand("openItem");
		openItem.addActionListener(this.ationHandler);
		this.add(openItem);

		this.addSeparator();

		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setActionCommand("saveItem");
		saveItem.addActionListener(this.ationHandler);
		this.add(saveItem);

		JMenuItem saveAsItem = new JMenuItem("SaveAs");
		saveAsItem.setActionCommand("saveAsItem");
		saveAsItem.addActionListener(this.ationHandler);
		this.add(saveAsItem);

		this.addSeparator();

		JMenuItem printItem = new JMenuItem("Print");
		printItem.setActionCommand("printAsItem");
		printItem.addActionListener(this.ationHandler);
		this.add(printItem);

		this.addSeparator();

		JMenuItem exitItem = new JMenuItem("Exit");
		this.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
				System.exit(0);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void open() {
		try {
			JFileChooser fileDialog = new JFileChooser(new File("./data"));
			fileDialog.showOpenDialog(null);
			File file = fileDialog.getSelectedFile();
			ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Object object = inputStream.readObject();
			drawingPanel.setDrawingShapes((Vector<GShape>) object);
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void save() {
		try {
			File file = new File("data/output");
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			outputStream.writeObject(drawingPanel.getDrawingShapes());
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveAs() {
		try {
			JFileChooser fileDialog = new JFileChooser(new File("./data"));
			fileDialog.showSaveDialog(null);
			File file = fileDialog.getSelectedFile();
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			outputStream.writeObject(drawingPanel.getDrawingShapes());
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void newItem() {
		saveAs();
		drawingPanel.drawingShapes.removeAllElements();
		drawingPanel.repaint();
	}

	private void print() {
		Container c = getRootPane();
		BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
		c.paint(im.getGraphics());
		try {
			ImageIO.write(im, "PNG", new File("data/savaImg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String actionCommnand = actionEvent.getActionCommand();
			if (actionCommnand.equals("openItem")) {
				open();
			} else if (actionCommnand.equals("saveItem")) {
				save();
			} else if (actionCommnand.equals("saveAsItem")) {
				saveAs();
			} else if (actionCommnand.equals("newItem")) {
				newItem();
			} else if (actionCommnand.equals("printAsItem")) {
				print();
			}

		}

	}

}