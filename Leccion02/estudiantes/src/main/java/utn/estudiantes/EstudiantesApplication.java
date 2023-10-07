package utn.estudiantes;

import org.slf4j.Logger; // es una interface
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;
import java.util.Scanner;

// implementamos commandlinerinner para levantar nuestra fabrica de spring mediante el method run
@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired // xq queremos utilizar la capa de servicio en esta aplicacion, al ejecutar el metodo main se hacela ejecucion de manera automatica
	private EstudianteServicio estudianteServicio;
	private static final
	Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class); // utilizamos loggerfactory, para obtener un logger y obtener la info de consola
	// el patron esta en el logback

	String nl = System.lineSeparator(); // no hace el salto de linea




	public static void main(String[] args) {


		logger.info("Iniciando la aplicación...");
		// Levantar fabrica de spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicación finalizada! :/ ");
	}

	@Override // no es static es un metodo normal
	public void run(String... args) throws Exception {
		logger.info(nl+"Ejecutando el metodo run de Spring..."+nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		} // Fin ciclo while

	}

	private boolean ejecutarOpciones(Scanner consola) {
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> {//Listar estudiantes
				logger.info(nl+"Listado de estudiantes: "+nl);
				List<Estudiantes2022> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString()+nl)));
			}
			case 2 -> {// Buscar estudiante por id
				logger.info("Digite el id estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiantes2022 estudiante =
				estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null)
					logger.info("Estudiante encontrado: "+ estudiante + nl);
				else
					logger.info("Estudiante NO encontrado: "+ estudiante + nl);
			}
			case 3 -> {// Agregar estudiante
				logger.info("Agregar estudiante: "+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				// CREAR EL OBJETO ESTUDIANTE SI EL ID
				var estudiante = new Estudiantes2022();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+estudiante+nl);
			}
			case 4  -> {// Modificar estudiante
				logger.info("Modificar estudiante: "+nl);
				logger.info("Ingrese el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				// buscamos el estudiante a modificar
				Estudiantes2022 estudiante =
						estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: "+estudiante+nl);
				}
				else
					logger.info("Estudiante No encontrado con el id: "+ idEstudiante+nl);

			}

		}// Fin switch
		return salir;
	}

	private void mostrarMenu() {
		logger.info(nl);
		logger.info("""
					******** Sistema de Estudiantes ********
					1. Listar Estudiantes
					2. Buscar Estudiante
					3. Agregar Estudiante
					4. Modificar Estudiante
					5. Eliminar Estudiante
					6. Salir
					Eliga una opción:""");
	}
}
