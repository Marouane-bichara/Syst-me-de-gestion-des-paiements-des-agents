package controller.agent;

import model.Agent;
import model.Payment;
import usecases.agent.*;

import java.util.List;
import java.util.Map;

public class ResponsableController {

    private ResponsableUseCase responsableUseCase;



    public ResponsableController()
    {
        this.responsableUseCase = new ResponsableUseCase();

    }

    public String  addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String value = responsableUseCase.addAgent(nom , prenom , email , motDePasse , type , departementName , id);

        return  value;
    }

    public String updateAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String resault = responsableUseCase.updateAgentUseCase(nom  , prenom , email , motDePasse , type, departementName , id);
        return  resault;
    }

    public Agent getAgentByNameAndLastName(String lastname , String name )
    {
        Agent agent = responsableUseCase.getAgentByNameAndLastname(lastname , name);
        return agent;
    }

    public String deleteAgentById(int id)
    {
        String resault = responsableUseCase.deleteAgentById(id);
        return resault;
    }

    public List<Agent> getAllAgentsWithoutDepartements(){
        return responsableUseCase.getAllAgentsWithoutDepartements();
    }

    public List<Agent> getallAgentWithDepartements(){
        return responsableUseCase.getAllAgentsWithDepartements();
    }

    public String addPayment(Payment payment)
    {
        return responsableUseCase.addPayment(payment);
    }

    public String updatePayment(Payment payment)
    {
        return responsableUseCase.updatePayment(payment);
    }

    public Payment getPaymentById(int id)
    {
        return responsableUseCase.getPaymentById(id);
    }

    public String deletePayment(int id)
    {
        return responsableUseCase.deletePayment(id);
    }

    public double getTotalPaymentsByDepartment(int departmentId)
    {
        double rs = responsableUseCase.getTotalPaymentsByDepartment(departmentId);
        return rs;
    }

    public double getAverageSalaryByDepartment(int departmentId){
        double rs = responsableUseCase.getAverageSalaryByDepartment(departmentId);
        return rs;
    }

    public Map<String, Double> getAgentsRankingByTotalPayments(Agent agent){
        return responsableUseCase.getAgentsRankingByTotalPayments(agent);
    }

    public boolean getAgentByEmail(String email){
        return responsableUseCase.getAgentByEmail(email);
    }

}
