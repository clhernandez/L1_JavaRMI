package cl.usach.lab1.main;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.finanzas.rmi.impl.ImplementacionFinanzas;
import cl.usach.lab1.rrhh.rmi.impl.ImplementacionRrhh;

/**
 *
 * @author Daniel Wladdimiro Cottet
 * @title Taller de sistemas distribuidos - Clase 1
 * 
 * Modificado por clhernandez 12-04-2015
 */

public class Servidor {

    public static ServidorRMI servidor;
    public static int puerto = 2015;
    public static ImplementacionFinanzas objetoLocalFinanzas;
    public static String nombreReferenciaFinanzasRemota = "FINANZAS-RMI";
    public static ImplementacionRrhh objetoLocalRrhh;
    public static String nombreReferenciaRrhhRemoto = "RRHH-RMI";

    static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getLogger("Servidor");

        //Se inicializa el objeto, el cual podria ser llamado remotamente
        try {
            objetoLocalFinanzas = new ImplementacionFinanzas();
            objetoLocalRrhh = new ImplementacionRrhh();
        } catch (RemoteException re) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, re.getMessage());
        }

        //El objeto se dejara disponible para una conexionn remota
        logger.log(Level.INFO, "Se va a conectar...");

        servidor = new ServidorRMI();

        boolean resultadoConexion = servidor.iniciarConexion(objetoLocalFinanzas, objetoLocalRrhh, nombreReferenciaFinanzasRemota, nombreReferenciaRrhhRemoto,  puerto);
        if (resultadoConexion) {
            logger.log(Level.INFO, "Se ha establecido la conexion correctamente");
        } else {
            logger.log(Level.INFO, "Ha ocurrido un error al conectarse");
        }

        System.out.println("Presione cualquier tecla y luego Enter para desconectar el servidor...");
        Scanner lector = new Scanner(System.in);
        lector.next();

        //En caso que presione una tecla el administrador, se detiene el servicio
        try {
            servidor.detenerConexion(nombreReferenciaFinanzasRemota, nombreReferenciaRrhhRemoto);
            lector.close();
        } catch (RemoteException re) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, re.getMessage());
        }

        System.exit(0);
    }
}
