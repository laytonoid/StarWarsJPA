import java.util.Scanner;
import java.util.List;


import model.ForceUser;
import controller.ForceUserHelper;
/**  
* Taylor Layton - tglayton
* CIS171 22149
* Sep 13, 2023
* Windows 10 
*/
public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static ForceUserHelper fuHelper = new ForceUserHelper();

    private static void addAForceUser() {
        System.out.print("Enter a name: ");
        String name = in.nextLine();
        System.out.print("Enter lightsaber color: ");
        String color = in.nextLine();
        System.out.print("Enter affiliation (Sith/Jedi): ");
        String affiliation = in.nextLine();
        ForceUser toAdd = new ForceUser(name, color, affiliation);
        fuHelper.insertCharacter(toAdd);
    }

    private static void viewTheForceUsers() {
        List<ForceUser> allForceUsers = fuHelper.showAllForceUsers();
        for (ForceUser singleForceUser : allForceUsers) {
            System.out.println(singleForceUser.returnForceUserDetails());
        }
    }
    private static void deleteAForceUser() {
        System.out.print("Enter the name of the Force User to delete: ");
        String name = in.nextLine();
        ForceUser toDelete = new ForceUser();
        toDelete.setName(name);
        fuHelper.
        deleteCharacter(toDelete);
    }
    private static void editAForceUser() {
        System.out.print("Enter the name of the Force User to edit: ");
        String name = in.nextLine();
        ForceUser toEdit = fuHelper.searchForCharacterByName(name); 
        if (toEdit != null) {
            System.out.println("What would you like to edit?");
            System.out.println("1 : Update Name");
            System.out.println("2 : Update Lightsaber Color");
            System.out.println("3 : Update Affiliation");
            int selection = in.nextInt();
            in.nextLine();
            if (selection == 1) {
                System.out.print("Enter the new name: ");
                String newName = in.nextLine();
                toEdit.setName(newName);
            } else if (selection == 2) {
                System.out.print("Enter the new lightsaber color: ");
                String newColor = in.nextLine();
                toEdit.setLightsaberColor(newColor);
            } else if (selection == 3) {
                System.out.print("Enter the new affiliation (Sith/Jedi): ");
                String newAffiliation = in.nextLine();
                toEdit.setAffiliation(newAffiliation);
            }
            fuHelper.updateCharacter(toEdit);
        } else {
            System.out.println("Force User not found.");
        }
    }
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        boolean goAgain = true;
        System.out.println("Star Wars Force User Database");
        while (goAgain) {
            System.out.println("*  Select an option:");
            System.out.println("*  1 -- Add Force User");
            System.out.println("*  2 -- Edit Force User");
            System.out.println("*  3 -- Delete Force User");
            System.out.println("*  4 -- View Force Users");
            System.out.println("*  5 -- Exit Program");
            System.out.print("*  Your selection: ");
            int selection = in.nextInt();
            in.nextLine();

            if (selection == 1) {
                addAForceUser();
            } else if (selection == 2) {
                editAForceUser();
            } else if (selection == 3) {
                deleteAForceUser();
            } else if (selection == 4) {
                viewTheForceUsers();
            } else {
                fuHelper.cleanUp();
                System.out.println("   Goodbye!   ");
                goAgain = false;
            }
        }
    }
}