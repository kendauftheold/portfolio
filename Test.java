
public class Test {

	public static void main(String[] args) {

		int[][] m = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 0, 0, 0, 1, 0, 0, 0},
				{0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

		GameOfLife a = new GameOfLife(m);
		
		for(int i = 0; i < 4; i++){
			System.out.println(a.getGenNum());
			a.nextGeneration();
		}

	}


}


