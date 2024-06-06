package com.example.kursova.controller;

import com.example.kursova.entity.Groupa;
import com.example.kursova.service.GroupaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroupaController {
    private GroupaService groupaService;

    public GroupaController(GroupaService groupaService) {
        this.groupaService = groupaService;
    }

    @GetMapping("/groups")
    public String listGroups(Model model) {
        model.addAttribute("groups", groupaService.getAllGroups());
        model.addAttribute("sourcePage", "groups");
        return "groups";
    }
    @GetMapping("/show-group")
    public String ShowGrouplist(Model model) {
        model.addAttribute("groups", groupaService.getAllGroups());
        return "groups";
    }

    @GetMapping("/groups/new")
    public String createGroupaForm(Model model) {

        // create student object to hold student form data
        Groupa groupa = new Groupa();
        model.addAttribute("groupa", groupa);
        return "create_groupa";

    }

    @PostMapping("/groups")
    public String saveGroupa(@ModelAttribute("groupa") Groupa groupa) {
        groupaService.saveGroupa(groupa);
        return "redirect:/groups";
    }

    @GetMapping("/groups/edit/{id}")
    public String editGroupForm(@PathVariable Long id, Model model) {
        model.addAttribute("groupa", groupaService.getGroupaById(id));
        return "edit_groupa";
    }

    @PostMapping("/groups/{id}")
    public String updateGroupa(@PathVariable Long id,
                                @ModelAttribute("groupa") Groupa groupa,
                                Model model) {

        // get group from database by id
        Groupa existingGroupa = groupaService.getGroupaById(id);
        existingGroupa.setId(id);
        existingGroupa.setName(groupa.getName());


        // save updated group object
        groupaService.updateGroupa(existingGroupa);
        return "redirect:/groups";
    }

    // handler method to handle delete group request

    @GetMapping("/groups/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupaService.deleteGroupaById(id);
        return "redirect:/groups";
    }
    @GetMapping("/search/groups")
    public String searchGroupaByName(@RequestParam(value = "name", required = false) String name, Model model) {
        List<Groupa> groups = groupaService.getGroupaByName(name);
        model.addAttribute("groups", groups);
        return "search-groupa";
    }

    @GetMapping("/search/group-name")
    public String searchStudentByLastName(@RequestParam(value = "name", required = false) String lastName, Model model) {
        List<Groupa> groups = groupaService.getGroupaByName(lastName);
        model.addAttribute("groups", groups);
        return "groups";

    }}
