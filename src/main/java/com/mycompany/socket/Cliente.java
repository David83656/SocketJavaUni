package com.mycompany.socket;

import java.net.*;
import java.io.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String mensaje;

            while ((mensaje = stdIn.readLine()) != null) {
                output.println(mensaje);
                System.out.println("Servidor: " + input.readLine());
            }

            output.close();
            input.close();
            stdIn.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
