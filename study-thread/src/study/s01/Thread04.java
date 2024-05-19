package study.s01;

public class Thread04 {

	public static void main(String[] args) {
		Thread04 t = new Thread04();
		t.study01();
	}


	public void study01() {
		Thread t = new NewThread();
		// main 쓰레드는 종료되어도, t 쓰레드는 오래걸리는 작업으로 종료되지않지만 종료되길 원할경우 아래와같이 설정한다.
		// 쓰레드가 start되기전에 설정되어야한다.
		t.setDaemon(true);
		t.start();
	}

	public static class NewThread extends Thread {
		@Override
		public void run() {
			// 오래걸리는 어떤작업을 수행하게된다.
			for (Long i = 0L; i < 100000000000L; i++) {
				Long a = 1 * i;
				System.out.println(a);
			}
		}
	}


}
