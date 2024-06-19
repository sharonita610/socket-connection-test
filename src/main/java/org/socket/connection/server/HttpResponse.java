package org.socket.connection.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HttpResponse {

	private DataOutputStream dos;
	private static final int DELAY = 1000;

	public HttpResponse(OutputStream os) {
		this.dos = new DataOutputStream(os);
	}

	public void sendResponse() throws IOException, InterruptedException {
		sendStatusLine();
		sendContentType();
		sendContentLength();
		endHeader();
		sendBody();
	}

	private void sendStatusLine() throws IOException, InterruptedException {
		Thread.sleep(DELAY);
		dos.writeBytes("HTTP/1.1 200 OK\r\n");
		dos.flush();
	}

	private void sendContentType() throws IOException, InterruptedException {
		Thread.sleep(DELAY);
		dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
	}

	private void sendContentLength() throws IOException, InterruptedException {
		Thread.sleep(DELAY);
		byte[] body = "ok".getBytes();
		dos.writeBytes("Content-Length: " + body.length + "\r\n");
		dos.flush();
	}

	private void endHeader() throws IOException, InterruptedException {
		Thread.sleep(DELAY);
		dos.writeBytes("\r\n");
		dos.flush();
	}

	private void sendBody() throws IOException, InterruptedException {
		Thread.sleep(DELAY);
		byte[] body = "ok".getBytes();
		dos.write(body, 0, body.length);
		dos.flush();
	}
}
