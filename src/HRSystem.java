import java.util.HashMap;
import java.util.Map;

class Employee{
    String firstName;
    String lastName;
    int registration;
    int age;
    int daysWorked;
    int vacationDaysTaken;
    double salary;
    int yearsWorked;


    public Employee(String firstName,String lastName,int registration,int age,int daysWorked,int vaccationDaysTaken,double salary,int yearsWorked){
        this.firstName=firstName;
        this.lastName=lastName;
        this.registration=registration;
        this.age=age;
        this.daysWorked=daysWorked;
        this.vacationDaysTaken=vaccationDaysTaken;
        this.salary=salary;
        this.yearsWorked=yearsWorked;
    }


public int timeToRetirement(){

        return Math.min(60 - age, 40 - yearsWorked);
    }

    public int vacationTimeLeft(){

        return (int) ((daysWorked/360.0)*(30 - vacationDaysTaken));
    }



    public int calculateBonus(){

        return (int) (2.2 * salary);

    }
}


class salesRep extends Employee{

    double salesMade;

    public salesRep(String firstName,String lastName,int registration,int age,int daysWorked,int vaccationDaysTaken,double salary,int yearsWorked, double salesMade){
        super(firstName,lastName,registration,age,daysWorked,vaccationDaysTaken,salary,yearsWorked);
        this.salesMade=salesMade;
    }

    public int calculateComission(){
        // comission = 0.1 * salesMade
        return (int) (0.1*salesMade);
    }
}

class salesManager extends salesRep{
    HashMap<Integer,salesRep> sTeam;
    public salesManager(String firstName,String lastName,int registration,int age,int daysWorked,int vaccationDaysTaken,double salary,int yearsWorked, double salesMade, HashMap sTeam){
        super(firstName,lastName,registration,age,daysWorked,vaccationDaysTaken,salary,yearsWorked,salesMade);
        this.sTeam=sTeam;
    }

    public int calculateCommission() {
        int totalSales = sTeam.values().stream().mapToInt(rep -> (int) rep.salesMade).sum();
        return (int) (0.03 * totalSales);
    }

}

public class HRSystem {
    public static void main(String[] args) {
        salesRep rep1 = new salesRep("Prince", "Raj", 101, 35, 300, 5, 60000, 8, 50);
        salesRep rep2 = new salesRep("Rajvendra", "kishore", 102, 40, 250, 10, 65000, 10, 70);

        Map<Integer, salesRep> team = new HashMap<>(); // Using HashMap
        team.put(rep1.registration, rep1);
        team.put(rep2.registration, rep2);

        salesManager manager = new salesManager("Gaurav", "Raut", 103, 45, 500, 15, 80000.0, 15, 150, (HashMap<Integer, salesRep>) team);

        // Test functionalities
        System.out.println("Time left for retirement for rep1: " + rep1.timeToRetirement());
        System.out.println("Vacation time left for rep1: " + rep1.vacationTimeLeft());
        System.out.println("Bonus for rep2: " + rep2.calculateBonus());
        System.out.println("Commission for rep1: " + rep1.calculateComission());

        System.out.println("Manager's name: " +manager.firstName);
        System.out.println("Time to retirement for manager: " + manager.timeToRetirement());
        System.out.println("vacation time left for manager: " + manager.vacationTimeLeft());
        System.out.println("Bonus for manager: " + manager.calculateBonus());
        System.out.println("Commission for manager: " + manager.calculateCommission());

    }
}

