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
        MensajesDAO.leerMensajes();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje= sc.nextInt();
        MensajesDAO.borrarMensajes(id_mensaje);
    }

    public static void actualizarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("indica el ID del mensaje a editar");
        int id_mensaje= sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }
}
