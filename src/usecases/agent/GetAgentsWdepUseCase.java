package usecases.agent;

import model.Agent;
import service.responsable.ResponsableService;

import java.util.List;

public class GetAgentsWdepUseCase {
    private ResponsableService agentService;

    public GetAgentsWdepUseCase()
    {
        this.agentService = new ResponsableService();
    }



    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentService.getAllAgentsWithoutDepartements();
    }
}
