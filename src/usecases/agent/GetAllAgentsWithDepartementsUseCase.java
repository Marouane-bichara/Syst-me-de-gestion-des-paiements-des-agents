package usecases.agent;

import model.Agent;
import service.responsable.ResponsableService;

import java.util.List;

public class GetAllAgentsWithDepartementsUseCase {
    private ResponsableService agentService;

    public GetAllAgentsWithDepartementsUseCase()
    {
        this.agentService = new ResponsableService();
    }

    public List<Agent> getAllAgentsWithoutDepartements(){
        return agentService.getallAgentsWithDepartements();
    }
}
