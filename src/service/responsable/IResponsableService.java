package service.responsable;

import model.Agent;
import model.Payment;

import java.util.List;
import java.util.Map;

public interface IResponsableService {
    String addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id);
    String updateAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id);
    Agent getAgentByNameAndLastName(String lastname , String name  );
    String deleteAgentbyId(int id);
    List<Agent> getAllAgentsWithoutDepartements();
    List<Agent> getallAgentsWithDepartements();
    String addPaymentToAgent(Payment payment);
    String updatePayment(Payment payment);
    Payment getPaymentById(int id);
    String deletePayment(int id);
    double getTotalPaymentsByDepartment(int departmentId);
    double getAverageSalaryByDepartment(int departmentId);
    Map<String, Double> getAgentsRankingByTotalPayments(Agent agent);
    boolean getAgentByEmail(String email);
}
