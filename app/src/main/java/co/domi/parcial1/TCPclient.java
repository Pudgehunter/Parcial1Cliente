package co.domi.parcial1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPclient extends Thread {

    //Singleton
    private static TCPclient unicaInstancia;

    public static TCPclient getInstance(){
        if(unicaInstancia == null){
            unicaInstancia = new TCPclient();
            unicaInstancia.start();
        }
        return unicaInstancia;
    }

    private TCPclient(){}
    //Singleton

    //Atributos

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    @Override
    public void run() {
        super.run();
        try {
            //2. Servidor intentando conectar
            socket = new Socket("192.168.1.2",5000);

            //3. Conectados
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            writer = new BufferedWriter(osw);
            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            reader = new BufferedReader(isw);


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Message
    public void Message(String msg) {
        new Thread(
                () -> {
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

}
