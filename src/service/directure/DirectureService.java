package service.directure;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import model.Agent;
import model.Departement;
import model.TypeAgent;

import java.util.ArrayList;
import java.util.List;

public class DirectureService {

    private AgentDAOImpl agentDAO;
    private DepartementDAO departementDAO;
    public DirectureService()
    {
        this.agentDAO = new AgentDAOImpl();
        this.departementDAO = new DepartementDAO();
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


}
