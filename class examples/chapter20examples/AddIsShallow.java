import java.util.ArrayList;

class Data2 {
	private int attribute;
	Data2(int data) {
		attribute = data;
	}
	int get() {
		return attribute;
	}
	void set(int data) {
		attribute = data;
	}
	public String toString() {
		return "" + attribute;
	}
}

public class AddIsShallow {
	public static void main(String[] args) {
		ArrayList<Data2> arrayList1 = new ArrayList<>();
		arrayList1.add(new Data2(10));
		arrayList1.add(new Data2(20));
		arrayList1.add(new Data2(30));
		System.out.println(arrayList1);
		
		ArrayList<Data2> arrayList2 = new ArrayList<>();
		arrayList2.add(new Data2(6));
		arrayList2.add(new Data2(66));
		arrayList2.add(new Data2(666));
		System.out.println(arrayList2);

		arrayList1.addAll(arrayList2);
		System.out.println(arrayList1);
		
		arrayList2.get(1).set(100);
		System.out.println(arrayList2);
		System.out.println(arrayList1);

	}

}
