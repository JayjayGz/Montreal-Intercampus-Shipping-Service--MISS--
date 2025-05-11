// --------------------------------------------------------- 
// Assignment (4) 
// Written by: (Jeffrey Gueyie and 40315016) 
// For COMP 248 Section (S 2242) – Fall 2024 
//
//This program act as a simulator of a registry for Montreal six universities campuses
//Using the concepts of classes, the program allows the user to do manipulations,
//including, seeing content, listing registries, and adding/removing from registries.
//
// ---------------------------------------------------------
import java.util.Scanner;

public class MissDemo {

	public static void main(String[] args)
	{

		//Welcome message
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Welcome to Montreal Intercampuses Shipping"
				+ " Service(Miss©) Application");
		System.out.println("------------------------------------------------------------------------");
		
		//Creation of hardcoded Registry objects 
		Registry[] registries = createRegistries();
		
		
		//Creation of Scanner///
		Scanner KeyIn = new Scanner(System.in);
		
		//Variable
		int choice;
	
	do 
	{
		displayMenu();
		choice = KeyIn.nextInt();
		KeyIn.nextLine();
		
		switch(choice)
		{
			case 1:
				displayAllRegistries(registries);
				break;
				
			case 2:
				displaySingleRegistry(KeyIn, registries);
				break;
				
			case 3:
				listRegistriesWithSameTotalStampValue(registries);
				break;
				
			case 4:
				listRegistriesWithSameStampCategories(registries);
				break;
				
			case 5:
				listEqualRegistries(registries);
				break;
				
			case 6:
				addLabelToRegistry(KeyIn, registries);
				break;
				
			case 7:
				removeLabelFromRegistry(KeyIn, registries);
				break;
				
			case 8:
				updateLabelExpiry(KeyIn, registries);
				break;
				
			case 9:
				addStampsToRegistry(KeyIn, registries);
				break;
			case 0:
				System.out.println("Thank you for using Montreal Delivery Intercampuses"
						+ " Shipping Service(MISSC©) Application! ");
				break;
			default:
				System.out.println("Sorry that is not a valid choice. Try again. ");	
				break;
		}
	}
	while(choice != 0);
	
	KeyIn.close();
	
	}
	
	//Display menu options
		private static void displayMenu()
		{
				
				System.out.println("What would you like to do? ");
				System.out.println("1 >> See the content of all Registries");
				System.out.println("2 >> See the content of one Registry ");
				System.out.println("3 >> List Registries with same $ amount of shipment stamps");
				System.out.println("4 >> List Registries with same number of shipment Stamps types");
				System.out.println("5 >> List Registries with same $ amount of Stamps and same number of prepaid Labels");
				System.out.println("6 >> Add a prepaid label to an existing Registry ");
				System.out.println("7 >> Remove an existing prepaid label from a Registry ");
				System.out.println("8. >> Update the expiry date of an existing prepaid Label ");
				System.out.println("9. >> Add Stamps to a Registry ");
				System.out.println("0. >> To quit ");
				System.out.println("------------------------------------------------------------");
				System.out.println("");
				System.out.println("Please enter your choice and press <Enter>: ");
				

		}
		
	private static Registry[] createRegistries()
	{
		//create Labels
		Label label1 = new Label("Standard", 98825164, 25, 12);
		Label label2 = new Label("Condidential", 98703195, 3, 12);
		Label label3 = new Label("Fragile", 98825164, 7, 12);
		Label label4 = new Label("Standard", 98596387, 24, 8);
		Label label5 = new Label("Express", 98432806, 1, 6);
		Label label6 = new Label("Small", 98087913, 18, 12 );
		Label label7 = new Label("Oversize", 98735421, 5, 4);
		
		
		//create Stamps
		Stamps stamps1 = new Stamps(4, 0, 0, 4, 1);
		Stamps stamps2 = new Stamps(9, 4, 0, 2, 1);
		Stamps stamps3 = new Stamps(3, 2, 4, 1, 0);
		Stamps stamps4 = new Stamps(3, 2, 4, 1, 0);
		
		//create Registries
		Registry registry1 = new Registry(stamps1, new Label[]{label1, label2});
		Registry registry2 = new Registry(stamps1, new Label[]{label3, label4});
		Registry registry3 = new Registry(stamps2, new Label[]{label5, label6, label7});
		Registry registry4 = new Registry(stamps3, null);
		Registry registry5 = new Registry(stamps4, null);
		
		return new Registry[]{registry1, registry2 ,registry3,registry4,registry5};
	}
	
	//Choice #1
	private static void displayAllRegistries(Registry[] registries)
	{
		System.out.println("Content of each Registry: ");
		System.out.println("---------------------------");
		for(int count = 0; count < registries.length; count++)
		{
			System.out.println("Registry #" + count + ":\n" + registries[count]);
		}
		System.out.println();
	}
	
	//Choice #2	
	private static void displaySingleRegistry(Scanner KeyIn, Registry[] registries)
	{
		int index;
		
		System.out.print("Which Registry do you want to see the content of? (Enter number 0 to 4): ");
		do 
	 	{
			index = KeyIn.nextInt();
			if(index >= 0 && index < registries.length)	
		{
			System.out.println(registries[index]);
			return;
		}
	
		else
		{
			System.out.println("Sorry but there is no Registry number " + index);
			System.out.println("--> Try again: (Enter number 0 to 4): ");
			System.out.print("");
		}
		
	 	}
		while(true);
		
		
	}		
	
	//Choice #3
	private static void listRegistriesWithSameTotalStampValue(Registry[] registries)
	{
		System.out.println("List of Registries with same total $ Stamps:");
		System.out.println("");
		for(int count= 0; count < registries.length; count++)
		{
			for(int count1 = count + 1; count1 < registries.length; count1++)
			{
				if(registries[count].StampValueTotal()==registries[count1].StampValueTotal())
				{
					System.out.println("        Registries " + count  + " and " + count1
							+ " both have " + registries[count].StampValueTotal());
				}
			}
	
		}
		System.out.println();
	
	}
	
	//Choice #4
	private static void listRegistriesWithSameStampCategories(Registry[] registries)
	{
	    System.out.println("List of Registries with same Stamps categories:");
	    System.out.println();
	    
	    for (int count = 0; count < registries.length; count++) 
	    {
	        for (int count1 = count + 1; count1 < registries.length; count1++) 
	        {
	            if (registries[count].equalStampsCategories(registries[count1])) 
	            {
	                System.out.println("        Registries " + count + " and " + count1
	                		+ " both have " + registries[count].getStamps());
	  
	            }
	        }
	    }
	    	System.out.println();
	}
	
	//Choice #5
	private static void listEqualRegistries(Registry[] registries)
	{
		System.out.println("List of Registries with same $ amount of Stamps"
				+ " and the same number of Labels : ");
		System.out.println();
		
		for(int count = 0; count < registries.length; count++)
		{
			for(int count1 = count + 1; count1 < registries.length; count1++)
			{
				if(registries[count].StampValueTotal() == registries[count1].StampValueTotal() &&
		                registries[count].numberOfLabels() == registries[count1].numberOfLabels())
				{
					System.out.println("        Registries " + count + " and " + count1);
				}
			}
		
		}
			System.out.println();
	}
		
		//Choice #6
		private static void addLabelToRegistry(Scanner KeyIn, Registry[] registries)
		{
			
			System.out.print("Which Registry do you want to add a label to? "
					+ "(Enter number 0 to 4): ");
			int regNum = KeyIn.nextInt();
			KeyIn.nextLine();
			if(regNum >= 0 && regNum <= registries.length)
			{
				System.out.println("Please enter the following information so that we"
						+ " may complete the Label-");
				System.out.print(" --> Type of Label (Confidential, Small, Oversize, Express,"
						+ " Standard, Fragile): ");
	            String type = KeyIn.nextLine();
	            System.out.print(" --> Id of the prepaid label possesor: ");
	            int iD = KeyIn.nextInt();
	            System.out.print(" --> Expiry day number and month (separate by a space): ");
	            int day = KeyIn.nextInt();
	            int month = KeyIn.nextInt();
	            
	            //Creatation and addition of Registry
	            int numLabels = registries[regNum].addLabel(new Label(type, iD, day, month));
	            System.out.println("You now have " + numLabels + (numLabels == 1  ? " Label" : " Labels"));
	            System.out.println();
	        } 
			else 
			{
	            System.out.println("Invalid Registry number.");
	        }
	   	
		  }
		
		//Choice #7
		private static void removeLabelFromRegistry(Scanner KeyIn, Registry[]registries)
		{
			System.out.print("Which Registry do you want to remove a label from? "
					+ "(Enter number 0 to 4): ");
			int regNum = KeyIn.nextInt();
			
			//Check for validity of registry number
			if (regNum >= 0 && regNum <= registries.length)
			{
				
				
				//Check if registry has labels
				Label[] labels = registries[regNum].getLabels();
				
				if (labels == null || labels.length == 0) 
				{
					
					System.out.println("Sorry that Registry has no Labels");
					System.out.println();
		        } 
				else 
				{
		            // If the registry has labels, prompt user to remove a label
		            System.out.print("(Enter number 0 to 2): ");
		            int index = KeyIn.nextInt();
		            
		            // Check if the index is valid
		            if (index >= 0 && index < labels.length) {
		                boolean removed = registries[regNum].removeLabel(labels[index]);
		                System.out.println(removed ? "Label removed successfully." : "Label removal failed.");
		            } else {
		                System.out.println("Invalid label index.");
		            }
		        }
		    } 
			else 
		    {
		        System.out.println("Invalid Registry number.");
		    }
				
					
		}
		
		//Choice #8
		private static void updateLabelExpiry(Scanner KeyIn, Registry[]registries)
		{
			//Registry number
			System.out.print("Which Registry do you want to update a label from? (Enter number 0 to 4): ");
	        int regNum = KeyIn.nextInt();
	        
	        //Validation for registry number
	        if (regNum >= 0 && regNum <= registries.length) 
	        {
	            	System.out.print("Which Label do you want to update?: (Enter number 0 to 4): ");
	            int index = KeyIn.nextInt();
	            	System.out.print("--> Enter new expiry day number and month (separated by a space): ");
	            int newDay = KeyIn.nextInt();
	            int newMonth = KeyIn.nextInt();
	            Label[] labelUpdate = registries[regNum].getLabels();
	            
	            if (newDay > 1 || newDay < 31 || newMonth > 1 || newMonth < 12)
	            {
	            	registries[regNum].updateExpiryLabel(labelUpdate[index], newDay, newMonth);
	                System.out.println("Expiry Date updated");
	            } 
	           
	        } 
	        else 
	        {
	        		System.out.println("Invalid Registry number.");	
	        }
		}
		
		//Choice #9
		private static void addStampsToRegistry(Scanner KeyIn, Registry[] registries)
		{
		    System.out.print("Which Registry do you want to add Stamps to? (Enter number 0 to 4): ");
		    int regNum = KeyIn.nextInt();
		    KeyIn.nextLine();

		    // Validate the registry number
		    if (regNum >= 0 && regNum < registries.length) {
		        System.out.println("How many category_A($2), category_B($5), category_C($10), category_D($15), "
		                + "and category_E($20) parcel stamps do you want to add?");
		        System.out.print("Enter 5 numbers separated by a space: ");

		        // Read the input for stamp quantities
		        int cat1 = KeyIn.nextInt();
		        int cat2 = KeyIn.nextInt();
		        int cat3 = KeyIn.nextInt();
		        int cat4 = KeyIn.nextInt();
		        int cat5 = KeyIn.nextInt();

		        // Add stamps to the selected registry
		        double newTotal = registries[regNum].addStamps(cat1, cat2, cat3, cat4, cat5);

		        // Display the new total
		        System.out.printf("You now have $" + newTotal);
		    } else {
		        System.out.println("Invalid Registry number.");
		    }
		    System.out.println(); // Add a blank line for better formatting
	}

}
