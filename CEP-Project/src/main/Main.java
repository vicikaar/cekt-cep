package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.MyFrame;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		new MyFrame();
	}

}
