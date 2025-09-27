
import dao.AgentDAOImpl;
import dao.DepartementDAO;
import model.Agent;
import model.Departement;
import model.TypeAgent;
import util.DbConnection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {






//        DepartementDAO departementDAO = new DepartementDAO();
//        departementDAO.DeleteDepartementByname("development");

          AgentDAOImpl agentDAO = new AgentDAOImpl();
          int i = agentDAO.deleteAgentbyId(1);
            if(i == 0)
            {
                System.out.println("not found");
            }else{
                System.out.println("its deleted ");
            }
        //
//        Departement departement = new Departement(2 , "development"  , null);
//////




//        Agent agent = new Agent("marouane" , "bichara" , "marouane08@gmail.com" , "12345678" , 1 , TypeAgent.DIRECTEUR ,null , null);
//
//        AgentDAOImpl agentDAO = new AgentDAOImpl();
//        System.out.println(agentDAO.getAgentById(1));

    }


}
