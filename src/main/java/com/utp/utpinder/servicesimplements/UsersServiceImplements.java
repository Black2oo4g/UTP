package com.utp.utpinder.servicesimplements;

import com.utp.utpinder.model.Users;
import com.utp.utpinder.repository.UsersRepository;
import com.utp.utpinder.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsersServiceImplements implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ArrayList<Users> getAllUsers() {
        return (ArrayList<Users>) usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserByDNI(String dni) {
        return usersRepository.findById(dni);
    }

    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(String dni) {
        usersRepository.deleteById(dni);
    }
}
