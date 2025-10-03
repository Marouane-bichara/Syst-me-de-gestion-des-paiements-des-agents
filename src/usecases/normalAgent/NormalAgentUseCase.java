package usecases.normalAgent;

import service.normalAgent.NormalAgentService;

import java.util.List;

public class NormalAgentUseCase implements INormalAgentUseCase{

    private NormalAgentService normalAgentService;

    public NormalAgentUseCase()
    {
        this.normalAgentService = new NormalAgentService();
    }

    public double getTotalAnnualSalary(int agentId){
        return normalAgentService.getTotalAnnualSalary(agentId);
    }

    public double getMaxPayment(int agentId){
            return normalAgentService.maxPaymentAgent(agentId);
    }

    public double LowestPayout(int agentId){
        return normalAgentService.LowestPayout(agentId);
    }

    public List<Double> getAgentPaymentByAgentId(int agentID){
        return normalAgentService.getAgentPaymentByAgentId(agentID);
    }

    public double sumPaymentToAgent(int agentID){
        return normalAgentService.sumPaymentToAgent(agentID);
    }
}
