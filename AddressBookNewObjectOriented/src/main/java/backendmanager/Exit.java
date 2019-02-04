package backendmanager;

import menuItem.MenuItem;

public class Exit extends MenuItem {
	
	MenuItem m;
	
	public Exit(int id, String name, MenuItem menuItem) {
		super(id, name);
	}

	
	@Override
	public void doSomething() {
		System.exit(0);
		
	}
}
