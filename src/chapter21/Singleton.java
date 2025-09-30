package chapter21;

public class Singleton {
	private static Singleton instance = null;
	private int content;

	private Singleton() {}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

}
