
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Emp {
    int empid;
    String name;
    int salary;

    Emp(int id, String name, int salary) {
        this.empid = id;
        this.name = name;
        this.salary = salary;
    }

    public int hashCode() {
        return Objects.hash(empid, name, salary);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Emp)) {
            return false;
        }
        Emp e = (Emp) obj;
        return Objects.equals(e.empid, empid) && Objects.equals(e.name, name) && Objects.equals(e.salary, salary);
    }

    public String toString() {
        return "EmpId: " + empid + ", Name: " + name + ", Salary: " + salary ;
    }


}

class Methods{

    HashSet<Emp> hs ;

    public void addEmployee(Emp e){
        if(this.hs == null){
            hs = new HashSet();
            hs.add(e);
            return;
        }
        try {
            for(Emp temp : hs){
                if(temp.empid == e.empid)
                    throw new Exception();
            }
        } catch (Exception e1) {
            System.out.println("Employee already present!");
            return;
        }

        hs.add(e);
    }

    public boolean removeEmployeeById(int id){
        for(Emp temp: hs){
            if(temp.empid == id){
                hs.remove(temp);
                return true;
            }
        }

        return false;
    }

    public HashSet<Emp> getEmployeeWithName(String name){
        HashSet<Emp> ans = new HashSet();
        for(Emp temp: hs){
            if(temp.name == name){
                ans.add(temp);
            }
        }
        return ans;
    }

    public HashSet<Emp> getEmployeeWithSalaryRange(int low, int high){
        HashSet<Emp> ans = new HashSet();
        for(Emp temp: hs){
            if(temp.salary >= low && temp.salary <= high){
                ans.add(temp);
            }
        }
        return ans;
    }



}
public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods m = new Methods();
        System.out.print("\n\nChoose one of the following:\n1. To add employee details\n2. Remove employee by id\n3. Get employee details from name\n4. Get employees within a salary range\n5. To quit\nEnter your choice: ");
        int userInput = sc.nextInt();
        while(userInput != 5){

            switch (userInput) {
                case 1 : {
                    int id;
                    String name;
                    int salary;
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    System.out.print("Enter name: ");
                    name = sc.next();
                    System.out.print("Enter salary: ");
                    salary = sc.nextInt();

                    Emp emp = new Emp(id, name, salary);
                    m.addEmployee(emp);
                    break;
                }

                case 2: {
                    System.out.print("Enter emp_id to be removed: ");
                    int ID = sc.nextInt();
                    if(m.removeEmployeeById(ID)){
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Some error occurred!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Employee name to retrieve information: ");
                    String nm = sc.next();
                    HashSet<Emp> entry1 = m.getEmployeeWithName(nm);
                    if(entry1.isEmpty())
                        System.out.println("Employee doesn't exist!");
                    else
                        System.out.println(entry1.toString());
                    break;
                }

                case 4:{
                    System.out.print("Enter a salary range: ");
                    int lowerlimit, uperlimit;
                    lowerlimit = sc.nextInt();
                    uperlimit = sc.nextInt();
                    HashSet<Emp> entry2 = m.getEmployeeWithSalaryRange(lowerlimit, uperlimit);
                    if(entry2.size() == 0)
                        System.out.println("Employee doesn't exist!");
                    else
                        System.out.println(entry2.toString());
                    break;
                }

                case 5: {
                    break;
                }

                default:
                    System.out.println("Enter a valid option");
                    break;
            }

            System.out.print("\n\nChoose one of the following:\n1. To add employee details\n2. Remove employee by id\n3. Get employee details from name\n4. Get employees within a salary range\n5. To quit\nEnter your choice: ");
            userInput = sc.nextInt();

        }

    }
}

