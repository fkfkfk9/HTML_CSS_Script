package java_11_20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueDemo {

	public static void main(String[] args) {
		Stack s = new Stack();
		Queue q = new LinkedList<>();
		//Queue q = new Queue();지원안한다.
		
		s.push("데 헤아");
		s.push("발렌시아");
		s.push("스몰링");
		s.push("필 존스");
		s.push("에쉴리 영");
		q.offer("마티치");
		q.offer("포그바");
		/*
			스텍 : posh로 자료 입력 pop으로 자료를 꺼냄
			스텍의 경우 인터넷의 뒤로 앞으로 기능에 응용할 수 있다.
			큐 : offer로 입력 poll로 꺼내온다.
			꺼내올 때 스텍은 마지막으로 넣은것 부터 규는 넣은 순서대로 나온다.
		*/
		System.out.println("스텍 출력");
		while(!s.empty()) {
			System.out.println(s.pop());
		}
		System.out.println();
		System.out.println("큐 출력");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
