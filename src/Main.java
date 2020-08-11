/**
 * 
 * @author Kahila kalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Main
 * */
import sockets.Server;


public class Main {

	public static void main(String[] args) throws Exception{
		//creating a server socket and binding it to port 1234
		Server server = new Server(1234);
		server.run();
	}
}

