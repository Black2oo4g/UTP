package com.utp.utpinder.services;

import com.utp.utpinder.model.Users;
import java.util.ArrayList;
import java.util.Optional;

public interface UsersService {

    ArrayList<Users> getAllUsers();

    Optional<Users> getUserByDNI(String dni);

    Users createUser(Users user);

    Users updateUser(Users user);

    void deleteUser(String dni);
}
