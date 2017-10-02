package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by XE on 19.07.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String userName = null;
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());

            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }

            if (userName != null && !userName.equals("")) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }


            sendBroadcastMessage(new Message(MessageType.TEXT, "Закрыто соединение с удаленным адресом"));
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName = null;
            Message message = null;
            MessageType messageType = null;
            boolean f = true;
            while (f) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                messageType = message.getType();
                userName = message.getData();

                if (messageType.equals(MessageType.USER_NAME)
                        && !(userName.isEmpty())
                        && !(connectionMap.containsKey(userName)))
                    f = false;
            }
            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            ConsoleHelper.writeMessage(userName+", добро пожаловать в чат!");
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String string : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, string);
                if (string.equals(userName)) {}
                else connection.send(message);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                MessageType messageType = message.getType();
                String messageData = message.getData();
                StringBuffer sb = new StringBuffer();

                if (messageType == MessageType.TEXT) {
                    sb.append(userName).append(": ").append(messageData);
                    sendBroadcastMessage(new Message(MessageType.TEXT, sb.toString()));
                } else
                    ConsoleHelper.writeMessage("Error!");
            }
        }
    }

    public static void main(String[] args) {
        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort)){
            System.out.println("Server started...");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}