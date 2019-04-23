package wuziqi_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class wuziqi extends JFrame {

	public static void main(String[] args) {

		wuziqi i = new wuziqi();
		i.UI();
	}

	public void UI() {
		this.setSize(740, 640);
		this.setTitle("励徨薙");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		// FlowLayout ljj = new FlowLayout(FlowLayout.TRAILING);
		// this.setLayout(ljj);
		// 。。。。。。。。。。。。。。。。。。。。。。
		JPanel jpa = new JPanel();
		// jpa.setBackground(Color.BLACK);
		jpa.setPreferredSize(new Dimension(100, 0));
		this.add(jpa, BorderLayout.EAST);

		JButton restart = new JButton("嶷仟蝕兵");
		jpa.add(restart);
		JButton regret = new JButton("孜薙");
		jpa.add(regret);
		// 。。。。。。。。。。。。。。。。。。。。。
		this.setVisible(true);
		listenner i = new listenner();

		// 。。。。。。。。。。。。。。。。。。。。
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main(null);
				dispose();
			}
		});
		regret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((black.size() - 1) >= 0) && ((white.size() - 1) >= 0)){
						if ((black.size()) == (white.size())) {
					white.remove(white.size() - 1);
				} else {
					black.remove(black.size() - 1);
				}
				paint(getGraphics());
			}}
		});
		// 。。。。。。。。。。。。。。。。。。。。
		i.setG(this.getGraphics());
		i.setA(black);
		i.setB(white);
		this.addMouseListener(i);
	}

	public ArrayList<shape> black = new ArrayList<shape>();
	public ArrayList<shape> white = new ArrayList<shape>();
	int NU;

	public void paint(Graphics g) {
		super.paint(g);
		for (int n = 0; n < 15; n++) {g.setColor(Color.BLACK);
			g.drawLine(40, (40) + 40 * n, 600, (40) + 40 * n);
			g.drawLine(40 + 40 * (n), 40, 40 + 40 * (n), 600);
			for (int k1 = 0; k1 < white.size(); k1++) {
				shape shape1 = white.get(k1);
				if (white != null) {
					g.setColor(Color.white);
					shape1.draw(g);
				}
			}
			for (int k = 0; k < black.size(); k++) {
				shape shape = black.get(k);
				if (black != null) {
					g.setColor(Color.black);
					shape.draw(g);
				}
			}
		}
	}

}
