import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion dbConnect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conexion = dbConnect.getConnection())  {
            String query="SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajes(int id_mensaje){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection())  {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");
            }catch(SQLException e) {
                System.out.println(e);
                System.out.println("no se pudo borrar el mensaje");
            }


        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection())  {
            PreparedStatement ps = null;

            try{
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje se actualizó correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("no se pudo actualizar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

}
