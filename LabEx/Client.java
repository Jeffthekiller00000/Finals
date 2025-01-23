import java.io.*;
import java.net.Socket;
import javax.xml.bind.JAXBException;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Create a new task
            Task newTask = new Task("Midterm Project", "Complete the To-Do List app");
            
            // Convert task to XML
            String taskXML = TaskXMLUtil.convertToXML(newTask);
            out.println(taskXML); // Send XML to server

            // Read server response
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Received from server: " + serverResponse);
            }

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
