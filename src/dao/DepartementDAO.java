package dao;

import dao.IDao.IDepartementDAo;
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

public class DepartementDAO implements IDepartementDAo {


    public int addDepartement(Departement departement){
        String sql = "INSERT INTO departements (name) VALUES (?)";
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, departement.getName());


            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding departement", e);
        }
    }



    public List<Departement> getAllDepartements(){
        List<Departement> departements = new ArrayList<>();

        String sql = "SELECT * FROM departements";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            System.out.println(resultSet.getClass());
            while(resultSet.next())
            {
                int departementId = resultSet.getInt("id");
                String departementName = resultSet.getString("name");
                ArrayList<Agent> agents = new ArrayList<>();

                String sqlAgnets = "SELECT * FROM agents WHERE departement_id = ?";
                try (PreparedStatement stmtAgent = conn.prepareStatement(sqlAgnets)) {

                    stmtAgent.setInt(1 , departementId);
                    ResultSet rsAgents = stmtAgent.executeQuery();
                    while (rsAgents.next())
                    {
                        TypeAgent typeAgent = TypeAgent.valueOf(rsAgents.getString("type"));

                        Agent agent = new Agent(
                                rsAgents.getString("nom"),
                                rsAgents.getString("prenom"),
                                rsAgents.getString("email"),
                                rsAgents.getString("motDePasse"),
                                rsAgents.getInt("id"),
                                typeAgent,
                                null,
                                new ArrayList<>()
                        );

                        agents.add(agent);
                    }
                }
                Departement departement = new Departement(resultSet.getInt("id") , resultSet.getString("name") , agents);

               departements.add(departement) ;
            }

            return departements;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding departement", e);
        }
    }

    public Departement getDepatrmentById(int id){
        String sql = "SELECT * from departements where id = ?";

        try{
            Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1 , id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                Departement departement = new Departement(rs.getInt("id") , rs.getString("name") , new ArrayList<>());
                return departement;
            }
            return null;
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error getting an departement", e);
        }
    }


    public Departement getDepartementByName(String name){
        String sql = "select * from departements where name = ?";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1 ,name);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Departement departement = new Departement(rs.getInt("id") , rs.getString("name") , new ArrayList<>());
                return  departement;
            }
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error getting a departement");
        }
    }

    public int DeleteDepartementByname(String name){
        String sql = "delete from departements where name = ?";
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1 , name);

            int rows = stmt.executeUpdate();

            return rows;


        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("error deleting an an departement");
        }
    }
}
