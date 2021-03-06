package chess.pieces;

import java.util.List;

import javafx.util.Pair;

public class King extends Piece{

	public King(int x, int y, int color, Piece[][] board) {
		super(x, y, color, board, 'K');
		if (color == 0) {
			this.filePath += "king-white.png";
		} else {
			this.filePath += "king-black.png";			
		}
	}

	@Override
	public List<Pair<String, String>> getPath() {
		this.clearPath();
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) { // For-loop that goes through all the values [y][x] 1 away from 0
				int targetX = this.x + j; // Centers the value to this
				int targetY = this.y + i;
				if (this.isInBoard(targetX, targetY)) {
					if (i != 0 || j != 0) {//If both values are 0 it isn't a legal move
						if (this.board[targetY][targetX] == null) {
							Pair<String, String> p = new Pair<>("" + this.x + this.y,"" + targetX + targetY);
							super.path.add(p);
						} else if (this.board[targetY][targetX].getColor() != this.getColor()) {
							Pair<String, String> p = new Pair<>("" + this.x + this.y,"" + targetX + targetY);
							super.path.add(p);
						}
					}
				}	
			}
		}
		return path;
	}

}
