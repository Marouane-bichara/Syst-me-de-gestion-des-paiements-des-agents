package usecases.agent;

import model.Agent;
import service.agent.AgentService;

import java.util.List;

public class GetAgentsWdepUseCase {
    private AgentService agentService;

    public GetAgentsWdepUseCase()
    {
        this.agentService = new AgentService();
    }



    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentService.getAllAgentsWithoutDepartements();
    }
}
