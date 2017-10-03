
/*
                    _-====-__-======-__-========-_____-============-__
                  _(                                                 _)
               OO(          @author				                  )_
              0  (_                  Kendall Niles Peretz             _)
            o0     (_                                                _)
           o         '=-___-===-_____-========-___________-===-___-='
         .o                                _________
        . ______          ______________  |         |      _____
      _()_||__|| ________ |            |  |_________|   __||___||__
     (         | |      | |            | __Y______00_| |_         _|
    /-OO----OO""="OO--OO"="OO--------OO"="OO-------OO"="OO-------OO"=P
   #####################################################################

 */

/*
 * 
 */
public class GameOfLife {

	//Privates
	private GameBoard board;
	private int rows;
	private int cols;
	private int gen;
	public final static int DEAD = 0;
	public final static int ALIVE = 1;


	/*
	 * constructor creates a new GameOfLife with a certain number of rows and cols
	 * the gameboard is defaulted to all values being equal to 0
	 */
	public GameOfLife(int rows, int cols){
		this.board = new GameBoard(rows, cols);
		this.rows = rows;
		this.cols = cols;
		this.gen = 0;
	}

	/*
	 *  constructor creates a new GameOfLife with a square GameBoard with the row and col length of size
	 *  the GamBoard is defaulted to all values being equal to 0
	 */
	public GameOfLife(int size){
		this.board = new GameBoard(size);
		this.rows = size;
		this.cols = size;
		this.gen = 0;
	}

	/*
	 * constructor creates a new GameOfLife object given a matrix
	 * allows the user to have a preset layout of the values of cells
	 */
	public GameOfLife(int[][] board){
		this.board = new GameBoard(board);
		this.rows = this.board.getRows();
		this.cols = this.board.getCols();
	}

	/*
	 * returns a string representation of the GameOfLife
	 */
	public String toString(){
		String s = "Generation " + this.getGenNum() + "\n";
		s += this.board.toString();
		return s;
	}

	/*
	 * returns the value of the cell at m[row][col]
	 */
	public int getCell(int row, int col){
		if(this.board.isValid(row, col) && this.board.getPiece(row, col) == ALIVE)
			return ALIVE;
		else
			return DEAD;
	}

	/*
	 * sets the value of the cell at m[row][col] to the value of state
	 */
	public void setCell(int row, int col, int state){
		if(this.board.isValid(row, col))
			this.board.setPiece(row, col, state);
	}

	/*
	 * counts how many of the 8 surrounding cells of a certain cell are alive
	 */
	public int countNeighbors(int row, int col){
		int neighbors = 0;
		for(int i = row - 1; i <= row + 1; i++){
			for(int j = col - 1; j <= col + 1; j++){
				if(this.board.isValid(i, j) && this.getCell(i, j) == 1)
					neighbors++;
			}
		}
		if(this.board.getPiece(row, col) == ALIVE)
			neighbors--;
		return neighbors;
	}

	/*
	 * calculates if the piece in the matrix at spot m[row][col] will be alive in the next generation
	 * if it has less than 2 neighbors it will not live
	 * if it has 2 neighbors then it will live if it is alive and will not live if it is dead
	 * if it has 3 neighbors it will live
	 * if it has over 3 neighbors it will not live
	 */
	public boolean willLive(int row, int col){
		int neighbors = this.countNeighbors(row, col);
		if(neighbors < 2)
			return false;
		if(neighbors == 2)
			if(this.getCell(row, col) == ALIVE)
				return true;
			else
				return false;
		if(neighbors == 3)
			return true;
		if(neighbors > 3)
			return false;
		return false;

	}

	/*
	 * calculates the next generation and points the private Gameboard board
	 * to the new board containing the next generation
	 * increments the genNumber
	 */
	public void nextGeneration(){
		GameBoard next = new GameBoard(new int[this.rows][this.cols]);
		for(int row = 0; row < this.rows; row++){
			for(int col = 0; col < this.cols; col++){
				if(this.willLive(row, col))
					next.setPiece(row, col, ALIVE);
			}
		}
		this.gen++;
		this.board = next;
	}

	/*
	 * returns the generation number
	 */
	public int getGenNum(){
		return this.gen;
	}

	/*
	 * setter for the generation number
	 */
	public void setGenNum(int num){
		this.gen = num;
	}

	/*
	 * returns the number of rows
	 */
	public int getRows(){
		return this.rows;
	}

	/*
	 * returns the number of columns
	 */
	public int getCols(){
		return this.cols;
	}





}









