package controller.normalAgent;

import controller.agent.ResponsableController;
import model.Agent;
import usecases.normalAgent.NormalAgentUseCase;

import java.util.List;

public class NormalAgentController {

    private ResponsableController responsableController;

    private NormalAgentUseCase normalAgentUseCase;

    public NormalAgentController(){
        this.normalAgentUseCase = new NormalAgentUseCase();
        this.responsableController = new ResponsableController();
    }

    public double getTotalAnnualSalary(int agentId){
        return normalAgentUseCase.getTotalAnnualSalary(agentId);
    }

    public double getMaxPayment(int agentId){
        return normalAgentUseCase.getMaxPayment(agentId);
    }

    public double LowestPayout(int agentId){
        return normalAgentUseCase.LowestPayout(agentId);
    }

    public Agent getinfoPerso(String name , String lastName)
    {
        Agent agent = responsableController.getAgentByNameAndLastName(lastName , name);
        return agent;
    }

    public List<Double> getAgentPaymentByAgentId(int agentID){
        return normalAgentUseCase.getAgentPaymentByAgentId(agentID);
    }

    public double sumPaymentToAgent(int agentID){
        return normalAgentUseCase.sumPaymentToAgent(agentID);
    }

}
