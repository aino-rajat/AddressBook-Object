package backendmanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import backend.Backend;
import backend.DataBaseBackend;
import backend.FileBackend;
import helper.BackendHelper;
import menu.Menu;

public class BackendMenuManager extends Menu {
	 ArrayList<Backend> menuList=new ArrayList<Backend>();
	    Backend currentBackend;
	    BackendHelper setHelper;
	    
		public BackendHelper getSetHelper() {
			return setHelper;
		}
		public void setSetHelper(BackendHelper setHelper) {
			this.setHelper = setHelper;
		}
		
		public Backend getCurrentBackend() {
			return currentBackend;
		}
		public void setCurrentBackend(Backend currentBackend) {
			this.currentBackend = currentBackend;
		}
		public BackendMenuManager(){
			super(0,"Manage Backend Menu");
			ListBackendMenu listbackend=new  ListBackendMenu(1,"List Backend",this);
			AddBackendMenu addbackend=new AddBackendMenu(2,"Add Backend",this);
			SelectBackend switchBackend=new SelectBackend(3,"Select Backend",this);
			DeleteBackend select=new DeleteBackend(4,"Delete Backend");
			Exit exit=new Exit(5,"Exit",this);
			
			addMenuItem(listbackend);
			addMenuItem(addbackend);
			addMenuItem(switchBackend);
			addMenuItem(select);
			addMenuItem(exit);
			load();
			
		}
		public void addPathList(Backend object) {
			getMenuList().add(object);
		}
		
		
		public void save() {
			try
			{  
				
				FileOutputStream file = new FileOutputStream("/home/intern3/Desktop/ABCD/abc.ser");
				
				ObjectOutputStream out = new ObjectOutputStream(file); 

				// Method for serialization of object 
				out.writeObject(menuList); 

				out.close(); 
				file.close(); 

			//	System.out.println("Object has been serialized"); 

			} 

			catch(Exception ex) 
			{ 
				//System.out.println("IOException is caught"); 
			} 

		}
	public void load() {		///home/intern3/Desktop/ABCD/file1.txt
			 try
		        {   
		            FileInputStream file = new FileInputStream("/home/intern3/Desktop/ABCD/abc.ser"); 
		            ObjectInputStream in = new ObjectInputStream(file); 
					try {
						setMenuList((ArrayList<Backend>)in.readObject());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} 
		            in.close(); 
		            file.close();  
		        } 
		          
		        catch(IOException ex) 
		        { 
		            System.out.println("IOException is caught"); 
		        } 
		}
		public void display() {
			for(Backend b: menuList) {
				if(b instanceof FileBackend) {
				System.out.println(b);
			  }
			}
		}
		
		public void display1() {
			for(Backend b1: menuList) {
				if(b1 instanceof DataBaseBackend) {
				System.out.println(b1);
			  }
			}
		}
		public ArrayList<Backend> getMenuList() {
			return menuList;
		}
		public void setMenuList(ArrayList<Backend> menuList) {
			this.menuList = menuList;
		}
	   
	   
	  

	}
