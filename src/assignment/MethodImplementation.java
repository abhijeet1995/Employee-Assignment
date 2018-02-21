package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class MethodImplementation {
	
	static Logger log = Logger.getLogger(Sentienz.class);
	EmployeeImplementation e;
	Employee employeeHirerachy;
	
	public MethodImplementation(Employee employeeHirerachy){
		this.employeeHirerachy = employeeHirerachy;
		e = new EmployeeImplementation(employeeHirerachy);
	}
	

	void inMemory(){
	    e.addEmployee(1, "Sounder", -1);
	    e.addEmployee(2, "Chackra", 1);
	    e.addEmployee(3, "abhijeet", 2);
	    e.addEmployee(3, "name", 2);
	    e.addEmployee(1, "game", -1);
	    e.addEmployee(4, "Rakesh", 2);
	    ArrayList<String> al = e.hirerachy(3);
	    for(String s:al){
	      log.info(s);
	    }
	    e.getEmployee(10);
	  }

	  void fileIO(){
	    try{
	      int flag=1;
	      FileInputStream fin = new FileInputStream("myFile.txt");
	      int i=0;
	      String s="";
	      int id = -2;
	      String name = "-2";
	      int manager = -2;
	      while((i=fin.read())!=-1){
	        //System.out.println((char)i);
	        if((char)i == ' ' || (char)i == '\n'){
	          //System.out.println(s);
	          if(flag % 3 == 1){
	            id=Integer.parseInt(s);
	            //System.out.println(id);
	          }
	          if(flag % 3 == 2){
	            name = s;
	            //System.out.println(name);
	          }
	          if(flag % 3 == 0){
	            manager = Integer.parseInt(s);
	            //System.out.println(manager);
	          }
	          s="";
	          flag++;
	        }
	        else{
	          s = s + (char)i;
	        }
	        if(id!=-2 && name!="-2" && manager!=-2) {
	        		e.addEmployee(id, name, manager);
	        		id = -2;
	        		name = "-2";
	        		manager = -2;
	        }
	      }
	      fin.close();
	    }catch(Exception e){
	      log.error(e);
	    }
	    e.hirerachy(4);
	    try{
	      Employee temp = employeeHirerachy;
	      FileOutputStream fout = new FileOutputStream("myFile.txt");
	      while(temp!=null){
	        int id=temp.id;
	        //System.out.println(id);
	        String name = temp.name;
	        //System.out.println(name);
	        int manager;
	        if(temp.manager!=null)
	          manager = temp.manager.id;
	        else
	          manager = -1;
	        //System.out.println(manager);
	        String s = id + " " + name + " " + manager + "\n";
	        byte b[]=s.getBytes();
	        fout.write(b);
	        temp=temp.next;
	      }
	      fout.close();
	    }catch(Exception e){
	      log.error(e);
	    }
	  }

	  void hadoop(){
	    log.info("Hadoop api under construction will be released soon");
	  }
}
