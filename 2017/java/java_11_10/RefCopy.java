package java_11_10;

public class RefCopy {

	public static void main(String[] args) {
		TempDate td = new TempDate();
		td.iNum = 13;
		
		TempDate newTd = copy(td);//새 객체를 만들어 기존객체의 값을 복사
		//newTd = td와는 다르다 이 경우는 주소값만 복사되어 같은 객체를 두변수가 가지고 있는것 
		
		System.out.println("td 의 값 : " + td.iNum);
		System.out.println("newTd 의 값 : " + newTd.iNum);
	}
	
	static TempDate copy(TempDate td) {
		TempDate mtd = new TempDate();//객체를 새로 만든다.
		mtd.iNum = td.iNum;
		return mtd;//새로만든 객체를 리턴
	}
}

class TempDate{
	int iNum;
}
