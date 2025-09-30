package usecases.agent;

import service.agent.AgentService;

public class CreateAgentUseCase {

        private AgentService agentService;

        public CreateAgentUseCase()
        {
            this.agentService = new AgentService();
        }

        public String addAgent(String nom, String prenom, String email,String motDePasse, String type , String departementName , int id)
        {
            String value = agentService.addAgent(nom , prenom , email , motDePasse , type , departementName , id);
            return  value;
        }
}
