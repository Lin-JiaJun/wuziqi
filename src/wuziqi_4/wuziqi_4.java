package wuziqi_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 
 */

public class wuziqi_4 extends JFrame {

	public static void main(String[] args) {
		wuziqi_4 i = new wuziqi_4();
		i.UI();
		}
	
	String[] a={"人机对战 " ,"玩家对战"};
	JComboBox<String> A=new JComboBox<String>(a);
	public void UI() {
		this.setSize(740, 640);
		this.setTitle("五子棋4.0");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GRAY);     

		// FlowLayout ljj = new FlowLayout(FlowLayout.TRAILING);
		// this.setLayout(ljj);
		// 。。。。。。。。。。。。。。。。。。。。。。
		
		JPanel jpa = new JPanel();
		jpa.setBackground(Color.YELLOW);
		jpa.setPreferredSize(new Dimension(100, 0));
		this.add(jpa, BorderLayout.EAST);
		JButton start = new JButton("开始游戏");
		jpa.add(start);
		JButton restart = new JButton("重新开始");
		jpa.add(restart);
		JButton regret = new JButton("悔棋");
		jpa.add(regret);
		JButton fail = new JButton("认输");
		jpa.add(fail);
		/////////////////////////////////
		
		
		jpa.add(A);
		
		
		
		// 。。。。。。。。。。。。。。。。。。。。。
		this.setVisible(true);
		listenner_4 i = new listenner_4();
		start.addActionListener(i);
		fail.addActionListener(i);//认输加监听
		A.addActionListener(i);
		
		i.setJcombobox(A);//传下拉框

		// 。。。。。。。。。。。。。。。。。。。。
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main(null);
				dispose();    
			}
		});
		regret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(A.getSelectedItem().equals("玩家对战")){
				//如果是玩家对战，悔棋悔一个
				if (((black.size() - 1) >= 0) && ((white.size() - 1) >= 0)) {
					if ((black.size()) == (white.size())) {
						white.remove(white.size() - 1);
					} else {
						black.remove(black.size() - 1);
					}
					paint(getGraphics());
				}
			}else {
				//人机对战悔棋悔两个
				if (((black.size() - 1) >= 0) && ((white.size() - 1) >= 0)) {
				//	System.out.println("==========");
						white.remove(white.size() - 1);
						black.remove(black.size() - 1);
						paint(getGraphics());
			}
				}
				}
			}
		);
		// 。。。。。。。。。。。。。。。。。。。。
		i.setG(this.getGraphics());
		i.setA(black);
		i.setB(white);
		this.addMouseListener(i);
	}

	public ArrayList<shape_4> black = new ArrayList<shape_4>();
	public ArrayList<shape_4> white = new ArrayList<shape_4>();
	int NU;
	//public ArrayList<Point> list=new ArrayList<Point>();
	//Point[][] point1=new Point[1][2];
	//list.add(point1);
	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//draw the line
		for (int n = 0; n < 15; n++) {
			g.setColor(Color.BLACK);
			g.drawLine(40, (40) + 40 * n, 600, (40) + 40 * n);
			g.drawLine(40 + 40 * (n), 40, 40 + 40 * (n), 600);
		}
		//draw the chess
		for (int k1 = 0; k1 < white.size(); k1++) {
				shape_4 shape1 = white.get(k1);
				if (white != null) {
					g.setColor(Color.white);
					shape1.draw(g);
				}
			}
		for (int k = 0; k < black.size(); k++) {
				shape_4 shape = black.get(k);
				if (black != null) {
					g.setColor(Color.black);
					shape.draw(g);
				}
			}
		}
	}

