package utn.estudiantes;

import org.slf4j.Logger; // es una interface
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.servicio.EstudianteServicio;

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

		private void mostrarMenu(){
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
}
