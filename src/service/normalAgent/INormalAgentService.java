package service.normalAgent;

import java.util.List;

public interface INormalAgentService {
    double getTotalAnnualSalary(int agentId);
    double maxPaymentAgent(int agentId);
    double LowestPayout(int agentId);
    List<Double> getAgentPaymentByAgentId(int agentID);
    double sumPaymentToAgent(int agentID);
}
