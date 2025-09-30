package chapter18.defaultMethod;

public interface Displayable {
	default void display() {
		System.out.println("This is the default method.");
	}
}