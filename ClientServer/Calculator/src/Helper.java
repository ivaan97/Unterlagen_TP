import java.io.*;
import java.net.*;
import java.util.*;

public class Helper extends Thread {
    Socket socket;
    Hashtable tOnlineUsers;
    Hashtable tOfflineUsers;
    String UsrNm;

    public Helper(Socket s, Hashtable on, Hashtable off, String usrNm) {
        socket = s;
        tOnlineUsers = on;
        tOfflineUsers = off;
        UsrNm = usrNm;
    }

    {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);

            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            String charak = "";
            String Erg = "";

            while (!charak.equals("d")) {
                Erg = "";
                charak = br.readLine();
                System.out.println("Benutzer Option ist " + charak);
                switch (charak.charAt(0)) {
                    case 'd':
                        System.out.println("Anfrage zum trennen der Verbndung.");
                        break;
                    case 's':
                        System.out.println("Sende Liste mit Personen die aktuell Online sind.\n");
                        Enumeration e = tOnlineUsers.keys();
                        while (e.hasMoreElements())
                            Erg += e.nextElement() + ", ";
                        pw.println(Erg);
                        break;
                    case 'z':
                        System.out.println("Berechnen des Ergebnises und senden der Antwort.\n");
                        String eins = br.readLine();
                        String zwei = br.readLine();
                        String Op = br.readLine();
                        int one = Integer.parseInt(eins);
                        int two = Integer.parseInt(zwei);
                        char chOp = Op.charAt(0);
                        String Result = "";
                        switch (chOp) {
                            case '+':
                                Result = "Das Ergebnis ist " + (one + two);
                                break;
                            case '-':
                                Result = "Das Ergebnis ist " + (one - two);
                                break;
                            case '*':
                                Result = "Das Ergebnis ist " + (one * two);
                                break;
                            case '/':
                                Result = "Das Ergebnis ist " + (one / two);
                                break;
                            default:
                                Result = "Operator ungültig.";
                                break;
                        }
                        pw.println(Result);

                        break;
                }
            }

            Socket s = (Socket) tOnlineUsers.remove(UsrNm);
            tOfflineUsers.put(UsrNm, s);
            socket.close();

        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten!");
        }

    }

}
