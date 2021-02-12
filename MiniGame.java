package ex;

import java.util.*;

abstract class Sprite {
	int x=3, y=3;
	abstract void move(char c);
}

class Main extends Sprite {
	void move(char c) {
		if(c == 'h') --x;
		else if(c == 'j') --y;
		else if(c == 'k') ++y;
		else if(c == 'l') ++x;
	}
}

class Monster extends Sprite {
	public Monster() {
		x = y = 7;
	}
	
	void move(char c) {
		x += (Math.random()-0.5)>0? 1: -1;
		y += (Math.random()-0.5)>0? 1: -1;
	}
}

class Game {
	private String[][] board = new String[10][19];
	// private char[][] board = new char[10][19];
	private char c;
	Scanner sc = new Scanner(System.in);
	Main player = new Main();
	Monster monster = new Monster();
	
	public Game() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<19; j++) {
				if(i==0 || i==9) board[i][j] = "#";
				else {
					if(j==0 || j==18) board[i][j] = "#";
					else board[i][j] = " ";
				}
			}
		}
		board[player.y][player.x] = "@";
		board[monster.y][monster.x] = "M";
		board[(player.y+3)][player.x] = "G";
	}
	
	public void print() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<19; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		System.out.print("왼쪽(h), 위쪽(j), 아래쪽(k), 오른쪽(l) : ");
		c = sc.next().charAt(0);
	}
	
	public void start() {
		board[player.y][player.x] = " ";
		board[monster.y][monster.x] = " ";
		player.move(c);
		monster.move(c);
		if((board[player.y][player.x]).equals("G") || (board[monster.y][monster.x]).equals("G"))
			return;
		board[player.y][player.x] = "@";
		board[monster.y][monster.x] = "M";
	}
	
	public boolean end() {
		if((player.y < 1 || player.y > 8) || (player.x < 1 || player.x > 18)) {
			System.out.println("You die ㅜㅡㅜ");
			return false;
		}
		else if((monster.y < 1 || monster.y > 8) || (monster.x < 1 || monster.x > 18)) {
			System.out.println("Monster loser");
			return false;
		}
		if((board[player.y][player.x]).equals("G")) {
			System.out.println("Get Gold, You Winner!!!");
			return false;
		}
		else if((board[monster.y][monster.x]).equals("G")) {
			System.out.println("Monster get Gold ㅜㅜ, bye");
			return false;
		}
		else if((board[player.y][player.x]).equals(board[monster.y][monster.x])) {
			System.out.println("Attacked Monster, You loser");
			return false;
		}
		return true;
	}
}

public class MiniGame {
	public static void main(String[] args) {
		Game gg = new Game();
		while(gg.end()) {
			gg.print();
			gg.start();
		}
	}
}
