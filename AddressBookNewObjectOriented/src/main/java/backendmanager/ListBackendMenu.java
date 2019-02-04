package backendmanager;

import menu.Menu;
import menuItem.MenuItem;

public class ListBackendMenu extends MenuItem{
	
		Menu menu=new Menu();
		BackendMenuManager manageBackend;
		DeleteBackend selectbackend=new DeleteBackend();
		public ListBackendMenu(int id, String name,Menu menu) {
			super(id,name);
		}

		public ListBackendMenu() {
			super();
		}

		@Override
		public void doSomething() {
			manageBackend=new BackendMenuManager();
			System.out.println("List Of Backends");
			manageBackend.display();
			manageBackend.display1();
		}



	}




