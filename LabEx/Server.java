import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8080;
    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected.");

                    // Read task XML from client
                    StringBuilder xmlBuilder = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        xmlBuilder.append(line);
                    }
                    
                    // Parse the received XML into a Task object
                    Task task = TaskXMLUtil.convertFromXML(xmlBuilder.toString());
                    taskList.add(task);

                    System.out.println("Received Task: " + task);

                    // Send confirmation to client
                    out.println("Task added successfully!");

                    // Optionally send all tasks to client
                    for (Task t : taskList) {
                        out.println(TaskXMLUtil.convertToXML(t));
                    }
                } catch (JAXBException e) {
                    System.err.println("Error processing XML: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
