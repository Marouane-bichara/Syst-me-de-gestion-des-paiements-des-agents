package dao.IDao;

import model.Agent;
import model.Payment;
import model.TypeAgent;

import java.util.List;
import java.util.Optional;

public interface IAgentDao {
    int addAgent(Agent agent);
//    List<Agent> getAllAgents();
    int updateAgent(Agent agent);
    int deleteAgentbyId(int id);
    Agent getAgentById(int agentId);
//
//    List<Agent> getAgentsByDepartement(int idDepartement);
    int assignAgentToDepartement(int agentId, int departementId);
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
