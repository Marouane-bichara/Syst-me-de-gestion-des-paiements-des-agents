package service.directure;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.PaymentDAOImpl;
import model.Agent;
import model.Departement;
import model.Payment;
import model.TypeAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectureService {

    private AgentDAOImpl agentDAO;
    private DepartementDAO departementDAO;
    private PaymentDAOImpl paymentDAO;



    public DirectureService()
    {
        this.agentDAO = new AgentDAOImpl();
        this.departementDAO = new DepartementDAO();
        this.paymentDAO = new PaymentDAOImpl();
    }


    public List<Agent> getAgentsBydepartement(String name)
    {
        return agentDAO.getAgentsBydepartement(name);
    }

    public String addDepartement(String name)
    {
        Departement departement = new Departement(3 , name , new ArrayList<>());

        int resault = departementDAO.addDepartement(departement);

        if(resault == 0)
        {
            return "Departement not added.";
        }
        else{
            return "Departement added.";
        }
    }

    public String addNewDepartemntResponsable(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement)
    {
        Departement departement = departementDAO.getDepartementByName(nameDepartement);

        if(departement == null)
        {
            return "Departement not found.";
        }
        Agent agent = new Agent(nom , prenom , email , motDePasse , 0 , TypeAgent.valueOf(typeAgent.toUpperCase()) , departement , new ArrayList<>());
        int n = agentDAO.addAgent(agent);
        if(n != 0)
        {
            return "Responsable Added.";
        }
        else{
            return "Probleme while adding an rsponsable.";
        }

    }

    public String deleteDepartement(String name)
    {
       int resault =  departementDAO.DeleteDepartementByname(name);

       if(resault == 0)
       {
           return "Departement not found";
       }
       else {
           return "Departement deleted";
       }
    }


    public String addPaymentToDirecture(Payment payment)
    {
        int rs = paymentDAO.addPayment(payment);
        if(rs == 0)
        {
            return "Payment didnt added.";
        }else{
            return "Payment added.";
        }
    }

    public Payment getPaymentById(int id)
    {
        Payment rs = paymentDAO.getPaymentById(id);
        return rs;
    }

    public Agent getAgentByNameAndLastName(String lastname , String name  )
    {
        Agent agent = agentDAO.getAgentBynameAndlastname(lastname , name);
        return  agent;
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

    public Map<String , Integer> getAllDepartementsWithTotal(){
        Map<String , Integer> rs =  departementDAO.getAllDepartementsWitTotal();

        return rs;
    }


    public int getTotalType(String type)
    {
        int size = paymentDAO.sizeType(type);
        if(size == 0)
        {
            return 0;
        }else{
            return size;
        }
    }

    public int getTotalPayments()
    {
        int size = paymentDAO.paymentSize();
        return size;
    }


}
