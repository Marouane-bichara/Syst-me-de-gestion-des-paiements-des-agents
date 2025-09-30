package usecases.agent;

import service.agent.AgentService;

public class DeleteAgentUseCase {

    private AgentService agentService;

    public DeleteAgentUseCase()
    {
        this.agentService = new AgentService();
    }

    public String deleteAgentById(int id)
    {

        String resault = agentService.deleteAgentbyId(id);
        return resault;
    }

}
