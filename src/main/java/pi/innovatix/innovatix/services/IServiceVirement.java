package pi.innovatix.innovatix.services;

import java.sql.SQLException;
import java.util.List;

public interface IServiceVirement <Virement>  {
    public void ajouter(Virement v ) throws SQLException;
    public void modifier(Virement v ) throws SQLException;
    public void supprimer(int id) throws SQLException;
    public List<Virement> afficher() throws SQLException;
}
