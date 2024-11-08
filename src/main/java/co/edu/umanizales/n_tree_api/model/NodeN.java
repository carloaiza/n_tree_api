package co.edu.umanizales.n_tree_api.model;

import co.edu.umanizales.n_tree_api.exceptions.TreeNException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NodeN {
    private Person data;
    private List<NodeN> children;

    public NodeN(Person data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public NodeN findParentById(String id) throws TreeNException {
        if(this.data.getIdentification().equals(id)) {
            return this;
        }
        else{
            for (NodeN child : this.children) {
                NodeN found = child.findParentById(id);
                if(found != null) {
                    return found;
                }
            }
            throw new TreeNException("El padre con id:" + id+" NO existe");
        }
    }

    public void validatePersonExist(String id) throws TreeNException {
        if(this.data.getIdentification().equals(id)) {
            throw new TreeNException("La persona ya existe");
        }
        else{
            for (NodeN child : this.children) {
               child.validatePersonExist(id);
            }
        }
    }

}
