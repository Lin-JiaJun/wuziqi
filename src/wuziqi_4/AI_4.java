package wuziqi_4;
import java.util.ArrayList;
import java.util.HashMap;

public class AI_4 {
	private ArrayList<shape_4> black;
	int x;
	int y;
	int x1;
	int y1;
	private ArrayList<shape_4> white;

	// create a HashMap<String,Integer>
	HashMap<String, Integer> hm = new HashMap<String, Integer>();

	public AI_4(ArrayList<shape_4> black, ArrayList<shape_4> white) {
		this.black = black;
		this.white = white;
		}
	int i[][] = new int[650][650];
	public void Integer() {
		// set the integer
		for (x = (40 - 35 / 2); x <= 600; x += 40) {
			for (y = (40 - 35 / 2); y <= 600; y += 40) {
				if (check(x, y) != 0) {
				} else {
					i[x][y] = setAIinteger(x, y);
					i[x][y]+=setHNinteger(x, y);
				}
			}
		}
		//choose the max value
		int p = 0;
		for (x = (40 - 35 / 2); x <= 600; x += 40) {
			for (y = (40 - 35 / 2); y <= 600; y += 40) {
				if (i[x][y] >= p) {
					p = i[x][y];
					x1 = x;
					y1 = y;	}}}
		
		//print the value
		for (y = (40 - 35 / 2); y <= 600; y += 40) {
			for (x = (40 - 35 / 2); x <= 600; x += 40) {
				System.out.print(i[x][y]+"  ");
			}
			System.out.println();
			}
		}
	

	// ///////////////////////
	public int getx1() {
		return x1;
	}

	public int gety1() {
		return y1;
	}

	// /////////////////////////////

	public int setAIinteger(int x, int y) {
		// 212表示下完后棋局的情况，为212. 
		// 1 means black,and 2 means white
		hm.put("010", 1);
		hm.put("0110", 30);
		hm.put("01110", 60);
		hm.put("011110", 20000);
		hm.put("012", 10);
		hm.put("0111112",1000);
		hm.put("0112", 10);
		hm.put("01112", 20);
		hm.put("011112", 200);
		hm.put("212", 5);
		hm.put("2112", 5);
		hm.put("21112", 5);
		hm.put("211112", 5);								
		int va = 0;//va为权值
		int c = 1;
		int cww = 0;
		// right and left check
		if (check(x + 40, y) == 1) {
			c++;
		} else if (check(x + 40, y) == 2) {
			cww++;
		}
		if (c == 2) {
			if (check(x + 40 * 2, y) == 1) {
				c++;
			} else if (check(x + 40 * 2, y) == 2) {
				cww++;
			}
		}
		if (c == 3) {
			if (check(x + 40 * 3, y) == 1) {
				c++;
			} else if (check(x + 40 * 3, y) == 2) {
				cww++;
			}
		}
		if (c == 4) {
			if (check(x + 40 * 4, y) == 1) {
				c++;
			} else if (check(x + 40 * 4, y) == 2) {
				cww++;
			}
		}
		
		// l means left
		int l = 0;
		if (check(x - 40, y) == 1) {
			l++;
		} else if (check(x - 40, y) == 2) {
			cww++;
		}
		if (l == 1) {
			if (check(x - 40 * 2, y) == 1) {
				l++;
			} else if (check(x - 40 * 2, y) == 2) {
				cww++;
			}
		}
		if (l == 2) {
			if (check(x - 40 * 3, y) == 1) {
				l++;
			} else if (check(x - 40 * 3, y) == 2) {
				cww++;
			}
		}
		if (l == 3) {
			if (check(x - 40 * 4, y) == 1) {
				l++;
			} else if (check(x - 40 * 4, y) == 2) {
				cww++;
			}
		}
		// set the interger.
		if ((c + l) == 1 && cww == 0) {
			va += hm.get("010");
		} else if ((c + l) == 2 && cww == 0) {
			va += hm.get("0110");
		} else if ((c + l) == 3 && cww == 0) {
			va += hm.get("01110");
		} else if ((c + l) == 4 && cww == 0) {
			va += hm.get("011110");
		} else if ((c + l) == 1 && (cww == 1)) {
			va += hm.get("012");
		} else if ((c + l) == 2 && (cww == 1)) {
			va += hm.get("0112");
		} else if ((c + l) == 3 && (cww == 1)) {
			va += hm.get("01112");
		} else if ((c + l) == 4 && (cww == 1)) {
			va += hm.get("011112" );
		}  else if ((c + l) == 1 && (cww == 2)) {
			va += hm.get("212");
		} else if ((c + l) == 2 && (cww == 2)) {
			va += hm.get("2112");
		} else if ((c + l) == 2 && (cww == 2)) {
			va += hm.get("21112");
		} else if ((c + l) == 3 && (cww == 2)) {
			va += hm.get("211112");
		}else if ((c + l) > 4) {
			va+=  hm.get("0111112");
		}else{va = va + hm.get("011110");}

		// north and south
		int s = 1;
		int cwwnw = 0;
		if (check(x, y + 40) == 1) {
			s++;
		} else if (check(x, y + 40) == 2) {
			cwwnw++;
		}

		if (s == 2) {
			if (check(x, y + 40 * 2) == 1) {
				s++;
			} else if (check(x, y + 40 * 2) == 2) {
				cwwnw++;
			}
		}
		if (s == 3) {
			if (check(x, y + 40 * 3) == 1) {
				s++;
			} else if (check(x, y + 40 * 3) == 2) {
				cwwnw++;
			}
		}
		if (s == 4) {
			if (check(x, y + 40 * 4) == 1) {
				s++;
			} else if (check(x, y + 40 * 4) == 2) {
				cwwnw++;
			}
		}
		// n
		int n = 0;
		if (check(x, y - 40) == 1) {
			n++;
		} else if (check(x, y - 40) == 2) {
			cwwnw++;
		}

		if (n == 1) {
			if (check(x, y - 40 * 2) == 1) {
				n++;
			} else if (check(x, y - 40 * 2) == 2) {
				cwwnw++;
			}
		}
		if (n == 2) {
			if (check(x, y - 40 * 3) == 1) {
				n++;
			} else if (check(x, y - 40 * 3) == 2) {
				cwwnw++;
			}
		}
		if (n == 3) {
			if (check(x, y - 40 * 4) == 1) {
				n++;
			} else if (check(x, y - 40 * 4) == 2) {
				cwwnw++;
			}
		}
		if ((n + s) == 1 && cwwnw == 0) {
			va += hm.get("010");
		} else if ((n + s) == 2 && cwwnw == 0) {
			va += hm.get("0110");
		} else if ((n + s) == 3 && cwwnw == 0) {
			va += hm.get("01110");
		} else if ((n + s) == 4 && cwwnw == 0) {
			va += hm.get("011110");
		} else if ((n + s) == 1 && (cwwnw == 1)) {
			va += hm.get("012");
		} else if ((n + s) == 2 && (cwwnw == 1)) {
			va += hm.get("0112");
		} else if ((n + s) == 3 && (cwwnw == 1)) {
			va += hm.get("01112");
		} else if ((n + s) == 4 && (cwwnw == 1)) {
			va += hm.get("011112");
		} else if ((n + s) == 1 && (cwwnw == 2)) {
			va += hm.get("212");
		} else if ((n + s) == 2 && (cwwnw == 2)) {
			va += hm.get("2112");
		} else if ((n + s) == 2 && (cwwnw == 2)) {
			va += hm.get("21112");
		} else if ((n + s) == 3 && (cwwnw == 2)) {
			va += hm.get("211112");
		} else if ((n + s) > 4) {
			va = va + hm.get("011110");
		}else{va = va + hm.get("011110");}
		// southeast
		int se = 1;
		int cwwse = 0;
		if (check(x + 40, y + 40) == 1) {
			se++;
		} else if (check(x + 40, y + 40) == 2) {
			cwwse++;
		}
		if (se == 2) {
			if (check(x + 40 * 2, y + 40 * 2) == 1) {
				se++;
			} else if (check(x + 40 * 2, y + 40 * 2) == 2) {
				cwwse++;
			}
		}
		if (se == 3) {
			if (check(x + 40 * 3, y + 40 * 3) == 1) {
				se++;
			} else if (check(x + 40 * 3, y + 40 * 3) == 2) {
				cwwse++;
			}
		}
		if (se == 4) {
			if (check(x + 40 * 4, y + 40 * 4) == 1) {
				se++;
			} else if (check(x + 40 * 4, y + 40 * 4) == 2) {
				cwwse++;
			}
		}
		// nouthwest
		int nw = 0;
		if (check(x - 40, y - 40) == 1) {
			nw++;
		} else if (check(x - 40, y - 40) == 2) {
			cwwse++;
		}

		if (nw == 1) {
			if (check(x - 40 * 2, y - 40 * 2) == 1) {
				nw++;
			} else if (check(x - 40 * 2, y - 40 * 2) == 2) {
				cwwse++;
			}
		}
		if (nw == 2) {
			if (check(x - 40 * 3, y - 40 * 3) == 1) {
				nw++;
			} else if (check(x - 40 * 3, y - 40 * 3) == 2) {
				cwwse++;
			}
		}
		if (nw == 3) {
			if (check(x - 40 * 4, y - 40 * 4) == 1) {
				nw++;
			} else if (check(x - 40 * 4, y - 40 * 4) == 2) {
				cwwse++;
			}
		}
		if ((nw + se) == 1 && cwwse == 0) {
			va += hm.get("010");
		} else if ((nw + se) == 2 && cwwse == 0) {
			va += hm.get("0110");
		} else if ((nw + se) == 3 && cwwse == 0) {
			va += hm.get("01110");
		} else if ((nw + se) == 4 && cwwse == 0) {
			va += hm.get("011110");
		} else if ((nw + se) == 1 && (cwwse == 1)) {
			va += hm.get("012");
		} else if ((nw + se) == 2 && (cwwse == 1)) {
			va += hm.get("0112");
		} else if ((nw + se) == 3 && (cwwse == 1)) {
			va += hm.get("01112");
		} else if ((nw + se) == 4 && (cwwse == 1)) {
			va += hm.get("011112");
		} else if ((nw + se) == 1 && (cwwse == 2)) {
			va += hm.get("212");
		} else if ((nw + se) == 2 && (cwwse == 2)) {
			va += hm.get("2112");
		} else if ((nw + se) == 2 && (cwwse == 2)) {
			va += hm.get("21112");
		} else if ((nw + se) == 3 && (cwwse == 2)) {
			va += hm.get("211112");
		} else if ((nw + se) > 4) {
			va = va + hm.get("011110");
		}else{va = va + hm.get("011110");}
		// southeast,northwest
		int ne = 1;
		int cwwne = 0;
		if (check(x - 40, y + 40) == 1) {
			ne++;
		} else if (check(x - 40, y + 40) == 2) {
			cwwne++;
		}
		if (ne == 2) {
			if (check(x - 40 * 2, y + 40 * 2) == 1) {
				ne++;
			} else if (check(x - 40 * 2, y + 40 * 2) == 2) {
				cwwne++;
			}
		}
		if (ne == 3) {
			if (check(x - 40 * 3, y + 40 * 3) == 1) {
				ne++;
			} else if (check(x - 40 * 3, y + 40 * 3) == 2) {
				cwwne++;
			}
		}
		if (ne == 4) {
			if (check(x - 40 * 4, y + 40 * 4) == 1) {
				ne++;
			} else if (check(x - 40 * 4, y + 40 * 4) == 2) {
				cwwne++;
			}
		}
		// sw
		int sw = 0;
		if (check(x + 40, y - 40) == 1) {
			sw++;
		} else if (check(x + 40, y - 40) == 2) {
			cwwne++;
		}
		if (sw == 1) {
			if (check(x + 40 * 2, y - 40 * 2) == 1) {
				sw++;
			} else if (check(x + 40 * 2, y - 40 * 2) == 2) {
				cwwne++;
			}
		}
		if (sw == 2) {
			if (check(x + 40 * 3, y - 40 * 3) == 1) {
				sw++;
			} else if (check(x + 40 * 3, y - 40 * 3) == 2) {
				cwwne++;
			}
		}
		if (sw == 3) {
			if (check(x + 40 * 4, y - 40 * 4) == 1) {
				sw++;
			} else if (check(x + 40 * 4, y - 40 * 4) == 2) {
				cwwne++;
			}
		}
		if ((ne + sw) == 1 && cwwne == 0) {
			va += hm.get("010");
		} else if ((ne + sw) == 2 && cwwne == 0) {
			va += hm.get("0110");
		} else if ((ne + sw) == 3 && cwwne == 0) {
			va += hm.get("01110");
		} else if ((ne + sw) == 4 && cwwne == 0) {
			va += hm.get("011110");
		} else if ((ne + sw) == 1 && (cwwne == 1)) {
			va += hm.get("012");
		} else if ((ne + sw) == 2 && (cwwne == 1)) {
			va += hm.get("0112");
		} else if ((ne + sw) == 3 && (cwwne == 1)) {
			va += hm.get("01112");
		} else if ((ne + sw) == 4 && (cwwne == 1)) {
			va += hm.get("011112");
		} else if ((ne + sw) == 1 && (cwwne == 2)) {
			va += hm.get("212");
		} else if ((ne + sw) == 2 && (cwwne == 2)) {
			va += hm.get("2112");
		} else if ((ne + sw) == 2 && (cwwne == 2)) {
			va += hm.get("21112");
		} else if ((ne + sw) == 3 && (cwwne == 2)) {
			va += hm.get("211112");
		} else if ((ne + sw) > 4) {
			va = va + hm.get("011110");
		}else{va = va + hm.get("011110");}

		return va;
	}

	// check whether this place have chessed.
	public int check(int x, int y) {
		int p = 0;
		for (int k = 0; k < black.size(); k++) {
			shape_4 check = black.get(k);
			if (x == check.getx1() && y == check.gety1()) {
				p = 1;
			}
		}
		for (int k = 0; k < white.size(); k++) {
			shape_4 check = white.get(k);
			if (x == check.getx1() && y == check.gety1()) {
				p = 2;
			}
		}
		if (p == 1) {
			// p==1 mean you have black chessed this place at chess.
			//System.out.println(x + " , " + y + "该处被黑棋下过了");
			System.out.println();return 1;
			
		} else if (p == 2) {
			// p==1 mean you have white chessed this place at chess.
			//System.out.println(x + " , " + y + "该处被白棋下过了");
			return 2;
		} else {
			//System.out.println(x + " , " + y + "该处为空");
			return 0;
		}

	}
	
	
	
	
	public int setHNinteger(int x, int y) {
		// 212表示下完后棋局的情况，为212. p.s. 1 means black
		hm.put("010", 2);
		hm.put("0110", 31);
		hm.put("01110", 61);
		hm.put("011110", 20001);
		hm.put("012", 11);
		hm.put("0111112",1001);
		hm.put("0112", 11);
		hm.put("01112", 21);
		hm.put("011112", 201);
		hm.put("212", 5);
		hm.put("2112", 5);
		hm.put("21112", 5);
		hm.put("211112", 5);								
		int va = 0;//va为权值
		int c = 1;
		int cww = 0;
		// right and left check
		if (check(x + 40, y) == 2) {
			c++;
		} else if (check(x + 40, y) == 1) {
			cww++;
		}
		if (c == 2) {
			if (check(x + 40 * 2, y) == 2) {
				c++;
			} else if (check(x + 40 * 2, y) == 1) {
				cww++;
			}
		}
		if (c == 3) {
			if (check(x + 40 * 3, y) == 2) {
				c++;
			} else if (check(x + 40 * 3, y) == 1) {
				cww++;
			}
		}
		if (c == 4) {
			if (check(x + 40 * 4, y) == 2) {
				c++;
			} else if (check(x + 40 * 4, y) == 1) {
				cww++;
			}
		}
		
		// l means left
		int l = 0;
		if (check(x - 40, y) == 2) {
			l++;
		} else if (check(x - 40, y) == 1) {
			cww++;
		}
		if (l == 1) {
			if (check(x - 40 * 2, y) == 2) {
				l++;
			} else if (check(x - 40 * 2, y) == 1) {
				cww++;
			}
		}
		if (l == 2) {
			if (check(x - 40 * 3, y) == 2) {
				l++;
			} else if (check(x - 40 * 3, y) == 1) {
				cww++;
			}
		}
		if (l == 3) {
			if (check(x - 40 * 4, y) == 2) {
				l++;
			} else if (check(x - 40 * 4, y) == 1) {
				cww++;
			}
		}
		// set the
		if ((c + l) == 1 && cww == 0) {
			va += hm.get("010");
		} else if ((c + l) == 2 && cww == 0) {
			va += hm.get("0110");
		} else if ((c + l) == 3 && cww == 0) {
			va += hm.get("01110");
		} else if ((c + l) == 4 && cww == 0) {
			va += hm.get("011110");
		} else if ((c + l) == 1 && (cww == 1)) {
			va += hm.get("012");
		} else if ((c + l) == 2 && (cww == 1)) {
			va += hm.get("0112");
		} else if ((c + l) == 3 && (cww == 1)) {
			va += hm.get("01112");
		} else if ((c + l) == 4 && (cww == 1)) {
			va += hm.get("011112" );
		}  else if ((c + l) == 1 && (cww == 2)) {
			va += hm.get("212");
		} else if ((c + l) == 2 && (cww == 2)) {
			va += hm.get("2112");
		} else if ((c + l) == 2 && (cww == 2)) {
			va += hm.get("21112");
		} else if ((c + l) == 3 && (cww == 2)) {
			va += hm.get("211112");
		}else if ((c + l) > 4) {
			va+=  hm.get("0111112");
		}else{va = va + hm.get("011110");}

		// north and south
		int s = 1;
		int cwwnw = 0;
		if (check(x, y + 40) == 2) {
			s++;
		} else if (check(x, y + 40) == 1) {
			cwwnw++;
		}

		if (s == 2) {
			if (check(x, y + 40 * 2) == 2) {
				s++;
			} else if (check(x, y + 40 * 2) == 1) {
				cwwnw++;
			}
		}
		if (s == 3) {
			if (check(x, y + 40 * 3) == 2) {
				s++;
			} else if (check(x, y + 40 * 3) == 1) {
				cwwnw++;
			}
		}
		if (s == 4) {
			if (check(x, y + 40 * 4) == 2) {
				s++;
			} else if (check(x, y + 40 * 4) == 1) {
				cwwnw++;
			}
		}
		// n
		int n = 0;
		if (check(x, y - 40) == 2) {
			n++;
		} else if (check(x, y - 40) == 1) {
			cwwnw++;
		}

		if (n == 1) {
			if (check(x, y - 40 * 2) == 2) {
				n++;
			} else if (check(x, y - 40 * 2) == 1) {
				cwwnw++;
			}
		}
		if (n == 2) {
			if (check(x, y - 40 * 3) == 2) {
				n++;
			} else if (check(x, y - 40 * 3) == 1) {
				cwwnw++;
			}
		}
		if (n == 3) {
			if (check(x, y - 40 * 4) == 2) {
				n++;
			} else if (check(x, y - 40 * 4) == 1) {
				cwwnw++;
			}
		}
		if ((n + s) == 1 && cwwnw == 0) {
			va += hm.get("010");
		} else if ((n + s) == 2 && cwwnw == 0) {
			va += hm.get("0110");
		} else if ((n + s) == 3 && cwwnw == 0) {
			va += hm.get("01110");
		} else if ((n + s) == 4 && cwwnw == 0) {
			va += hm.get("011110");
		} else if ((n + s) == 1 && (cwwnw == 1)) {
			va += hm.get("012");
		} else if ((n + s) == 2 && (cwwnw == 1)) {
			va += hm.get("0112");
		} else if ((n + s) == 3 && (cwwnw == 1)) {
			va += hm.get("01112");
		} else if ((n + s) == 4 && (cwwnw == 1)) {
			va += hm.get("011112");
		} else if ((n + s) == 1 && (cwwnw == 2)) {
			va += hm.get("212");
		} else if ((n + s) == 2 && (cwwnw == 2)) {
			va += hm.get("2112");
		} else if ((n + s) == 2 && (cwwnw == 2)) {
			va += hm.get("21112");
		} else if ((n + s) == 3 && (cwwnw == 2)) {
			va += hm.get("211112");
		} else if ((n + s) > 4) {
			va = va + hm.get("011110");
		}else{va = va + hm.get("011110");}
		// southeast
		int se = 1;
		int cwwse = 0;
		if (check(x + 40, y + 40) == 2) {
			se++;
		} else if (check(x + 40, y + 40) == 1) {
			cwwse++;
		}
		if (se == 2) {
			if (check(x + 40 * 2, y + 40 * 2) == 2) {
				se++;
			} else if (check(x + 40 * 2, y + 40 * 2) == 1) {
				cwwse++;
			}
		}
		if (se == 3) {
			if (check(x + 40 * 3, y + 40 * 3) == 2) {
				se++;
			} else if (check(x + 40 * 3, y + 40 * 3) == 1) {
				cwwse++;
			}
		}
		if (se == 4) {
			if (check(x + 40 * 4, y + 40 * 4) == 2) {
				se++;
			} else if (check(x + 40 * 4, y + 40 * 4) == 1) {
				cwwse++;
			}
		}
		// nouthwest
		int nw = 0;
		if (check(x - 40, y - 40) == 2) {
			nw++;
		} else if (check(x - 40, y - 40) == 1) {
			cwwse++;
		}

		if (nw == 1) {
			if (check(x - 40 * 2, y - 40 * 2) == 2) {
				nw++;
			} else if (check(x - 40 * 2, y - 40 * 2) == 1) {
				cwwse++;
			}
		}
		if (nw == 2) {
			if (check(x - 40 * 3, y - 40 * 3) == 2) {
				nw++;
			} else if (check(x - 40 * 3, y - 40 * 3) == 1) {
				cwwse++;
			}
		}
		if (nw == 3) {
			if (check(x - 40 * 4, y - 40 * 4) ==2) {
				nw++;
			} else if (check(x - 40 * 4, y - 40 * 4) == 1) {
				cwwse++;
			}
		}
		if ((nw + se) == 1 && cwwse == 0) {
			va += hm.get("010");
		} else if ((nw + se) == 2 && cwwse == 0) {
			va += hm.get("0110");
		} else if ((nw + se) == 3 && cwwse == 0) {
			va += hm.get("01110");
		} else if ((nw + se) == 4 && cwwse == 0) {
			va += hm.get("011110");
		} else if ((nw + se) == 1 && (cwwse == 1)) {
			va += hm.get("012");
		} else if ((nw + se) == 2 && (cwwse == 1)) {
			va += hm.get("0112");
		} else if ((nw + se) == 3 && (cwwse == 1)) {
			va += hm.get("01112");
		} else if ((nw + se) == 4 && (cwwse == 1)) {
			va += hm.get("011112");
		} else if ((nw + se) == 1 && (cwwse == 2)) {
			va += hm.get("212");
		} else if ((nw + se) == 2 && (cwwse == 2)) {
			va += hm.get("2112");
		} else if ((nw + se) == 2 && (cwwse == 2)) {
			va += hm.get("21112");
		} else if ((nw + se) == 3 && (cwwse == 2)) {
			va += hm.get("211112");
		} else if ((nw + se) > 4) {
			va = va + hm.get("011110");
		}else{va = va + hm.get("011110");}
		
		
		// southeast,northwest
		int ne = 1;
		int cwwne = 0;
		if (check(x - 40, y + 40) == 2) {
			ne++;
		} else if (check(x - 40, y + 40) == 1) {
			cwwne++;
		}
		if (ne == 2) {
			if (check(x - 40 * 2, y + 40 * 2) == 2) {
				ne++;
			} else if (check(x - 40 * 2, y + 40 * 2) == 1) {
				cwwne++;
			}
		}
		if (ne == 3) {
			if (check(x - 40 * 3, y + 40 * 3) == 2) {
				ne++;
			} else if (check(x - 40 * 3, y + 40 * 3) == 1) {
				cwwne++;
			}
		}
		if (ne == 4) {
			if (check(x - 40 * 4, y + 40 * 4) == 2) {
				ne++;
			} else if (check(x - 40 * 4, y + 40 * 4) == 1) {
				cwwne++;
			}
		}
		// sw
		int sw = 0;
		if (check(x + 40, y - 40) == 2) {
			sw++;
		} else if (check(x + 40, y - 40) == 1) {
			cwwne++;
		}
		if (sw == 1) {
			if (check(x + 40 * 2, y - 40 * 2) == 2) {
				sw++;
			} else if (check(x + 40 * 2, y - 40 * 2) == 1) {
				cwwne++;
			}
		}
		if (sw == 2) {
			if (check(x + 40 * 3, y - 40 * 3) == 2) {
				sw++;
			} else if (check(x + 40 * 3, y - 40 * 3) == 1) {
				cwwne++;
			}
		}
		if (sw == 3) {
			if (check(x + 40 * 4, y - 40 * 4) == 2) {
				sw++;
			} else if (check(x + 40 * 4, y - 40 * 4) == 1) {
				cwwne++;
			}
		}
		if ((ne + sw) == 1 && cwwne == 0) {
			va += hm.get("010");
		} else if ((ne + sw) == 2 && cwwne == 0) {
			va += hm.get("0110");
		} else if ((ne + sw) == 3 && cwwne == 0) {
			va += hm.get("01110");
		} else if ((ne + sw) == 4 && cwwne == 0) {
			va += hm.get("011110");
		} else if ((ne + sw) == 1 && (cwwne == 1)) {
			va += hm.get("012");
		} else if ((ne + sw) == 2 && (cwwne == 1)) {
			va += hm.get("0112");
		} else if ((ne + sw) == 3 && (cwwne == 1)) {
			va += hm.get("01112");
		} else if ((ne + sw) == 4 && (cwwne == 1)) {
			va += hm.get("011112");
		} else if ((ne + sw) == 1 && (cwwne == 2)) {
			va += hm.get("212");
		} else if ((ne + sw) == 2 && (cwwne == 2)) {
			va += hm.get("2112");
		} else if ((ne + sw) == 2 && (cwwne == 2)) {
			va += hm.get("21112");
		} else if ((ne + sw) == 3 && (cwwne == 2)) {
			va += hm.get("211112");
		} else if ((ne + sw) > 4) {
			va = va + hm.get("011110");
		} else{va = va + hm.get("011110");}

		
		
		return va;
	}
}
