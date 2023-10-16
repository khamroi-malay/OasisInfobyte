import java.util.*;

class BankAccount{
	String name;
	String username;
	private String password;
	private String accountno;
	int prevtransaction;
	int balance = 50000;
	int transactions =0;
	int flag = 0;
	String transacationshistory = " ";
	Scanner sc = new Scanner(System.in);
public void register()
	{
		System.out.println("Enter Your Name :");
		this.name = sc.nextLine();
		System.out.println("Enter User Name :");
		this.username=sc.nextLine();
		System.out.println("Enter Password :");
		this.password=sc.nextLine();
		System.out.println("Enter Your Account Number");
		this.accountno=sc.nextLine();
		System.out.println("Your Registraion Process is Completed...Continue to LogIn..");	
	}
	
public void checkbalance()
	{
		System.out.println("Rs" + balance + "/-");
	}
	
	public void deposit()
	{
		System.out.println("Enter the Amount That you want to Deposit:");
		int amount = sc.nextInt();
		try
		{
			if(amount<=20000)
			{
				transactions ++;
				balance+=amount;
				prevtransaction= amount;
				System.out.println("Deposit Sucessfully");
				String str = "Rs."+amount+"is credited in your Account";
				transacationshistory = transacationshistory.concat(str);
			}
			else
			{
				System.out.println("OPPS SORRY...Deposite Amout is limited to 20000");
			}
		}
		catch(Exception e)
		{
			
		}
	}
public void withdrawl()
	{
		System.out.println("Enter the Amount Want to Withdraw");
		int amount = sc.nextInt();
		try {
			if(balance>=amount)
			{
				transactions++;
				balance-=amount;
				prevtransaction-=amount;
				System.out.println("Withdrawl Sucessful");
				String str = "Rs."+amount+"is Debited from your Account";
				transacationshistory = transacationshistory.concat(str);
			}
			else
			{
				System.out.println("Insufficient Balance...Not Possible Withdrawl...");
			}
		}
		catch(Exception e)
		{
			
		}
	}
public void transfer()
{
	System.out.println("Enter the Reciver name:");
	String reciver = sc.nextLine();
	System.out.println("Enter the Amount that you want to transfer:");
	int amount = sc.nextInt();
	try
	{
		if(balance<amount)
		{
			if(amount<=10000)
			{
				transactions++;
				balance=-amount;
				System.out.println("The Amount is SucessFully Transferde to" + reciver);
				String str = "Rs."+amount+"is Transferd to"+reciver+ "'s acount from your Account";
				transacationshistory = transacationshistory.concat(str);
			}
			else
			{
				System.out.println("Sorry...The Amount is limited to 10000");
			}
		}
		
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	catch(Exception e)
	{
		
	}
}

public void getprevioustransaction()
{
	if(prevtransaction>0)
	{
		System.out.println("Deposited: " + prevtransaction);
	}
	else if(prevtransaction<0)
	{
		System.out.println("Withdraw: " + Math.abs(prevtransaction));
	}
	else
	{
		System.out.println("No Transactions Occured");
	}
}

public void transactionhistory()
{
	if(transactions == 0)
	{
		System.out.println("Empty!!");
	}
	else
	{
		System.out.println("\n"+transacationshistory );
	}	
}

public boolean login()
{
	boolean islogin = false;
	while(!islogin)
	{
		System.out.println("Enter User Name:");
		String username=sc.nextLine();
		if(username.equals(name))
		{
			while(!islogin)
			{
				System.out.println("Enter Password:");
				String passwd = sc.nextLine();
				if(password.equals(passwd))
				{
					System.out.println("Log In Sucessful");
					islogin = true;
				}
				else
				{
					System.out.println("You Have Entered Wrong Password");
				}
			}
		}
		
		else
		{
			System.out.println(" Not Found");
		}
	}
	return islogin;	
}	
}

public class AtmInterface {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("_______ WELCOME TO ATM INTERFACE _______");
		System.out.println("1.Register"+"\n"+"2.exit");
		System.out.println("Enter your choice : ");
		int choice = input.nextInt();
		if(choice == 1)
		{
			BankAccount B = new BankAccount();
			B.register();
			while(true)
			{
				System.out.println("1.Login"+"\n"+"2.exit");
				System.out.println("Enter your choice : ");
				int ch = input.nextInt();
				if(ch == 1)
				{
					if(B.login())
					{
						System.out.println("Welcome"+ B.name);
						boolean isfinished = false;
						while(!isfinished)
						{	System.out.println("_________ MENU________");
							System.out.println("Enter 1 for Check kBalance");
							System.out.println("Enter 2 for Depsit");
							System.out.println("Enter 3 for Withdrawl");
							System.out.println("Enter 4 for Transfer");
							System.out.println("Enter 5 To get Previous Trasactions");
							System.out.println("Enter 6 To Get Transactions History");
							System.out.println("Enter 7 To Exit");
							System.out.println("Enter Your Choice:");
							int c = input.nextInt();
							switch(c)
							{
								case 1: B.checkbalance (); 
								break; 
								case 2: B.deposit(); 
								break; 
								case 3: B.withdrawl(); 
								break; 								
								case 4: B.transfer(); 
								break; 
								case 5: B.getprevioustransaction(); 
								break; 
								case 6: B.transactionhistory();
								break;
								case 7: isfinished = true; 
								break; 
							
							}
						}
					}
				}
				else
				{
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}

	}

}
