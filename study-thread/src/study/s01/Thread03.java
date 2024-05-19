package study.s01;

public class Thread03 {

	public static void main(String[] args) throws InterruptedException {
		Thread03 t = new Thread03();
		t.study01();
	}


	public void study01() throws InterruptedException {
		Thread t = new NewThread();
		t.start();
		Thread.sleep(1000);
		// 만약 오래걸리는 작업일 경우 main 쓰레드는 종료되었지만, t 쓰레드는 종료되지않는다.
		// 이런경우 interrupt()를 사용하여 종료시킬수 있다.
		t.interrupt();
	}

	public static class NewThread extends Thread {
		@Override
		public void run() {
			pwo();
		}

		private void pwo() {
			try {
				for (Long i = 0L; i < 100000000000L; i++) {
					if (Thread.currentThread().isInterrupted()) { // 현재쓰레드가 인터럽트 상태인지 체크후 인터럽트일경우에는 쓰레드를 종료하게된다.
						System.out.println("Interrupted");
						return;
					}
					Long a = 1 * i;
					System.out.println(a);
				}
			} catch (Exception e) {
				System.out.println("Interrupted : " + e.getMessage());
			}
		}
	}


}
