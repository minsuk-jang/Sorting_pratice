package sort_project;

import java.awt.Color;

/*
 * ���� ����
 * ���� ������ �ٽ��� ���� �ε����� �ִ� ���� ���ĵ� ������ �ִ� ������ �����ϸ� �ȴ�.
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

		finish();
	}
}