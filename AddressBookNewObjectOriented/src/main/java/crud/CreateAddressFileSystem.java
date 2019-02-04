package crud;

import backendmanager.BackendMenuManager;
import helper.FileAddressBookHelper;
import menu.Menu;
import menuItem.MenuItem;

public class CreateAddressFileSystem extends MenuItem {

	BackendMenuManager manage;
	FileAddressBookHelper filehelper;
	 public CreateAddressFileSystem(int i, String string,MenuItem menu) {
          super(i,string);
          this.manage=(BackendMenuManager) menu;
	}
	@Override
	public void doSomething() {
		
		manage.getSetHelper().createAddressbook();
	}

}
