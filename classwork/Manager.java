import java.util.ArrayList;

public class Manager{
  ArrayList<Task> taskList;
	public Manager(){
    Task t= new Task();
    taskList= new ArrayList<Task>();
		int size= (int) (Math.random()*21 + 30);
		for(int i=0; i<size; i++){
			taskList.add(t);
		}
	}

	public void work(){
		int size= taskList.size();
		int curr= 0;
		while(curr<size){
      if(size-curr>=5){
        Thread t1= new Thread(taskList.get(curr));
        Thread t2= new Thread(taskList.get(curr+1));
        Thread t3= new Thread(taskList.get(curr+2));
        Thread t4= new Thread(taskList.get(curr+3));
        Thread t5= new Thread(taskList.get(curr+4));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try{
    			   t1.join();
  					 t2.join();
  					 t3.join();
  					 t4.join();
  					 t5.join();
    		} catch(Exception e) {}
      }
      else{
        for(int i=curr; i<size; i++){
					Thread t = new Thread(taskList.get(i));
          t.start();
        }
        for(int i=curr; i<size; i++){
					Thread t = new Thread(taskList.get(i));
          try { t.join(); } catch (Exception e) {}
        }
      }
      if(size-curr>5)
        curr+=5;
      else
        curr+=(size-curr);
		}
	}

	public String toString(){
		String total= "";
		for(int i=0; i<taskList.size(); i++)
			total+=taskList.get(i) + "\n";
		return total;
	}
}
