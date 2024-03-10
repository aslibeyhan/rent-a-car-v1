package com.example.rentacarv1.repositories;

import com.example.rentacarv1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByGsm(String gsm);
    Optional<User> findByName(String name);
    Optional<User> findBySurname(String surname);
    boolean existsByEmail(String email);
    boolean existsByGsm(String gsm);
    boolean existsByName(String name);
    boolean existsBySurname(String surname);
}
