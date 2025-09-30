package usecases.agent;

import service.responsable.ResponsableService;

public class UpdateAgentUseCase {

    private ResponsableService agentService;

    public UpdateAgentUseCase()
    {
        this.agentService = new ResponsableService();
    }

    public String updateAgentUseCase(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
    {
        String resault = agentService.updateAgent(nom , prenom , email, motDePasse , type , departementName, id);

        return resault;
    }

}
