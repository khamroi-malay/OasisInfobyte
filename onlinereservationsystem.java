package onlinereservationsystem;
import java.util.*;

public class onlinereservationsystem {

	private static boolean[] seats = new boolean[10];
	
	private static void viewSeatMap()
	{
		System.out.println("Current Seat Map");
		for(int i=0;i<seats.length;i++)
		{
			if(seats[i])
			{
				System.out.println(" x ");
			}
			else
			{
				System.out.print((i+1)+" ");
			}
		}
		System.out.println();
	}
	private static void bookingSeat()
	{
		System.out.println("Enter the Seat Number Between 1-10");
		Scanner seat = new Scanner(System.in);
		int seatno = seat.nextInt();
		if(seatno<1 || seatno>10)
		{
			System.out.println("Seat no Not Exit");
		}
		else if(seats[seatno - 1])
		{
			System.out.println("Sit is alreay Reserved");
		}
		else
		{
			seats[seatno - 1] = true;
			System.out.println("Seat booking is confirmed");
		}
	}
	
	private static void cancelTheBooking()
	{
		System.out.println("Enter the Seat Number Between 1-10");
		Scanner seat = new Scanner(System.in);
		int seatno = seat.nextInt();
		if(seatno<1 || seatno>10)
		{
			System.out.println("Seat no Not Exit");
		}
		else if(!seats[seatno - 1])
		{
			System.out.println("Sit is not Reserved");
		}
		else
		{
			seats[seatno - 1] = false;
			System.out.println("Seat booking is canceled");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		System.out.println("Menu of the Reservation System");
		while(true)
		{
			System.out.println("Enter 1 for showing the SeatMap");
			System.out.println("Enter 2 for booking the seat");
			System.out.println("Enter 3 for canceliation");
			System.out.println("Enter 4 for exit");
			
			int choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
				viewSeatMap();
				break;
			case 2:
				bookingSeat();
				break;
			case 3:
				cancelTheBooking();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("You have entered wrong choice");
			}
		}
	}

}
