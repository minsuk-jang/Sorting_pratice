package sort_project;

import java.awt.Color;
import java.util.*;

/*
 * 버블 정렬
 * O(n^2) 의 시간이 걸린다.
 */
public class BubbleThread extends baseThread implements Runnable {

	public BubbleThread(int LEN, Point[] array, int x, int y) {
		super(LEN, array, "Bubble Sort", x, y);

	}

	public void run() {
		System.out.println("Start bubble Sort");
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[i].len > array[j].len) {

					array[i].color = Color.red;
					array[j].color = Color.red;

					b.repaint();
					sleep();

					Point temp = array[i];
					array[i] = array[j];
					array[j] = temp;

					array[i].color = Color.white;
					array[j].color = Color.white;

					b.repaint();
					sleep();
				}
			}
		}

		finish();
	}

}
