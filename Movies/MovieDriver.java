/**
 * @author Omeed Mariani
 */

import java.util.Scanner;
public class MovieDriver {

public static void main(String[] args) {

char ch='y';

Scanner sc = new Scanner(System.in);

String name="";

String rating="";

int tickets=0;

while(ch=='y' || ch=='Y'){

System.out.println("Enter the name of movie ");

name = sc.nextLine();

System.out.println("Enter the rating of movie ");

rating = sc.nextLine();

System.out.println("Enter number of tickets sold for this movie");

tickets = sc.nextInt();

sc.nextLine();

Movie m = new Movie(name, rating, tickets);

System.out.println(m);

System.out.println("do you want to enter another? (y or n)");

ch = sc.nextLine().charAt(0);

}

sc.close();

System.out.println("goodbye");

}

}
