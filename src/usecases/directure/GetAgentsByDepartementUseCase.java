package usecases.directure;

import model.Agent;
import service.directure.DirectureService;

import java.util.List;

public class GetAgentsByDepartementUseCase {

    private DirectureService directureService;

    public GetAgentsByDepartementUseCase()
    {
        this.directureService = new DirectureService();
    }

    public List<Agent> getAgentsByDepartements(String name)
    {
        return directureService.getAgentsBydepartement(name);
    }



}
