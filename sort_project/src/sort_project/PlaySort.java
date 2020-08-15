package sort_project;

import java.awt.Color;
import java.util.*;

public class PlaySort {
	private static Random rn;
	private static final int LEN = 1000;

	public static void main(String[] args) {
		rn = new Random();

		Point[] array = new Point[LEN];
		boolean[] check = new boolean[LEN];

		for (int i = 0; i < LEN; i++) {
			int h = get_len(check);
			array[i] = new Point(h, Color.white);
		}

		Thread bubble = new Thread(new BubbleThread(LEN, array,0,0));
		bubble.start();

		Thread select = new Thread(new SelectionThread(LEN, array,700,0));
		select.start();

		Thread insert = new Thread(new InsertionThread(LEN, array,0,500));
		insert.start();

		Thread merge = new Thread(new MergeThread(LEN, array,700,500));
		merge.start();

	}

	private static int get_len(boolean[] check) {
		while (true) {
			int len = rn.nextInt(LEN);

			if (!check[len]) {
				check[len] = true;
				return len;
			}
		}
	}

}