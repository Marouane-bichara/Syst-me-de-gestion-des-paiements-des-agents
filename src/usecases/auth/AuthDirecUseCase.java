package usecases.auth;

import model.Agent;
import service.auth.AuthDirectureService;

public class AuthDirecUseCase {

    private AuthDirectureService authDirectureService;

    public  AuthDirecUseCase()
    {
        this.authDirectureService = new AuthDirectureService();
    }


    public Agent authDirecUseCase(String email , String password)
    {
        return authDirectureService.authDirecteur(email , password);
    }
}
