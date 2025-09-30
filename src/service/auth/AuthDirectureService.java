package service.auth;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import model.Agent;

public class AuthDirectureService {
    private IAgentDao agentDao;
    private IDepartementDAo departementDAo;

    public AuthDirectureService()
    {
        this.agentDao = new AgentDAOImpl();
        this.departementDAo = new DepartementDAO();
    }


    public Agent authDirecteur (String email , String password) {
        Agent agent = agentDao.authDirecture(email , password);

        if(agent == null) {
            return null;
        }

        if(!agent.getTypeAgent().name().equals("DIRECTEUR")) {
            return null;
        }

        return agent;
    }
}
