package service.directure;

import model.Agent;
import model.Payment;

import java.util.List;
import java.util.Map;

public interface IDirectureService {
    List<Agent> getAgentsBydepartement(String name);
    String addDepartement(String name);
    String addNewDepartemntResponsable(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement);
    String deleteDepartement(String name);
    String addPaymentToDirecture(Payment payment);
    Payment getPaymentById(int id);
    Agent getAgentByNameAndLastName(String lastname , String name  );
    String updatePayment(Payment payment);
    String deletePayment(int id);
    Map<String , Integer> getAllDepartementsWithTotal();
    int getTotalType(String type);
    int getTotalPayments();
    int countAgents();
    int countDepartements();
    String assignExestingAgentToDepartement (String agentName , String agentLastName , String DepartementName);

}
