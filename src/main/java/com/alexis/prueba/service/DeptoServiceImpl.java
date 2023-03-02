package com.alexis.prueba.service;

import com.alexis.prueba.entity.Depto;
import com.alexis.prueba.repository.IDeptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto,Long>implements IDeptoService{

    @Autowired
    IDeptoRepository deptoRepository;
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;
    }
}
