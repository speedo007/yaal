package net.egork;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class MikeAndMark {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		int rowCount = in.readInt();
		int columnCount = in.readInt();
		int shots = in.readInt();
		if (rowCount * columnCount >= shots)
			out.printLine("NO");
		else
			out.printLine("YES");
    }
}
