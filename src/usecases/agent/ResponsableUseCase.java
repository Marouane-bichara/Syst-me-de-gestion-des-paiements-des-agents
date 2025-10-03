package usecases.agent;

import model.Agent;
import model.Payment;
import service.responsable.ResponsableService;

import java.util.List;
import java.util.Map;

public class ResponsableUseCase implements IResponsableUseCase {

    private ResponsableService agentService;

    public ResponsableUseCase()
    {

        this.agentService = new ResponsableService();
    }


    public String deletePayment(int id)
    {
        return agentService.deletePayment(id);
    }

    public String updatePayment(Payment payment)
    {
        return agentService.updatePayment(payment);
    }


    public String addPayment(Payment payment)
    {
        return agentService.addPaymentToAgent(payment);
    }
    public String addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String value = agentService.addAgent(nom , prenom , email , motDePasse , type , departementName , id);
        return  value;
    }

    public double getAverageSalaryByDepartment(int departmentId){
        double rs = agentService.getAverageSalaryByDepartment(departmentId);
        return rs;
    }


    public String deleteAgentById(int id)
    {

        String resault = agentService.deleteAgentbyId(id);
        return resault;
    }
    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentService.getAllAgentsWithoutDepartements();
    }



    public Agent getAgentByNameAndLastname(String lastname , String name )
    {

        Agent agent =  agentService.getAgentByNameAndLastName(lastname ,name);
        return agent;
    }
    public List<Agent> getAllAgentsWithDepartements(){
        return agentService.getallAgentsWithDepartements();
    }

    public String updateAgentUseCase(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String resault = agentService.updateAgent(nom , prenom , email, motDePasse , type , departementName, id);

        return resault;
    }

    public boolean getAgentByEmail(String email){
        return agentService.getAgentByEmail(email);
    }
    public Payment getPaymentById(int id)
    {
        Payment rs = agentService.getPaymentById(id);
        return rs;
    }

    public double getTotalPaymentsByDepartment(int departmentId)
    {
        double rs = agentService.getTotalPaymentsByDepartment(departmentId);
        return rs;
    }

    public Map<String, Double> getAgentsRankingByTotalPayments(Agent agent){
        return agentService.getAgentsRankingByTotalPayments(agent);
    }

}
