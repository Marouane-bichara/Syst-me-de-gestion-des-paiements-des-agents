package dao;

import model.Payment;
import model.TypePyment;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAOImpl {



    int addPayment(Payment payment)
    {
        String sql = "INSERT INTO payments (type, amount, datePaiement, motif, agent_id, conditionValidee) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1 , payment.getTypePyment().name());
            stmt.setDouble(2, payment.getAmount());
            stmt.setDate(3 , new java.sql.Date(payment.getDate().getTime()));
            stmt.setString(4, payment.getMotif());
            stmt.setInt(5, payment.getAgent().getId());
            stmt.setInt(6, payment.isConditionValidee());

            int rs = stmt.executeUpdate();
            return rs;
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error while Adding payment",e);
        }

    }
}
