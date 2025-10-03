package controller.deirecture;

import model.Agent;
import model.Departement;
import model.Payment;
import model.TypeAgent;
import usecases.agent.ResponsableUseCase;
import usecases.directure.DirectureUseCase;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectureController {

    private DirectureUseCase directureUseCase;
    private ResponsableUseCase responsableUseCase;

    public DirectureController()
    {
        this.directureUseCase = new DirectureUseCase();
        this.responsableUseCase = new ResponsableUseCase();

    }



    public List<Agent> getAgentsBydepartement(String name)
    {
        return directureUseCase.getAgentsByDepartements(name);
    }

    public String addDepartement(String name)
    {
        return directureUseCase.addDepartement(name);
    }

    public String addnewRespo(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement)
    {
        return  directureUseCase.addNewRespDep( nom,  prenom,  email,  motDePasse,  typeAgent,   nameDepartement);
    }

    public String deleteDepartement(String name)
    {
        return directureUseCase.deleteDepartement(name);
    }


    public String addPaymentToDirecture(Payment payment)
    {
        return directureUseCase.addPaymentToDirecture(payment);
    }

    public Agent getAgentByNameAndLastName(String lastname , String name  ){
        return directureUseCase.getAgentByNameAndLastName(lastname , name);
    }

    public Payment getPaymentById(int id)
    {
        return directureUseCase.getPaymentById(id);
    }

    public String updatePayment(Payment payment)
    {
        return directureUseCase.updatePayment(payment);
    }


    public String deletePayment(int id)
    {
        return directureUseCase.deletePayment(id);
    }

    public Map<String , Integer> getAllDepartementsWithTotal()
    {
        return directureUseCase.getAllDepartementsWithoutTotal();
    }

    public int getTotalType(String type){
        return directureUseCase.getTotalType(type);
    }


    public int getTotalPayments(){
        return directureUseCase.getTotalPayments();
    }


    public double calculeBytotal(String type){
        int sizeType = this.getTotalType(type);
        int sizePayments = this.getTotalPayments();

        return ((double) sizeType / sizePayments) * 100;
    }


     public int countAgents()
     {
         return directureUseCase.countAgents();
     }

     public int countDepartements(){
        return directureUseCase.countDepartements();
     }


     public String assignExestingAgentToDepartement(String agentName , String agentLastName , String DepartementName)
     {
          String rs = directureUseCase.assignExestingAgentToDepartement(agentName , agentLastName , DepartementName);
          return rs;
     }

}
