package utn.estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.estudiantes.modelo.Estudiante;

// Esta es una clase interface del tipo repository antes se le agregaba la conotacion @repository ahora yano hace falta
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
}
