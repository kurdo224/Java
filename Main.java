//Purpose: Final Project (To-Do List Application)
//Author: Wasim Alkrad
//Date: December/10/22

import Tasks.Tasks;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Declare a scanner
        Scanner n = new Scanner(System.in);

        //Declare an array list
        ArrayList<Tasks> task_objects = new ArrayList<>();

        Tasks new_task;

        System.out.println("Press 1 To Start");
        System.out.println("Press 0 To End");

        int start = n.nextInt();
        boolean flag = Boolean.TRUE;


        while(flag){

            if (start != 0){


                //Ask for Input
                System.out.println("\n" + "Press 1 to ADD a Task");

                System.out.println("Press 2 to DISPLAY Tasks ");

                System.out.println("Press 3 to EDIT a Task");

                System.out.println("Press 4 to MARK a Task as DONE");

                System.out.println("Press 5 to REMOVE a Task");

                System.out.println("Press 6 to EXIT");

                int action = n.nextInt();

                switch (action){

                    case 1:

                        new_task = new Tasks();

                        n.nextLine();

                        System.out.println("Title: ");
                        String task_title = n.nextLine();


                        System.out.println("Description: ");
                        String task_description = n.nextLine();

                        System.out.println("Due Date (Day/Month/Year)");
                        System.out.println("Day");
                        int day_input = n.nextInt();

                        System.out.println("Month (i.e. Nr. 1 for January)");
                        int month_input = n.nextInt();

                        System.out.println("Year");
                        int year_input = n.nextInt();

                        String st = "Pending";
                        new_task.setTitle(task_title);
                        new_task.setDescription(task_description);
                        new_task.setStatus(st);
                        new_task.setDay(day_input);
                        new_task.setMonth(month_input);
                        new_task.setYear(year_input);

                        task_objects.add(new_task);

                        break;

                    case 2:

                        System.out.println("-------------------------");
                        System.out.println("You have: " + task_objects.size() + " Tasks");
                        System.out.println("-------------------------");
                        int counter = 1;

                        for (Tasks a: task_objects) {

                            System.out.println("Task number: " + counter + "\n" + "Title: " + a.getTitle() + "\n" +
                                    "Description: " + a.getDescription() + "\n" +
                                    "Status: " + a.getStatus() + "\n" + "Due on: " + a.getDay() + "/" + a.getMonth() + "/" + a.getYear());
                            System.out.println("----------------------");

                            counter++;
                        }

                        break;

                    case 3:

                        if (task_objects.size() == 0){

                            System.out.println("----------------------");
                            System.out.println("You have " + task_objects.size() + " Tasks to EDIT");
                            System.out.println("----------------------");
                            break;
                        }

                        boolean flag2 = Boolean.TRUE;
                        while (flag2){


                            System.out.println("----------------------");
                            int counter2 = 1;
                            for (Tasks a: task_objects) {

                                System.out.println("Task number: " + counter2 + "\n" + "Title: " + a.getTitle() + "\n" +
                                        "Description: " + a.getDescription() + "\n" +
                                        "Status: " + a.getStatus() + "\n" + "Due on: " + a.getDay() + "/" + a.getMonth() + "/" + a.getYear());
                                System.out.println("----------------------");

                                counter2++;
                            }



                            while (flag2){

                                System.out.println("Enter the number of Task you want to edit or (Press 9 to go back to the Main Menu): ");
                                int task_nr = n.nextInt();

                                if (task_nr == 9){

                                    flag2 = false;
                                    break;

                                }
                                Tasks task_edit = task_objects.get(task_nr -1);

                                System.out.println("What do you want to edit? ");
                                System.out.println("Press 1 to edit Title");
                                System.out.println("Press 2 to edit Description");
                                System.out.println("Press 3 to edit Due Date");

                                int capture = n.nextInt();

                                if (capture == 1){
                                    System.out.println("Type your new Title");
                                    n.nextLine();
                                    String new_title = n.nextLine();
                                    task_edit.setTitle(new_title);

                                }

                                else if (capture == 2){

                                    System.out.println("Type your new Description");
                                    n.nextLine();
                                    String new_description = n.nextLine();
                                    task_edit.setDescription(new_description);

                                }

                                else if (capture == 3){

                                    System.out.println("Type your new Date");
                                    System.out.println("New Day:");
                                    int new_day = n.nextInt();
                                    System.out.println("New Month (i.e. Nr. 1 for January):");
                                    int new_month = n.nextInt();
                                    System.out.println("New Year:");
                                    int new_year = n.nextInt();


                                    task_edit.setDay(new_day);
                                    task_edit.setMonth(new_month);
                                    task_edit.setYear(new_year);

                                    System.out.println("Date Changed!");

                                }
                            }
                        }

                        break;

                    case 4:

                        if (task_objects.size() == 0){

                            System.out.println("----------------------");
                            System.out.println("You have " + task_objects.size() + " Tasks to MARK as DONE!");
                            System.out.println("----------------------");
                            break;
                        }

                        boolean flag3 = Boolean.TRUE;
                        while (flag3){

                            int counter3 = 1;
                            System.out.println("----------------------");
                            for (Tasks a: task_objects) {

                                System.out.println("Task number: " + counter3 + "\n" + "Title: " + a.getTitle() + "\n" +
                                        "Status: " + a.getStatus());
                                System.out.println("----------------------");
                                counter3++;

                            }

                            while (flag3) {


                                System.out.println("What Task do you want to MARK as DONE? or (Press 9 to go back to the Main Menu)");
                                int mrk_as_done = n.nextInt();

                                if (mrk_as_done == 9){

                                    flag3 = false;
                                    break;

                                }

                                Tasks task_mark_done = task_objects.get(mrk_as_done - 1);

                                System.out.println("Type C to Confirm changing the status of " + " >>> " + task_mark_done.getTitle() + " <<< " + " to DONE!");
                                String c = n.next();

                                if (c.equals("c")){

                                    task_mark_done.setStatus("DONE!");
                                    System.out.println("OK Task " + " >>> " + task_mark_done.getTitle() + " <<< " + " is Marked as DONE!");
                                }
                            }
                        }

                        break;

                    case 5:

                        if (task_objects.size() == 0){

                            System.out.println("----------------------");
                            System.out.println("You have " + task_objects.size() + " Tasks to REMOVE");
                            System.out.println("----------------------");
                            break;
                        }

                        boolean flag4 = Boolean.TRUE;
                        while (flag4){


                            int counter4 = 1;
                            System.out.println("----------------------");
                            for (Tasks a: task_objects) {

                                System.out.println("Task number: " + counter4 + "\n" + "Title: " + a.getTitle());
                                System.out.println("----------------------");

                                counter4++;

                            }

                            while (flag4){

                                System.out.println("What Task do you want to REMOVE? or (Press 9 to go back to the Main Menu)");
                                int remove_task = n.nextInt();

                                if (remove_task == 9){

                                    flag4 = false;
                                    break;

                                }

                                Tasks task_remove = task_objects.get(remove_task - 1);

                                System.out.println("Type c to Confirm removing task " + " >>> " + task_remove.getTitle() + " <<< ");
                                String cc = n.next();

                                if (cc.equals("c")){

                                    System.out.println("OK Task " + " >>> " + task_remove.getTitle() + " <<< " + " is REMOVED! \n");
                                    task_objects.remove(task_remove);
                                    flag4 = false;

                                }
                            }
                        }

                        break;

                    case 6:

                        flag = false;
                        break;

                }
            }

            else if (start == 0){

                flag = Boolean.FALSE;
            }
        }
    }
}