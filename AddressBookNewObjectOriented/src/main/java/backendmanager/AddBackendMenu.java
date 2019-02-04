package backendmanager;

import menu.Menu;
import menuItem.MenuItem;

public class AddBackendMenu extends MenuItem{
	Menu menu1;
	AddBackendMenu(int id, String name,Menu menu) {
		super(id,"Add Backend");
		menu1=new Menu(id,name);
		AddDbBackend db=new AddDbBackend(1,"DataBase Backend ",menu);
		FileSystemBackend fb=new FileSystemBackend(2,"FileSystem Database Backend",menu);
		GoBack goback=new GoBack(3,"Go Back",menu);
		Exit exit=new Exit(4,"Exit",menu);
		menu1.addMenuItem(db);
		menu1.addMenuItem(fb);
		menu1.addMenuItem(goback);
		menu1.addMenuItem(exit);
	}

	public AddBackendMenu() {

		super();
	}
	@Override
	public void doSomething() {

		while(true) {
			System.out.println("Select The Backend...");
			menu1.displayMenuItem();
			int choice=menu1.readAndSelectedChoice();
			menu1.matchWithTheChoice(choice);
		}

	}
}
