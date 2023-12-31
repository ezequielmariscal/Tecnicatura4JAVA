package UTN.servicio;

import UTN.dominio.Estudiante;

import static UTN.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    public List <Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        // Creamos algunos objetos que son necesarios para comunicarnos con la bd
        PreparedStatement ps; // Envia la sentencia a la base de datos
        ResultSet rs; // Obtenemos el resultado de la bd
        // Creamos un objeto de tipo conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getNString("nombre"));
                estudiante.setApellido(rs.getNString("apellido"));
                estudiante.setTelefono(rs.getNString("telefono"));
                estudiante.setEmail(rs.getNString("email"));
                // Falta agregarlo a la lista
                estudiantes.add(estudiante);
            }
        } catch (Exception e){
            System.out.println("Ocurrio un error al seleccionar datos: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: "+e.getMessage());
            }
        }// Fin finally
        return estudiantes;
    } // Fin metodo listar

    // Metodo por id -> fin by id
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true; // Se encontro un registro
            }// Fin if
            } catch (Exception e){
            System.out.println("Ocurrio un error al buscar estudiante: "+e.getMessage());
            }// Fin catch
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: "+e.getMessage());
            }// Fin catch
        }// Fin finally
        return false;
    }

    // Metodo agregar un nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES (?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute(); // solo esxecute porq es para insertar
        }catch (Exception e){
            System.out.println("Ocurrio un error para agregar estudiante: "+e.getMessage());
        } //Fin catch
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }// Fin catch
        }// Fin finally
        return false;
    } // Fin metodo agregarEstudiante

    //Metodo para modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getNombre());
            ps.setString(4, estudiante.getNombre());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al modigicar estudiante: "+e.getMessage());
        }// Fin catch
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }//Fin catch
        }// Fin finally
        return false;
    }// Fin metodo modificarEstudiante

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();
        /*
        // Modificar estudiantes
        var estudianteModificado = new Estudiante(1,"Juan Carlos", "Juarez", "456345345", "jjauarez@mail.com");
        var modificado = estudianteDAO.modificarEstudiante(estudianteModificado);
        if(modificado)
            System.out.println("Estudiante modificado: "+estudianteModificado);
        else
            System.out.println("No se modfico el estudiante: "+estudianteModificado);

         */

        /*
        // Agregar estudiante
        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "4356456456", "carlosl@mail.com");
        var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
        if (agregado)
            System.out.println("Estudiante agregado: "+nuevoEstudiante);
        else
            System.out.println("No se ha agregado estudiante: "+nuevoEstudiante);

         */
        // Eliminar estudiante con id 3
        var estudianteEliminar = new Estudiante(4);
        var eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminar);
        if(eliminado)
            System.out.println("Estudiante eliminado: "+estudianteEliminar);
        else
            System.out.println("No se elimino estudiante: "+estudianteEliminar);
        /*
        //Listar los estudiantes
        var estudianteDAO = new EstudianteDAO();
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        estudiantes.forEach(System.out::println); // Funcion lambda para imprimir

        /*
        // Agregar estudiante
        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "4356456456", "carlosl@mail.com");
        var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
        if (agregado)
            System.out.println("Estudiante agregado: "+nuevoEstudiante);
        else
            System.out.println("No se ha agregado estudiante: "+nuevoEstudiante);

         */

        // Buscar por id
        /*
        var estudiante1 =  new Estudiante(1);
        System.out.println("Estudiantes antes de la busqueda: "+estudiante1);
        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
        if(encontrado)
            System.out.println("Estudiante encontrado: "+estudiante1);
        else
            System.out.println("No se encontro el estudiante: "+estudiante1.getIdEstudiante());
         */


    }
}
