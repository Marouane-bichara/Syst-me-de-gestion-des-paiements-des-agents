package usecases.auth;

import model.Agent;
import service.auth.AuthResponsableService;

public class AuthResponsableUseCase {

    private AuthResponsableService authResponsableService;

    public  AuthResponsableUseCase()
    {
        this.authResponsableService = new AuthResponsableService();
    }

    public Agent authRespoUseCase(String email , String password)
    {
        return authResponsableService.authResponsable(email , password);
    }

}
