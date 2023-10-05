package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Identifica una clase de identidad que representa una tabla de datos
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // nuestra llave es autoincrementable en nuestra bd
    private Integer idEstudiante;
}
