import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajesDAO {
    public static  void createMensajeDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor());
                ps.executeUpdate();
                System.out.println("Mensaje enviado con exito");
            } catch (SQLException e){
                System.out.println(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void leerMensajes(){

    }

    public static void borrarMensajes(int id_mensaje){

    }

    public static void actualizarMensajeDB(Mensajes mensaje){

    }

}
