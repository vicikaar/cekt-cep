package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.MyEvent;

public class MyFrame extends JFrame {
	private JPanel cp = new JPanel();
	private JPanel pane = new JPanel();
	private List<MyEvent> events = new LinkedList<MyEvent>();
	
	public MyFrame(){
		addEvents();
		
		this.setLocation(0, 0);
		this.setSize(500, 525);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(cp);
		
		pane.setLayout(null);
	}

	private void addEvents(){
		events.add(new MyEvent("Test1", "Hallo1"));
		events.add(new MyEvent("Test2", "Hallo2"));
		events.add(new MyEvent("Test3", "Hallo3"));
		events.add(new MyEvent("Test4", "Hallo4"));
	}
}
