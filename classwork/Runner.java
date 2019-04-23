public class Runner {
	public static void main(String[] args) {
		Manager m = new Manager();
		System.out.println(m);
		SimpleThread st = new SimpleThread(m);

		Thread[] threadList = new Thread[5];
		for (int i = 0; i < threadList.length; i++) {
			threadList[i] = new Thread(st);
			threadList[i].start();
		}

		try {
			for(int i = 0; i < threadList.length; i++) {
				threadList[i].join();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(m);
	}
}
