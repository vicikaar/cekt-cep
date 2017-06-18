package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.MyEvent;

public class MyFrame extends JFrame {
	private JPanel cp = new JPanel();
	private JPanel pane = new JPanel();
	private List<MyEvent> events = new LinkedList<MyEvent>();
	private List<String> eventsRight = new LinkedList<String>();
	
	private DefaultListModel<String> dlm = new DefaultListModel<>();
	
	JButton addAll = new JButton("Add all");
	JButton removeAll = new JButton("Delete all");
	JButton addRight = new JButton(">>");
	JButton deleteRight = new JButton("<<");
	
	JLabel time = new JLabel("Set time: ");		
	
	JList<String> eventList;
	JList<String> eventListRight = new JList<String>();
	
	String selectedItem = "";
	
	public MyFrame(){
		addEvents();
		
		this.setLocation(0, 0);
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(cp);
		
		pane.setLayout(null);
		pane.setPreferredSize(new Dimension(600, 500));
		cp.add(pane);
		
		eventList.setLocation(20, 10);
		eventList.setSize(200, 300);
		pane.add(eventList);
		
		addRight.setLocation(260, 130);
		addRight.setSize(50, 30);
		addRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ein ausgewähltes Element der rechten Liste hinzufügen
				selectedItem = eventList.getSelectedValue();
				eventsRight.add(selectedItem);
				dlm = new DefaultListModel<>();
				
				for(int i = 0; i < eventsRight.size(); i++){
					dlm.addElement(eventsRight.get(i));
				}
				eventListRight = new JList<>(dlm);
			}
		});
		pane.add(addRight);
		
		deleteRight.setLocation(260, 170);
		deleteRight.setSize(50, 30);
		deleteRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ein ausgewähltes Element aus der rechten Liste löschen
			}
		});
		pane.add(deleteRight);
		
		eventListRight.setLocation(350, 10);
		eventListRight.setSize(200, 300);
		pane.add(eventListRight);
		
		addAll.setLocation(80, 320);
		addAll.setSize(70, 30);
		addAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Alle Elemente aus der linken Liste in die rechte Liste einfügen
				dlm = new DefaultListModel<>();
				
				for(int i = 0; i < events.size(); i++){
					dlm.addElement(events.get(i).getName());
					eventsRight.add(events.get(i).getName());
				}
				eventListRight = new JList<>(dlm);
				pane.repaint();
			}
		});
		pane.add(addAll);
		
		removeAll.setLocation(410, 320);
		removeAll.setSize(80, 30);
		removeAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Alle Elemente aus der rechten Liste löschen
				eventListRight.setListData(new String[0]);
				pane.repaint();
			}
		});
		pane.add(removeAll);
		
		MyFrame.this.setTitle("CEP-Project");
		this.setVisible(true);
	}

	/**
	 * Events einfügen
	 */
	private void addEvents(){
		events.add(new MyEvent("Check mail", "retrieve e-Mails"));
		events.add(new MyEvent("Save data", "Save data to hard drive"));
		events.add(new MyEvent("Test3", "Hallo3"));
		events.add(new MyEvent("Test4", "Hallo4"));
		
		for(int i = 0; i < events.size(); i++){
			dlm.addElement(events.get(i).getName());
		}
		
		eventList = new JList<String>(dlm);
	}
}
