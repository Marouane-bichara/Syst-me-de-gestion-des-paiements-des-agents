package dao.IDao;

import model.Agent;
import model.Departement;
import model.Payment;
import model.TypeAgent;

import java.util.List;
import java.util.Optional;

public interface IAgentDao {
    int addAgent(Agent agent);
    int updateAgent(Agent agent);
    int deleteAgentbyId(int id);
    Agent getAgentById(int agentId);
    int assignAgentToDepartement(int agentId, int departementId);
    Agent getAgentBynameAndlastname( String lastname , String name );
    List<Agent> getAllAgents();
    List<Agent> getAllAgentsWithoutDepartements();
    Agent authResponsable(String email , String password);
    Agent authDirecture(String email , String password);
    Agent authAgentNormal(String email , String password);
    List<Agent> getAgentsBydepartement(String name);
    int countAgents();
    Agent getResponsableByDepartementID(int idDepartement);
    boolean getAgentByEmail(String email);
}
