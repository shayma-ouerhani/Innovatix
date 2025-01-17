package pi.innovatix.innovatix.services;
import pi.innovatix.innovatix.entities.Virement;

import pi.innovatix.innovatix.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceVirement implements IServiceVirement <Virement> {

    private Connection connection;
    public ServiceVirement() {
        connection = MyDatabase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Virement virement) throws SQLException {
        String req = "INSERT INTO virement "
                + "(compte_id, user_id, nomet_prenom, type_virement, transferez_a, num_beneficiare, "
                + "montant, cin, rib, email, decision_v, actions_v, actions_em, photo_cin_v, phone_number) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, virement.getCompte_id());
            ps.setInt(2, virement.getUser_id());
            ps.setString(3, virement.getNomet_prenom());
            ps.setString(4, virement.getType_virement());
            ps.setString(5, virement.getTransferez_a());
            ps.setInt(6, virement.getNum_beneficiare());
            ps.setInt(7, virement.getMontant());
            ps.setInt(8, virement.getCin());
            ps.setInt(9, virement.getRib());
            ps.setString(10, virement.getEmail());
            ps.setString(11, virement.getDecision_v());
            ps.setInt(12, virement.getActions_v());
            ps.setInt(13, virement.getActions_em());
            ps.setString(14, virement.getPhoto_cin_v());
            ps.setString(15, virement.getPhone_number());

            ps.executeUpdate();
            System.out.println("Virement ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void modifier(Virement virement) throws SQLException {
        try {
            String req = "UPDATE virement SET compte_id=?, user_id=?, nomet_prenom=?, type_virement=?, "
                    + "transferez_a=?, num_beneficiare=?, montant=?, cin=?, rib=?, email=?, decision_v=?, "
                    + "actions_v=?, actions_em=?, photo_cin_v=?, phone_number=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, virement.getCompte_id());
            ps.setInt(2, virement.getUser_id());
            ps.setString(3, virement.getNomet_prenom());
            ps.setString(4, virement.getType_virement());
            ps.setString(5, virement.getTransferez_a());
            ps.setInt(6, virement.getNum_beneficiare());
            ps.setInt(7, virement.getMontant());
            ps.setInt(8, virement.getCin());
            ps.setInt(9, virement.getRib());
            ps.setString(10, virement.getEmail());
            ps.setString(11, virement.getDecision_v());
            ps.setInt(12, virement.getActions_v());
            ps.setInt(13, virement.getActions_em());
            ps.setString(14, virement.getPhoto_cin_v());
            ps.setString(15, virement.getPhone_number());
            ps.setInt(16, virement.getId());

            ps.executeUpdate();
            System.out.println("Virement avec ID " + virement.getId() + " modifié !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM virement WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Virement avec ID " + id + " supprimé !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public List<Virement> afficher() throws SQLException {
        List<Virement> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM virement";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Virement(rs.getInt("id"), rs.getInt("compte_id"),
                        rs.getInt("user_id"), rs.getString("nomet_prenom"),
                        rs.getString("type_virement"), rs.getString("transferez_a"),
                        rs.getInt("num_beneficiare"), rs.getInt("montant"),
                        rs.getInt("cin"), rs.getInt("rib"), rs.getString("email"),
                        rs.getString("decision_v"), rs.getInt("actions_v"),
                        rs.getInt("actions_em"), rs.getString("photo_cin_v"),
                        rs.getString("phone_number")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    }

