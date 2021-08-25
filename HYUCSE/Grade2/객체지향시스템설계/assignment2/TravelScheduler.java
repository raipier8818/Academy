package assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.*;

public class TravelScheduler {
	static Scanner keyboard = new Scanner(System.in);
	static Person[] memberList;
	static int activityListNum;
	static int memberListNum;
	
	static boolean addActivity(Activity[] activityList, Schedule selectedSchedule) {
		for(int i = 0; i < activityListNum; i++) {
			System.out.println((i+1) + ") " + activityList[i].toString());
		}
		int activityNum;
		int day, time;	
		
		try {
			System.out.print("Select activity to do : ");
			activityNum = keyboard.nextInt();
			if(activityNum > activityListNum || activityNum <= 0) throw new InvalidAccessException(activityNum);
			
			Activity selectedActivity = activityList[activityNum-1];
			
			System.out.print("Enter the day to do activity : ");
			day = keyboard.nextInt();
			System.out.print("Enter the time to do activity(9~20) : ");
			time = keyboard.nextInt();
			
			
			selectedSchedule.checkException(selectedActivity);

			if(!selectedSchedule.addActivity(day, time, selectedActivity)) throw new InvalidAccessException(0);
			else return true;
		}catch(InsufficientConditionException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
	}
	
	static boolean removeActivity(Schedule selectedSchedule) {
		selectedSchedule.printPlan();
		
		
		try {
			int day, time;
			System.out.print("Enter the day to remove activity : ");
			day = keyboard.nextInt();
			System.out.print("Enter the time to remove activity : ");
			time = keyboard.nextInt();
			
			if(!selectedSchedule.removeActivity(day, time)) throw new InvalidAccessException(0);	
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
		return true;
		
	}
	
	
	static void selectSchedule(Schedule[] scheduleList, Activity[] activityList) {
		for(int i = 0; i < 5; i++) {
			if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
			else System.out.println((i+1) + ") " + scheduleList[i].getName());
		}
		
		int scheduleNum;
		Schedule selectedSchedule = null;

		System.out.print("Select a schedule : ");
		
		try {
			scheduleNum = keyboard.nextInt();
			if(scheduleNum == 0) return;
			else if(scheduleNum > 5) throw new InvalidAccessException(scheduleNum);
			
			selectedSchedule = scheduleList[scheduleNum-1];
			if (selectedSchedule == null) throw new InvalidAccessException(scheduleNum);
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return;
		}
		

		
		int actNum = 0;
		
		do {		
			try {
				System.out.println("1) Add activity");
				System.out.println("2) Remove activity");
				System.out.println("3) Print schedule");
				System.out.print("Select menu : ");
				
				
				actNum = keyboard.nextInt();
				
				if(actNum == 1) {
					if(!addActivity(activityList, selectedSchedule)) System.out.println("Fail to add activity");			
				}
				else if(actNum == 2) {
					if(removeActivity(selectedSchedule))
						System.out.println("Removed successfully");
				}
				else if(actNum == 3) {
					if(selectedSchedule == null) continue;
					selectedSchedule.printPlan();
				}
				else if(actNum != 0) throw new InvalidAccessException(actNum);
			} catch (InvalidAccessException e) {
				System.out.println(e.getMessage());
				continue;
			} catch(InputMismatchException e) {
				System.out.println("Input Mismatch Exception");
				continue;
			}

		}while(actNum != 0);

	}
	
	static boolean makeNewSchedule(Schedule[] scheduleList) {
		try {
			if(Schedule.scheduleNum >= scheduleList.length) throw new ArrayFullException(Schedule.scheduleNum);	
			

			System.out.print("Enter a name for the schedule : ");
			String scheduleName = keyboard.nextLine();
			
			for(int i = 0; i < Schedule.scheduleNum; i++) {
				if(scheduleList[i].getName().equals(scheduleName)) return false;
			}
			
			
			System.out.print("Enter travel days : ");
			int days = keyboard.nextInt();
			scheduleList[Schedule.scheduleNum] =  new Schedule(scheduleName, days);
			scheduleList[Schedule.scheduleNum].setMember(memberListNum);
			
			for(int i = 0; i < memberListNum; i++) {
				System.out.println((i + 1) + ". " + memberList[i].toString());
			}
			
			keyboard.nextLine();

			System.out.print("Choose members you want to Add (Enter the numbers in line) : ");
			String line = keyboard.nextLine();
			String[] members = line.split(" ");
			
			for(int i = 0; i < members.length; i++) {
				if(Integer.parseInt(members[i]) - 1 >= memberList.length) throw new InvalidAccessException(Integer.parseInt(members[i]) - 1);
				scheduleList[Schedule.scheduleNum].addMember(memberList[Integer.parseInt(members[i]) - 1]);
			}
			
			Schedule.scheduleNum += 1;
			
			
			
		}catch(ArrayFullException e){
			System.out.println(e.getMessage());
			return false;
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}catch(NumberFormatException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		}
		
		
		return true;
	}
	
	static boolean copyExistingSchedule(Schedule[] scheduleList) {
		try {
			if(Schedule.scheduleNum >= scheduleList.length) throw new ArrayFullException(Schedule.scheduleNum);
			
			for(int i = 0; i < 5; i++) {
				if(scheduleList[i] == null) System.out.println((i+1) + ") EMPTY SCHEDULE");
				else System.out.println((i+1) + ") " + scheduleList[i].getName());
			}
			
			System.out.print("Select the schedule to copy : ");
			int selectedNum = keyboard.nextInt();
			keyboard.nextLine();
			System.out.print("Enter a new schedule name : ");
			String scheduleName = keyboard.nextLine();
			
			if(scheduleList[selectedNum-1] == null) throw new InvalidAccessException(0);
			for(int i = 0; i < Schedule.scheduleNum; i++) {
				if(scheduleList[i].getName().equals(scheduleName)) return false;
			}
			
			scheduleList[Schedule.scheduleNum++] = new Schedule(scheduleList[selectedNum-1], scheduleName);
				
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return false;
		} catch(InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return false;
		} catch(ArrayFullException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	static void editSchedule(Schedule[] scheduleList, Activity[] activityList) {
		System.out.println("1) Make a new schedule");
		System.out.println("2) Copy an existing schedule");
		System.out.print("Select menu : ");
		
		try {

			int scheduleNum;
			scheduleNum = keyboard.nextInt();
			keyboard.nextLine();
			
			if(scheduleNum == 0) return;
			
			else if(scheduleNum == 1) {
				makeNewSchedule(scheduleList);
			}
			
			else if(scheduleNum == 2) {
				copyExistingSchedule(scheduleList);					
			}
			else throw new InvalidAccessException(scheduleNum);
	
		} catch (InvalidAccessException e) {
			System.out.println(e.getMessage());
			return;
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception");
			return;
		}
		
	}
	
	
	public static void main(String[] args) {
		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList;
		
		
		try {
			Scanner ActivityListFile = new Scanner(new FileInputStream("ActivityList.txt"));
			Scanner MemberListFile = new Scanner(new FileInputStream("MemberList.txt"));
			
			activityListNum = ActivityListFile.nextInt();
			ActivityListFile.nextLine();
			
			memberListNum = MemberListFile.nextInt();
			MemberListFile.nextLine();
			
			activityList = new Activity[activityListNum];
			memberList = new Person[memberListNum];
			
			
			for(int i = 0; i < activityListNum; i++) {
				String input = ActivityListFile.nextLine();
				String[] line = input.split(", ");
				Activity newActivity;
				
				
				if(line[0].equals("Activity")){
					if(line.length == 4) newActivity = new Activity(line[1],line[2],Integer.parseInt(line[3]));
					else newActivity = new Activity(line[1], null, Integer.parseInt(line[2]));
				}else if(line[0].equals("Show")) {
					if(line.length == 5) newActivity = new ShowActivity(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					else newActivity = new ShowActivity(line[1], null,  Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				}else if(line[0].equals("Extreme")) {
					if(line.length == 5) {
						newActivity = new ExtremeActivity(line[1], "null", Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					}else newActivity = new ExtremeActivity(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
				}else {
					newActivity = null;
				}
				
				activityList[i] = newActivity;
				
				
			}
			
			for(int i = 0; i < memberListNum; i++) {
				String input = MemberListFile.nextLine();
				String[] line = input.split(", ");
				
				Person newMember;
				newMember = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				memberList[i] = newMember;
				
			}
			
			int menuNum = 3;
			
			do {
				System.out.println("1) Select schedule");
				System.out.println("2) Edit schedule");
				System.out.println("3) End program");
				System.out.print("Select menu : ");
				
				try {
					menuNum = keyboard.nextInt();
					
					if(menuNum == 1) {
						selectSchedule(scheduleList, activityList);								
					}else if (menuNum == 2) {
						editSchedule(scheduleList, activityList);
					}else if(menuNum != 3) throw new InvalidAccessException(menuNum);
						
				} catch (InvalidAccessException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Input Mismatch Exception");
				}
				
			}while(menuNum != 3);
			
			
			ActivityListFile.close();
			MemberListFile.close();
			
		}catch(Exception e) {
			System.exit(0);
		}
		
	}
}