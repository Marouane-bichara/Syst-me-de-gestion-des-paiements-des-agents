package service.departement;

import dao.AgentDAOImpl;
import dao.DepartementDAO;
import dao.IDao.IAgentDao;
import dao.IDao.IDepartementDAo;
import model.Departement;

import java.util.List;

public class DepartementService  implements IDepartementService{

    private IDepartementDAo departementDAo;

    public DepartementService()
    {
        this.departementDAo = new DepartementDAO();
    }

    public List<Departement> getAllDepartement()
    {
        return departementDAo.getAllDepartements();
    }
}
