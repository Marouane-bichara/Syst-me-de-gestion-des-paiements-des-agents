package controller.auth;

import model.Agent;
import usecases.auth.AuthResponsableUseCase;

public class AuthRespoController {


    private AuthResponsableUseCase authResponsableUseCase;

    public AuthRespoController()
    {
        this.authResponsableUseCase = new AuthResponsableUseCase();
    }

    public Agent authRespController(String email , String password)
    {
        return authResponsableUseCase.authRespoUseCase(email , password);
    }


}
