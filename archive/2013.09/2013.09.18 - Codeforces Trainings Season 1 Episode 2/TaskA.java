package net.egork;

import net.egork.collections.comparators.IntComparator;
import net.egork.misc.ArrayUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		String token = in.readString();
		if ("THEEND".equals(token))
			throw new UnknownError();
		final char[] keyWord = token.toCharArray();
		char[] encrypted = in.readString().toCharArray();
		char[][] message = new char[encrypted.length / keyWord.length][keyWord.length];
		int[] order = ArrayUtils.createOrder(keyWord.length);
		ArrayUtils.sort(order, new IntComparator() {
			public int compare(int first, int second) {
				if (keyWord[first] != keyWord[second])
					return (int)keyWord[first] - keyWord[second];
				return first - second;
			}
		});
		int k = 0;
		for (int i : order) {
			for (int j = 0; j < message.length; j++)
				message[j][i] = encrypted[k++];
		}
		for (char[] row : message)
			out.print(row);
		out.printLine();
    }
}
