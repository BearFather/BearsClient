package net.bearfather.BearsClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame implements MouseListener, ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField input = new JTextField();
	private JFrame frame=new JFrame();
	public static JTextPane pane = new JTextPane();	
	public static HTMLEditorKit kit = new HTMLEditorKit();
	public static HTMLDocument console= new HTMLDocument();
	JMenuBar menuBar = new JMenuBar();
	JMenuItem mConnect = new JMenuItem("Connect");
	private final JScrollPane scrollPane = new JScrollPane();
	StyledDocument doc = pane.getStyledDocument();

	public MainFrame(){
		Styles.buildStyles();
		DisplayPanel();
	}
	
	 public void append(final String smsg) {
		 Styles.writeConsole(smsg);
		 pane.setCaretPosition(pane.getDocument().getLength());
	 }
	
	private void DisplayPanel(){
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(pane);
		input.setText("goodbye");
		input.setForeground(Color.WHITE);
		input.setBackground(Color.GRAY);
		frame.getContentPane().add(input, BorderLayout.SOUTH);
		input.setColumns(10);
		input.addKeyListener(this);
		
		pane.setText("Hello");
		pane.setForeground(Color.WHITE);
		pane.setBackground(Color.BLACK);
		
		frame.setJMenuBar(menuBar);
		pane.setEditorKit(kit);
		pane.setContentType("text/html");
		pane.setDocument(console);
		menuBar.add(mConnect);
		mConnect.addActionListener(this);
		frame.setSize(400, 400);
		frame.setVisible(true);
		input.requestFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		 Object e = evt.getSource();
		 if (e.equals(mConnect)){
			 BearsClient.conn=new Connector("bbs.bearfather.net",23);
			 Thread t=new Thread(BearsClient.conn);
			 t.start();
			 
		 }
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==(KeyEvent.VK_ENTER)){
			String text = input.getText();
			append("8:¥:> "+text);
			BearsClient.conn.write(text);
			input.setText("");
		}
	}
}
