package utn.estudiantes;

import org.slf4j.Logger; // es una interface
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.servicio.EstudianteServicio;

// implementamos commandlinerinner para levantar nuestra fabrica de spring mediante el method run
@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired // xq queremos utilizar la capa de servicio en esta aplicacion, al ejecutar el metodo main se hacela ejecucion de manera automatica
	private EstudianteServicio estudianteServicio;
	private static final
	Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class); // utilizamos loggerfactory, para obtener un logger y obtener la info de consola
	// el patron esta en el logback



	public static void main(String[] args) {

		SpringApplication.run(EstudiantesApplication.class, args);
	}

	@Override // no es static es un metodo normal
	public void run(String... args) throws Exception {

	}
}
