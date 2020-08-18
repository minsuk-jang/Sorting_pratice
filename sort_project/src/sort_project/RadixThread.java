package sort_project;

import java.awt.Color;
import java.util.*;

public class RadixThread extends baseThread implements Runnable {
	private Queue<Point>[] bucket;

	public RadixThread(int LEN, Point[] array, int x, int y) {
		super(LEN, array, "Radix Sort", x, y);
		bucket = new LinkedList[10];

		for (int i = 0; i < bucket.length; i++)
			bucket[i] = new LinkedList<>();
	}

	public void run() {
		int size = getSize();
		for (int i = 0; i < size; i++) {
			for (Point p : array) {
				String temp = String.valueOf((int) p.len);
				int idx = 0;
				if (temp.length() > i) {
					idx = temp.charAt(temp.length()-i-1) - '0';
				}

				bucket[9-idx].add(p);
			}
			
			int j = 0;
			for (Queue<Point> q : bucket) {
				while (!q.isEmpty()) {
					Point temp = q.poll();
					temp.color= Color.red;
					array[j++] = temp;
					b.repaint();
					sleep();
					
					temp.color = Color.white;
					b.repaint();
					sleep();
				}
			}
		}

		finish();
	}

	private int getSize() {
		int ret = 0;
		int div = array.length;

		while (true) {
			int mod = div / 10;
			if (div == 0)
				break;

			ret++;
			div = mod;
		}

		return ret;
	}
}
