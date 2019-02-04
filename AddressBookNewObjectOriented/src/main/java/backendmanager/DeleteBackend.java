package backendmanager;

import menuItem.MenuItem;

public class DeleteBackend extends MenuItem{

	public DeleteBackend() {
		super();
	}


	public DeleteBackend(int i, String string) {
		super(i,"Delete Backend");

	}

	@Override
	public void doSomething() {


		System.out.println("Delete Backend Selected");
	}
}


