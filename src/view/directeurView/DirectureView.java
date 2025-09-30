package view.directeurView;

import model.Agent;

import java.util.Scanner;

public class DirectureView {

    private AfficheAllAgentWitDepView afficheAllAgentWitDepView;
    private FillterAgentsByDepView fillterAgentsByDepView;
    private CreateDepartementView createDepartementView;
    private AssignAgentToDepartementView assignAgentToDepartementView;
    private DeleteDepartementView deleteDepartementView;

    private Scanner scanner;

    public DirectureView()
    {
        this.afficheAllAgentWitDepView = new AfficheAllAgentWitDepView();
        this.fillterAgentsByDepView = new FillterAgentsByDepView();
        this.createDepartementView = new CreateDepartementView();
        this.scanner = new Scanner(System.in);
        this.assignAgentToDepartementView = new AssignAgentToDepartementView();
        this.deleteDepartementView = new DeleteDepartementView();
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
            System.out.println("7. Exite.");
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
                case 7:
                    System.exit(0);
            }
        }
    }


}
