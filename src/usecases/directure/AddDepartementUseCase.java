package usecases.directure;

import service.directure.DirectureService;

public class AddDepartementUseCase {

    private DirectureService directureService;
    public AddDepartementUseCase()
    {
        this.directureService = new DirectureService();
    }
    public String addDepartement(String name)
    {
        return directureService.addDepartement(name);
    }
}
