package chapter20;

public class SplitTest {

	public static void main(String[] args) {
		String s1 = "12-234+300 +(499   / 5)";
		String new_s1 = insertBlanks(s1);
//		String[] tokens = new_s1.split(" ");
		String[] tokens = new_s1.split("\\s+");
		System.out.println(new_s1);
		for (String s : tokens) {
			System.out.println(">>>>" + s +"<<<<");
		}
	}

	public static String insertBlanks(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/')
				result.append(" " + s.charAt(i) + " ");
			else
				result.append(s.charAt(i));
		}
		return result.toString();
	}

}
