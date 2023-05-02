import java.io.IOException;

public class Main {
	public static void sleepOneSecond() {
		try {
            Thread.sleep(1000);
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
	}
    /*public static void main(String[] args) {
        LogServer server = new LogServer();

        // Add new entries and exits for employee with id 1
        System.out.println(server.newEntry(1));
        sleepOneSecond();

        System.out.println(server.newExit(1));
        sleepOneSecond();

        System.out.println(server.newEntry(1));
        sleepOneSecond();

        System.out.println(server.newEntry(1));
        sleepOneSecond();

        System.out.println(server.newExit(1));
        sleepOneSecond();

        System.out.println(server.newExit(1));
        sleepOneSecond();

        // Add new entries and exits for employee with id 2
        System.out.println(server.newEntry(2));
        sleepOneSecond();

        System.out.println(server.newEntry(2));
        sleepOneSecond();



        // Print the log server
        System.out.println(server.toString());
        
        
    }*/
	public static void main(String[] args) {
		HTTPServer server = new HTTPServer();
		try {
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
