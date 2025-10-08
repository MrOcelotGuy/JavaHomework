package chapter21;

public class SingletonDemo {

    // Single instance
    private static SingletonDemo instance = null;
    
    private int content;

    // Private constructor prevents instantiation
    private SingletonDemo() {}

    // Public accessor for the single instance
    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    // Getter and setter for content
    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    // Main method to test the singleton
    public static void main(String[] args) {
        SingletonDemo singleton1 = SingletonDemo.getInstance();
        System.out.println("Initial content: " + singleton1.getContent());

        singleton1.setContent(5);
        System.out.println("Updated content: " + singleton1.getContent());
        System.out.println("singleton1 instance: " + singleton1);

        // Another reference to the singleton
        SingletonDemo singleton2 = SingletonDemo.getInstance();
        System.out.println("singleton2 instance: " + singleton2);
        System.out.println("Content from singleton2: " + singleton2.getContent());

        // Confirm both references point to the same object
        System.out.println("singleton1 == singleton2? " + (singleton1 == singleton2));
    }
}

