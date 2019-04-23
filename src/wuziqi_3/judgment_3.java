package wuziqi_3;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class judgment_3 {
	private ArrayList<shape_3> black;
	private ArrayList<shape_3> white;
	
	public judgment_3(ArrayList<shape_3> black, ArrayList<shape_3> white) {
		this.black = black;
		this.white = white;
	}
	public judgment_3(ArrayList<shape_3> black, ArrayList<shape_3> white,int x1,int y1) {
		this.black = black;
		this.white = white;
		judgeblack(x1,  y1);
	}
	public int judgeblack(int x1, int y1) {
		int c = 1;
		// right and left check
		for (int k = 0; k < black.size(); k++) {
			shape_3 check = black.get(k);
			if ((x1 + 40) == check.getx1() && y1 == check.gety1()) {
				c++;
			}
		}
		if (c > 1) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40 * 2) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		if (c > 2) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40 * 3) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		if (c > 3) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40 * 4) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		// r
		int l = 0;
		for (int k2 = 0; k2 < black.size(); k2++) {
			shape_3 check2 = black.get(k2);
			if ((x1 - 40) == check2.getx1() && y1 == check2.gety1()) {
				l++;
			}
		}
		if (l > 0) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 - 40 * 2) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if (l > 1) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 - 40 * 3) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if (l > 2) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 - 40 * 4) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if ((c + l) >= 5) {
			System.out.println("黑色勝利");
			JOptionPane.showMessageDialog(null, "黑棋胜利");
			return 1;
		}
		// check south and north
		int s = 1;
		for (int k = 0; k < black.size(); k++) {
			shape_3 check = black.get(k);
			if (x1 == check.getx1() && (y1 + 40) == check.gety1()) {
				s++;
			}
		}
		if (s > 1) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 2) == check.gety1()) {
					s++;
				}
			}
		}
		if (s > 2) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 3) == check.gety1()) {
					s++;
				}
			}
		}
		if (s > 3) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 4) == check.gety1()) {
					s++;
				}
			}
		}
		// n
		int n = 0;
		for (int k2 = 0; k2 < black.size(); k2++) {
			shape_3 check2 = black.get(k2);
			if (x1 == check2.getx1() && (y1 - 40) == check2.gety1()) {
				n++;
			}
		}
		if (n > 0) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if (x1 == check2.getx1() && (y1 - 40 * 2) == check2.gety1()) {
					n++;
				}
			}
		}
		if (n > 1) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if (x1 == check2.getx1()&& (y1 - 40 * 3) == check2.gety1()) {
					n++;
				}
			}
		}
		if (n > 2) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if (x1 == check2.getx1() && (y1 - 40 * 4) == check2.gety1()) {
					n++;
				}
			}
		}
		if ((s + n) >= 5) {
			System.out.println("黑色勝利");
			JOptionPane.showMessageDialog(null, "黑色勝利");
		}
		//check south east;
		
		int se = 1;
		for (int k = 0; k < black.size(); k++) {
			shape_3 check = black.get(k);
			if ((x1 + 40) == check.getx1() && (y1 + 40) == check.gety1()) {
				se++;
			}
		}
		if (se > 1) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40*2) == check.getx1() && (y1 + 40*2) == check.gety1()) {
					se++;
				}
			}
		}
		if (se > 2) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40*3) == check.getx1() && (y1 + 40*3) == check.gety1()) {
					se++;
				}
			}
		}
		if (se > 3) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 + 40*4) == check.getx1() && (y1 + 40*4) == check.gety1()) {
					se++;
				}
			}
		}
		// n
		int nw = 0;
		for (int k2 = 0; k2 < black.size(); k2++) {
			shape_3 check2 = black.get(k2);
			if ((x1-40) == check2.getx1() && (y1 - 40) == check2.gety1()) {
				nw++;
			}
		}
		if (nw > 0) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1-40*2) == check2.getx1() && (y1 - 40*2) == check2.gety1()) {
					nw++;
				}
			}
		}
		if (nw > 1) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1-40*3) == check2.getx1() && (y1 - 40*3) == check2.gety1()) {
					nw++;
				}
			}
		}
		if (nw > 2) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 -40*4)== check2.getx1() && (y1 - 40 * 4) == check2.gety1()) {
					nw++;
				}
			}
		}
		if ((se + nw) >= 5) {
			System.out.println("黑色勝利");
			JOptionPane.showMessageDialog(null, "黑色勝利");return 1;
		}
		//check northeast and southwest
		int ne = 1;
		for (int k = 0; k < black.size(); k++) {
			shape_3 check = black.get(k);
			if ((x1 - 40) == check.getx1() && (y1 +40)== check.gety1()) {
				ne++;
			}
		}
		if (ne > 1) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 - 40*2)== check.getx1() && (y1 +40*2) == check.gety1()) {
					ne++;
				}
			}
		}
		if (ne > 2) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 - 40*3 )== check.getx1() && (y1 + 40*3 ) == check.gety1()) {
					ne++;
				}
			}
		}
		if (ne > 3) {
			for (int k = 0; k < black.size(); k++) {
				shape_3 check = black.get(k);
				if ((x1 - 40 * 4) == check.getx1() && (y1+40 * 4) == check.gety1()) {
					ne++;
				}
			}
		}
		// sw
		int sw = 0;
		for (int k2 = 0; k2 < black.size(); k2++) {
			shape_3 check2 = black.get(k2);
			if ((x1 + 40 ) == check2.getx1() && (y1-40 ) == check2.gety1()) {
				sw++;////////////
			}
		}
		if (sw > 0) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 + 40 * 2) == check2.getx1() && (y1-40 * 2) == check2.gety1() ){
					sw++;
				}
			}
		}
		if (sw> 1) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 + 40 * 3) == check2.getx1() && (y1-40 * 3) == check2.gety1()) {
					sw++;
				}
			}
		}
		if (sw > 2) {
			for (int k2 = 0; k2 < black.size(); k2++) {
				shape_3 check2 = black.get(k2);
				if ((x1 + 40 * 4) == check2.getx1() && (y1-40 * 4) == check2.gety1()) {
					sw++;
				}
			}
		}
		if ((sw + ne) >= 5) {
			System.out.println("黑色勝利");
			JOptionPane.showMessageDialog(null, "黑色勝利");return 1;
		}
		return 0;
	}

	public int judgewhite(int x1, int y1) {
		int c = 1;
		// right and left check
		for (int k = 0; k < white.size(); k++) {
			shape_3 check = white.get(k);
			if ((x1 + 40) == check.getx1() && y1 == check.gety1()) {
				c++;
			}
		}
		if (c > 1) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40 * 2) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		if (c > 2) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40 * 3) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		if (c > 3) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40 * 4) == check.getx1() && y1 == check.gety1()) {
					c++;
				}
			}
		}
		// r
		int l = 0;
		for (int k2 = 0; k2 < white.size(); k2++) {
			shape_3 check2 = white.get(k2);
			if ((x1 - 40) == check2.getx1() && y1 == check2.gety1()) {
				l++;
			}
		}
		if (l > 0) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 - 40 * 2) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if (l > 1) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 - 40 * 3) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if (l > 2) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 - 40 * 4) == check2.getx1() && y1 == check2.gety1()) {
					l++;
				}
			}
		}
		if ((c + l) >= 5) {
			System.out.println("白色勝利");
			JOptionPane.showMessageDialog(null, "白色勝利");return 1;
		}
		// check south and north
		int s = 1;
		// right and left check
		for (int k = 0; k < white.size(); k++) {
			shape_3 check = white.get(k);
			if (x1 == check.getx1() && (y1 + 40) == check.gety1()) {
				s++;
			}
		}
		if (s ==2) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 2) == check.gety1()) {
					s++;
				}
			}
		}
		if (s==3) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 2 + 40) == check.gety1()) {
					s++;
				}
			}
		}
		if (s ==4) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if (x1 == check.getx1() && (y1 + 40 * 4) == check.gety1()) {
					s++;
				}
			}
		}
		// n
		int n = 0;
		for (int k2 = 0; k2 < white.size(); k2++) {
			shape_3 check2 = white.get(k2);
			if (x1 == check2.getx1() && (y1 - 40) == check2.gety1()) {
				n++;
			}
		}
		if (n==1) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if (x1 == check2.getx1() && (y1 - 40 * 2) == check2.gety1()) {
					n++;
				}
			}
		}
		if (n==2) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if (x1 == check2.getx1()
						&& (y1 - 40 * 2 + 40) == check2.gety1()) {
					n++;
				}
			}
		}
		if (n==3) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if (x1 == check2.getx1() && (y1 - 40 * 4) == check2.gety1()) {
					n++;
				}
			}
		}
		if ((s + n) >= 5) {
			System.out.println("白色勝利");
			JOptionPane.showMessageDialog(null, "白色胜利");return 1;
		}
		//check south east;
		
		int se = 1;
		for (int k = 0; k < white.size(); k++) {
			shape_3 check = white.get(k);
			if ((x1 + 40) == check.getx1() && (y1 + 40) == check.gety1()) {
				se++;
			}
		}
		if (se > 1) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40*2) == check.getx1() && (y1 + 40*2) == check.gety1()) {
					se++;
				}
			}
		}
		if (se > 2) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40*3) == check.getx1() && (y1 + 40*3) == check.gety1()) {
					se++;
				}
			}
		}
		if (se > 3) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 + 40*4) == check.getx1() && (y1 + 40*4) == check.gety1()) {
					se++;
				}
			}
		}
		// n
		int nw = 0;
		for (int k2 = 0; k2 < white.size(); k2++) {
			shape_3 check2 = white.get(k2);
			if ((x1-40) == check2.getx1() && (y1 - 40) == check2.gety1()) {
				nw++;
			}
		}
		if (nw > 0) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1-40*2) == check2.getx1() && (y1 - 40*2) == check2.gety1()) {
					nw++;
				}
			}
		}
		if (nw > 1) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1-40*3) == check2.getx1() && (y1 - 40*3) == check2.gety1()) {
					nw++;
				}
			}
		}
		if (nw > 2) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 -40*4)== check2.getx1() && (y1 - 40 * 4) == check2.gety1()) {
					nw++;
				}
			}
		}
		if ((se + nw) >= 5) {
			System.out.println("白色勝利");
			JOptionPane.showMessageDialog(null, "白色胜利");return 1;
		}
		//check northeast and southwest
		int ne = 1;
		for (int k = 0; k < white.size(); k++) {
			shape_3 check = white.get(k);
			if ((x1 - 40) == check.getx1() && (y1 +40)== check.gety1()) {
				ne++;
			}
		}
		if (ne ==2) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 - 40*2)== check.getx1() && (y1 +40*2) == check.gety1()) {
					ne++;
				}
			}
		}
		if (ne ==3) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 - 40*3 )== check.getx1() && (y1 + 40*3 ) == check.gety1()) {
					ne++;
				}
			}
		}
		if (ne ==4) {
			for (int k = 0; k < white.size(); k++) {
				shape_3 check = white.get(k);
				if ((x1 - 40 * 4) == check.getx1() && (y1+40 * 4) == check.gety1()) {
					ne++;
				}
			}
		}
		// sw
		int sw = 0;
		for (int k2 = 0; k2 < white.size(); k2++) {
			shape_3 check2 = white.get(k2);
			if ((x1 + 40 ) == check2.getx1() && (y1-40 ) == check2.gety1()) {
				sw++;////////////
			}
		}
		if (sw ==1) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 + 40 * 2) == check2.getx1() && (y1-40 * 2) == check2.gety1() ){
					sw++;
				}
			}
		}
		if (sw==2) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 + 40 * 3) == check2.getx1() && (y1-40 * 3) == check2.gety1()) {
					sw++;
				}
			}
		}
		if (sw ==3) {
			for (int k2 = 0; k2 < white.size(); k2++) {
				shape_3 check2 = white.get(k2);
				if ((x1 + 40 * 4) == check2.getx1() && (y1-40 * 4) == check2.gety1()) {
					sw++;
				}
			}
		}
		if ((sw + ne) >= 5) {
			System.out.println("白色勝利");
			JOptionPane.showMessageDialog(null, "白色胜利");return 1;
			
		}
		return 0;
	}

	}
