package net.egork.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public class CollectionUtils {
	public static int[] toArray(Collection<Integer> collection) {
		int[] array = new int[collection.size()];
		int index = 0;
		for (int element : collection)
			array[index++] = element;
		return array;
	}

	public static List<Integer> range(int from, int to) {
		List<Integer> result = new ArrayList<Integer>(Math.max(from, to) - Math.min(from, to) + 1);
		if (to > from) {
			for (int i = from; i <= to; i++)
				result.add(i);
		} else {
			for (int i = from; i >= to; i--)
				result.add(i);
		}
		return result;
	}

	public static void rotate(List<Integer> list) {
		list.add(list.remove(0));
	}

	public static List<Integer> increment(List<Integer> path) {
		return Transformer.transform(path, new Transformer<Integer>() {
			@Override
			public Integer transform(Integer value) {
				return value + 1;
			}
		});
	}

	public static<T extends Comparable<T>> T minElement(Iterable<T> collection) {
		T result = null;
		for (T element : collection) {
			if (result == null || result.compareTo(element) > 0)
				result = element;
		}
		return result;
	}

	public static<T extends Comparable<T>> T maxElement(Iterable<T> collection) {
		T result = null;
		for (T element : collection) {
			if (result == null || result.compareTo(element) < 0)
				result = element;
		}
		return result;
	}

	public static<T> List<T> asList(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
		for (T element : iterable)
			list.add(element);
		return list;
	}

	public static<T> int count(Iterable<T> array, T sample) {
		int result = 0;
		for (T element : array) {
			if (element.equals(sample))
				result++;
		}
		return result;
	}
}
