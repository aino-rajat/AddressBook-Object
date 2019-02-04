package backendmanager;

import menu.Menu;
import menuItem.MenuItem;

public class SelectBackend extends MenuItem {
	
Menu menu1;
	
	public SelectBackend(int i, String string,Menu menu) {
		super(i,string);
     	menu1=new Menu(i,string);
	    SwitchToDBBackend db=new SwitchToDBBackend(1,"To DataBase",menu);
	    SwitchToFileSystemBackend fb=new SwitchToFileSystemBackend(2,"To FileSystem",menu);
	    GoBack goback=new GoBack(3,"Go Back",menu);
	    Exit exit=new Exit(4,"Exit",menu);
	    menu1.addMenuItem(db);
	    menu1.addMenuItem(fb);
	    menu1.addMenuItem(goback);
	    menu1.addMenuItem(exit);
			
	}

	@Override
	public void doSomething() {
		
		menu1.doSomething();
	
	}
}
