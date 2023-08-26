package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.dominio.Estudiante;
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
                var estudiantes = estudianteDAO.listarEstudiantes(); // recibe el listado
                // vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println); // para imprimir lista¿
            } // Fin caso 1
            case  2 -> { // Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("Estudiante no encontrado: "+estudiante);
            } // Fin caso 2
            case 3 -> { // Agregar estudiante
                System.out.print("Agregar estudiante: ");
                System.out.print("Digite el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Digite el apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Digite el telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Digite el email: ");
                var email = consola.nextLine();
                // creamos el objeto estudiante sin id
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                // Agregamos la persona a la lista
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante NO agregado: "+estudiante);
            } // Fin del caso 3
            case 4 -> {
                System.out.println("Modificar Estudiante: ");
                System.out.print("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                var estudiante =
                        new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if (modificado)
                    System.out.println("Estudiante modificado: " + estudiante);
                else
                    System.out.println("Estudiante no modificado: " + estudiante);
            }
            case 5 -> {
                System.out.println("Eliminar Estudiante: ");
                System.out.print("Id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante  eliminado: " + estudiante);
                else
                    System.out.println("Estudiante no eliminado" + estudiante);

            }
            case 6 -> {
                System.out.println("Finalizo el programa");
                System.out.println("Hasta pronto gato");
                System.out.println("4to semestre UTN SAN RAFAEL MZA ");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida, ingrese otra opción");

        } // Fin del switch
        return salir;
    }
}// Fin clase
