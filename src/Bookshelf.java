import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;


public class Bookshelf {
	
	public Hashtable<Integer, Integer> width;
	public LinkedList<Integer> pos;
	
	int size = 0;
	int currentSize;
	int counter = 1;
	
	public void solve() {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		while (size != -1) {
			width = new Hashtable<>();
			pos = new LinkedList<>();
			currentSize = 0;
			String str = scan.next();
			while(!str.equals("E")) {
				if (str.equals("A")) {
					add(scan.nextInt(), scan.nextInt());
				}
				else {
					remove(scan.nextInt());
				}
				str = scan.next();
			}
			print();
			size = scan.nextInt();
		}
		
		
		scan.close();
	}
	
	public void add (int id, int sz) {
		width.put(id, sz);
		pos.addFirst(id);
		currentSize += sz;
		while (currentSize > size) {
			currentSize -= width.remove(pos.removeLast());
		}
	}
	
	public void remove (int id) {
		if (width.containsKey(id)) {
			currentSize -= width.remove(id);
			Object o = id;
			pos.remove(o);
		}
	}
	
	public void print() {
		System.out.print("PROBLEM " + counter + ":");
		for(Integer num: pos) {
			System.out.print(" " + num);
		}
		System.out.println();
		counter++;
	}
	
	
	public static void main (String[] args) {
		Bookshelf b = new Bookshelf();
		b.solve();
	}
}
