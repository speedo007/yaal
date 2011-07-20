import net.egork.collections.ArrayUtils;
import net.egork.collections.CollectionUtils;
import net.egork.collections.function.Function;
import net.egork.collections.sequence.ArrayWrapper;
import net.egork.collections.sequence.SequenceUtils;
import net.egork.io.IOUtils;
import net.egork.utils.Solver;
import net.egork.utils.io.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskB implements Solver {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.readInt();
		int[] order = IOUtils.readIntArray(in, size);
		SequenceUtils.transform(ArrayWrapper.wrap(order), new Function<Integer, Integer>() {
			public Integer value(Integer argument) {
				return argument - 1;
			}
		});
		int[] left = new int[size];
		int[] right = new int[size];
		int[] level = new int[size];
		int[] min = new int[size];
		int[] max = new int[size];
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);
		Arrays.fill(min, -1);
		Arrays.fill(max, size);
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (order[j] < order[i] && order[j] > min[order[i]] && order[j] < max[order[i]]) {
					left[order[i]] = order[j];
					level[order[j]] = level[order[i]] + 1;
					max[order[j]] = order[i];
					break;
				}
			}
			for (int j = i + 1; j < size; j++) {
				if (order[j] > order[i] && order[j] > min[order[i]] && order[j] < max[order[i]]) {
					right[order[i]] = order[j];
					level[order[j]] = level[order[i]] + 1;
					min[order[j]] = order[i];
					break;
				}
			}
		}
		int maxLevel = CollectionUtils.maxElement(ArrayWrapper.wrap(level));
		char[][] answer = new char[2 * maxLevel + 1][size];
		ArrayUtils.fill(answer, ' ');
		for (int i = 0; i < size; i++) {
			int row = level[i] * 2;
			answer[row][i] = 'o';
			if (left[i] != -1) {
				for (int j = left[i] + 1; j < i; j++)
					answer[row][j] = '-';
				answer[row][left[i]] = '+';
				answer[row + 1][left[i]] = '|';
			}
			if (right[i] != -1) {
				for (int j = i + 1; j < right[i]; j++)
					answer[row][j] = '-';
				answer[row][right[i]] = '+';
				answer[row + 1][right[i]] = '|';
			}
		}
		out.println("Case #" + testNumber + ":");
		for (char[] row : answer) {
			int last = size;
			while (last > 0 && row[last - 1] == ' ') {
				last--;
			}
			for (int j = 0; j < last; j++) {
				out.print(row[j]);
			}
			out.println();
		}
	}
}

