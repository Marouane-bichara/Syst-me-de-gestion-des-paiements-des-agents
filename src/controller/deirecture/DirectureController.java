package controller.deirecture;

import model.Agent;
import model.Departement;
import model.Payment;
import model.TypeAgent;
import usecases.directure.AddDepartementUseCase;
import usecases.directure.AddNewRespoDepUseCase;
import usecases.directure.DeleteDepartementUseCase;
import usecases.directure.GetAgentsByDepartementUseCase;

import java.util.ArrayList;
import java.util.List;

public class DirectureController {

    private GetAgentsByDepartementUseCase getAgentsByDepartement;
    private AddDepartementUseCase addDepartement;
    private AddNewRespoDepUseCase addNewRespoDepUseCase;
    private DeleteDepartementUseCase deleteDepartementUseCase;


    public DirectureController()
    {
        this.getAgentsByDepartement = new GetAgentsByDepartementUseCase();
        this.addDepartement = new AddDepartementUseCase();
        this.addNewRespoDepUseCase = new AddNewRespoDepUseCase();
        this.deleteDepartementUseCase = new DeleteDepartementUseCase();
    }

    public List<Agent> getAgentsBydepartement(String name)
    {
        return getAgentsByDepartement.getAgentsByDepartements(name);
    }

    public String addDepartement(String name)
    {
        return addDepartement.addDepartement(name);
    }

    public String addnewRespo(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement)
    {
        return  addNewRespoDepUseCase.addNewRespDep( nom,  prenom,  email,  motDePasse,  typeAgent,   nameDepartement);
    }

    public String deleteDepartement(String name)
    {
        return deleteDepartementUseCase.deleteDepartement(name);
    }

}
