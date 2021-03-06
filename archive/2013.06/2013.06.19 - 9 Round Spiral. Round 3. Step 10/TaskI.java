package net.egork;

import net.egork.geometry.Point;
import net.egork.geometry.Ray;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskI {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		Point point = Point.readPoint(in);
		Point from = Point.readPoint(in);
		Point to = Point.readPoint(in);
		Ray ray = new Ray(from, to);
		out.printFormat("%.6f\n", ray.distance(point));
    }
}
