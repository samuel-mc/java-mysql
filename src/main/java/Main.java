import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("------------------------\n");
            System.out.println("Aplicacion de mensajeria");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Ver mensajes");
            System.out.println("3. Eliminar mensajes");
            System.out.println("4. Editar mensajes");
            System.out.println("5. Salir");
            System.out.println("\n Elije una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.actualizarMensaje();
                    break;
                case 5:
                    System.out.println("Hasta la proxima :)");
                    break;
            }

        } while (opcion != 5);
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
