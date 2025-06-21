// Logger.java - Singleton class definition
class Logger {
    // Step 1: Create a private static instance of Logger (eager initialization)
    private static Logger instance = new Logger();

    // Step 2: Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to provide access to the single instance
    public static Logger getInstance() {
        return instance;
    }

    // Utility logging method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

// LoggerTest.java - Test class to verify Singleton behavior
public class LoggerTest {
    public static void main(String[] args) {
        // Trying to get multiple Logger instances
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("\n✅ Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("\n❌ logger1 and logger2 are different instances.");
        }
    }
}
