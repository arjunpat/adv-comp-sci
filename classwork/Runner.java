import java.util.Scanner;

public class Runner {
  public static void main (String[] args) {

    Scanner key = new Scanner (System.in);
    DLList <Task> taskList = new DLList <Task>();
    taskList.add (new Task ("Homework", 1));
    taskList.add (new Task ("TV", 3));
    taskList.add (new Task ("Study", 1));
    taskList.add (new Task ("Check Email", 2));
    taskList.add (new Task ("Run", 2));

    while (true) {
      System.out.print("Choose an option (Display, Add, Remove, Update, Quit): ");
      String userChoice = key.nextLine();
      key.nextLine();
      if (userChoice.equals ("Display")) {
        for (int i = 0; i < taskList.size() - 1; i ++) {
          int loc = i;
          for (int j = i + 1; j < taskList.size(); j ++) {
            if (taskList.get(j).getRank() < taskList.get(loc).getRank()) {
              loc = j;
            }
          }
          Task temp = taskList.get(i);
          taskList.set (i, taskList.get(loc));
          taskList.set (loc, temp);
        }
        System.out.println (taskList.toString());
      } else if (userChoice.equals ("Add")) {
        System.out.print ("Input a task name: ");
        String name = key.nextLine();
        System.out.print ("Input a task rank: ");
        int rank = key.nextInt();
        Task tempTask = new Task (name, rank);
        for (int i = 0; i < taskList.size(); i ++) {
          if (taskList.get(i).compareTo (tempTask) == 0) {
            break;
          } else if (taskList.get(i).compareTo (tempTask) < 0) {
            taskList.add (tempTask);
          }
        }
      } else if (userChoice.equals ("Remove")) {
        System.out.print ("Input a task name: ");
        String name = key.nextLine();
        System.out.print ("Input a task rank: ");
        int rank = key.nextInt();
        Task tempTask = new Task (name, rank);
        for (int i = 0; i < taskList.size(); i ++) {
          if (taskList.get(i).compareTo (tempTask) == 0) {
            taskList.remove(i);
          }
        }
      } else if (userChoice.equals ("Update")) {
        System.out.print ("Input a task name: ");
        String name = key.nextLine();
        System.out.print ("Input a task rank: ");
        int rank = key.nextInt();
        for (int i = 0; i < taskList.size(); i ++) {
          if (taskList.get(i).compareTo (new Task (name, rank)) == 0) {
            System.out.print ("Input a task name: ");
            name = key.nextLine();
            System.out.print ("Input a task rank: ");
            rank = key.nextInt();
            taskList.remove (i);
            taskList.add (new Task (name, rank));
          }
        }
      } else if (userChoice.equals ("Quit")) {
        break;
      }
    }
  }

}
