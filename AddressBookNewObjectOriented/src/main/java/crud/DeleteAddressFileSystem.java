package crud;

import backendmanager.BackendMenuManager;
import menuItem.MenuItem;

public class DeleteAddressFileSystem extends MenuItem{

	BackendMenuManager manage;
	public  DeleteAddressFileSystem(int i, String string, MenuItem menu) {
		 super(i,string);
		 this.manage=(BackendMenuManager) menu;
	}

	@Override
	public void doSomething() {
		manage.getSetHelper().deleteAddressbook();
		
	}

}
