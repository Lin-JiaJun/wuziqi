package wuziqi_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class listenner extends MouseAdapter {
	// pass the graphics
	private Graphics g;
	private ArrayList<shape> black;
	private ArrayList<shape> white;
	

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
				// p！=0 mean you repeat at chess
				System.out.println("报错,下重了");
				JOptionPane.showMessageDialog(null, "报错,下重了");
			
			}

			else {// set the color,draw shape
				if (black.size()==white.size()) {
					g.setColor(Color.black);
					shape ii = new shape(x1, y1, g.getColor());
					ii.draw(g);
					// 判断胜利条件
					judgment k = new judgment(black, white);
					k.judgeblack(x1, y1);
					if (black.size()==white.size()) {
						black.add(ii);
					} else {
						white.add(ii);
					}
				} else {
					g.setColor(Color.white);
					shape ii = new shape(x1, y1, g.getColor());
					ii.draw(g);
					if (black.size()==white.size()) {
						black.add(ii);
					} else {
						white.add(ii);
					}
					// 判断胜利条件
					judgment k = new judgment(black, white);
					k.judgewhite(x1, y1);

				}
			}
		}
	}


}
