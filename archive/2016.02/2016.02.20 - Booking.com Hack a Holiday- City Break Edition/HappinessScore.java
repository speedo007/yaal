package net.egork;

import net.egork.generated.collections.set.IntHashSet;
import net.egork.generated.collections.set.IntSet;
import net.egork.misc.ArrayUtils;
import net.egork.numbers.IntegerUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import static net.egork.io.IOUtils.*;
import static net.egork.misc.MiscUtils.*;
import static net.egork.misc.ArrayUtils.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class HappinessScore {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] s = readIntArray(in, n);
        boolean[] isPrime = IntegerUtils.generatePrimalityTable((int) (sumArray(s) + 1));
        IntSet set = new IntHashSet();
        for (int i = 1; i < (1 << n); i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    current += s[j];
                }
            }
            set.add(current);
        }
        int answer = 0;
        for (int i : set) {
            if (isPrime[i]) {
                answer++;
            }
        }
        out.printLine(answer);
    }
}
