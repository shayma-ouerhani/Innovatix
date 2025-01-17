package pi.innovatix.innovatix.services;

import pi.innovatix.innovatix.entities.Cheque;
import pi.innovatix.innovatix.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCheque implements  IServiceCheque <Cheque> {
    private Connection connection;
    public Statement statement;

    public ServiceCheque() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Cheque cheque) throws SQLException {
        String req = "INSERT INTO cheque "
                + "(compte_id, user_id, beneficiaire, montant, telephone, email, cin, nom_prenom, date, decision, actions_c, actions_e, photo_cin, signature_id, signer_id, pdf_sans_signature) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, cheque.getCompte_id());
            ps.setInt(2, cheque.getUser_id());
            ps.setString(3, cheque.getBeneficiaire());
            ps.setDouble(4, cheque.getMontant());
            ps.setInt(5, cheque.getTelephone());
            ps.setString(6, cheque.getEmail());
            ps.setInt(7, cheque.getCin());
            ps.setString(8, cheque.getNom_prenom());
            ps.setObject(9, cheque.getDate());
            ps.setString(10, cheque.getDecision());
            ps.setInt(11, cheque.getActions_c());
            ps.setInt(12, cheque.getActions_e());
            ps.setString(13, cheque.getPhoto_cin());
            ps.setString(14, cheque.getSignature_id());
            ps.setString(15, cheque.getSigner_id());
            ps.setString(16, cheque.getpdf_sans_signature());

            ps.executeUpdate();
            System.out.println("Chèque ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void modifier(Cheque cheque ) throws SQLException {
        try {
            String req = "UPDATE cheque SET compte_id=?, user_id=?, beneficiaire=?, montant=?, telephone=?, email=?, cin=?, nom_prenom=?, date=?, decision=?, actions_c=?, actions_e=?, photo_cin=?, signature_id=?, signer_id=?, pdf_sans_signature=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, cheque.getCompte_id());
            ps.setInt(2, cheque.getUser_id());
            ps.setString(3, cheque.getBeneficiaire());
            ps.setDouble(4, cheque.getMontant());
            ps.setInt(5, cheque.getTelephone());
            ps.setString(6, cheque.getEmail());
            ps.setInt(7, cheque.getCin());
            ps.setString(8, cheque.getNom_prenom());
            ps.setObject(9, cheque.getDate());
            ps.setString(10, cheque.getDecision());
            ps.setInt(11, cheque.getActions_c());
            ps.setInt(12, cheque.getActions_e());
            ps.setString(13, cheque.getPhoto_cin());
            ps.setString(14, cheque.getSignature_id());
            ps.setString(15, cheque.getSigner_id());
            ps.setString(16, cheque.getpdf_sans_signature());
            ps.setInt(17, cheque.getId());

            ps.executeUpdate();
            System.out.println("Chèque avec ID " + cheque.getId() + " modifié !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM cheque WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Chèque avec ID " + id + " supprimé !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public List<Cheque> afficher() throws SQLException {
        List<Cheque> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM cheque";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Cheque(rs.getInt("id"), rs.getInt("compte_id"),
                        rs.getInt("user_id"), rs.getString("beneficiaire"),
                        rs.getDouble("montant"), rs.getInt("telephone"),
                        rs.getString("email"), rs.getInt("cin"),
                        rs.getString("nom_prenom"), rs.getObject("date", Date.class),
                        rs.getString("decision"), rs.getInt("actions_c"),
                        rs.getInt("actions_e"), rs.getString("photo_cin"),
                        rs.getString("signature_id"), rs.getString("signer_id"),
                        rs.getString("pdf_sans_signature")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    }

