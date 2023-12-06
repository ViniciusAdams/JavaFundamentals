import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Student implements Serializable {
    private String SID;
    private String name;
    private String major;
    private boolean replicatedFlag;
    public Student(String SID, String name, String major) {

        this.SID = SID;
        this.name = name;
        this.major = major;
        this.replicatedFlag = false;
    }

    public boolean ReplicatedFlag() {
        return replicatedFlag;
    }

    public void SetReplicatedFlag(boolean replicatedFlag) {
        this.replicatedFlag = replicatedFlag;
    }
}

class Server {
    private static final int PORT = 5000;
    private static final String SERVER_NAME = "Dublin_Server";
    private static final String PASSWORD = "password";
    private static final List<Student> studentList = new ArrayList<>();
    private static final AtomicInteger counter = new AtomicInteger(1);
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(Server::replicateData, 0, 3, TimeUnit.MINUTES);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void handleClient(Socket clientSocket) {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {


            String serverName = (String) in.readObject();
            String password = (String) in.readObject();

            if (serverName.equals(SERVER_NAME) && password.equals(PASSWORD)) {
                out.writeObject(studentList);

                List<Student> newRecords = (List<Student>) in.readObject();


                studentList.addAll(newRecords);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void replicateData() {
        Student newStudent = new Student(createSID(), "New_Student", "Computing_Science");
        newStudent.SetReplicatedFlag(true);
        studentList.add(newStudent);
    }
    private static String createSID() {
        String cityCode = "D";
        int number = counter.getAndIncrement();
        String Numberready = String.format("%04d", number);
        return cityCode + Numberready;
    }
}

class Client {
    private static final String SERVER_HOST = "local_host";
    private static final int SERVER_PORT = 5000;
    private static final String SERVER_NAME = "Dublin_Server";
    private static final String PASSWORD = "Password";
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {


            out.writeObject(SERVER_NAME);
            out.writeObject(PASSWORD);

            List<Student> studentList = (List<Student>) in.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

