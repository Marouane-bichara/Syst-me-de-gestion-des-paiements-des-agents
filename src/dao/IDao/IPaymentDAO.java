package dao.IDao;

import model.Agent;
import model.Payment;
import model.TypePyment;

import java.util.List;
import java.util.Map;

public interface IPaymentDAO {
    int addPayment(Payment payment);

//    List<Payment> getAllPayments();
    int updatePayment(Payment payment);
    Payment getPaymentById(int id);
    int deletePayment(int id);
    int sizeType(String type);
    int paymentSize();
    double getTotalPaymentsByDepartment(int departmentId);
    double getAverageSalaryByDepartment(int departmentId);
    Map<String, Double> getAgentsRankingByTotalPayments(Agent agent);
    double getTotalAnnualSalary(int agentId);
    double highestPayout(int agentId);
     double LowestPayout(int agentId);
    List<Double> getAgentPaymentByAgentId(int agentID);
    double sumPaymentToAgent(int agentID);
//    List<Payment> getPaymentsByType(TypePyment type);
//    List<Payment> getPaymentsByAgent(int agentId);
//
//    double getTotalPayments();
//    double getAveragePayments();

//    List<Payment> getAnomalousPayments();
}
