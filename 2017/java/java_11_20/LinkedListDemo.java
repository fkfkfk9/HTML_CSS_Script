package java_11_20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
	public static void main(String args[]) { 
        ArrayList al = new ArrayList(3333333);
        LinkedList ll = new LinkedList(); 

        System.out.println("----- 순차적으로 추가하기 -----");
        //객체 하나하나마다 다음객체 주소가 필요한 링크트 리스트가 느림다.
        System.out.println("ArrayList :"+add_check1(al)); 
        System.out.println("LinkedList :"+add_check1(ll)); 
        System.out.println(); 
        System.out.println("----- 중간에 추가하기 -----"); 
        System.out.println("ArrayList :"+add_check2(al)); 
        System.out.println("LinkedList :"+add_check2(ll)); 
        //어레이 리스트는 중간추가시 그 뒤 변수 모두가 인덱스가 바뀌어 느리지만
        //링크드 리스트는 들어가는 것과 다음것의 주소만 바뀌므로 빠르다.
        System.out.println(); 
        System.out.println("----- 중간에서 삭제하기 -----"); 
        System.out.println("ArrayList :"+remove_check2(al)); 
        System.out.println("LinkedList :"+remove_check2(ll)); 
        //중간삭제 또한 모든 인덱스를 다뤄야하는 어레이 리스트가 느리다.
        System.out.println();         
        System.out.println("----- 순차적으로 삭제하기 -----"); 
        System.out.println("ArrayList :"+remove_check1(al)); 
        System.out.println("LinkedList :"+remove_check1(ll));
        //순차적 삭제는 어레이 리스트가 빠르다
        
        
        ArrayList al2 = new ArrayList();
        LinkedList ll2 = new LinkedList<>(al2);
        //이런식으로 어레이 리스트에 데이터를 순차적으로 입력하고
        //링크드리스트에 값을 넣어 중간에 추가나 삭제의 속도를 높이는 방식으로 응용가능
  } 

  public static long add_check1(List list) {//리스으안에 데이터를 add하는 시간 체크
        long start = System.currentTimeMillis(); 
        //시간을 체크한다.
        for(int i=0; i<2000000;i++) list.add(i+""); 
        long end = System.currentTimeMillis(); 
        return end - start; 
  } 

  public static long add_check2(List list) { 
        long start = System.currentTimeMillis(); 
        for(int i=0; i<3333;i++) list.add(333, "add"); 
        long end = System.currentTimeMillis(); 
        return end - start; 
  } 

  public static long remove_check1(List list) {//매개변수 list의 맨뒤부터 지움
        long start = System.currentTimeMillis(); 
        for(int i=list.size()-1; i >= 0;i--) list.remove(i); 
        long end = System.currentTimeMillis(); 
        return end - start; 
  } 

  public static long remove_check2(List list) { 
        long start = System.currentTimeMillis(); 
        for(int i=0; i<10000;i++) list.remove(i); 
        long end = System.currentTimeMillis(); 
        return end - start; 
  } 
}
