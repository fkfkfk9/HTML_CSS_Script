package java_11_07;

class LoopEx {
	public static void main(String[] args)
	{
        // for문에 Lop이라는 이름을 붙였다.
		Lop : for (int i = 1; i < 9; i++) {
					for (int j = 2; j <= 9 ; j++) {
						if(i == 8) {
							break Lop;//바깥 포문을 탈출
//							break;//안의 포문을 탈출
//							continue Lop;//바깥 루프로 이동 i++
//							continue//안쪽 루프로 이동 j++
						}
						System.out.printf("%d x %d = %2d", j, i, i*j);
						if(j == 9) System.out.println();
						else System.out.print(" | ");
					}
		} 
	}
}
