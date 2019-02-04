package backendmanager;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import backend.DataBaseBackend;
import backend.FileBackend;
import menuItem.MenuItem;

public class AddDbBackend extends MenuItem {
	BackendMenuManager m;
	protected AddDbBackend(int id, String name,MenuItem m) {
		super(id, name);
		this.m= (BackendMenuManager) m;
	}

	
	@Override
	public void doSomething() {
		System.out.println("Add Data Base Selected ");
		create();
		m.save();
	}

	public void create() {

		DataBaseBackend file=new DataBaseBackend();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter User");
		file.setUsername(input.next());
		System.out.println("Enter url");
		file.setUrl(input.next());
		
		System.out.println("Enter password");
		file.setPassword(input.next());
		
		m.addPathList(file);
	

	}

	
	
}

