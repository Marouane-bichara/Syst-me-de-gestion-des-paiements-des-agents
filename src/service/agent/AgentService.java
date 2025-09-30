package service.agent;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import model.Agent;
import model.Departement;
import model.TypeAgent;

import java.util.ArrayList;
import java.util.List;

public class AgentService {

    private  IAgentDao agentDao;
    private IDepartementDAo departementDAo;

    public AgentService()
    {
        this.agentDao = new AgentDAOImpl();
        this.departementDAo = new DepartementDAO();
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


}
