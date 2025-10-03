package usecases.auth;

import model.Agent;
import service.auth.AuthAgentNormalService;

public class AuthAgentNormalUseCase {

    private AuthAgentNormalService agentNormalService;


    public AuthAgentNormalUseCase()
    {
        this.agentNormalService = new AuthAgentNormalService();
    }


    public Agent authAgentNormal (String email , String password){
        return agentNormalService.authAgentNormal(email , password);
    }
}
