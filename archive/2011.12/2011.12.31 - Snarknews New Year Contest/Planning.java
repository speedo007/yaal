package net.egork;

import net.egork.io.IOUtils;
import net.egork.misc.MiscUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class Planning {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int vertexCount = in.readInt();
		int edgeCount = in.readInt();
		int[] from = new int[edgeCount];
		int[] to = new int[edgeCount];
		IOUtils.readIntArrays(in, from, to);
		MiscUtils.decreaseByOne(from, to);
		boolean[][] dependencies = new boolean[vertexCount][vertexCount];
		for (int i = 0; i < edgeCount; i++)
			dependencies[from[i]][to[i]] = true;
		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < vertexCount; j++) {
				for (int k = 0; k < vertexCount; k++)
					dependencies[j][k] |= dependencies[j][i] && dependencies[i][k];
			}
		}
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < edgeCount; i++) {
			boolean found = false;
			for (int j = 0; j < vertexCount && !found; j++) {
				if (from[i] != j && to[i] != j)
					found = dependencies[from[i]][j] && dependencies[j][to[i]];
			}
			if (found)
				answer.add(i + 1);
		}
		out.printLine(answer.size());
		out.printLine(answer.toArray());
	}
}
