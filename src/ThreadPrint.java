
public class ThreadPrint {
	public static void main(String[] args){
		Task task = new Task(new LockObject());
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
}

class LockObject{
	int i = 1 ;
	void print(){
		System.out.print(Thread.currentThread().getName()+ "=====");
		System.out.println(i++);
	}
}

class Task implements Runnable{
	LockObject lockObj;
	public Task(LockObject lockObj){
		this.lockObj = lockObj;
	}
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
			synchronized(lockObj){
				lockObj.notifyAll();
				lockObj.print();
				try {
					lockObj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}