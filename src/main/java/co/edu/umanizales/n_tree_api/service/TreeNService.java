package co.edu.umanizales.n_tree_api.service;

import co.edu.umanizales.n_tree_api.exceptions.TreeNException;
import co.edu.umanizales.n_tree_api.model.Person;
import co.edu.umanizales.n_tree_api.model.TreeN;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TreeNService {
    private TreeN treeN;

    public TreeNService() {
         treeN = new TreeN();
     }

     @PostConstruct
     private void init() {
        Person carloaiza = new Person("123","Carlos",
                "Loaiza",'M',(byte)46);
         try {
             treeN.add(carloaiza,null);
         } catch (TreeNException e) {
             throw new RuntimeException(e);
         }
     }

}
