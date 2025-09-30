package chapter21;

public class TestSingleton {

	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getContent());
		singleton.setContent(5);
		System.out.println(singleton.getContent());
		System.out.println(singleton);
		
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2);
	}

}
