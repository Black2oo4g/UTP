package com.utp.utpinder.servicesimplements;

import com.utp.utpinder.model.Sede;
import com.utp.utpinder.repository.SedeRepository;
import com.utp.utpinder.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SedeServiceImplements implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public ArrayList<Sede> getAllCampus() {
        return (ArrayList<Sede>) sedeRepository.findAll();
    }
}
