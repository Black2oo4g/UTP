package com.utp.utpinder.servicesimplements;

import com.utp.utpinder.model.Careers;
import com.utp.utpinder.repository.CareersRepository;
import com.utp.utpinder.services.CareersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CareersServiceImplements implements CareersService {
    @Autowired
    private CareersRepository careersRepository;

    @Override
    public ArrayList<Careers> getAllcareers() {
        return (ArrayList<Careers>) careersRepository.findAll();
    }
}
