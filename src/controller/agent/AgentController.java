package controller.agent;

import model.Agent;
import usecases.agent.*;

import java.util.List;

public class AgentController {

    private CreateAgentUseCase createAgentUseCase;
    private UpdateAgentUseCase updateAgentUseCase;
    private GetAgentUseCase getAgentUseCase;
    private DeleteAgentUseCase deleteAgentUseCase;
    private GetAgentsWdepUseCase getAgentsWdepUseCase;
    private GetAllAgentsWithDepartementsUseCase getAllAgentsWithDepartementsUseCase;

    public  AgentController()
    {
        this.createAgentUseCase = new CreateAgentUseCase();
        this.updateAgentUseCase = new UpdateAgentUseCase();
        this.getAgentUseCase = new GetAgentUseCase();
        this.deleteAgentUseCase = new DeleteAgentUseCase();
        this.getAllAgentsWithDepartementsUseCase = new GetAllAgentsWithDepartementsUseCase();
        this.getAgentsWdepUseCase = new GetAgentsWdepUseCase();
    }

    public String  addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String value = createAgentUseCase.addAgent(nom , prenom , email , motDePasse , type , departementName , id);

        return  value;
    }

    public String updateAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String resault = updateAgentUseCase.updateAgentUseCase(nom  , prenom , email , motDePasse , type, departementName , id);
        return  resault;
    }

    public Agent getAgentByNameAndLastName(String lastname , String name )
    {
        Agent agent = getAgentUseCase.getAgentByNameAndLastname(lastname , name);
        return agent;
    }

    public String deleteAgentById(int id)
    {
        String resault = deleteAgentUseCase.deleteAgentById(id);
        return resault;
    }

    public List<Agent> getAllAgentsWithoutDepartements(){
        return getAgentsWdepUseCase.getAllAgentsWithoutDepartements();
    }

    public List<Agent> getallAgentWithDepartements(){
        return getAllAgentsWithDepartementsUseCase.getAllAgentsWithoutDepartements();
    }



}
