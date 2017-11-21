package java_11_21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo2 {
	static HashMap footBallPlayer = new HashMap();

	public static void main(String[] args) {
		addFootBallPlayer("맨유", "포그바", "프랑스");
		addFootBallPlayer("맨유", "루카쿠", "벨기에");
		addFootBallPlayer("맨유", "줄라탄", "스웨덴");
		addFootBallPlayer("토트넘", "손흥민", "한국");
		addFootBallPlayer("토트넘", "헤리 케인", "잉글랜드");
		addFootBallPlayer("아스날", "리카제트", "프랑스");
		addFootBallPlayer("아스날", "외질", "독일");
		addFootBallPlayer("제라드", "잉글랜드");

		printList();
	} // main

	// 팀을 추가하는 메서드
	static void addTeam(String teamName) {
		if(!footBallPlayer.containsKey(teamName))
			footBallPlayer.put(teamName, new HashMap());
	}

	// 팀에 선수를 추가하는 메서드
	static void addFootBallPlayer(String teamName, String playerName, String playerContry) {
		addTeam(teamName);
		HashMap team = (HashMap)footBallPlayer.get(teamName);
		team.put(playerName, playerContry);	
	}

	static void addFootBallPlayer(String playerName, String playerContry) {
		addFootBallPlayer("은퇴", playerName, playerContry);
	}//팀이 없는 선수는 전부 은퇴로 묵는다.

	// 모든 축구선수를 출력시킨다.
	static void printList() {
		Set set = footBallPlayer.entrySet();
		Iterator it = set.iterator();	

		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();

			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();	

			System.out.println(" * "+e.getKey()+"["+subSet.size()+"]");

			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String playerName = (String)subE.getKey();
				String playerContry = (String)subE.getValue();
				System.out.println(playerName + " " + playerContry );
			}
			System.out.println();
		}
	} // printList()
}
