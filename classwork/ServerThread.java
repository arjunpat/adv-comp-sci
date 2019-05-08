public class ServerThread implements Runnable {
  private Socket clientSocket;
  private PrintWriter out;
  private Manager cm;

  public SeverThread(Socket clientSocket, Manager cm) {
    this.clientSocket = clientSocket;
    this.cm = cm;
  }

  public void sendMessage(String msg) {
    if (out != null) {
      out.println(msg);
    }
  }

  public void run() {
    System.out.println(Thread.currentThread().getName() + ": connection opened");

    try  {
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out.println("Connection successful!");

      while (true) {
        String inputLine = in.readLine();

        if (inputLine.equals("bye")) {
          break;
        } else {
          cm.broadCast(inputLine);
        }
      }

      out.flush();
      out.close();
    }
  }
}
