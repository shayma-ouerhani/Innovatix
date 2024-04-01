package pi.innovatix.innovatix.services;

import java.sql.SQLException;
import java.util.List;

public interface IServiceCheque <Cheque>{
    public void ajouter(Cheque cheque) throws SQLException;
    public void modifier(Cheque cheque) throws SQLException;
    public void supprimer(int id) throws SQLException;
    public List<Cheque> afficher() throws SQLException;
}
