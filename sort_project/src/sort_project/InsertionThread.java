package sort_project;

import java.awt.Color;

/*
 * 삽입 정렬
 * 삽입 정렬의 핵심은 현재 인덱스에 있는 값을 정렬된 지점에 넣는 것으로 생각하면 된다.
 * 
 */

public class InsertionThread extends baseThread implements Runnable {

	public InsertionThread(int LEN, Point[] array, int x, int y) {
		super(LEN, array, "Insertion Sort", x, y);
	}

	public void run() {
		for (int i = 1; i < array.length; i++) {
			Point temp = array[i];
			temp.color = Color.red;
			b.repaint();

			int j = i - 1;

			while (j >= 0 && temp.len > array[j].len) {
				array[j].color = Color.red;
				array[j + 1] = array[j];
				b.repaint();
				sleep();

				array[j + 1].color = Color.white;
				j--;
			}

			array[j + 1] = temp;
			array[j + 1].color = Color.white;
			b.repaint();
			sleep();
		}

		for(Point p: array) {
			System.out.print(p.len + " ");
		}
		finish();
	}
}
