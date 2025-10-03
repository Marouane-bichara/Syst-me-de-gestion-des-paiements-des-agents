package view.directeurView;

import model.Agent;
import view.agentResponsable.AddPaymentView;
import view.agentResponsable.DeletePaymentView;

import java.util.Scanner;

public class DirectureView {

    private AfficheAllAgentWitDepView afficheAllAgentWitDepView;
    private FillterAgentsByDepView fillterAgentsByDepView;
    private CreateDepartementView createDepartementView;
    private AssignAgentToDepartementView assignAgentToDepartementView;
    private DeleteDepartementView deleteDepartementView;
    private AddPaymentDirView addPaymentDirView;
    private UpdatePaymentView updatePaymentView;
    private DeletePaymentViewDirec deletePaymentView;
    private TotalAgentsDeparementsView totalAgentsDeparementsView;
    private DistributionPaymentTypeView distributionPaymentTypeView;
    private TotalAgentsAndDepartemensSecondView totalAgentsAndDepartemensSecondView;

    private Scanner scanner;

    public DirectureView()
    {
        this.afficheAllAgentWitDepView = new AfficheAllAgentWitDepView();
        this.fillterAgentsByDepView = new FillterAgentsByDepView();
        this.createDepartementView = new CreateDepartementView();
        this.scanner = new Scanner(System.in);
        this.assignAgentToDepartementView = new AssignAgentToDepartementView();
        this.deleteDepartementView = new DeleteDepartementView();
        this.addPaymentDirView = new AddPaymentDirView();
        this.updatePaymentView = new UpdatePaymentView();
        this.deletePaymentView = new DeletePaymentViewDirec();
        this.totalAgentsDeparementsView = new TotalAgentsDeparementsView();
        this.distributionPaymentTypeView = new DistributionPaymentTypeView();
        this.totalAgentsAndDepartemensSecondView = new TotalAgentsAndDepartemensSecondView();
    }

    public void responView(Agent agent)
    {

        boolean isTrue = true;
        int choice ;

        while (isTrue)
        {
            System.out.println("****************************************");
            System.out.println("                                        ");
            System.out.println("Gestion d’une Banque Digitale en Java");
            System.out.println("                                        ");
            System.out.println("****************************************");
            System.out.println("                                        ");


            System.out.println("1. Affiche all agents with departements.");
            System.out.println("2. Filter agents by departement.");
            System.out.println("3. Create Departement.");
            System.out.println("4. Assign agent to departement.");
            System.out.println("5. Delete Departement.");
            System.out.println("6. Payer un responsable.");
            System.out.println("7. Update Payment.");
            System.out.println("8. Delete Payment.");
            System.out.println("9. Total number of agents and departments.");
            System.out.println("10. Distribution of payments by type (percentage SALAIRE / PRIME / BONUS / INDEMNITE.");
            System.out.println("11. Total number of agents and departments.");
            System.out.println("12. Exite.");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice)
            {
                case 1:
                    afficheAllAgentWitDepView.afficheAllagentsWithDep();
                    break;
                case 2:
                    fillterAgentsByDepView.filterAgents();
                    break;
                case 3:
                    createDepartementView.addDepartement();
                    break;
                case 4:
                    assignAgentToDepartementView.assignAgent();
                    break;
                case 5:
                    deleteDepartementView.deleteDepartement();
                    break;
                case 6:
                    addPaymentDirView.addPayment();
                    break;
                case 7:
                    updatePaymentView.updatePayment();
                    break;
                case 8:
                    deletePaymentView.deletePayment();
                    break;
                case 9:
                    totalAgentsDeparementsView.totalAgentsAndDepartements();
                    break;
                case 10 : distributionPaymentTypeView.distributionPaymentType();
                        break;
                case 11:
                        totalAgentsAndDepartemensSecondView.totalAgentsAndDepartements();
                    break;
                case 12:
                    System.exit(0);
            }
        }
    }


}
