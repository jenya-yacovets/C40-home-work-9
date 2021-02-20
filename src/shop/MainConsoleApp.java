package shop;

public class MainConsoleApp {
    public static void main(String[] args) {
        Application app = new Application(
                new Shop()
        );

        app.start();
    }
}
