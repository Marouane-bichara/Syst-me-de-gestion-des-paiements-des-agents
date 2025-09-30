package service.auth;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import model.Agent;

public class AuthResponsableService {


    private IAgentDao agentDao;
    private IDepartementDAo departementDAo;

    public AuthResponsableService()
    {
        this.agentDao = new AgentDAOImpl();
        this.departementDAo = new DepartementDAO();
    }


    public Agent authResponsable (String email , String password) {
        Agent agent = agentDao.authResponsable(email , password);

        if(agent == null) {
            return null;
        }

        if(!agent.getTypeAgent().name().equals("RESPONSABLE_DEPARTEMENT")) {
            return null;
        }

        return agent;
    }

}
