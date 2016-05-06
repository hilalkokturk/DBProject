import java.util.Scanner;

public class MysqlCinemaBooking {
	public static void main(String[] args) {

	    	Scanner sc = new Scanner(System.in);
	    		DBConnector database = new DBConnector();
	                  //  String moviename = sc.nextLine();
	    				//database.searchForMovieInfo(moviename);

	    		System.out.println("**********Welcome Your Cinema Guideline**********");
	    		System.out.println("If you are Admin please press 1");
	    		System.out.println("If you are User please press 2");
	    		System.out.println("To sign in please press 3");
	    		int button = sc.nextInt();
	    			
	    		
	    		if (button == 1) {
	    			System.out.println("id:");
	    			String id=sc.nextLine();

	    			System.out.println("password:");
	    			String password = sc.nextLine();
	    			if(database.loginCheckAdmin(id,password)==true){
	    			System.out.println("Welcome to administrator interface");
	    			System.out
	    					.println("In this interface, you can see all data in the database. Also, you can insert or delete data from database. ");
	    			System.out.println("To see all of data about Cinema press 1");
	    			System.out.println("To see all of data about Movies press 2");
	    			System.out.println("To insert data for Cinema press 3");
	    			System.out.println("To insert data for Movies press 4");
	    			System.out.println("To delete data from Cinema press 5");
	    			System.out.println("To delete data from Movies press 6");
	    			System.out.println("0 is the exit number.");
	    			int button2 = sc.nextInt();

	    			if (button2 == 1) {
	    				database.getAllDataInCinemaForAdmin();
	    				return;
	    			}

	    			else if (button2 == 2) {
	    				database.getAllDataInMoviesForAdmin();
	    				return;
	    			}

	    			else if (button2 == 3) {
	    				database.putDataintoCinemasForAdmin();
	    				return;
	    			}

	    			else if (button2 == 4) {
	    				database.putDataintoMoviesForAdmin();
	    				return;
	    			}

	    			else if (button2 == 5) {
	    				database.deleteDataFromCinemaForAdmin();
	    				return;
	    			}

	    			else if (button2 == 6) {
	    				database.deleteDataFromMoviesForAdmin();
	    				return;
	    			}

	    			else {
	    				System.out.println(sc + "is not defined.");
	    				return;
	    			}
	    			}
	    			else{
	    				System.out.println("Check Your info Again");
	    			}
	    		} 
	    		
	    		//*************************************************************************************
	    		else if (button == 2) {
	    			System.out.println("mail:");
	    			String mail=sc.nextLine();

	    			System.out.println("password:");
	    			String password = sc.nextLine();
	                                if(database.loginCheckAdmin(mail,password)==true){
	    			System.out.println("Welcome the user interface.");
	    			System.out
	    					.println("In this interface, you can all cinemas information in Ankara. Also, you can see all movies in vision.");
	    			System.out.println("To see all data about Cinemas press 1");
	    			System.out
	    					.println("To see all data about movies in vision press 2");
	    			System.out.println("To search information about a movie press 3");
	    			System.out.println("To see which movie exist on which cinema press 4");
	    			System.out.println("To see all movie session press 5");
	    			int button2 = sc.nextInt();
	    			if (button2 == 1) {
	    				database.getAllDataInCinemaForCustomer();
	    				return;
	    			} else if (button2 == 2) {
	    				database.getAllDataInMoviesForCustomer();
	    				return;
	    			} else if (button2 == 3) {
	    				System.out.println("Which movie you want to have information?");
	    				String moviename = sc.nextLine();
	    				database.searchForMovieInfo(moviename);
	    				return;
	    			} else if (button2 == 4) {
	    				database.searchForMovieonCinema();
	    				return;
	    			}
	    			else if(button2==5){
	    				database.searchForSession();

	    			}
	                                }
	                                else{
	                                    System.out.println("Check your information.");
	                                }
	                                }
	    			

	    		else if (button == 3) {
	    			System.out.println("Please fill the user form.");
	    			database.haveNewCustomer();
	    			return;
	    		}

	    		else {
	    			System.out.println(sc + " is not defined.Try again");
	    		}
	    		
	    	}    }
	
