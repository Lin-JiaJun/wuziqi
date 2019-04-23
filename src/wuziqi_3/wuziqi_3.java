package wuziqi_3;

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

public class wuziqi_3 extends JFrame {

	public static void main(String[] args) {

		wuziqi_3 i = new wuziqi_3();
		i.UI();
	}
	String[] a={"繁字斤媾 " ,"螺社斤媾"};
	 JComboBox<String> A=new JComboBox<String>(a);
	public void UI() {
		this.setSize(740, 640);
		this.setTitle("励徨薙3.0");
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
		JButton start = new JButton("蝕兵嗄老");
		jpa.add(start);
		JButton restart = new JButton("嶷仟蝕兵");
		jpa.add(restart);
		JButton regret = new JButton("孜薙");
		jpa.add(regret);
		/////////////////////////////////
		
		
		jpa.add(A);
		
		
		
		// 。。。。。。。。。。。。。。。。。。。。。
		this.setVisible(true);
		listenner_3 i = new listenner_3();
		start.addActionListener(i);
		A.addActionListener(i);
		
		i.setJcombobox(A);//勧和性崇

		// 。。。。。。。。。。。。。。。。。。。。
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main(null);
				dispose();    
			}
		});
		regret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(A.getSelectedItem().equals("螺社斤媾")){
				if (((black.size() - 1) >= 0) && ((white.size() - 1) >= 0)) {
					if ((black.size()) == (white.size())) {
						white.remove(white.size() - 1);
					} else {
						black.remove(black.size() - 1);
					}
					paint(getGraphics());
				}
			}else {
				if (((black.size() - 1) >= 0) && ((white.size() - 1) >= 0)) {
					System.out.println("==========");
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

	public ArrayList<shape_3> black = new ArrayList<shape_3>();
	public ArrayList<shape_3> white = new ArrayList<shape_3>();
	int NU;

	public void paint(Graphics g) {
		super.paint(g);
		for (int n = 0; n < 15; n++) {
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.BLACK);
			g.drawLine(40, (40) + 40 * n, 600, (40) + 40 * n);
			g.drawLine(40 + 40 * (n), 40, 40 + 40 * (n), 600);
			for (int k1 = 0; k1 < white.size(); k1++) {
				shape_3 shape1 = white.get(k1);
				if (white != null) {
					g.setColor(Color.white);
					shape1.draw(g);
				}
			}
			for (int k = 0; k < black.size(); k++) {
				shape_3 shape = black.get(k);
				if (black != null) {
					g.setColor(Color.black);
					shape.draw(g);
				}
			}
		}
	}
}
