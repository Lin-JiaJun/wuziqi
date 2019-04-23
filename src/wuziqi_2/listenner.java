package wuziqi_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class listenner extends MouseAdapter implements ActionListener {
	// pass the graphics
	private Graphics g;
	private ArrayList<shape> black;
	private ArrayList<shape> white;
	String p;
	int choose = 1;
	public void setA(ArrayList<shape> black) {
		this.black = black;
	}

	public void setB(ArrayList<shape> white) {
		this.white = white;
	}

	public void setG(Graphics g) {
		this.g = g;
		
	}

	public void mouseClicked(MouseEvent e) {
		// get x , y.

		int x1 = e.getX();
		int y1 = e.getY();
		// if the place is true,
		if (x1 <= 600 && y1 <= 600) {
			// optimize x1,y1 
			if ((x1 % 40) < 20) {
				x1 = (x1 - (x1 % 40));
			} else {
				x1 = x1 + (40 - (x1 % 40));
			}
			if ((y1 % 40) < 20) {
				y1 = (y1 - (y1 % 40));
			} else {
				y1 = y1 + (40 - (y1 % 40));
			}
			// set oval heart
			x1 = x1 - 35 / 2;
			y1 = y1 - 35 / 2;

			// to check whether repeat
			int p = 0;
			for (int k = 0; k < black.size(); k++) {
				shape check = black.get(k);
				if (x1 == check.getx1() && y1 == check.gety1()) {
					p++;
				}
			}
			for (int k = 0; k < white.size(); k++) {
				shape check = white.get(k);
				if (x1 == check.getx1() && y1 == check.gety1()) {
					p++;
				}
			}
			if (p != 0) {
				// p！=0 mean you have chessed this place at chess.
				System.out.println("报错,下重了");
				JOptionPane.showMessageDialog(null, "报错,下重了");
			}

			else {// set the color,draw shape
				if (black.size() == white.size()) {
					g.setColor(Color.black);
					shape ii = new shape(x1, y1, g.getColor());
					ii.draw(g);
					// 判断胜利条件
					judgment k = new judgment(black, white);
					k.judgeblack(x1, y1);
					black.add(ii);
					// 人机
					if (choose == 1) {
						g.setColor(Color.white);
						AI i = new AI(black, white);
						i.Integer();
						shape ii1 = new shape(i.getx1(), i.gety1(),g.getColor());
						ii1.draw(g);
						judgment k1 = new judgment(black, white);
						k1.judgewhite(i.getx1(), i.gety1());
						white.add(ii1);
					}
				} else {
					// 玩家对战
					if (choose == 2) {
						g.setColor(Color.white);
						shape ii = new shape(x1, y1, g.getColor());
						ii.draw(g);
						white.add(ii);
						// 判断胜利条件
						judgment k1 = new judgment(black, white);
						k1.judgewhite(x1, y1);
					}

				}
			}
		}
	}
/////////////////////////////////////////
	public void actionPerformed(ActionEvent e) {
		p = e.getActionCommand();
		if (p == "人机对战") {
			choose = 1;
		} else if (p == "玩家对战") {
			choose = 2;
		}
	}}
	