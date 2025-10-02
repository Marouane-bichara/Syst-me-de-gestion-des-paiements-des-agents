package usecases.agent;

import model.Agent;
import model.Payment;
import service.responsable.ResponsableService;

import java.util.List;

public class ResponsableUseCase implements IResponsableService{

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


    public Payment getPaymentById(int id)
    {
        Payment rs = agentService.getPaymentById(id);
        return rs;
    }



}
