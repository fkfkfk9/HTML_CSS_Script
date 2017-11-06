package java_11_06;

public class ByteOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte num1 = 8; 
        byte num2 = 13; 
//      byte c = a + b; ERROR
//      a+b의 연산은 int 로 계산되기 때문에 입력받는 변수도 int여야한다.
//      System.out.println(c);
        int num3 = num1 + num2;//입력받을 변수를 int로 하거나
        byte num4 = (byte)(num1 * num2);//계산한 값을 byte로 형변환한다.
        //byte는 크기가 작아 계산결과가 오버플로우가 일어날 수 있으니 int형에 값을넣는걸 권장
        System.out.println("num1 : " + num1 + "  num2 : " + num2);
        System.out.println("num3 : " + num3 + "  num4 : " + num4);
    }

}
