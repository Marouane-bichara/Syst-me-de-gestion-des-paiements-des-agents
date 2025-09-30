package usecases.directure;

import service.directure.DirectureService;

public class DeleteDepartementUseCase {

    private DirectureService directureService;

    public DeleteDepartementUseCase()
    {
        this.directureService = new DirectureService();
    }


    public String deleteDepartement(String name)
    {
        return directureService.deleteDepartement(name);
    }
}
