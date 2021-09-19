import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu mensaje :");
        String mensaje = sc.nextLine();

        System.out.println("Ingresa tu nombre :");
        String nombre = sc.nextLine();

        Mensajes nuevoMensaje = new Mensajes();
        nuevoMensaje.setMensaje(mensaje);
        nuevoMensaje.setAutor(nombre);

        MensajesDAO.createMensajeDB(nuevoMensaje);

    }

    public static void listarMensajes(){

    }

    public static void borrarMensaje(){

    }

    public static void actualizarMensaje(){

    }
}
