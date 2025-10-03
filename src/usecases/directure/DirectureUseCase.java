package usecases.directure;

import model.Agent;
import model.Payment;
import service.directure.DirectureService;

import java.util.List;
import java.util.Map;

public class DirectureUseCase implements IDirectureUseCase{

    private DirectureService directureService;

    public DirectureUseCase()
    {
        this.directureService = new DirectureService();
    }

    public List<Agent> getAgentsByDepartements(String name)
    {
        return directureService.getAgentsBydepartement(name);
    }


    public String deleteDepartement(String name)
    {
        return directureService.deleteDepartement(name);
    }

    public String addNewRespDep(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement)
    {
        return directureService.addNewDepartemntResponsable(nom,  prenom,  email,  motDePasse,  typeAgent,   nameDepartement);
    }

    public String addDepartement(String name)
    {
        return directureService.addDepartement(name);
    }

    public String addPaymentToDirecture(Payment payment)
    {
        return  directureService.addPaymentToDirecture(payment);
    }

    public Agent getAgentByNameAndLastName(String lastname , String name  ){
        return directureService.getAgentByNameAndLastName(lastname , name);
    }

    public String deletePayment(int id)
    {
        return directureService.deletePayment(id);
    }

    public String updatePayment(Payment payment)
    {
        return directureService.updatePayment(payment);
    }

    public Map<String , Integer> getAllDepartementsWithoutTotal()
    {
        return directureService.getAllDepartementsWithTotal();
    }
    public Payment getPaymentById(int id)
    {
        Payment rs = directureService.getPaymentById(id);
        return rs;
    }

    public int getTotalType(String type){
        return directureService.getTotalType(type);
    }

    public int getTotalPayments(){
        return directureService.getTotalPayments();
    }

    public int countAgents(){
        return directureService.countAgents();
    }

    public int countDepartements(){
        return directureService.countDepartements();
    }

    public String assignExestingAgentToDepartement(String agentName , String agentLastName , String DepartementName){
        return directureService.assignExestingAgentToDepartement(agentName , agentLastName , DepartementName);
    }

}
