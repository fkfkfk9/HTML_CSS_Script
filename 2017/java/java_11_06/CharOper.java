package java_11_06;

public class CharOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char char1 = 'f';        
        char char2 = char1;          
        char char3 =' ';
        char char4 = 'v';

        int inum = char1 + 3;//char형은 인트값과 더하면 int로 형변환이 일어난다.       

        char3 = (char)(char1 + 3); 
        //단항연산자는 케릭터형을 유지할 수 있다.
        char2++;//char2 = char2 + 1은 에러 int로 형변환 된다. 
        char3++; 
        char1 = 'f' + 4;//컴파일러가 연산을 먼저 처리하기 때문에 오류가 나지 않는다.
        
        System.out.println("inum = " + inum); 
        System.out.println("char1=" + char1); 
        System.out.println("char2=" + char2); 
        System.out.println("char3=" + char3);
        System.out.println("변경 전 char4=" + char4);
        char4 = (char)(char4-32);//소문자와 대문자는 32의 차이가 난다.
        System.out.println("변경 후 char4=" + char4);
	}

}
