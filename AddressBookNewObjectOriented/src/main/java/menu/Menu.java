package menu;

import java.util.ArrayList;
import java.util.Scanner;

import menuItem.MenuItem;

public class Menu extends MenuItem{
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	protected ArrayList<MenuItem> menuItem=new ArrayList<MenuItem>();

	public Menu() {
		super();
	}
	

	public Menu(int ch,String text) {
		super(ch, text);
	}
	public Menu(String text) {
		super(text);
	}
	public void addMenuItem(MenuItem menuitem) {
		menuItem.add(menuitem);
	}

	public void	doSomething() {
		    
		do {
			System.out.println("Title:"+this);
			System.out.println("Menu item for Manage Backend Menu");
			displayMenuItem();
			int choice=readAndSelectedChoice();
			matchWithTheChoice(choice); 
		}while(true);
	}
	public void displayMenuItem() {
		
		
		for(MenuItem mi:menuItem) {
			System.out.println(mi);
		}

	}
	public int readAndSelectedChoice() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nenter the choice");
		int choice=scanner.nextInt();
		return choice;
	}
	public void matchWithTheChoice(int choice) {
		boolean count=false;
		for(MenuItem mitem:menuItem) {
			if(choice==mitem.getId()) {
				count=true;
				mitem.doSomething();
				break;
			}
		}
		if(count==false) {
			System.out.println("Invalid Choice");
		}

	}
}
