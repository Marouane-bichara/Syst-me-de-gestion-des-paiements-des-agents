package service.auth;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import model.Agent;

public class AuthAgentNormalService {

    private IAgentDao agentDao;
    private IDepartementDAo departementDAo;

    public AuthAgentNormalService()
    {
        this.agentDao = new AgentDAOImpl();
        this.departementDAo = new DepartementDAO();
    }

    public Agent authAgentNormal (String email , String password){
        Agent agent = agentDao.authAgentNormal(email , password);

        if(agent == null) {
            return null;
        }

        if(!agent.getTypeAgent().name().equals("STAGIARE") && !agent.getTypeAgent().name().equals("OUVRIER")) {
            return null;
        }

        return agent;
    }
}
