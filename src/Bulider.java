import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bulider {

	public static void main(String[] args) throws Exception {


		Scanner input = new Scanner(System.in);
		Scanner descIn = new Scanner(System.in);
		Scanner storeIn = new Scanner(System.in);
		/*
		 * set quit to true to allow loop on program
		 */

		boolean quit = true;

		while(quit){

			System.out.println("What would you like to do?");
			System.out.println(" '0' to quit \n '1' to add expense \n '3' to add Catagory \n '4' to view Catagories");
			int x = input.nextInt();
			/*
			 * quit
			 */
			if (x == 0){

				System.out.println("Have a Wonderful Day!");
				break;
				/*
				 * record expense
				 */
			}else if (x == 1){



				System.out.println("Record your expense:");

				System.out.println("Date: ");
				String date = input.next();

				System.out.println("Store Name: ");

				String store =  storeIn.nextLine();

				System.out.println("Amount: ");
				String amount = input.next();


				System.out.println("Desc, PO, or Sn: ");
				String desc = descIn.nextLine();

				String exspenseCat = " ";


				/*										*
				 * 		Get Data from Cat file			*
				 * 		read and print cats to screen 	*	
				 *										*/

				Scanner inFile1 = new Scanner(new File("src/cats.txt"));

				ArrayList<String> cats = new ArrayList<String>();

				while (inFile1.hasNext()){
					exspenseCat = inFile1.nextLine();
					cats.add(exspenseCat);


				}

				System.out.println("Catagory:");
				int j = 1;

				for(int i = 0; i < cats.size(); i++)
				{ 
					System.out.printf( "\n\t" + j + ". " + cats.get(i));
					j++;
				} 

				int cat = input.nextInt();
				String catagory =  cats.get(cat - 1 );

				System.out.printf("Date: %s \nStore: %s \nAmount of: %s \nDesc: %s \n was added to: %s" ,date,store,amount,desc,catagory);

				/*
				 * write expense to file
				 */
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/expense.csv", true))))
				{

					out.println(date + "," + store + "," + amount + "," + desc + "," + catagory);

					out.println();
					//more code
				}catch (IOException e){

				}finally
				{



				}


				/*
				 * check to see if wanting to continue
				 */


				inFile1.close();

				System.out.println("\nContinue? \n 'y' yes 'n' no");
				String y = input.next();
				if (y.equals("y"))
					quit = true;
				else{
					System.out.println("Have a nice day!");
					break;
				}

				/*
				 * add category
				 */


			}else if  (x == 3)	{

				System.out.println("What would you like to add?:");
				String newCat = input.next();

				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/cats.txt", true)))) {
					out.print(newCat+"\n");

				}catch (IOException e) {
				}
				finally{

				}

				System.out.println("\nContinue? \n 'y' yes 'n' no");
				String y = input.next();
				if (y.equals("y"))
					quit = true;
				else{
					System.out.println("Have a nice day!");
					break;
				}

			}else if(x == 4){
				String exspenseCat = " ";

		

				Scanner inFile1 = new Scanner(new File("src/cats.txt"));

				ArrayList<String> cats = new ArrayList<String>();

				while (inFile1.hasNext()){
					exspenseCat = inFile1.nextLine();
					cats.add(exspenseCat);


				}

				System.out.println("Catagory:");
				int j = 1;

				for(int i = 0; i < cats.size(); i++)
				{ 
					System.out.printf( "\n\t" + j + ". " + cats.get(i));
					j++;
				} 
					inFile1.close();
				
					
					System.out.println("\n\n\tContinue? \n 'y' yes /// 'n' no");
					String y = input.next();
					if (y.equals("y"))
						quit = true;
					else{
						System.out.println("Have a nice day!");
						break;
					}

			}//close else if

		input.close();	
		descIn.close();
		storeIn.close();
		}//close while

	}//close main


}//close class
