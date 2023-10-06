package utn.estudiantes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// implementamos commandlinerinner para levantar nuestra fabrica de spring mediante el method run
@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(EstudiantesApplication.class, args);
	}

	@Override // no es static es un metodo normal
	public void run(String... args) throws Exception {

	}
}
