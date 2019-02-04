package backendmanager;

import java.util.Scanner;

import backend.Backend;
import backend.DataBaseBackend;
import crud.CreateAddressFileSystem;
import crud.DeleteAddressFileSystem;
import crud.ReadAddressFileSystem;
import crud.UpdateAddressFileSystem;
import helper.DatabaseAddressBookHelper;
import helper.FileAddressBookHelper;
import menu.Menu;
import menuItem.MenuItem;

public class SwitchToDBBackend extends MenuItem {
	BackendMenuManager manage;
	Menu menu1;
	public SwitchToDBBackend(int i, String string, MenuItem menu) {
		super(i,string);
		this.manage= (BackendMenuManager) menu;
		 menu1=new Menu(i,string);
		 CreateAddressFileSystem create=new CreateAddressFileSystem(1,"Create Address",menu);
			ReadAddressFileSystem read=new ReadAddressFileSystem(2,"Read Address",menu);
			UpdateAddressFileSystem update=new UpdateAddressFileSystem(3,"Update Address",menu);
			DeleteAddressFileSystem delete=new DeleteAddressFileSystem(4,"Delete Address",menu);
			GoBack goback=new GoBack(5,"GoBack",menu);
			Exit exit=new Exit(6,"Exit",menu);
		    menu1.addMenuItem(create);
		    menu1.addMenuItem(read);
		    menu1.addMenuItem(update);
		    menu1.addMenuItem(delete);
		    menu1.addMenuItem(goback);
		    menu1.addMenuItem(exit);
		}

		
	

	@Override
	public void doSomething() {
		display();
		selectList();
	    menu1.doSomething();
		
	}
	void display() {
		int i=0;
		for(Backend b : manage.getMenuList()) {
			
			if(b instanceof DataBaseBackend ) {
				
				System.out.println(i++  +"."+b);
			}

		}
	}
	
	void selectList() {
		System.out.println("Select the back end you want to work");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		for(Backend b : manage.getMenuList()) {
			
			if(choice == manage.getMenuList().indexOf(b) ) {
				manage.setCurrentBackend(b);
				manage.setSetHelper(new DatabaseAddressBookHelper(manage));
			}
			
		}
	}


	
}
