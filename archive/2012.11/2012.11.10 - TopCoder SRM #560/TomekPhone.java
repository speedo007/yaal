package net.egork;

import net.egork.collections.ArrayUtils;
import net.egork.collections.comparators.IntComparator;

public class TomekPhone {
	public int minKeystrokes(int[] occurences, int[] keySizes) {
		long totalKeys = ArrayUtils.sumArray(keySizes);
		if (totalKeys < occurences.length)
			return -1;
		ArrayUtils.sort(keySizes, IntComparator.REVERSE);
		ArrayUtils.sort(occurences, IntComparator.REVERSE);
		int j = 0;
		int k = 1;
		int answer = 0;
		for (int occurence : occurences) {
			if (j == keySizes.length || keySizes[j] == 0) {
				j = 0;
				k++;
			}
			keySizes[j++]--;
			answer += k * occurence;
		}
		return answer;
	}
}
