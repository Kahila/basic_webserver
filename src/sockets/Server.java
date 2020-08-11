
/**
 * 
 * @author Kahila kalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Server
 * */
package sockets;

import java.net.*;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

//class that will be used to create a web server 
public class Server extends Thread {
	private ServerSocket serverSocket;
	
	//creating a server socket
	public Server(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	}
	
	//mathod responsible for the creation of the connection to client
	public void run() {
		System.out.println("Listeniong for connection on port 1234 ...");
		while (true) {
			try(Socket client = serverSocket.accept()){//waiting for client to connect
				//HTTP response to be sent to client
				String resp = null;
				resp = "GET/HTTP/1.1 200 OK\r\n\r\n<h3 style='color:green;'>"+ "response code: 200"+"</h3>"
						+ "<body><br><img src='https://www.piperclassics.com/wp-content/uploads/2019/05/Simple-Welcome-Home-18x12.jpg' alt='images saying welocme_home' width='500' height='300'>"
						+ "<video width='400' height='300' controls style='padding-left:5px;'>"
						+ "<source src='../../P02_Additional/small.mp4' type='video/mp4'>"
						+ "your brwoser does not support this file format."
						+ "</video></body>";
				client.getOutputStream().write(resp.getBytes("UTF-8"));//sending the HTTP response
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
