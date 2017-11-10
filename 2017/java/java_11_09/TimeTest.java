package java_11_09;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time();
		t.setHour(12);
		t.setMinute(77);
		t.setSecond(33);
		
		t.printTime();
	}
}

class Time{
	//private : 접근자
	private int hour;
	private int minute;
	private int second;
		
	//기능 : 필드에 정확한 값을 할당하고 유효성 검사도 할 수 있다.
	
	//getter메서드
	public int getHour() {
		return hour;
	}
	//setter메서드
	public void setHour(int hour) {
		if(hour < 0 || hour > 23 ) {
			System.out.println("시간은 0~23까지만 입력가능합니다.");
			System.exit(0);
		}else this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute < 0 || minute > 59 ) {
			System.out.println("분은 0~59까지만 입력가능합니다.");
			System.exit(0);
		}else this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second < 0 || second > 59 ) {
			System.out.println("초는 0~59까지만 입력가능합니다.");
			System.exit(0);
		}else this.second = second;
	}

	public void printTime() {
		System.out.printf("현재 시간은 %d시 %d분 %d초 입니다.", hour, minute, second);
	}
}
