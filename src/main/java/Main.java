import java.sql.Connection;

public class Main {

    public static void main(String[] args){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
