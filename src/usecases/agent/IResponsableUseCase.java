package usecases.agent;

import model.Agent;
import model.Payment;

import java.util.List;
import java.util.Map;

public interface IResponsableUseCase {
    String addPayment(Payment payment);

    String deleteAgentById(int id);

    List<Agent> getAllAgentsWithoutDepartements();

    Agent getAgentByNameAndLastname(String lastname, String name);

    List<Agent> getAllAgentsWithDepartements();

    String updateAgentUseCase(String nom, String prenom, String email, String motDePasse, String type, String departementName, int id);

    String updatePayment(Payment payment);

    Payment getPaymentById(int id);

    double getTotalPaymentsByDepartment(int departmentId);

    double getAverageSalaryByDepartment(int departmentId);

    Map<String, Double> getAgentsRankingByTotalPayments(Agent agent);

    boolean getAgentByEmail(String email);

}