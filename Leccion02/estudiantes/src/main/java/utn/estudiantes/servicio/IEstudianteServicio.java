package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    List<Estudiante> listarEstudiantes();

    Estudiante buscarEstudiantePorId(Integer estudiante);

    void guardarEstudiante(Estudiante estudiante);

    void eliminarEstudiante(Estudiante estudiante);
}
