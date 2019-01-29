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
      System.out.println("Choose an option (Display, Add, Remove, Update, Quit): ");
      String userChoice = key.nextLine();
      if (userChoice.equals ("Display")) {
        System.out.println (taskList);
      } else if (userChoice.equals ("Add")) {
        System.out.println ("Input a task name: ");
        String name = key.nextLine();
        System.out.println ("Input a task rank: ");
        int rank = key.nextInt();
        taskList.add (new Task (name, rank));
      } else if (userChoice.equals ("Remove")) {
        System.out.println ("Input a task name: ");
        String name = key.nextLine();
        System.out.println ("Input a task rank: ");
        int rank = key.nextInt();
        Task tempTask = new Task (name, rank);
        for (int i = 0; i < taskList.size(); i ++) {
          if (taskList.get(i).getName().equals(tempTask.getName()) && taskList.get(i).getRank() == tempTask.getRank()) {
            taskList.remove(i);
            break;
          }
        }
      } else if (userChoice.equals ("Update")) {
        System.out.println ("Input a task name: ");
        String name = key.nextLine();
        System.out.println ("Input a task rank: ");
        int rank = key.nextInt();

        Task tempTask = new Task (name, rank);
        for (int i = 0; i < taskList.size(); i ++) {
          if (taskList.get(i).getName().equals(tempTask.getName()) && taskList.get(i).getRank() == tempTask.getRank()) {
            System.out.println ("Input a task name: ");
            key.nextLine();
            name = key.nextLine();
            System.out.println ("Input a task rank: ");
            rank = key.nextInt();
            taskList.set (i, new Task(name, rank));
          }
        }
      } else if (userChoice.equals ("Quit")) {
        break;
      }
    }
  }

}
