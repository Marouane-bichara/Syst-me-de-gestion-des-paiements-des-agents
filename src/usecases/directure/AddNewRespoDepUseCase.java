package usecases.directure;

import model.Agent;
import service.directure.DirectureService;

public class AddNewRespoDepUseCase {

    private DirectureService directureService;

    public AddNewRespoDepUseCase()
    {
        this.directureService = new DirectureService();
    }


    public String addNewRespDep(String nom, String prenom, String email, String motDePasse, String typeAgent, String nameDepartement)
    {
        return directureService.addNewDepartemntResponsable(nom,  prenom,  email,  motDePasse,  typeAgent,   nameDepartement);
    }
}
