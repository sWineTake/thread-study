package study.s01;

import java.util.ArrayList;
import java.util.List;

public class Thread05 {

	public static void main(String[] args) {
		Thread05 t = new Thread05();
		t.study01();
	}


	public void study01() {
		List<NewThread> t = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			// 10개의 오래걸리는 작업을 생성 함
			Long loop = (long) (Math.random() * 10000000L);
			t.add(new NewThread(loop));
		}

		for (NewThread thread : t) {
			thread.start();
		}

		// 1. 여기서의 문제는 10개의 스레드중, 작업이 완료되지 않은 쓰레드들이 존재할수 있다.
		/* for (NewThread thread : t) {
			boolean finish = thread.isFinish();
			if (finish) {
				System.out.println("작업 완료 : " + thread.getLoop());
			} else {
				System.out.println("작업 미완료 : " + thread.getLoop());
			}
		}
		*/

		// 2. join으로 10개의 스레드가 모두 종료될때까지 main 쓰레드를 대기할수있다.
		for (NewThread thread : t) {
			try {
				// thread.join(); join설정으로 인해 main 쓰레드가 대기하게된다.
				thread.join(2000); // 2초동안 대기하게된다.
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		// 3. 작업이 완료된 스레드들만 출력할수 있다.
		for (NewThread thread : t) {
			boolean finish = thread.isFinish();
			if (finish) {
				System.out.println("작업 완료 : " + thread.getLoop());
			} else {
				System.out.println("작업 미완료 : " + thread.getLoop());
			}
		}
	}

	public static class NewThread extends Thread {
		public Long loop = 0L;
		public boolean isFinish = false;
		@Override
		public void run() {
			pwo();
		}

		public NewThread(Long loop) {
			this.loop = loop;
		}

		private void pwo() {
			for (Long i = 0L; i < loop; i++) {
				Long a = 1 * i;
			}
			isFinish = true;
		}

		public Long getLoop() {
			return loop;
		}

		public boolean isFinish() {
			return isFinish;
		}
	}
}
