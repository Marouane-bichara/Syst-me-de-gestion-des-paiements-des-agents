package usecases.agent;

import model.Agent;
import service.responsable.ResponsableService;

public class GetAgentUseCase {

    private ResponsableService agentService;

    public GetAgentUseCase()
    {
        this.agentService = new ResponsableService();
    }


    public Agent getAgentByNameAndLastname(String lastname , String name )
    {

       Agent agent =  agentService.getAgentByNameAndLastName(lastname ,name);
        return agent;
    }


}
