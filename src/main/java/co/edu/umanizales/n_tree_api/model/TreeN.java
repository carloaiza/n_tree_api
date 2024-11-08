package co.edu.umanizales.n_tree_api.model;

import co.edu.umanizales.n_tree_api.exceptions.TreeNException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TreeN {
    private NodeN root;
    private int size;


    public void add(Person person, String parentId) throws TreeNException {
        if (root == null) {
            root = new NodeN(person);
        }
        else{
            NodeN parent = root.findParentById(parentId);
            root.validatePersonExist(person.getIdentification());
            parent.getChildren().add(new NodeN(person));
            this.size++;
        }
    }


}
