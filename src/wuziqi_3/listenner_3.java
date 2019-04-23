package wuziqi_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class listenner_3 extends MouseAdapter implements ActionListener {
	// pass the graphics
	private Graphics g;
	private JComboBox<String> A;
	private ArrayList<shape_3> black;
	private ArrayList<shape_3> white;
	String p;
	int choose = 1;
	int off = 0;
	int win = 0;

	public void setJcombobox(JComboBox<String> A) {
		this.A = A;
	}

	public void setA(ArrayList<shape_3> black) {
		this.black = black;
	}

	public void setB(ArrayList<shape_3> white) {
		this.white = white;
	}

	public void setG(Graphics g) {
		this.g = g;
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void mouseClicked(MouseEvent e) {
		// get x , y.
		if (off == 1 && win == 0) {
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
					shape_3 check = black.get(k);
					if (x1 == check.getx1() && y1 == check.gety1()) {
						p++;
					}
				}
				for (int k = 0; k < white.size(); k++) {
					shape_3 check = white.get(k);
					if (x1 == check.getx1() && y1 == check.gety1()) {
						p++;
					}
				}
				if (p != 0) {
					// p！=0 mean you have chessed this place at chess.
					System.out.println("报错,下重了");
					JOptionPane.showMessageDialog(null, "报错,下重了");
				} else {// set the color,draw shape
					if (black.size() == white.size()) {
						g.setColor(Color.black);
						shape_3 ii = new shape_3(x1, y1, g.getColor());
						ii.draw(g);
						// 判断胜利条件
						judgment_3 k = new judgment_3(black, white);
						win = k.judgeblack(x1, y1);
						black.add(ii);
						// 人机
						if (choose == 1 && win == 0) {
							g.setColor(Color.white);
							AI_3 i = new AI_3(black, white);
							i.Integer();// 计算最高权值
							shape_3 ii1 = new shape_3(i.getx1(), i.gety1(),
									g.getColor());
							ii1.draw(g);
							white.add(ii1);
							judgment_3 k1 = new judgment_3(black, white);
							win = k1.judgewhite(i.getx1(), i.gety1());

						}
					} else {
						// 玩家对战
						if (choose == 2 && win == 0) {
							g.setColor(Color.white);
							shape_3 ii = new shape_3(x1, y1, g.getColor());
							ii.draw(g);
							white.add(ii);
							// 判断胜利条件
							judgment_3 k1 = new judgment_3(black, white);
							win = k1.judgewhite(x1, y1);

						}
					}
				}
			}
		}
	}

	// ///////////////////////////////////////
	public void actionPerformed(ActionEvent e) {

		p = e.getActionCommand();
	//	System.out.println(p);
	//	System.out.println(A.getActionCommand());
		if (A.getSelectedItem().equals("人机对战")) {
			choose = 1;
		} else if (A.getSelectedItem().equals("玩家对战")) {
			choose = 2;
		//	System.out.println("12131313");
		}
		if (p == "开始游戏") {
			off = 1;
			A.setEnabled(false);
		}
	}
}
