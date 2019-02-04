package backendmanager;

import java.util.Scanner;

import backend.Backend;
import backend.FileBackend;
import crud.CreateAddressFileSystem;
import crud.DeleteAddressFileSystem;
import crud.ReadAddressFileSystem;
import crud.UpdateAddressFileSystem;
import helper.FileAddressBookHelper;
import menu.Menu;
import menuItem.MenuItem;

public class SwitchToFileSystemBackend extends MenuItem {
	BackendMenuManager manage;
    FileSystemBackend file;
    Menu menu1;
	public SwitchToFileSystemBackend(int i, String string, MenuItem menu) {
		super(i,string);
		this.manage= (BackendMenuManager) menu;
		 menu1=new Menu(i,string);
	    CreateAddressFileSystem create=new CreateAddressFileSystem(1,"Create Address",menu);
		ReadAddressFileSystem read=new ReadAddressFileSystem(2,"Read Address",menu);
		UpdateAddressFileSystem update=new UpdateAddressFileSystem(3,"Update Address",menu);
		DeleteAddressFileSystem delete=new DeleteAddressFileSystem(4,"Delete Address",menu);
		GoBack goback=new GoBack(5,"GoBack",menu);
		Exit exit=new Exit(5,"Exit",menu);
	    menu1.addMenuItem(create);
	    menu1.addMenuItem(read);
	    menu1.addMenuItem(update);
	    menu1.addMenuItem(delete);
	    menu1.addMenuItem(goback);
	    menu1.addMenuItem(exit);
	}

	@Override
	public void doSomething() {
		manage.display();
		findInstance();
	    menu1.doSomething();
	}
	
	 public void findInstance() {
		   int i=0;
		   for(Backend b:manage.getMenuList()) {
			   System.out.println(""+(i++)+"."+b);
		   }
		   System.out.println("Enter the file number to select");
		   Scanner scanner=new Scanner(System.in);
		   int ch=scanner.nextInt();
		   for(Backend b:manage.getMenuList()) {
		   if(ch==manage.getMenuList().indexOf(b)) {
			 manage.setCurrentBackend(b);  
			 manage.setSetHelper(new FileAddressBookHelper(manage)); 
		   }
		   
	     }
	 }




	
	
	
}
