package sort_project;

import java.awt.Color;

public class MergeThread extends baseThread implements Runnable {
	private Point[] temp;

	public MergeThread(int LEN, Point[] array, int x ,int y) {
		super(LEN, array, "Merge Sort",x,y);
		temp = new Point[array.length];
	}

	public void run() {
		int left = 0;
		int right = array.length - 1;

		merge_sort(left, right);

		finish();
	}

	private void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (array[i].len > array[j].len) {
				temp[k] = array[i++];
			} else
				temp[k] = array[j++];
			temp[k++].color = Color.red;
		
		}

		if (i > mid) {
			for (int l = j; l <= right; l++) {
				temp[k] = array[l];
				temp[k].color = Color.red;
				k++;
			}
		} else {
			for (int l = i;  l <= mid; l++) {
				temp[k] = array[l];
				temp[k].color = Color.red;
				k++;
				
			}
		}

		for (int l = left; l <= right; l++) {
			array[l] = temp[l];
			array[l].color = Color.white;
			temp[l] = null;
			
			b.repaint();
			sleep();
		}
		
	}

	private void merge_sort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			merge_sort(left, mid);
			merge_sort(mid + 1, right);
			merge(left, mid, right);
		}
	}
}
