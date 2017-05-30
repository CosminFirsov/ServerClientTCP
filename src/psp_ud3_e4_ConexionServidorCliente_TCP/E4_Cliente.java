/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ud3_e4_ConexionServidorCliente_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author DAM203
 */
public class E4_Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        
        System.out.println("Programa cliente iniciando....");
        Socket cliente = new Socket(host,puerto);
        
        DataOutputStream flujosalid = new DataOutputStream(cliente.getOutputStream());
        flujosalid.writeUTF("Saludos al Servidor desde el cliente");
        
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        
        System.out.println("Recibiendo del Servidor: " + flujoEntrada.readUTF());
        
        flujoEntrada.close();
        flujosalid.close();
        cliente.close();
        
        
    }
}
