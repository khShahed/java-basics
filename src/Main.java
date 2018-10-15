import multithreading.TestingClasses;
import networking.NetworkingTesting;
import runtime.TestingRuntime;

public class Main {
    public static void main(String[] args) {
        System.out.println("App starting...");
        TestingClasses.TestClasses();
        TestingRuntime.TestRuntime();
        NetworkingTesting.NetworkingTest();
    }
}
