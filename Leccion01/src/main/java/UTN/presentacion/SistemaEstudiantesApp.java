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
        var estudianteDAO = new EstudianteDAO(); // Esta instancia debe hacerse una vez
        // Empezamos el menu
        var salir = false;
        while(!salir){
            try{
                mostrarMenu(); // Mostramos menu
                // Este sera el metodo ejecutarOpciones que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDAO); // Este arroja una exception
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
        }// Fin while

    } // Fin main

    private static void mostrarMenu(){
        System.out.println("""
                ******* Sistema de Estudiantes *******
                1. Listar estudiantes
                2. Buscar estudiante
                3. Agregar estudiante
                4. Modificar estudiante
                5. Eliminar estudiante
                6. Salir
                Elige una opción:
                """);
    }
    // Metodo para ejecutar las opciones, va aregresar un valor booleano, ya que es el que
    //puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion digita a traves de un switch
        switch (opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de estudiantes... ");
                // no muestra la informacion, solo recupera la info y regresa una lista

            } // Fin caso 1
            case  2 -> { // Listar a las personas
                System.out.println("Listado de personas: ");
                // Mejoras con lambda y el metodo de referencia
                // personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println); // :: se conoce como metodo de referencia
            } // Fin caso 2
            case 3 -> { // Salir del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            } // Fin del caso 3
            default -> System.out.println("Opcion incorrecta: "+opcion);
        } // Fin del switch
        return salir;
}// Fin clase
