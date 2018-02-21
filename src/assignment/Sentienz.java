package assignment;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Sentienz {
	Employee employeeHirerachy = null;
	MethodImplementation m;
	static Logger log = Logger.getLogger(Sentienz.class);

	  Sentienz(String option){
		m = new MethodImplementation(employeeHirerachy); 
	    switch(option){
	      case "inMemory":
	        m.inMemory();
	        break;
	      case "fileIO":
	        m.fileIO();
	        break;
	      case "hadoop":
	        log.info("hadoop");
	      default:
	        log.info("Option given doesn't matches with available options");
	        log.info("Options Available");
	        log.info("1. inMemory");
	        log.info("2. fileIO");
	        log.info("3. Hadoop");
	    }
	  }

	  public static void main(String[] args){
		BasicConfigurator.configure();
	    Sentienz emp = new Sentienz("inMemory");
	    //emp.fileIO();
	  }
}
