import java.util.ArrayList;
import java.util.Arrays;


public class PoolModel {
	private int[][] balls = new int[5][5];
	private ArrayList<Integer> sets;
	public ArrayList<Integer> getSets() {
		return sets;
	}
	
	public void generateSets() {
		sets = new ArrayList<Integer>();

		for(int s = 0; s <= 32767; s++ ){
//			25298
			fillTriangle(s);
//			printBalls();
			if (isPossible()){
				sets.add(s);
				printBalls();
				System.out.println(s);

			}
		}
		
		System.out.println(getCount());
		
	}
	

	public void fillTriangle(int set) {

		balls[0][0] = ((set & (1<<0))== 0) ? 0 : 1;
		balls[1][0] = ((set & (1<<1))== 0) ? 0 : 1;
		balls[2][0] = ((set & (1<<2))== 0) ? 0 : 1;
		balls[3][0] = ((set & (1<<3))== 0) ? 0 : 1;
		balls[4][0] = ((set & (1<<4))== 0) ? 0 : 1;
		balls[0][1] = ((set & (1<<5))== 0) ? 0 : 1;
		balls[1][1] = ((set & (1<<6))== 0) ? 0 : 1;
		balls[2][1] = ((set & (1<<7))== 0) ? 0 : 1;
		balls[3][1] = ((set & (1<<8))== 0) ? 0 : 1;
		balls[0][2] = ((set & (1<<9))== 0) ? 0 : 1;
		
		balls[1][2] = ((set & (1<<10))== 0) ? 0 : 1;
		
		balls[2][2] = ((set & (1<<11))== 0) ? 0 : 1;
		balls[0][3] = ((set & (1<<12))== 0) ? 0 : 1;
		balls[1][3] = ((set & (1<<13))== 0) ? 0 : 1;
		balls[0][4] = ((set & (1<<14))== 0) ? 0 : 1;

		
//		balls[1][2] = 2;
//		printBalls();
		}
	
	boolean isPossible() {
		boolean possible ;
		possible = checkCount() && checkColumns() && checkRaw() && checkTriangles()
				&& countDiag();
//		possible = checkCount() && checkColumns() && checkRaw() && checkTriangles();
		
		return possible;
	}
	private boolean checkCount() {
		int n = 0;
		for (int i = 0; i < 5; i++) {
			for(int j = 0; i + j < 5; j++) {
				if (balls[i][j] == 1) {
					n++;
				}
			}
		}
		return n == 7 && balls[1][2] == 0;

	}
	
	private boolean checkColumns() {
		for (int j = 0; j < 5; j++) {
			int count = 0;
			for (int i = 0; i + j < 5 - 1; i++) {
				if (balls[i][j] == balls[i + 1][j]){
					++count;
				}
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}

	private  boolean checkRaw() {
		for (int i = 0; i < 5; i++) {
			int count = 0;
			for (int j = 0; i + j < 5 - 1; j++) {
				if (balls[i][j] == balls[i][j + 1]) {
					count++;
				}
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkTriangles() {
		for (int i = 1; i < 5 ; i++) {
			for (int j = 0; i + j < 5 ; j++) {
				if (! checkBallTriangles(i, j)){
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkBallTriangles(int i, int j) {
		int count = 0;
		int tm = balls[i][j];
		if (i != 0) {
			if (tm == balls[i - 1][j] ){
				count++;
//				System.out.println(count + "up" );
			}
		}
		if (j != 0) {
			if (tm == balls[i][j - 1]){
			count++;
//				System.out.println(count + "left");
			}
		}
		if (count == 2) {
			return false;
		}
		count = 0;
		if (i + j < 5 - 1) {
			if (tm == balls[i][j + 1]){
				count++;
//				System.out.println(count + "right" );
			}
			if (tm == balls[i + 1][j]){
				count++;
//				System.out.println(count + "down");
			}
		}
		
//		System.out.println(count + " i = " + i + "; j = " + j);
		if (count == 2) {
			return false;
		}
		
	return true;
}

	private boolean countDiag() {

		for (int i = 2; i < 5 ; i++)
		{
			for (int j = 0; j < 5 - i; j++) 
			{
//				System.out.println(checkBallDiag (balls, i, j) + "i = " + i + "; j = " + j);
				if (! checkBallDiag(i, j)){
					return false;
				}
			}
		}
		if ((balls[0][0] == balls[1][1] && balls[0][0] == balls[2][2])){
			return false;
		}
		
		return true;
	}
	private boolean checkBallDiag(int i, int j) {
		if (((balls[i][j] == balls[i - 1][j + 1]) 
				&& (balls[i][j] == balls[i - 2][j + 2]))) {
					return false;
				}
		return true;
	}
	
	public void printBalls() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(balls[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printBallsSet() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(balls[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getCount() {
		return sets.size();
	}
	
}
