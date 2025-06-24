public class Faculty{
	private int id;
	private String name;
	private float  salary;
	private String dept;
	private String address;
	
	public Faculty(){}
	public Faculty(int id, String name,String dept, float salary, String address){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.address = address;
	}
	public Faculty(String id, String name,String dept, String salary, String address){
		this.id = Integer.parseInt(id);
		this.name = name;
		this.dept = dept;
		this.salary = Float.parseFloat(salary);
		this.address = address;
	}
	public Faculty(String stringData){ 
		String[] data = stringData.split(",");
		this.id = Integer.parseInt(data[0]);
		this.name = data[1];
		this.dept = data[2];
		this.salary = Float.parseFloat(data[3]);
		this.address = data[4];
		
	}
	public String toString(){
		String output = id+","+name+","+dept+","+salary+","+address+"\n";
		return output;
	}
	public String showInfoGUI(){
		String output = "Name: "+name +"\n"+
						"Id: "+id +"\n"+
						"Department: "+dept +"\n"+
						"Salary: "+salary +"\n"+
						"Address: "+address +"\n";
		return output;
	}
	public void showInfo(){
		
		System.out.println("Name: "+ name);
		System.out.println("Id: "+ id);
		System.out.println("Department: "+ dept);
		System.out.println("Salary: "+ salary);
		System.out.println("Address: "+ address);
	}



	
}