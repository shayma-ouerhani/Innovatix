package pi.innovatix.innovatix.services;

import java.sql.SQLException;
import java.util.List;

public interface IServiceCompte <C>  {
    public void ajouter(C c) throws SQLException;
    public void modifier(C c) throws SQLException;
    public void supprimer(int id) throws SQLException;
    public List<C> afficher() throws SQLException;
}
