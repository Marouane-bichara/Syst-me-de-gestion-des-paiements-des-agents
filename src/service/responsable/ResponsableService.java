package service.responsable;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import dao.IDao.IPaymentDAO;
import dao.PaymentDAOImpl;
import model.Agent;
import model.Departement;
import model.Payment;
import model.TypeAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponsableService  implements IResponsableService{

    private  IAgentDao agentDao;
    private IDepartementDAo departementDAo;
    private IPaymentDAO paymentDAO;

    public ResponsableService()
    {
        this.agentDao = new AgentDAOImpl();
        this.departementDAo = new DepartementDAO();
        this.paymentDAO = new PaymentDAOImpl();
    }

    public String addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id){

        Departement  departement = this.departementDAo.getDepartementByName(departementName);

        Agent agent = new Agent(nom , prenom , email , motDePasse ,id ,TypeAgent.valueOf(type) , departement , new ArrayList<>());

        int rows = agentDao.addAgent(agent);

        if(rows == 0)
        {
            String answear = "Couldnt Add an agent.";
            return  answear;
        }else{
            String answear = "agnet Added";
            return answear;
        }

    }


    public String updateAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        Departement  departement = this.departementDAo.getDepartementByName(departementName);
        Agent agentfound = agentDao.getAgentById(id);

        agentfound.setNom(nom);
        agentfound.setPrenom(prenom);
        agentfound.setEmail(email);
        agentfound.setMotDePasse(motDePasse);
        agentfound.setTypeAgent(TypeAgent.valueOf(type));
        agentfound.setDepartement(departement);

        int rows =  agentDao.updateAgent(agentfound);

        if(rows == 0)
        {
            return "Cant update this agent.";
        }
        if(rows != 0)
        {
            return "Agent updated.";
        }
        else {
            return "Error updating this agent try later.";
        }

    }


    public Agent getAgentByNameAndLastName(String lastname , String name  )
    {
            Agent agent = agentDao.getAgentBynameAndlastname(lastname , name);
            return  agent;
    }

    public String deleteAgentbyId(int id)
    {
        int resault = agentDao.deleteAgentbyId(id);

        if(resault == 0)
        {
            return "Agent can Not be Deleted.";
        }
        if(resault != 0)
        {
            return "Agent Deleted";
        }
        else {
            return  "Error Deleting the Agent Try Later";
        }


    }


    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentDao.getAllAgentsWithoutDepartements();
    }


    public List<Agent> getallAgentsWithDepartements(){
        return agentDao.getAllAgents();
    }


    public String addPaymentToAgent(Payment payment)
    {
        int rs = paymentDAO.addPayment(payment);
        if(rs == 0)
        {
            return "Payment didnt added.";
        }else{
            return "Payment added.";
        }
    }

    public String updatePayment(Payment payment)
    {
        int rs = paymentDAO.updatePayment(payment);
        if(rs == 0)
        {
            return "Payment didnt updated.";
        }else{
            return "Payment Updated.";
        }
    }

    public Payment getPaymentById(int id)
    {
        Payment rs = paymentDAO.getPaymentById(id);
        return rs;
    }


    public String deletePayment(int id)
    {
        int rs = paymentDAO.deletePayment(id);

        if(rs == 0)
        {
            return "Payment didnt delete";
        }else {
            return "Payment Deleted";
        }
    }

    public double getTotalPaymentsByDepartment(int departmentId)
    {
        double rs = paymentDAO.getTotalPaymentsByDepartment(departmentId);
        return rs;
    }

    public double getAverageSalaryByDepartment(int departmentId){
        double rs = paymentDAO.getAverageSalaryByDepartment(departmentId);
        return rs;
    }

    public Map<String, Double> getAgentsRankingByTotalPayments(Agent agent){
        return paymentDAO.getAgentsRankingByTotalPayments(agent);
    }


    public boolean getAgentByEmail(String email){
        return agentDao.getAgentByEmail(email);
    }


}
