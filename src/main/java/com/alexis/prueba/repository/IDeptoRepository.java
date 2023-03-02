package com.alexis.prueba.repository;

import com.alexis.prueba.entity.Depto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDeptoRepository extends MongoRepository<Depto,Long> {
}
