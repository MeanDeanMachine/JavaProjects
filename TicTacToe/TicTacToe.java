import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Simple TicTacToe program with GUI
public class TicTacToe extends JFrame{
    //player1 always starts first
    private boolean player1 = true;
    private JPanel title_panel = new JPanel();
    private JPanel board = new JPanel();
    private JLabel textfield = new JLabel();
    private JButton[] buttons = new JButton[9];
    private JFrame popUp = new JFrame();
    private JLabel prompt = new JLabel("Play again?");
    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");

    public TicTacToe(){
        //constructor
        super("Tic-Tac-Toe");
        setSize(800,800);
        getContentPane().setBackground(new Color(50,50,50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setLayout(new BorderLayout());
        setVisible(true);
        //construct prompt
        textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("MV Boli",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //construct board
        board.setLayout(new GridLayout(3,3));
        board.setBackground(new Color(150,150,150));

        //initialize all buttons
        for(int i = 0;i<9;i++){
            buttons[i] = new JButton();
            board.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new PerformMoveListener());
        }

        title_panel.add(textfield);
        add(title_panel,BorderLayout.NORTH);
        add(board);
    }
    public void playAgainPrompt(){
        //prompt that asks if player wants to play again
        //yes resets all buttons 
        yes.addActionListener(new PlayAgain());
        //closes the program if user selects no for play again
        no.addActionListener(e -> {popUp.dispose();this.dispose();});
        popUp.setSize(200,150);
        popUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        popUp.setLocation(350,350);
        popUp.setVisible(true);
        popUp.setLayout(new FlowLayout());
        prompt.setFont(new Font("MV Boli",Font.BOLD,24));
        popUp.add(prompt);
        popUp.add(yes);
        popUp.add(no);

    }
    private class PlayAgain implements ActionListener{
        //resets all buttons and background colors 
        public void actionPerformed(ActionEvent e){
            popUp.setVisible(false);
            for(int i=0;i<9;i++) {
                buttons[i].setEnabled(true);
                buttons[i].setBackground(UIManager.getColor("Button.background"));
                buttons[i].setText("");
            }
            textfield.setText("Tic-Tac-Toe");
            player1=true;
        }
    }
    private class PerformMoveListener implements ActionListener{
        //action listener for performing moves on the board
        public void actionPerformed(ActionEvent e){
            for(int i = 0;i<9;i++){
                if(e.getSource()==buttons[i]){
                    if(player1){
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(255,0,0));
                            buttons[i].setText("X");
                            player1=false;
                            textfield.setText("O turn");
                            checkWin();
                        }
                    }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1=true;
                        textfield.setText("X turn");
                        checkWin();
                        }
                    }
                }
            }
        }
    }
    public void checkWin(){
        //check X win conditions
		if(
            (buttons[0].getText()=="X") &&
            (buttons[1].getText()=="X") &&
            (buttons[2].getText()=="X")
            ) {
        xWins(0,1,2);
    }
    if(
            (buttons[3].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[5].getText()=="X")
            ) {
        xWins(3,4,5);
    }
    if(
            (buttons[6].getText()=="X") &&
            (buttons[7].getText()=="X") &&
            (buttons[8].getText()=="X")
            ) {
        xWins(6,7,8);
    }
    if(
            (buttons[0].getText()=="X") &&
            (buttons[3].getText()=="X") &&
            (buttons[6].getText()=="X")
            ) {
        xWins(0,3,6);
    }
    if(
            (buttons[1].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[7].getText()=="X")
            ) {
        xWins(1,4,7);
    }
    if(
            (buttons[2].getText()=="X") &&
            (buttons[5].getText()=="X") &&
            (buttons[8].getText()=="X")
            ) {
        xWins(2,5,8);
    }
    if(
            (buttons[0].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[8].getText()=="X")
            ) {
        xWins(0,4,8);
    }
    if(
            (buttons[2].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[6].getText()=="X")
            ) {
        xWins(2,4,6);
    }
    //check O win conditions
    if(
            (buttons[0].getText()=="O") &&
            (buttons[1].getText()=="O") &&
            (buttons[2].getText()=="O")
            ) {
        oWins(0,1,2);
    }
    if(
            (buttons[3].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[5].getText()=="O")
            ) {
        oWins(3,4,5);
    }
    if(
            (buttons[6].getText()=="O") &&
            (buttons[7].getText()=="O") &&
            (buttons[8].getText()=="O")
            ) {
        oWins(6,7,8);
    }
    if(
            (buttons[0].getText()=="O") &&
            (buttons[3].getText()=="O") &&
            (buttons[6].getText()=="O")
            ) {
        oWins(0,3,6);
    }
    if(
            (buttons[1].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[7].getText()=="O")
            ) {
        oWins(1,4,7);
    }
    if(
            (buttons[2].getText()=="O") &&
            (buttons[5].getText()=="O") &&
            (buttons[8].getText()=="O")
            ) {
        oWins(2,5,8);
    }
    if(
            (buttons[0].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[8].getText()=="O")
            ) {
        oWins(0,4,8);
    }
    if(
            (buttons[2].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[6].getText()=="O")
            ) {
        oWins(2,4,6);
    }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
        playAgainPrompt();
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
        playAgainPrompt();
    }
}
