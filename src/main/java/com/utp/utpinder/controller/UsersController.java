package com.utp.utpinder.controller;

import com.utp.utpinder.model.Users;
import com.utp.utpinder.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public ArrayList<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{dni}")
    public Optional<Users> getUserByDNI(@PathVariable String dni) {
        return usersService.getUserByDNI(dni);
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user) {
        return usersService.updateUser(user);
    }

    @DeleteMapping("/delete/{dni}")
    public void deleteUser(@PathVariable String dni) {
        usersService.deleteUser(dni);
    }
}
