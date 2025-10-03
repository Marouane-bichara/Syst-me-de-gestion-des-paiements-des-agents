package dao.IDao;

import model.Departement;

import java.util.List;
import java.util.Map;

public interface IDepartementDAo {
    int addDepartement(Departement departement);
    List<Departement> getAllDepartements();
    Departement getDepatrmentById(int id);
    Departement getDepartementByName(String name);
    int DeleteDepartementByname(String name);
    Map<String , Integer> getAllDepartementsWitTotal();
    int countDepartements();


}
