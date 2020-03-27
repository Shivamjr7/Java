package jvm;

public class ShutDownHook {

	public static void main(String[] args) {

		//one way
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shutdown Hook is running !");
			}
		});
		System.out.println("Application Terminating ...");

		
		//other way
		Task task = new Task();
		Runtime.getRuntime().addShutdownHook(task);
	}

}


class Task extends Thread
{
	@Override
	public void run() {
		//code to be executed while shutdown
		
		
		for(int i =0;i<5;i++)
		{
			System.out.println("Shutdown!!");
		}
	}
}