package wuziqi_3;
import java.awt.Color;
import java.awt.Graphics;

public class shape_3 {
	private Graphics g;
	private int x1;
	private int y1;
	private Color color;

	public void setG(Graphics g) {
		this.g = g;
	}

	public shape_3(int x1, int y1, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x1, y1, 35, 35);
	}

	public int getx1() {
		return x1;
	}

	public int gety1() {
		return y1;
	}
}
