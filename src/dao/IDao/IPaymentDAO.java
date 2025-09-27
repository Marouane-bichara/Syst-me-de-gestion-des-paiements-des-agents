package dao.IDao;

import model.Payment;
import model.TypePyment;

import java.util.List;

public interface IPaymentDAO {
    void addPayment(Payment payment);
    List<Payment> getAllPayments();
    void updatePayment(Payment payment);
    void deletePayment(int id);

    List<Payment> getPaymentsByType(TypePyment type);
    List<Payment> getPaymentsByAgent(int agentId);

    double getTotalPayments();
    double getAveragePayments();

    List<Payment> getAnomalousPayments();
}
