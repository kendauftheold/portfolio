
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

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/*
 * this class extends JPanel in order to override the paintComponent() method
 * to draw the game of life in a GUI
 */
public class BoardPanel extends JPanel{
	
	//Privates
	private GameOfLife game;
	
	/*
	 * Construcor creates a BoardPanel given a GameOfLife as a parameter
	 */
	public BoardPanel(GameOfLife game){
		this.game = game;
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * draws a grid based on the length and width of the game within the GameBoard
	 * if the specific cell being drawn is alive, the rectangle gets filled
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		for(int row = 0; row < this.game.getRows(); row++){
			for(int col = 0; col < this.game.getCols(); col++){
				g2.drawRect(col * this.getWidth() / this.game.getCols(),
						row * this.getHeight() / this.game.getRows(),
						this.getWidth() / this.game.getCols() - 2,
						this.getHeight() / this.game.getRows() - 2);
				if(this.game.getCell(row, col) == 1)
					g2.fillRect(col * this.getWidth() / this.game.getCols(),
							row * this.getHeight() / this.game.getRows(),
							this.getWidth() / this.game.getCols() - 2,
							this.getHeight() / this.game.getRows() - 2);
			}
		}
	}
	
	/*
	 * setter for the GameOfLife used in the boardpanel
	 */
	public void setGame(GameOfLife game){
		this.game = game;
	}
	
}