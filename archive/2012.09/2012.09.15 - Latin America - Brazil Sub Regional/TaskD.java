package net.egork;

import net.egork.collections.ArrayUtils;
import net.egork.io.IOUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskD {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		if (in.isExhausted()) {
			throw new UnknownError();
		}
		int count = in.readInt();
		int[] notes = IOUtils.readIntArray(in, count);
		long sum = ArrayUtils.sumArray(notes);
		if (sum % count != 0) {
			out.printLine(-1);
			return;
		}
		long mean = sum / count;
		long answer = 0;
		for (int i : notes)
			answer += Math.abs(i - mean);
		answer /= 2;
		out.printLine(answer + 1);
	}
}
