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
    List<Agent> getAgentsBydepartement(String name);





//    List<Agent> getAllAgents();

    //
//    List<Agent> getAgentsByDepartement(int idDepartement);
    //
//    List<Agent> getAgentsByType(TypeAgent type);
//
//    void addPaymentToAgent(int agentId, Payment payment);
//    List<Payment> getPaymentsByAgent(int agentId);
//
//    List<Payment> getPaymentsByAgentAndType(int agentId, String typePayment);
//
//    double getTotalPaymentsByAgent(int agentId);
//    double getAveragePaymentsByAgent(int agentId);
//
//    List<Payment> getAnomalousPaymentsByAgent(int agentId);
}
