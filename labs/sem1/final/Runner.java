
public class Runner {
	public static void main(String[] args) throws Exception {

		Thread s = new Thread(new Runnable() {
			public void run() {
				Server server = new Server();

				try {
					server.poll(); 
				} catch (Exception e) { e.printStackTrace(); }
			}
		});

		Thread c = new Thread(new Runnable() {
			public void run() {
				Client client = new Client();

				try {
					client.poll();
				} catch (Exception e) { e.printStackTrace(); }
			}
		});

		s.start();
		c.start();

	}
}