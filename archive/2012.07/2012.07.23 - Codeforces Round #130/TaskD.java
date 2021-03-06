package net.egork;

import net.egork.collections.sequence.Array;
import net.egork.io.IOUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskD {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int[] points = IOUtils.readIntArray(in, count);
		int[] cost = IOUtils.readIntArray(in, 5);
		long remaining = 0;
		long[] answer = new long[5];
		for (int i : points) {
			remaining += i;
			for (int j = 4; j >= 0; j--) {
				answer[j] += remaining / cost[j];
				remaining %= cost[j];
			}
		}
		out.printLine(Array.wrap(answer).toArray());
		out.printLine(remaining);
	}
}
