package controller.auth;

import model.Agent;
import usecases.auth.AuthAgentNormalUseCase;

public class AuthAgentNormalController {

    private AuthAgentNormalUseCase authAgentNormal;

    public AuthAgentNormalController()
    {
        this.authAgentNormal = new AuthAgentNormalUseCase();
    }


    public Agent authAgentNormal (String email , String password){
        return authAgentNormal.authAgentNormal(email , password);
    }
}
