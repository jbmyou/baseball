package baseBall;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PitchingVsBatting {
	
	public void pitchingVSBatting() {
		
		if(batting()==true&&pitching()==true) {
			System.out.println("쳤습니다.");
		}else if(batting()){
			
		}
	}
	
	

	public boolean batting() {
		Scanner swingOrNot = new Scanner(System.in);
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() { // 수행할 로직을 짜준다.

				swingOrNot.close();
			}
		};

		// 타자 스윙여부 입력창 및 입력창 종료
		System.out.print("				스윙한다 >> 1 입력  거른다 >> 2를 입력하거나 아무것도 입력하지 않는다.");
		
		int swing = swingOrNot.nextInt();
		t.schedule(tt, 1500);

		return swing == 1 ? true : false;

	}


	public boolean pitching() {
		Random ran = new Random();
		int sleep = 150;
		// 난도를 낮추려면 curve를 높이고, straight를 낮추면 됨
		int straight = 8;
		int curve = 2;
		// 투수의 스트라이크/볼 비율에 맞춰 랜덤해서 케이스 나눠(투수 피칭 경우의 수 있다면 그걸로 좌우 선택하게 하고)
		// 그렇지 않다면 볼일경우 1,2 둘중에 다시 랜덤

		// 투수 피칭 결과 랜덤 뽑기 -> 스트라이크/볼 결과까지 뽑아서 아래 조건절들 대체
		double pitching = ran.nextDouble();
		

		try {
			for (int i = 0; i < straight; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(" ");
				}
				System.out.println("○");
				Thread.sleep(sleep);
			}
			if (pitching < 0.33) {
				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = 0;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("○");
					Thread.sleep(sleep);

				}
			} else if (pitching < 0.66) {

				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = i + 1;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("○");
					Thread.sleep(sleep);
				}
			} else {

				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = -i - 1;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("○");
					Thread.sleep(sleep);

				}

			}

			System.out.println("--------------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return pitching<=0.33? true : false;
	}
	
	
	

}
