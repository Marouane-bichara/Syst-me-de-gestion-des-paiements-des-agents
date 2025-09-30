package controller.departement;

import model.Departement;
import usecases.departement.GetAllDepartementsUseCase;

import java.util.List;

public class DepartementController {


    private GetAllDepartementsUseCase departementsUseCase;

    public DepartementController()
    {
        this.departementsUseCase = new GetAllDepartementsUseCase();
    }

    public List<Departement> getAlldepartements()
    {
        return departementsUseCase.getAllDepartements();
    }
}
