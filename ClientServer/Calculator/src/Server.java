import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class Server
{
	public static void main(String []args)
	{
		try
		{
			ServerSocket sersoc = new ServerSocket(1234);

			Hashtable tOnlineUsers = new Hashtable(10);
			Hashtable tOfflineUsers = new Hashtable(10);

			while(true)
			{
				Socket socket = sersoc.accept();
				System.out.println("Neuer Client verbunden.");

				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(out, true);

				String UsrNr = br.readLine();
				System.out.println("Benutzername: " + UsrNr + "\n");
				tOnlineUsers.put(UsrNr, socket);

				Helper work = new Helper(socket, tOnlineUsers, tOfflineUsers, UsrNr);
				work.start();
			}

		}
		catch(Exception e)
		{
			System.out.println("Ein Fehler ist aufgetreten!");
		}

	}
}