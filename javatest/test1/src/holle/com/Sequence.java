package holle.com;

//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;

interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private Object[] objects;
	private int next = 0;

	public Sequence(int size) {
		objects = new Object[size];
	}

	public void add(Object x) {
		if (next < objects.length)
			objects[next++] = x;
	}

	private class SSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == objects.length;
		}

		public Object current() {
			return objects[i];
		}

		public void next() {
			if (i < objects.length)
				i++;
		}
	}

	public Selector getSelector() {
		return new SSelector();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.getSelector();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
//			Set set = new HashSet();
		}
	}

}
