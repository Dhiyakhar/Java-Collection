import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
    {
        Family family = new Family();
        Scanner sc1 = new Scanner(System.in);	//Input pilihan berupa angka
        Menu menu = new Menu();

        menu.mainMenu(family);					//Main Menu Program

    }
}