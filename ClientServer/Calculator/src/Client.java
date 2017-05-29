import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class Client {

    public static void main(String[] args) {

        int port = 1234;
        String Port = "";
        String IP = "";
        String UsrNm = "";

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("Verbindung zum Server.\n" +
                    "- Läuft der Server auf dem gleichen Pc," +
                    "einfach entertaste betätigen oder \"127.0.0.1\" eingeben.\n" +
                    "- Nichts ändern bis Sie den Port in " +
                    "Server.java ändern." +
                    "-Einfach Enter drücken\n" +
                    " Benutzernamen der Wahl eingeben\n");


            System.out.print("\n\nIP des Servers eingeben ");
            IP = inp.readLine();
            if (IP.equals(""))
                IP = "127.0.0.1";


            System.out.print("Port Nummer: ");
            Port = inp.readLine();
            if (Port.equals(""))
                port = 1234;
            else
                port = Integer.parseInt(Port);


            UsrNm = "Temporär";
            do {
                System.out.print("Benutzernamen eingeben: ");
                UsrNm = inp.readLine();
            }
            while (UsrNm.equals(""));


            Socket socket = new Socket(IP, port);

            System.out.print("\n\n\t\tVerbindung erfolgreich.\n\t\t");

            String rand = "z";
            String eins = "2";
            String zwei = "4";
            String opt = "-";
            String Result = "";
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);


            pw.println(UsrNm);


            while (rand.charAt(0) != 'd') {

                System.out.println("\n\nGeben Sie zum Trennen der Verbindung d ein,\n" +
                        "      und s für eine Liste der Personen die Online sind.\n" +
                        "      Jede andere beliebige Taste zum lösen eines Ausdruckes.  ");
                rand = inp.readLine();
                if (rand.equals(""))
                    rand = "z";
                switch (rand.charAt(0)) {
                    case 'd':
                        pw.println("d");
                        break;
                    case 's':
                        pw.println("s");
                        Result = br.readLine();
                        System.out.println(Result);
                        break;
                    default:
                        pw.println("z");

                        System.out.print("Erste Nummer eingeben: ");
                        eins = inp.readLine();
                        if (eins.equals(""))
                            eins = "2";


                        System.out.print("Zweite Nummer eingeben: ");
                        zwei = inp.readLine();
                        if (zwei.equals(""))
                            zwei = "4";

                        System.out.print("Rechenoperation eingeben: ");
                        opt = inp.readLine();
                        if (opt.equals(""))
                            opt = "-";
                        pw.println(eins);
                        pw.println(zwei);
                        pw.println(opt);
                        Result = br.readLine();
                        System.out.println(Result);
                        break;
                }
            }
            socket.close();

        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten!");
            System.exit(0);
        }

    }
}
