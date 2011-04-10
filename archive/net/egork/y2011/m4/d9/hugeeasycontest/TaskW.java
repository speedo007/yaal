package net.egork.y2011.m4.d9.hugeeasycontest;

import net.egork.utils.io.inputreader.InputReader;
import net.egork.utils.solver.Solver;

import java.io.PrintWriter;

public class TaskW implements Solver {
	private static final int[] TEN = {1, 10, 100, 1000, 10000, 100000, 1000000};

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		in.readCharacter();
		in.readCharacter();
		String first = in.readString();
		in.readCharacter();
		in.readCharacter();
		String second = in.readString();
		int result = go(Integer.parseInt(first) * TEN[6 - first.length()], Integer.parseInt(second) * TEN[6 - second.length()]);
		out.println("Case " + testNumber + ": " + result);
	}

	private int go(int x, int y) {
		for (int i = -1; i < 50000; i++) {
			if (x / 1000000 == 1 && y / 1000000 == 1)
				return i;
			x %= 1000000;
			y %= 1000000;
			x *= 3;
			y *= 3;
		}
		return -1;
	}
}

