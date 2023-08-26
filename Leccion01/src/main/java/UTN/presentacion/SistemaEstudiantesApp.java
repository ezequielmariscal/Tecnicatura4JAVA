package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.servicio.EstudianteDAO;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        /*
        var conexion = Conexion.getConnection();
        if (conexion != null){
            System.out.println("Conexion exitosa: "+conexion);
        }else
            System.out.println("Error al conectarse");

        */
        var consola = new Scanner(System.in); // Creamos consola, se encarga de leer la informacion
        // Creamos una instancia de la clase servicio, esto lo hacemos fuera del ciclo while
        var estudianteDao = new EstudianteDAO(); // Esta instancia debe hacerse una vez
        // Empezamos el menu
        var salir = false;
        while(!salir){
            try{
                mostrarMenu(); // Este sera el metodo que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDao); // Este arroja una exception
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
        }// Fin while

    } // Fin main

    private static void mostrarMenu(){
        System.out.println("""
                ******* Sistema de Estudiantes *******
                
                """

        );
    }
}// Fin clase
