import java.util.Scanner; //Import of Scanner
import java.util.ArrayList; //Import of Array list utility
public class ListMaker
{
    private  static ArrayList<String> list = new ArrayList<>(); //Creation of global dynamic variable array list called list
    private static String item = ""; //Creation of global dynamic variable item initialized to nothing
    private static int toDelete; //Creation of global dynamic variable for user's numeric list choice for deletion

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); //Scanner utility for user input
        final String MENU = "A - Add; D - Delete; P - Print; Q - Quit"; //Display of menu choice options for user
        boolean done = false; //Variable used for main program loop
        String input = ""; //Variable for user menu input
        boolean finalConfirm = false;

            do //Start of program loop
           {
                input = SafeInput.getRegExString(in, MENU, "[AaDdPpQq]"); //Call method and display choice options for user to use from menu
                input = input.toUpperCase(); //Convert users menu choice to upper case

                switch (input) //Used to execute users choice
                {
                    case "A": //Menu choice for Add
                        item = SafeInput.getNonZeroLenString(in, "Enter item to add to list"); //Call method for user to enter item. Check for an actual value.
                        //list.add(item); //Call built in method to add user's item to list
                        addListItem(item); //Call custom method to add user's item to list
                        break; //Jump out of loop
                    case "D": //Menu choice for Delete
                        displayList(); //display the list of items that can be deleted
                        toDelete = SafeInput.getRangedInt(in, "Pick number of item to delete", 1, list.size()) - 1; //Call method for User's choice of item to delete. Subtract 1 to match index
                        //list.remove(toDelete); //Call built in method to delete item from array list
                        deleteListItem(toDelete); //Call custom method to remove chosen item from list
                        System.out.println("Here is your Updated List"); //Message to user that current list display is the modified version
                        displayList(); //Display updated list after delete
                        break; //Jump out of loop
                    case "P": //Menu choice for printing list to screen
                        displayList(); //Show the list of items to user
                        break; //Jump out of loop
                    case "Q": //Menu choice for Quiting the program
                        finalConfirm = SafeInput.getYNConfirm(in, "Are you sure?"); //Prompt user one more time to confirm they do want to quit program
                        if(!finalConfirm) //Boolean to determine if user quits program
                            {
                                //System.exit(0); //Call Exit method with no error message
                                done = true; //Exit program
                            }
                }
            } while(!done); //Determines if program continues or not based on user response
    }
    private static void displayList() //Method to show user list of items in the array list
        {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++"); //Used for cosmetic purposes for display
            if (list.size() != 0) //Execute if list have items in it
                {
                    for (int i = 0; i < list.size(); i++) //For loop to iterate through the array list to the end based on size
                        {
                            System.out.println(i + 1 + ":" + list.get(i)); //Display each list item by adding 1 to index value which gives user numeric choice for each item
                        }
                }
            else //Execute this block if no items in user list
                System.out.println("+++              List is empty                  +++"); //Used for cosmetic purposes for display and show user that they have no items in their list
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++"); //Used for cosmetic purposes for display
        }

//Add item with numeric choice value
    private static String addListItem(String item) //Method for adding an item to array list
        {
            Scanner in = new Scanner(System.in); //Scanner for feeding user input into method
            list.add(item); //Built in method for adding item to array list
            return item; //Required return statement
        }
    //Method to remove item from array list
    private static int deleteListItem(int toDelete)
        {
            list.remove(toDelete);
            return toDelete;
        }


}