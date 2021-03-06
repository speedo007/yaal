package net.egork;

import net.egork.collections.comparators.IntComparator;
import net.egork.io.IOUtils;
import net.egork.misc.ArrayUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int[] degrees = IOUtils.readIntArray(in, count);
		long sum = ArrayUtils.sumArray(degrees);
		if (sum != 2 * count - 2) {
			out.printLine("None");
			return;
		}
		ArrayUtils.sort(degrees, IntComparator.DEFAULT);
		if (degrees[count - 1] == 2 || count == 2 || degrees[count - 3] == 1 || count >= 4 && degrees[count - 3] == degrees[count - 1] && degrees[count - 4] == 1)
			out.printLine("Unique");
		else
			out.printLine("Multiple");
    }
}
