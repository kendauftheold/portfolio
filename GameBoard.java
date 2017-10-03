
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
 * This class is a general game board class, allowing for the creation of a board where each space can be set to the value of a piece
 */
public class GameBoard {

	//Privates
	private int[][] board;
	int rows, cols;

	/*
	 * Constructor creates a new GameBoard with the number of rows and columns specified
	 * the int[][] is set to a new int[][] with length rows and width cols, and all values are 0
	 */
	public GameBoard(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		this.board = new int[rows][cols];
	}

	/*
	 * constructor creates a new square GamBoard where the number of rows and columns is equal to the parameter size
	 * the int[][] board is set to a new int[][] that has the length and width size, and all values are 0
	 */
	public GameBoard(int size){
		this.rows = size;
		this.cols = size;
		this.board = new int[rows][cols];
	}

	/*
	 * constructor creates a new gameboard where the # of rows and columns are equal to the length and height of the int[][] given in the parameter
	 * the int[][] board is also set to equal the int[][] in the parameter, so it inherits all values for each space
	 */
	public GameBoard(int[][] initialState){
		this.rows = initialState.length;
		this.cols = initialState[0].length;
		this.board = initialState;
	}

	/*
	 * returns a string representation of the gameboard
	 */
	public String toString(){
		String s = "";
		for(int row = 0; row < this.getRows(); row++){
			for(int col = 0; col < this.getCols(); col++){
				s += this.getPiece(row, col) + " ";
			}
			s += "\n";
		}
		return s;
	}

	/*
	 * returns the value of a piece at the given location
	 */
	public int getPiece(int row, int col){
		if(this.isValid(row, col))
			return this.board[row][col];
		else
			return 0;
	}

	/*
	 * sets the value of a piece at a given location to the specified value and returns the previous value at that location
	 */
	public int setPiece(int row, int col, int piece){
		int val = this.getPiece(row, col);
		this.board[row][col] = piece;
		return val;
	}

	/*
	 * sets the value of a piece at a given location to 0 and returns the previous value at that location
	 */
	public int removePiece(int row, int col){
		int val = this.getPiece(row, col);
		this.board[row][col] = 0;
		return val;
	}

	/*
	 * returns a boolean representing whether or not the specified location is contained by the GameBoard
	 */
	public boolean isValid(int row, int col){
		if(!(row < 0 || row > this.rows - 1) && !(col < 0 || col > this.cols - 1))
			return true;
		return false;
	}

	/*
	 * returns a boolean representing whether or not the specified location contains a value other than 0 (0 represents an empty space)
	 */
	public boolean isOccupied(int row, int col){
		if(isValid(row, col))
			if(this.getPiece(row, col) == 0)
				return false;
			else
				return true;
		return false;
	}

	/*
	 * returns a boolean representing whether or not the specified location contains the specified value
	 */
	public boolean isOccupied(int row, int col, int pieceType){
		if(isValid(row, col))
			if(this.getPiece(row, col) == pieceType)
				return true;
			else
				return false;
		return false;
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