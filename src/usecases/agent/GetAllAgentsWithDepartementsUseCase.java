package usecases.agent;

import model.Agent;
import service.agent.AgentService;

import java.util.List;

public class GetAllAgentsWithDepartementsUseCase {
    private AgentService agentService;

    public GetAllAgentsWithDepartementsUseCase()
    {
        this.agentService = new AgentService();
    }

    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentService.getallAgentsWithDepartements();
    }
}
