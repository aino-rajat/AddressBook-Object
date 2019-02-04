package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import addressbook.Address;
import backend.Backend;
import backendmanager.BackendMenuManager;

public class FileAddressBookHelper implements BackendHelper {

	
		BackendMenuManager manage;
		Backend current;

		public Backend getCurrent() {
			return current;
		}

		public void setCurrent(Backend current) {
			this.current = current;
		}

		ArrayList<Address> addList=new ArrayList<Address>();
		public FileAddressBookHelper(BackendMenuManager manage) {
			this.manage=manage;
			current=manage.getCurrentBackend();
			load1();
		}

		@Override
		public String toString() {
			return "FileBackendHelper [current=" + current + "]";
		}

		public void createAddressbook() {
			Address address=new Address();
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter the name");
			address.setName(scanner.next());
			System.out.println("enter the emailid");
			address.setEmailId(scanner.next());
			System.out.println("enter the phone number");
			address.setPhoneNo(scanner.nextInt());
			addAddress(address);
			saveAddress();
			System.out.println("Address Created!");
			display1();
		}
		public void addAddress(Address address) {

			addList.add(address);
		}
		public void readAddressbook() {
			
			
			System.out.println("Enter Name to Read Address :");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter The Name :");
			String name=scanner.next();
			for(Address address:addList)
			{
				if(name.equals(address.getName()))
				{
					System.out.println("Email id :"+address.getEmailId());

					System.out.println("Phone No.:"+address.getPhoneNo());
				}
			}
			display1();
		} 



		public void updateAddressbook() {
			System.out.println("Enter Details to Update the Address :");

			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the Name which you want to update :");

			String name=scanner.next();
			for(Address address:addList){
				if(name.equals(address.getName())){
					System.out.println("Enter the new  Email :");

					address.setEmailId(scanner.next());
					System.out.println("Enter the new PhoneNumber :");

					address.setPhoneNo((scanner.nextInt()));
				}
			}
			saveAddress();
			System.out.println("Details Updated....");
			display1();
		}

		public void deleteAddressbook() {
			System.out.println("Enter The Details to Delete the Address :");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter The Name  :");

			String name=scanner.next();
			Address address1=null;
			for(Address address:addList){
				if(name.equals(address.getName())){
					address1=address;
				}
			}
			addList.remove(address1);
			saveAddress();
			display1();
			System.out.println("Record Deleted...!");
		}

		public void saveAddress() {
			try
			{    
				
				FileOutputStream file = new FileOutputStream(current.toString()); //Saving the  object in a file 
				ObjectOutputStream out = new ObjectOutputStream(file); 

				
				out.writeObject(addList); // for serialization of object 

				out.close(); 
				file.close(); 

				System.out.println("Object has been serialized"); 

			} catch(IOException ex) 
			{ 
				System.out.println("IOException is caught"); 
			} 

		}
		public void load1() {
			try
			{   
				FileInputStream file = new FileInputStream(current.toString()); 
				ObjectInputStream in = new ObjectInputStream(file); 
				try {
					addList=(ArrayList<Address>)in.readObject();
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
		public void display1() {
			for(Address ad:addList) {
				System.out.println(ad);
			}
		}
	}

		


