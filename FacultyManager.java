import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FacultyManager{
	String path;
	
	public FacultyManager(){
		path = "./faculty.txt";
	}
	
	public void writeFaculty(Faculty s){
		
		File file = new File(path);
		try{
			FileWriter writer = new FileWriter(file,true);
			writer.write(s.toString());
			writer.flush();
			writer.close();
		}catch(Exception ex){
			
		}
	}
	public Faculty[] getAllFaculty(){
		File file = new File(path);
		int count=0;
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				sc.nextLine();
				count++;
			}
			
		}catch(Exception ex){}
		Faculty[] facultys = new Faculty[count];
		try{
			Scanner sc = new Scanner(file);
			for(int i=0;i<count;i++){
				String line = sc.nextLine();
				Faculty f = new Faculty(line);
				facultys[i] = f;
			}
		}catch(Exception ex){
			
		}
		return facultys;
		
		
	}
}