package dao;

import dao.IDao.IPaymentDAO;
import model.*;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements IPaymentDAO {



    public int addPayment(Payment payment)
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


    public Payment getPaymentById(int id)
    {
        String sql = "select * from payments inner join agents on payments.agent_id = agents.id where payments.id = ?";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1 , id);

            ResultSet rs = stmt.executeQuery();



            if(rs.next())
            {
                AgentDAOImpl agentDAO = new AgentDAOImpl();

                Agent agent = agentDAO.getAgentBynameAndlastname(rs.getString("nom") , rs.getString("prenom"));

                Payment payment = new Payment(rs.getDate("datePaiement") , id , TypePyment.valueOf(rs.getString("type")) , rs.getDouble("amount") , rs.getString("motif") , agent , rs.getInt("conditionValidee"));

                return payment;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error while getting payment",e);
        }
    }


    public int updatePayment(Payment payment) {
        String sql = "UPDATE payments SET type = ?, amount = ?, datePaiement = ?, motif = ?, agent_id = ?, conditionValidee = ? " +
                "WHERE id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, payment.getTypePyment().name());
            stmt.setDouble(2, payment.getAmount());
            stmt.setDate(3, new java.sql.Date(payment.getDate().getTime()));
            stmt.setString(4, payment.getMotif());
            stmt.setInt(5, payment.getAgent().getId());
            stmt.setInt(6, payment.isConditionValidee());
            stmt.setInt(7, payment.getId());

            int n =  stmt.executeUpdate();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating payment", e);
        }
    }


    public int deletePayment(int id) {
        String sql = "DELETE FROM payments WHERE id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting payment", e);
        }
    }

    public int sizeType(String type){
        String sql = "select count(type) AS typeTotal from payments where type = ? and payments.conditionValidee = 1";

        try {

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 ,type);
            ResultSet rs = stmt.executeQuery();
            int totalType;
            while (rs.next()){
                totalType = rs.getInt("typeTotal");
                return totalType;
            }
            return 0;
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Error while getting the total of the type" , e);
        }
    }

    public int paymentSize(){
        String sql = "select COUNT(payments.id) as paymentsTotal from payments where payments.conditionValidee = 1";

        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int size = rs.getInt("paymentsTotal");
                return size;
            }
           return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
