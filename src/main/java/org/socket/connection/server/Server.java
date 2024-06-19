package org.socket.connection.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.stereotype.Component;

@Component
public class Server extends Thread {

	private static int SOCKET_PORT = 8000;

	@Override
	public void run() {

		try (ServerSocket serverSocket = new ServerSocket(SOCKET_PORT)) {

			Socket connection;
			while ((connection = serverSocket.accept()) != null) {
				RequestHandler requestHandler = new RequestHandler(connection);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
