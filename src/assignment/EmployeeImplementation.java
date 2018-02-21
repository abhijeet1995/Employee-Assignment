package assignment;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class EmployeeImplementation {
	
	Employee employeeHirerachy;
	static Logger log = Logger.getLogger(Sentienz.class);
	
	EmployeeImplementation(Employee employeeHirerachy){
		this.employeeHirerachy = employeeHirerachy;
	}
	
	Employee getEmployee(int id){
	    Employee temp = employeeHirerachy;
	    while(temp!=null){
	      if(temp.id==id)
	        return temp;
	      temp=temp.next;
	    }
	    try{
	      throw new InputException("Employee doesn't exist");
	    }catch(InputException e){
	      log.error(e);
	    }
	    return null;
	  }

	  void addEmployee(int id, String name, int managerId){
	    Employee temp = employeeHirerachy;
	    Employee temp1 = null;
	    if(managerId == -1){
	      Employee emp = new Employee();
	      emp.id = id;
	      emp.name = name;
	      emp.next = null;
	      emp.manager = null;
	      if(temp==null)
	        employeeHirerachy = emp;
	      else{
	        while(temp.next!=null){
	          if(temp.id == id){
	            try{
	              throw new InputException("Mentioned employee id already exist");
	            }catch(InputException e){
	              log.error(e);
	            }
	            return;
	          }
	          temp = temp.next;
	        }
	        if(temp.id==id){
	          try{
	            throw new InputException("Mentioned employee id already exist");
	          }catch(InputException e){
	            log.error(e);
	          }
	          return;
	        }
	        temp.next = emp;
	      }
	    }
	    else{
	      while(temp!=null){
	        if(temp.id == managerId){
	          temp1=temp;
	          break;
	        }
	        temp=temp.next;
	      }
	      if(temp1==null){
	        try{
	          throw new InputException("Mentioned manager id doesn't exist");
	        }catch(InputException e){
	          log.error(e);
	        }
	        return;
	      }
	      temp = employeeHirerachy;
	      Employee emp = new Employee();
	      emp.id = id;
	      emp.name = name;
	      emp.manager = temp1;
	      emp.next = null;
	      if(temp==null)
	        employeeHirerachy=emp;
	      else{
	        while(temp.next!=null){
	          if(temp.id==id){
	            try{
	              throw new InputException("Mentioned employee id already exist");
	            }catch(InputException e){
	              log.error(e);
	            }
	            return;
	          }
	          temp=temp.next;
	        }
	        if(temp.id==id){
	          try{
	            throw new InputException("Mentioned employee id already exist");
	          }catch(InputException e){
	            log.error(e);
	          }
	          return;
	        }
	        temp.next=emp;
	      }
	    }
	  }

	  ArrayList<String> hirerachy(int id){
	    ArrayList<String> al=new ArrayList<String>();
	    Employee temp = employeeHirerachy;
	    Employee temp1 = null;
	    while(temp!=null){
	      if(temp.id == id){
	        temp1 = temp;
	        break;
	      }
	      temp = temp.next;
	    }
	    while(temp1!=null){
	      al.add(temp1.name);
	      log.info("id: "+temp1.id+"  "+"name: " + temp1.name+"---->");
	      temp1=temp1.manager;
	    }
	    System.out.println("");
	    return al;
	  }
}
