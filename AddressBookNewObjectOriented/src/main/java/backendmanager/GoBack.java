package backendmanager;

import menu.Menu;
import menuItem.MenuItem;

public class GoBack extends MenuItem {

	MenuItem menuitem;
	public GoBack(int id, String name, MenuItem menu) {
		super(id, name);
		this.menuitem=menuitem;
	}

	@Override
	public void doSomething() {
		menuitem.doSomething();
		
	}
}
