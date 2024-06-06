package com.example.kursova.service;

import com.example.kursova.entity.Groupa;

import java.util.List;

public interface GroupaService {
    List<Groupa> getAllGroups();

    Groupa saveGroupa(Groupa groupa);

    Groupa getGroupaById(Long id);

    Groupa updateGroupa(Groupa groupa);

    void deleteGroupaById(Long id);
    public List<Groupa> getGroupaByName(String name);

}
