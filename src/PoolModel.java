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
		for(int s = 0; s <= 16383; s++ ){
			fillTriangle(s);
			if (isPossible()){
				sets.add(s);
//				printBalls();
//				System.out.println(s);
			}
		}
	}
	
	private void fillTriangle(int set) {
		String binSet = Integer.toBinaryString(set);
		char[] b = binSet.toCharArray();
		if(b.length < 14){
			char[] tempb = new char[14];
			Arrays.fill(tempb, '0');
			for (int i = 14 - b.length; i < 14; i++) {
			tempb[i] = b[i - (14 - b.length)];
			}
			b = tempb;
		}
		balls[0][0] = Integer.parseInt("" + b[0]);
		balls[1][0] = Integer.parseInt("" + b[1]);
		balls[2][0] = Integer.parseInt("" + b[2]);
		balls[3][0] = Integer.parseInt("" + b[3]);
		balls[4][0] = Integer.parseInt("" + b[4]);
		balls[0][1] = Integer.parseInt("" + b[5]);
		balls[1][1] = Integer.parseInt("" + b[6]);
		balls[2][1] = Integer.parseInt("" + b[7]);
		balls[3][1] = Integer.parseInt("" + b[8]);
		balls[0][2] = Integer.parseInt("" + b[9]);
		balls[2][2] = Integer.parseInt("" + b[10]);
		balls[0][3] = Integer.parseInt("" + b[11]);
		balls[1][3] = Integer.parseInt("" + b[12]);
		balls[0][4] = Integer.parseInt("" + b[13]);
		
		balls[1][2] = 2;
		}
	
	boolean isPossible() {
		boolean possible ;
		possible = checkCount() && checkColumns() && checkRaw() && checkTriangles()
				&& countDiag();
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
		return n == 7;
	}
	
	private boolean checkColumns() {
		for (int j = 0; j < 5; j++) {
			int count = 0;
			for (int i = 0; i + j < 5 - 1; i++) {
				if ((balls[i][j] == balls[i + 1][j])
						|| (balls[i][j] == 0 && balls[i + 1][j] == 2)
						|| (balls[i][j] == 2 && balls[i + 1][j] == 0)) {
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
				if ((balls[i][j] == balls[i][j + 1])
						|| (balls[i][j] == 0 && balls[i][j + 1] == 2)
						|| (balls[i][j] == 2 && balls[i][j + 1] == 0)) {
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
			if (tm == balls[i - 1][j] 
					|| ((tm == 0 || tm == 2) 
							&& (balls[i - 1][j] == 0 || balls[i - 1][j] == 2))){
				count++;
//				System.out.println(count + "up" );
			}
		}
		if (j != 0) {
			if (tm == balls[i][j - 1] 
					|| ((tm == 0 || tm == 2) 
							&& (balls[i][j - 1] == 0 || balls[i][j - 1] == 2))){

			count++;
//				System.out.println(count + "left");
			}
		}
		if (count == 2) {
			return false;
		}
		count = 0;
		if (i + j < 5 - 1) {
			if (tm == balls[i][j + 1] 
					|| ((tm == 0 || tm == 2) 
							&& (balls[i][j + 1] == 0 || balls[i][j + 1] == 2))){
				count++;
//				System.out.println(count + "right" );
			}
			if (tm == balls[i + 1][j] 
					|| ((tm == 0 || tm == 2) 
							&& (balls[i + 1][j] == 0 || balls[i + 1][j] == 2))){
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
		if ((balls[0][0] == balls[1][1] && balls[0][0] == balls[2][2])
				|| ((balls[0][0] == 0 || balls[0][0] == 2)
						&& (balls[1][1] == 0 || balls[1][1] == 2)
						&& (balls[2][2] == 0 || balls[2][2] == 2))){
			return false;
		}
		
		return true;
	}
	private boolean checkBallDiag(int i, int j) {
		if (((balls[i][j] == balls[i - 1][j + 1]) 
				&& (balls[i][j] == balls[i - 2][j + 2]))
				|| ((balls[i][j] == 0 || balls[i][j] == 2) 
					&& (balls[i - 1][j + 1] == 0 || balls[i - 1][j + 1] == 2) 
				&& (balls[i - 2][j + 2] == 0 || balls[i - 2][j + 2] == 2))) {
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
