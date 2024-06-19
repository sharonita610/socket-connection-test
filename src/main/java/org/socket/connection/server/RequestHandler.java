package org.socket.connection.server;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {
	private Socket connection;

	public RequestHandler(Socket connection) {
		this.connection = connection;
	}

	@Override
	public void run() {
		try (OutputStream out = connection.getOutputStream()) {
			HttpResponse response = new HttpResponse(out);
			response.sendResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}