package usecases.agent;

import model.Agent;
import service.agent.AgentService;

public class GetAgentUseCase {

    private AgentService agentService;

    public GetAgentUseCase()
    {
        this.agentService = new AgentService();
    }


    public Agent getAgentByNameAndLastname(String lastname , String name )
    {

       Agent agent =  agentService.getAgentByNameAndLastName(lastname ,name);
        return agent;
    }


}
