package dao.IDao;

import model.Payment;
import model.TypePyment;

import java.util.List;

public interface IPaymentDAO {
    int addPayment(Payment payment);

//    List<Payment> getAllPayments();
    int updatePayment(Payment payment);
    Payment getPaymentById(int id);
    int deletePayment(int id);
    int sizeType(String type);
    int paymentSize();
//
//    List<Payment> getPaymentsByType(TypePyment type);
//    List<Payment> getPaymentsByAgent(int agentId);
//
//    double getTotalPayments();
//    double getAveragePayments();

//    List<Payment> getAnomalousPayments();
}
