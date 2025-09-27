package dao;

import dao.IDao.IAgentDao;
import model.Agent;
import model.Departement;
import model.TypeAgent;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgentDAOImpl implements IAgentDao {


    @Override
    public int addAgent(Agent agent){
        String sql = "INSERT INTO agents (nom, prenom,email,motDePasse, type , departement_id) VALUES (?, ?, ?, ? , ? , ?)";
        try  {
            Connection conn = DbConnection.getConnection();
//            System.out.println(conn.isClosed());
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, agent.getNom());
            stmt.setString(2, agent.getPrenom());
            stmt.setString(3, agent.getEmail());
            stmt.setString(4, agent.getMotDePasse());
            stmt.setString(5, agent.getTypeAgent().name());
            stmt.setObject(6, agent.getDepartement() != null ? agent.getDepartement().getId() : null);
            int i = stmt.executeUpdate();
            return i;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding agent", e);
        }
    }
    @Override
    public int updateAgent(Agent agent) {
        String sql = "UPDATE agents SET nom=?, prenom=?, email=?, motDePasse=?, type=?, departement_id=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, agent.getNom());
            stmt.setString(2, agent.getPrenom());
            stmt.setString(3, agent.getEmail());
            stmt.setString(4, agent.getMotDePasse());
            stmt.setString(5, agent.getTypeAgent().name());

            stmt.setInt(6, agent.getDepartement().getId());

            stmt.setInt(7, agent.getId());

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating agent", e);
        }
    }
    @Override
    public Agent getAgentById(int agentId)
    {

        String sql = "SELECT * FROM agents WHERE id = ?";
        try  {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , agentId);
            ResultSet rs = stmt.executeQuery();
            
            DepartementDAO departementDAO = new DepartementDAO();

        if(rs.next())
        {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String email = rs.getString("email");
            String motDePasse = rs.getString("motDePasse");
            String type = rs.getString("type");
            int departementId = rs.getInt("departement_id");

            Departement dep = departementDAO.getDepatrmentById(departementId);

            return new Agent(
                    nom,
                    prenom,
                    email,
                    motDePasse,
                    id,
                    TypeAgent.valueOf(type),
                    dep,
                    new ArrayList<>()
            );

        }
        return null;
        }catch(SQLException e){
        e.printStackTrace();
        throw new RuntimeException("Error updating agent", e);
    }
       
    }

    public int assignAgentToDepartement(int agentId, int departementId){
        String sql = "UPDATE agents SET departement_id = ? WHERE id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 ,departementId);
            stmt.setInt(2 , agentId);

            int rows = stmt.executeUpdate();

            return rows;

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error setting an departement", e);
        }
    }

    public int deleteAgentbyId(int id){
        String sql = "delete from agents where id = ?";
        try{

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1 , id);
            int rows = stmt.executeUpdate();
            return rows;

        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("error deleting an agent" , e);
        }
    }

}






