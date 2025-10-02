package usecases.directure;

import model.Agent;
import model.Payment;

import java.util.List;
import java.util.Map;

public interface IDirectureUseCase {

    String addDepartement(String name);
    String addNewRespDep(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement);
    String deleteDepartement(String name);
    List<Agent> getAgentsByDepartements(String name);
    Payment getPaymentById(int id);
    String updatePayment(Payment payment);
    String deletePayment(int id);
    Map<String , Integer> getAllDepartementsWithoutTotal();
    int getTotalType(String type);
    int getTotalPayments();

}
