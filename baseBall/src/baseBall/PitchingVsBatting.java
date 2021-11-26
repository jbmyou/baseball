package baseBall;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PitchingVsBatting {
	
	public void pitchingVSBatting() {
		
		if(batting()==true&&pitching()==true) {
			System.out.println("�ƽ��ϴ�.");
		}else if(batting()){
			
		}
	}
	
	

	public boolean batting() {
		Scanner swingOrNot = new Scanner(System.in);
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() { // ������ ������ ¥�ش�.

				swingOrNot.close();
			}
		};

		// Ÿ�� �������� �Է�â �� �Է�â ����
		System.out.print("				�����Ѵ� >> 1 �Է�  �Ÿ��� >> 2�� �Է��ϰų� �ƹ��͵� �Է����� �ʴ´�.");
		
		int swing = swingOrNot.nextInt();
		t.schedule(tt, 1500);

		return swing == 1 ? true : false;

	}


	public boolean pitching() {
		Random ran = new Random();
		int sleep = 150;
		// ������ ���߷��� curve�� ���̰�, straight�� ���߸� ��
		int straight = 8;
		int curve = 2;
		// ������ ��Ʈ����ũ/�� ������ ���� �����ؼ� ���̽� ����(���� ��Ī ����� �� �ִٸ� �װɷ� �¿� �����ϰ� �ϰ�)
		// �׷��� �ʴٸ� ���ϰ�� 1,2 ���߿� �ٽ� ����

		// ���� ��Ī ��� ���� �̱� -> ��Ʈ����ũ/�� ������� �̾Ƽ� �Ʒ� �������� ��ü
		double pitching = ran.nextDouble();
		

		try {
			for (int i = 0; i < straight; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(" ");
				}
				System.out.println("��");
				Thread.sleep(sleep);
			}
			if (pitching < 0.33) {
				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = 0;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("��");
					Thread.sleep(sleep);

				}
			} else if (pitching < 0.66) {

				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = i + 1;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("��");
					Thread.sleep(sleep);
				}
			} else {

				int j = 0;
				for (int i = 0; i < curve; i++) {
					j = -i - 1;
					for (; j < 9; j++) {
						System.out.print(" ");
					}
					System.out.println("��");
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
