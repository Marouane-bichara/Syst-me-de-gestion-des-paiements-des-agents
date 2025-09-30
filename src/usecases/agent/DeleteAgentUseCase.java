package usecases.agent;

import service.responsable.ResponsableService;

public class DeleteAgentUseCase {

    private ResponsableService agentService;

    public DeleteAgentUseCase()
    {
        this.agentService = new ResponsableService();
    }

    public String deleteAgentById(int id)
    {

        String resault = agentService.deleteAgentbyId(id);
        return resault;
    }

}
