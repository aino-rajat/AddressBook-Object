package menuItem;

public abstract class MenuItem {

	private int id=1;
	private String name;
	
	public MenuItem(int ch,String text){
		id=ch;
		name=text;
		
	}
	public MenuItem() {
		
	}
	public MenuItem(String text) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	abstract public  void doSomething();
	public String toString() {
		return ""+id+"."+name;
	}
	
	
}
