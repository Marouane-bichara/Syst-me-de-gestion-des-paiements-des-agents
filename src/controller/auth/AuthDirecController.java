package controller.auth;

import model.Agent;
import usecases.auth.AuthDirecUseCase;

public class AuthDirecController {


    private AuthDirecUseCase authDirecUseCase;

    public AuthDirecController()
    {
        this.authDirecUseCase = new AuthDirecUseCase();
    }


    public Agent authDirecController(String email , String password)
    {
        return authDirecUseCase.authDirecUseCase(email , password);
    }
}
