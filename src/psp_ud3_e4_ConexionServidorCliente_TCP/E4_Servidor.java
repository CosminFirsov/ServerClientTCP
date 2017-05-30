/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ud3_e4_ConexionServidorCliente_TCP;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DAM203
 */
public class E4_Servidor {
    public static void main(String[] args) throws IOException {
        int numeroPuerto = 6000;
        ServerSocket servidor = null;
        servidor = new ServerSocket(numeroPuerto);
        
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente.......");
        clienteConectado = servidor.accept();
        
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        System.out.println("Recibiendo del cliente: " + flujoEntrada.readUTF());
        
        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujosalida = new DataOutputStream(salida);
        
        flujosalida.writeUTF("Saludos al cliente del servidor");
        
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujosalida.close();
        clienteConectado.close();
        servidor.close();
        
    }
    
}
