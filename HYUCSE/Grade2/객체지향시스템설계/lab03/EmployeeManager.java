package prac3;

public class EmployeeManager {
	public static void main(String[] args) {
		Employee A = new Employee("James Wright", 42, "Manager", 20000);
		Employee B = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
		Employee C = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
		Employee D = new Employee("John Doe", 22, "Engineer", 10000, 10);

		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(C.toString());
		System.out.println(D.toString());
		
		Employee E = new Employee("Joo MinJae", 21);
		boolean check = E.equals(B);
		if(check) {
			System.out.println("같은 직원입니다.");
		}else {
			System.out.println("다른 직원입니다.");
		}
		
		A.Vacation(10);
		C.Vacation(10);
		
		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(C.toString());
		System.out.println(D.toString());
		System.out.println(E.toString());
	}
}
