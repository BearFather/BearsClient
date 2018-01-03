package net.bearfather.BearsClient;

import java.awt.Color;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Styles {
//	public static ImageIcon iconnect=new ImageIcon(MainFrame.class.getResource("/res/connect1.jpg"));
	
	
	static SimpleAttributeSet green = new SimpleAttributeSet();
	static SimpleAttributeSet red = new SimpleAttributeSet();
	static SimpleAttributeSet black = new SimpleAttributeSet();
	static SimpleAttributeSet yellow = new SimpleAttributeSet();
	static SimpleAttributeSet white = new SimpleAttributeSet();
	static SimpleAttributeSet blue = new SimpleAttributeSet();
	static SimpleAttributeSet cyan = new SimpleAttributeSet();
	static SimpleAttributeSet gray = new SimpleAttributeSet();
	static SimpleAttributeSet lightgray = new SimpleAttributeSet();
	static SimpleAttributeSet magenta = new SimpleAttributeSet();
	static SimpleAttributeSet orange = new SimpleAttributeSet();
	static SimpleAttributeSet pink = new SimpleAttributeSet();
	static SimpleAttributeSet ltblue = new SimpleAttributeSet();
	static SimpleAttributeSet error = new SimpleAttributeSet();
	static SimpleAttributeSet error2 = new SimpleAttributeSet();
	
	public static void buildStyles(){
		StyleConstants.setForeground(green, Color.green);		
		StyleConstants.setForeground(red, Color.red);
	    StyleConstants.setForeground(black, Color.darkGray);
	    StyleConstants.setForeground(yellow, Color.yellow);
	    StyleConstants.setForeground(white, Color.white);
	    StyleConstants.setForeground(blue, Color.blue);
	    StyleConstants.setForeground(cyan, Color.cyan);
	    StyleConstants.setForeground(gray, Color.gray);
	    StyleConstants.setForeground(lightgray, Color.lightGray);
	    StyleConstants.setForeground(magenta, Color.magenta);
	    StyleConstants.setForeground(orange, Color.orange);
	    StyleConstants.setForeground(pink, Color.pink);
	    StyleConstants.setForeground(ltblue, Color.cyan.darker());
	    StyleConstants.setForeground(error, Color.white);
	    StyleConstants.setBackground(error, Color.blue);
	    StyleConstants.setForeground(error2, Color.red);
	    StyleConstants.setBackground(error2, Color.darkGray);
	    
	}
	@SuppressWarnings("unused")
	public static void writeConsole(String msg){
	try {
			if (msg.contains(":¥:")){
				String[] broken=msg.split(":¥:");
				msg=msg.substring(broken[0].length()+3);
				int clrnum=Integer.parseInt(broken[0]);
				SimpleAttributeSet clr=color(clrnum);
				if(clrnum==0){
					//msg=msg.replaceAll("style=font-size:12", "style=font-size:"+MainFrame.fontsize);
					MainFrame.kit.insertHTML(MainFrame.console,MainFrame.console.getLength(), msg+"\n", 0,0,null);
				}else{
					MainFrame.console.insertString(MainFrame.console.getLength(), msg, color(clrnum));
					MainFrame.console.insertString(MainFrame.console.getLength(), "\n", color(5));
				}

			}else{
				MainFrame.console.insertString(MainFrame.console.getLength(), msg, color(5));
				MainFrame.console.insertString(MainFrame.console.getLength(), "\n", color(5));
			}
			
		} catch (BadLocationException | IOException e) {e.printStackTrace();}
	}
	public static SimpleAttributeSet color(int num){
		SimpleAttributeSet rtn=white;	
		switch (num){
			case 1:
				rtn=green;
				break;
			case 2:
				rtn=red;
				break;
			case 3:
				rtn=black;
				break;
			case 4:
				rtn=yellow;
				break;
			case 5:
				rtn=white;
				break;
			case 6:
				rtn=blue;
				break;
			case 7:
				rtn=cyan;
				break;
			case 8:
				rtn=gray;
				break;
			case 9:
				rtn=lightgray;
				break;
			case 10:
				rtn=magenta;
				break;
			case 11:
				rtn=orange;
				break;
			case 12:
				rtn=pink;
				break;
			case 13:
				rtn=error;
				break;
			case 14:
				rtn=error2;
				break;
			case 15:
				rtn=ltblue;
			}
		return rtn;
	}
	public static String color2(int num){
		String rtn="white";	
		switch (num){
			case 1:
				rtn="green";
				break;
			case 2:
				rtn="red";
				break;
			case 3:
				rtn="black";
				break;
			case 4:
				rtn="yellow";
				break;
			case 5:
				rtn="white";
				break;
			case 6:
				rtn="blue";
				break;
			case 7:
				rtn="cyan";
				break;
			case 8:
				rtn="gray";
				break;
			case 9:
				rtn="lightgray";
				break;
			case 10:
				rtn="magenta";
				break;
			case 11:
				rtn="orange";
				break;
			case 12:
				rtn="pink";
				break;
			case 15:
				rtn="ltblue";
			}
		return rtn;
	}
}
