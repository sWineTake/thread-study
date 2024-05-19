package study.s01;

// 가장 기본적인 스레드 사용법
public class Thread01 {

	public static void main(String[] args) {
		Thread01 t = new Thread01();
		t.study02();

	}

	// 스레드 생성 및 실행
	public void study01() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread01");
			}
		});

		// 현재쓰레드 -> main
		System.out.println("Main01 : start, name : " + Thread.currentThread().getName());
		t.start();
		System.out.println("Main01 : end, name : " + Thread.currentThread().getName());
	}

	// 스레드에서 에러 발생시 처리
	public void study02() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread02");
				throw new RuntimeException("Thread02 Error");
			}
		});

		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("name : " + t.getName());
				System.out.println("여기서 에러처리를 할수 있다." + e.getMessage());
			}
		});

		// 실행될 t 객체의 스레드의 우선순위를 높여서 작업 - 추후 여러개의 쓰레드 작업을 할시 우선순위를 높여서 작업을 할수 있다.
		t.setPriority(Thread.MAX_PRIORITY);
		t.setName("Thread02");
		t.start();
	}
}
