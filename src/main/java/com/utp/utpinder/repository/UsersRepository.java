package com.utp.utpinder.repository;

import com.utp.utpinder.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, String> {
}
