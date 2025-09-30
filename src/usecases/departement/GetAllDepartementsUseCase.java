package usecases.departement;

import model.Departement;
import service.departement.DepartementService;

import java.util.List;

public class GetAllDepartementsUseCase {
    private DepartementService departementService;

    public GetAllDepartementsUseCase()
    {
        this.departementService = new DepartementService();
    }

    public List<Departement> getAllDepartements()
    {
        return departementService.getAllDepartement();
    }

}
