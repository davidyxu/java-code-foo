import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ConnectFour extends JFrame implements KeyListener, MouseListener {
	Image board; Image red; Image black; int position; boolean start; boolean turn;
	public ConnectFour(){
		super("Connect 4");
		tile = Toolkit.getDefaultToolkit().getImage("tile.gif");
		red = Toolkit.getDefaultToolkit().getImage("red.gif");
		black = Toolkit.getDefaultToolkit().getImage("black.gif");
		start=true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		addMouseListener(this);
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
	}
	public void paint(Graphics g){
		if (start){

		}
		else{
			for (int i = 0; i < 6; i++){
				for (int j =-0; j< 7; j++) {
					if (board[i][j]==0)
						g.drawImage(tile,(i)*50,(j)*50, null);
					else if (board[i][j]==1)
						g.drawImage(red,(i)*50,(j)*50, null);
					else if (board[i][j]==2)
						g.drawImage(black,(i)*50,(j)*50, null);
				}
			}
		}
	}
	public void dropPiece(int column){
		if (turn){
			for (int i =0; i < 6; i++){
				if (board[i][column]==0)
				board[i][column]=1;
			}
		}
		else {
			for (int i =0; i < 6; i++){
				if (board[i][column]==0)
				board[i][column]=2;
			}
		}
		turn = false;
	}


	public void paint(Graphics g){
		for (int i = 0; i <= 7; i++){
			for (int j =-0; j<=7; j++) {
				g.drawImage(tile1,(i)*50,(j)*50, null);
			}
		}
		if (centered=true) g.drawImage(player1, 350, 350, null);
		else {}
	}
	public void keyPressed (KeyEvent e){
		if (e.getKeyCode()==37) { // LEFT
			x--;
		}
		else if (e.getKeyCode()==38) { // DOWN
			if (turn) dropPiece();
		}
		else if (e.getKeyCode()==39) { // RIGHT
			x++;
		}
		else if (e.getKeyCode()==40) { // UP
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	public void mouseEntered(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}



	public static void main(String[] args) {
		Console console = new Console();
	}

}