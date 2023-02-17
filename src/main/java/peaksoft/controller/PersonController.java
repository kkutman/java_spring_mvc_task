package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Person;
import peaksoft.services.PersonServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonServices personServices;


    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("newPerson",new Person());
        return "addPerson";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("newPerson")Person person){
        personServices.save(person);
        return "redirect:/person";
    }

    @GetMapping
    public String allPerson(Model model){
        model.addAttribute("getAllPerson",personServices.getAll());
        return "getAll";
    }
    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id")Long id){
        personServices.deleteBiId(id);
        return "redirect:/person";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model){
        model.addAttribute("updatePerson",personServices.getById(id));
        return "update";
    }

    @PatchMapping("{id}/update")
    public String update(@ModelAttribute("updatePerson")Person person){
        personServices.update(person);
        return "redirect:/person";
    }



}
