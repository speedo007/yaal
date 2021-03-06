package net.egork;

import net.egork.io.IOUtils;
import net.egork.misc.MiscUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int[][] distance = IOUtils.readIntTable(in, count, count);
		int[] order = IOUtils.readIntArray(in, count);
		MiscUtils.decreaseByOne(order);
		boolean[] present = new boolean[count];
		long[] answer = new long[count];
		for (int ii = count - 1; ii >= 0; ii--) {
			int i = order[ii];
			for (int j = 0; j < count; j++) {
				if (present[j]) {
					for (int k = 0; k < count; k++) {
						if (present[k]) {
							distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
							distance[j][i] = Math.min(distance[j][i], distance[j][k] + distance[k][i]);
						}
					}
					answer[ii] += distance[i][j] + distance[j][i];
				}
			}
			for (int j = 0; j < count; j++) {
				if (present[j]) {
					for (int k = 0; k < count; k++) {
						if (present[k]) {
							answer[ii] += distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
						}
					}
				}
			}
			present[i] = true;
		}
		out.printLine(answer);
    }
}
