package frame;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.io.IOException;

public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private GMenuBar menuBar;
	private GDrawingToolBar drawingToolBar;
	private GDrawingPanel drawingPanel;

	// constructor
	public GMainFrame(String title) throws IOException {
		// invoke super's constructor
		super(title);
		// initialize attributes
		this.setLocation(100, 50);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);

		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);

		// initialize components
		this.menuBar = new GMenuBar();
		this.setJMenuBar(menuBar);

		this.drawingToolBar = new GDrawingToolBar();
		this.add(drawingToolBar, BorderLayout.NORTH);

		this.drawingPanel = new GDrawingPanel();
		this.add(drawingPanel, BorderLayout.CENTER);

		// association
		menuBar.setDrawingPanel(drawingPanel);
		drawingToolBar.setDrawingPanel(drawingPanel);

	}

	public void initialize() {
		this.menuBar.initialize();
		this.drawingToolBar.initialize();
		this.drawingPanel.initialize();

	}
}
