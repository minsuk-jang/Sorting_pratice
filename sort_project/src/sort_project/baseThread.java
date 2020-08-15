package sort_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class baseThread {
	protected Point[] array;
	protected Board b;
	protected long TIME = 1;
	private int LEN;

	// 초기화
	protected baseThread(int LEN, Point[] array, String name, int x, int y) {
		this.array = new Point[LEN];
		this.LEN = LEN;

		for (int i = 0; i < LEN; i++) {
			this.array[i] = new Point(array[i].len, Color.white);
		}

		b = new Board(name, 700, 500,x,y);
	}

	protected void finish() {
		for (int i = 0; i < array.length; i++) {
			array[i].color = Color.red;
			b.repaint();
			sleep();
		}

		for (int i = 0; i < array.length; i++) {
			array[i].color = Color.white;
			b.repaint();
			sleep();
		}

		b.dispose();
	}

	protected void sleep() {
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected class Board extends JFrame {
		private int w, h;

		public Board(String n, int w, int h, int x, int y) {
			setTitle(n);
			this.w = w;
			this.h = h;
			setSize(w+25, h+ 50);
			setLocation(x,y);
			setContentPane(new Panel());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}

		private class Panel extends JPanel {
			public Panel() {
				setBackground(Color.black);
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// 그리기
				Graphics2D g2 = (Graphics2D) g;
				for (int i = 0; i < array.length; i++) {
					double x1 = (double) i * w / (double)array.length;
					double y1 = (double) h * array[i].len / (double)array.length;
					double x2 = (double) i * w / (double)array.length;
					double y2 = (double) h;
					g2.setColor(array[i].color);
					g2.draw(new Line2D.Double(x1, y1, x2, y2));
				}
			}
		}
	}
}
