package study.s01;

public class Thread02 {

	public static void main(String[] args) {
		Thread02 t = new Thread02();
		t.study01();
	}

	// 상속받아서 사용한 쓰레드 실행
	public void study01() {
		Thread t = new NewThread();
		t.start();

	}

	// 이렇게 Thread를 상속받아서 사용도 가능하며, 좋은점은 Runable을 바로 오버라이드만 하면되기때문에 간편하다
	public static class NewThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread02");
		}


	}

}
