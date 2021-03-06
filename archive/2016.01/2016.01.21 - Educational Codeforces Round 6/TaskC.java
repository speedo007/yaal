package net.egork;

import net.egork.generated.collections.list.IntArrayList;
import net.egork.generated.collections.list.IntList;
import net.egork.generated.collections.set.IntHashSet;
import net.egork.io.IOUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskC {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.readInt();
		int[] a = IOUtils.readIntArray(in, n);
		int answer = 0;
		IntHashSet was = new IntHashSet();
		IntList ends = new IntArrayList();
		for (int j = 0; j < a.length; j++) {
			int i = a[j];
			if (was.contains(i)) {
				answer++;
				was = new IntHashSet();
				ends.add(j);
			} else {
				was.add(i);
			}
		}
		out.printLine(answer == 0 ? -1 : answer);
		if (answer != 0) {
			out.print("1 ");
			ends.popLast();
			for (int i : ends) {
				out.printLine(i + 1);
				out.print((i + 2) + " ");
			}
			out.printLine(n);
		}
	}
}
