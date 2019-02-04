package crud;

import backendmanager.BackendMenuManager;
import helper.FileAddressBookHelper;
import menuItem.MenuItem;

public class ReadAddressFileSystem extends MenuItem{
	BackendMenuManager manage;
	FileAddressBookHelper file;

			public ReadAddressFileSystem(int i, String string, MenuItem menu) {
				 super(i,string);
		         this.manage=(BackendMenuManager) menu;
			}

			@Override
			public void doSomething() {
				manage.getSetHelper().readAddressbook();
			}

}
