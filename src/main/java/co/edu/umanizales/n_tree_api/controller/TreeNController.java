package co.edu.umanizales.n_tree_api.controller;

import co.edu.umanizales.n_tree_api.exceptions.TreeNException;
import co.edu.umanizales.n_tree_api.model.Person;
import co.edu.umanizales.n_tree_api.service.TreeNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tree_n")
public class TreeNController {
    @Autowired
    private TreeNService treeNService;

    @GetMapping
    public Object showTree(){
        return treeNService.getTreeN().getRoot();
    }

    @PostMapping
    public String addPerson(@RequestBody Person person,
                            @RequestParam String parentId) throws TreeNException {
        treeNService.getTreeN().add(person,parentId);
        return "Added person";
    }
}
