package com.alexis.prueba.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "depto")
@Data
public class Depto {

    @Id
    private Long depto_ID;

    private String nombre;

    private String director;

    private String descripcion;

    private List<Profesor> listProfesor;
}
