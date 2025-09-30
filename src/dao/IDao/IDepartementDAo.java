package dao.IDao;

import model.Departement;

import java.util.List;

public interface IDepartementDAo {
    int addDepartement(Departement departement);
    List<Departement> getAllDepartements();
    Departement getDepatrmentById(int id);
    Departement getDepartementByName(String name);
    int DeleteDepartementByname(String name);

//    void updateDepartement(Departement departement);
//    void deleteDepartement(int id);
//
//    void assignResponsable(int departementId, int agentId);
//    List<Agent> getAgentsByDepartement(int idDepartement);
//
//    double getTotalPaymentsByDepartement(int idDepartement);
//    double getAveragePaymentsByDepartement(int idDepartement);
//
//    List<Agent> getAgentsSortedByPayments(int idDepartement);
}
