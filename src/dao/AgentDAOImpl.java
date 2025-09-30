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
import java.util.List;

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

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
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


    public Agent getAgentBynameAndlastname( String lastname , String name )
    {
        String sql = "select * from agents where nom = ? and prenom = ?";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lastname);
            stmt.setString(2, name);
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
            throw new RuntimeException("Error founding an agent");
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



    public List<Agent> getAllAgentsWithoutDepartements()
    {
        List<Agent> allAgents = new ArrayList<>();

        String sql = "SELECT * from agents";
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Agent agent = new Agent(rs.getString("nom") , rs.getString("prenom") , rs.getString("email") , rs.getString("motDePasse") , rs.getInt("id") , TypeAgent.valueOf(rs.getString("type")) , null , new ArrayList<>());
                allAgents.add(agent);
            }
            return allAgents;

        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error Getting an agent", e);
        }
    }

    @Override


    public List<Agent> getAllAgents(){

        List<Agent> allAgents = new ArrayList<>();

        String sql = "SELECT * FROM agents inner join departements on departements.id = agents.departement_id";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Departement departement = new Departement(rs.getInt("id") , rs.getString("name") , new ArrayList<>());
                Agent agent = new Agent(rs.getString("nom") , rs.getString("prenom") , rs.getString("email") , rs.getString("motDePasse") , rs.getInt("id") , TypeAgent.valueOf(rs.getString("type")) , departement , new ArrayList<>());

                allAgents.add(agent);
            }

            return allAgents;
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error Getting agents.");
        }

    }


    public Agent authDirecture(String email , String password)
    {
        String sql = "select * from agents where email = ? and motDePasse = ? ";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            DepartementDAO departementDAO = new DepartementDAO();

            if(rs.next())
            {
                Agent agent = new Agent(rs.getString("nom") , rs.getString("prenom") , rs.getString("email") , rs.getString("motDePasse") , rs.getInt("id") , TypeAgent.valueOf(rs.getString("type")) , null , new ArrayList<>());
                return agent;
            }
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error getting this agent",e);
        }
    }

    public Agent authResponsable(String email , String password){

        String sql = "select * from agents where email = ? and motDePasse = ? ";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            DepartementDAO departementDAO = new DepartementDAO();

            if(rs.next())
            {
                int departementId = rs.getInt("departement_id");
                Departement dep = departementDAO.getDepatrmentById(departementId);
                Agent agent = new Agent(rs.getString("nom") , rs.getString("prenom") , rs.getString("email") , rs.getString("motDePasse") , rs.getInt("id") , TypeAgent.valueOf(rs.getString("type")) , dep , new ArrayList<>());
                return agent;
            }
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error getting this agent",e);
        }
    }

    public List<Agent> getAgentsBydepartement(String name)
    {
        List<Agent> agents = new ArrayList<>();
       String sql = "select * from agents inner join departements on departements.id = agents.departement_id where departements.name = ?";
       try{
           Connection conn = DbConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);

           stmt.setString(1 , name);
           ResultSet rs =  stmt.executeQuery();

           while(rs.next())
           {
               Departement dep = new Departement(rs.getInt("id") , rs.getString("name") , new ArrayList<>());
               Agent agent = new Agent(rs.getString("nom") , rs.getString("prenom") , rs.getString("email") , rs.getString("motDePasse") , rs.getInt("id") , TypeAgent.valueOf(rs.getString("type")) , dep , new ArrayList<>());
               agents.add(agent);
           }

           return agents;

       }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error Getting agents from this departement" , e);
        }
    }


}






