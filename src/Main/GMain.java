package Main;

import java.io.IOException;

import frame.GMainFrame;

public class GMain {

	public static void main(String[] args) throws IOException {
		// memory allocation
		// constructor invocation
		GMainFrame mainFrame = new GMainFrame("GraphicsEditor");
		mainFrame.initialize();
		// draw mainFrame
		mainFrame.setVisible(true);
	}
}

