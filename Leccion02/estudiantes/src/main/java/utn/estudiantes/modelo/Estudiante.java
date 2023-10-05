package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Identifica una clase de identidad que representa una tabla de datos
//boilerplate - Repetitivo --- para no perder tiempo con get-set-contructor- se utiliza lombok
@Data // Sirve para no generar los constructores - get y set
@NoArgsConstructor // genera construcror vacio
@AllArgsConstructor // genera constructor con todos los argumentos
@ToString
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // nuestra llave es autoincrementable en nuestra bd
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
