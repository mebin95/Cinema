import java.util.*;

public class Cinema {
	public static void main(String[] args) {
		int option = 0;
		int totalCost = 0;
		String name;

		ArrayList < Movie > movies = new ArrayList < Movie > ();

		Scanner select = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);
		Scanner custName = new Scanner(System.in);

		movies.add(new Movie("Spiderman Homecoming", "17/07/2017"));
		movies.add(new Movie("Wonder Woman", "19/07/2017"));

		System.out.println("Welcome to QA Cinemas. What is your name?");
		String CustomerName = custName.nextLine();
		System.out.println();
		System.out.println("Welcome " + CustomerName + ".");
		System.out.println();
		do {
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("Please Enter 1 to Display Movies");
			System.out.println("Please Enter 2 to Make Booking");
			System.out.println("Please Enter 3 to Exit\n");

			System.out.print("Enter Option: ");
			option = select.nextInt();


			if (option == 1) {
				System.out.println("DISPLAY MOVIES Selected");
				System.out.println("-------------------------\n");
				for (int i = 0; i < movies.size(); i++) {
					int movieNumber = i + 1;
					System.out.println("Movie Number: " + movieNumber);;
					System.out.println("Movie Name: " + movies.get(i).getMovieName());
					System.out.println("Movie Date: " + movies.get(i).getMovieDate());
					System.out.println("\n");
				}
				System.out.println("End of Movie List.\n");
			}


			if (option == 2) {
				System.out.println("MAKE BOOKING Selected");
				System.out.println("-------------------------\n");
				Random rnd = new Random();
				int costumerId = rnd.nextInt(999);
				Customer customer = new Customer(costumerId, CustomerName);

				for (int i = 0; i < movies.size(); i++) {
					int movieNumber = i + 1;
					System.out.println("Movie Number: " + movieNumber);;
					System.out.println("Movie Name:   " + movies.get(i).getMovieName());
					System.out.println("Movie Date:   " + movies.get(i).getMovieDate());
					System.out.println();
				}
				System.out.println("-------------------------");
				System.out.println("Which movie would you like to book?");
				System.out.print("Enter Option: ");
				int movieNumber = choice.nextInt();

				System.out.println();

				System.out.println("These are the ticket prices.");
				System.out.println("Standard - £8");
				System.out.println("OAP - £6");
				System.out.println("Student - £6");
				System.out.println("Child - £4");
				System.out.println();

				System.out.println("How many standard tickets would you like?");
				System.out.println();

				System.out.print("Enter Option: ");
				int selectStandard = choice.nextInt();

				System.out.println("How many OAP tickets would you like?");
				System.out.print("Enter Option: ");
				int selectOAP = choice.nextInt();

				System.out.println("How many Student tickets would you like?");
				System.out.print("Enter Option: ");
				int selectStudent = choice.nextInt();

				System.out.println("How many Child tickets would you like?");
				System.out.print("Enter Option: ");
				int selectChild = choice.nextInt();

				System.out.println();

				Booking booking = new Booking(customer, movies.get(movieNumber - 1));
				System.out.println();

				System.out.println("Your Order");
				System.out.println("-------------------------");


				if (movies.get(movieNumber - 1).getMovieDate() == "19/07/2017") {
					totalCost = booking.getCost(selectStandard, selectOAP, selectStudent, selectChild, true);
				} else {
					totalCost = booking.getCost(selectStandard, selectOAP, selectStudent, selectChild, false);
				}

				System.out.println("Costumer ID: " + customer.getId());
				System.out.println("Costumer Name: " + customer.getName());
				System.out.println("Total costs: £" + totalCost);
				System.out.println();
				System.out.println("Thanks for booking with QA Cinemas.");
				System.exit(0);
			}


			if (option == 3) {
				System.exit(0);
			}

		} while (true);
	}
}