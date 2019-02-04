package crud;

import backendmanager.BackendMenuManager;
import menuItem.MenuItem;

public class UpdateAddressFileSystem extends MenuItem{
	BackendMenuManager manage;
	 public UpdateAddressFileSystem(int i, String string, MenuItem menu) {
			super(i,string);
			this.manage=(BackendMenuManager) menu;
		}

		@Override
		public void doSomething() {
			manage.getSetHelper().updateAddressbook();

			
		}

}
