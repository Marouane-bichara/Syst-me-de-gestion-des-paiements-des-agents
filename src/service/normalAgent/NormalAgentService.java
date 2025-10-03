package service.normalAgent;

import dao.PaymentDAOImpl;

import java.util.List;

public class NormalAgentService implements INormalAgentService{


    private PaymentDAOImpl paymentDAO;

    public NormalAgentService()
    {
        this.paymentDAO = new PaymentDAOImpl();
    }

    public double getTotalAnnualSalary(int agentId){
        return paymentDAO.getTotalAnnualSalary(agentId);
    }

    public double maxPaymentAgent(int agentId)
    {
        return paymentDAO.highestPayout(agentId);
    }

    public double LowestPayout(int agentId){
        return paymentDAO.LowestPayout(agentId);
    }

    public List<Double> getAgentPaymentByAgentId(int agentID){
        return paymentDAO.getAgentPaymentByAgentId(agentID);
    }

    public double sumPaymentToAgent(int agentID){
        return paymentDAO.sumPaymentToAgent(agentID);
    }
}
