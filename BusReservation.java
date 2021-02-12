package ex;

import java.util.*;

class MyRunnable implements Runnable {
	private Bus bus;
	private int count;
	
	public MyRunnable(Bus bus, int count) {
		this.bus = bus;
		this.count = count;
	}

	@Override
	public void run() {
		synchronized(bus) {
			System.out.println("-----------------------------------");
			System.out.println("Thread-" + count + " 가 들어왔음.");
			bus.availableSeat();
			bus.requestSeat();
			bus.reservedSeat();
			System.out.println("Thread-" + count + " 가 나갑니다.");
			System.out.println("-----------------------------------");
			if(bus.getSeat() < 0) System.exit(0);
		}
	}
}

class Bus {
	private int seat, inputSeat;
	
	public Bus(int seat) {
		this.seat = seat;
	}
	
	public int getSeat() {
		return seat;
	}
	
	public void availableSeat() {
		System.out.print("가능한 좌석수 : " + seat);
	}
	
	public void requestSeat() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 요청좌석수 : ");
		inputSeat = sc.nextInt();
	}
	
	public void reservedSeat() {
		seat -= inputSeat;
		if(seat < 0)
			System.out.println("좌석 예약이 불가능합니다.");
		else
			System.out.println(inputSeat + " 좌석이 예약되었음.");
	}
}

public class busTest {
	public static void main (String[] args) {
		Bus bus = new Bus(10);
		for(int count=0; count<5; count++) {
			Thread t = new Thread(new MyRunnable(bus, count));
			t.start();
		}
	}
}