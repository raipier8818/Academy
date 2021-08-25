# Assignment 1
  

## Configuration

- Activity.java

- Schedule.java

- TravelScheduler.java

----

  

## *Activity.java*

  

  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name |
| private String | location | Activity location |
| private int | price | Activity price |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>String location <br>int price | set all private variable to parameter |
| Activity other | copy constructor |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public String  | toString | Null | return Activity's **name**, **location** and **price** in String
| public boolean | equals | Activity other | return true if all variables in Other is equal to this
  
  
  
  
  

## *Schedule.java*
   


  

### Variable

  

| Type | Variable Name | Description |
| :------------ | :----------- | :------------------- |
| private String | name | Activity name  	 |
| private int 	 | days | Schedule total day |
| private Activity | plan | Activities array |
| private int | expense | total price in plan |
| public static int | scheduleNum | the number of Schedule  |

  

<br>

### Constructor

  

| parameter | Description |
| :------------ | :----------- |
| String name <br>int days | set **name** and **days** to parameter, set expense to 0 and set all **plan**'s element to null |
| Schedule other | copy constructor |
| Schedule other <br>String newName | copy other's **plan** and set **name** to newName |

  

<br>

  

### Method

| Return Type | Method Name | Parameter | Description |
| :------------ | :----------- | :------ |:------------------- |
| public Activity[][] | getPlan | Null | return **plan** (shallow copy)
| public boolean | checkActivity | Activity newActivity <br>int day <br>int time | return true if newActivity can be added in **plan[day][time]**
| public void | printPlan | Null | print plan
| public boolean | removeActivity | int day <br>int time | return true if it can remove Activity in **plan[day][time]** and update expense
| public boolean | addActivity | int day <br>int time <br>Activity selectedActivity | return true if it can add selectedActivity to **plan[day][time]** and update **expense**
  
  
  

## *TravelScheduler.java*

  

### Method

   

| Return Type | Method Name | Parameter |
| :------------ | :----------- | :------ | 
| public static void | main | String[] args 
| static void | selectSchedule | Schedule[] scheduleList <br>Activity[] activityList | 
| static void | editSchedule   | Schedule[] scheduleList <br>Activity[] activityList | 
| static boolean | addActivity | Activity[] activityList <br> Schedule selectedSchedule| 
| public boolean | removeActivity | Schedule selectedSchedule |
| public void	 | printSchedule | Schedule selectedSchedule| 
| public boolean | makeNewSchedule | Schedule[] scheduleList |
| public boolean | copyExistingSchedule | Schedule[] scheduleList |  


### Method Description

| Method Name | Description |
| :-----------------:| :------------|
| main | Declare and Allocate scheduleList[5], activityList[8]. <br>And initialize activityList. <br>Enter an integer to select menu using Scanner while num is not 3. <br>1. Do **selectSchedule** <br>2. Do **editSchedule** <br>3. Exit program
| selectSchedule | Print scheduleList. <br> Enter an Integer to select Schedule using Scanner. <br> Enter an Integer to select menu using Scanner while num is not 0.<br> 1. If **addActivity** is false, print "Fail to add activity"<br>2. If **removeActivity** is true, print "Removed successfully"<br> 3. Do **printSchedule**.
| editSchedule | Enter an integer to select menu using Scanner.<br>0. Return<br>1. Do **makeNewSchedule**.<br>2. Do **copyExistingSchedule**.
| addActivity  | Print activityList.<br>Enter an integer to select Activity<br>Enter two integers. (day, time)<br> return true if selected Activity can be added in selected Schedule.<br> (using selectedSchedule.addActivity(day, time, selectedActivity))
| removeActivity  | Print selected Schedule's plan.<br>Enter two integers. (day, time)<br>return true if it can remove Activity in selected Schedule's plan. <br>(using selectedSchedule.removeActivity(day,time))
| printSchedule  | Print selected Schedule's plan<br>(using selectedSchedule.printPlan())
| makeNewSchedule  | If the number of Schedule is not less than 5, return false.<br>Enter the new Schedule name.<br>If there is a Schedule has same name, return false.<br>Enter travel days, make new Schedule and return true.
| copyExistingSchedule  | Enter an integer to select Schedule to copy plan.<br>Enter the new Schedule name.<br>If selected Schedule is null or there is a Schedule already has same name, return false.<br>Make new Schedule and return true.

<br>

# Runtime

![1](/uploads/8fd5a80dafbd380d2de89305104a3b4b/1.PNG)

<br>

![2](/uploads/215028c0967fbf41a96eb6c36fe35d76/2.PNG)