package usecases.normalAgent;

import java.util.List;

public interface INormalAgentUseCase {



    double getTotalAnnualSalary(int agentId);
    double getMaxPayment(int agentId);
    double LowestPayout(int agentId);
    List<Double> getAgentPaymentByAgentId(int agentID);
    double sumPaymentToAgent(int agentID);
    //    double getTotalAnnualSalaryUseCase(int agentId);

}
