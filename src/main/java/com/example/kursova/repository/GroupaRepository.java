package com.example.kursova.repository;

import com.example.kursova.entity.Groupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupaRepository extends JpaRepository<Groupa, Long> {
    List<Groupa> findByName(String name);
}
