package net.egork;

import net.egork.numbers.IntegerUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskH {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int canTake = in.readInt();
		long[][] c = IntegerUtils.generateBinomialCoefficients(count + 1);
		out.printLine(c[count][canTake]);
	}
}
