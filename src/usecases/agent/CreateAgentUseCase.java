package usecases.agent;

import service.responsable.ResponsableService;

public class CreateAgentUseCase {

        private ResponsableService agentService;

        public CreateAgentUseCase()
        {
            this.agentService = new ResponsableService();
        }

        public String addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
        {
            String value = agentService.addAgent(nom , prenom , email , motDePasse , type , departementName , id);
            return  value;
        }
}
