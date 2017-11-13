package java_11_13;

public class GameTest {

	public static void main(String[] args) {
		Game g = new Game();
		Game g2 = new Game("Adventure");
		Game g3 = new Game("FPS", 5, 9000);
		
		System.out.println("장르 : " + g.genre + " 평점 : " + 
				g.score + " 플레이시간 : " + g.playtime);
		System.out.println("장르 : " + g2.genre + " 평점 : " + 
				g2.score + " 플레이시간 : " + g2.playtime);
		System.out.println("장르 : " + g3.genre + " 평점 : " + 
				g3.score + " 플레이시간 : " + g3.playtime);
	}
}

class Game{
	String genre;
	int score;
	int playtime;
	
	Game(){
		this("RPG", 3, 900);//생성자가 생성자를 불러올땐 this를 붙인다.
		//Game("RPG", 3, 900);호출은 지원하지 않는다.
	}
	Game(String genre){
		this(genre, 3, 500);
	}
	Game(String genre, int score, int playtime){
		this.genre = genre;
		this.score = score;
		this.playtime = playtime;
	}
}
