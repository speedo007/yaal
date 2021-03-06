package net.egork;

import net.egork.generated.collections.list.CharArray;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import static net.egork.io.IOUtils.*;
import static net.egork.misc.MiscUtils.*;
import static net.egork.misc.ArrayUtils.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class ChefAndColoring {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        char[] colors = readCharArray(in, n);
        out.printLine(n - maxElement(new CharArray(colors).qty()));
    }
}
