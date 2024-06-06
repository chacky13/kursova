package com.example.kursova.service.impl;

import com.example.kursova.service.GroupaService;
import com.example.kursova.entity.Groupa;
import com.example.kursova.repository.GroupaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupaServiceImpl implements GroupaService {
    private GroupaRepository groupaRepository;

    public GroupaServiceImpl(GroupaRepository groupaRepository) {
        super();
        this.groupaRepository = groupaRepository;
    }
    @Override
    public List<Groupa> getAllGroups() {
        return groupaRepository.findAll();
    }

    @Override
    public Groupa saveGroupa(Groupa groupa) {
        return groupaRepository.save(groupa);
    }

    @Override
    public Groupa getGroupaById(Long id) {
        return groupaRepository.findById(id).get();
    }

    @Override
    public Groupa updateGroupa(Groupa groupa) {
        return groupaRepository.save(groupa);
    }

    @Override
    public void deleteGroupaById(Long id) {
        groupaRepository.deleteById(id);
    }
    @Override
    public List<Groupa> getGroupaByName(String name){
        return groupaRepository.findByName(name);    }

}
