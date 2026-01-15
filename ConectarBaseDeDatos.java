import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*

Para conectar con las bases de datos son necesarios drivers JDBC. Pueden
descargarse desde:

- PostgreSQL: https://jdbc.postgresql.org/download/
- MariaDB: https://mariadb.org/download/?t=connector&p=connector-java

Una vez descargado el driver JDBC pertinente, es necesario añadir al
classpath la ruta del archivo .jar descargado.

*/


public class ConectarBaseDeDatos {
    

    public static void main(String[] args) {
        
        try {
        // Connection con = DriverManager.getConnection(
        //                  "jdbc:postgresql://localhost:5432/agenda",
        //                  "jairo",
        //                  "");
        Connection con = DriverManager.getConnection(
                         "jdbc:mariadb://127.0.0.1:3306/agenda",
                         "jairo",
                         "aaa");

        System.out.println("Conexión exitosa a la base de datos.");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM contactos");

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            String email = rs.getString("email");

            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Dirección: " + direccion +
                               ", Teléfono: " + telefono + ", Email: " + email);
        }

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
