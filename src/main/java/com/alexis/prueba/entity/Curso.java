package com.alexis.prueba.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "curso")
@Data
public class Curso {

    @Id
    private Long curso_ID;

    private String nombre;

    private String nivel;

    private String descripcion;
}
