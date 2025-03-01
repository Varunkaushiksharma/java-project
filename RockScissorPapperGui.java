import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//frontend
public class RockScissorPapperGui extends JFrame implements ActionListener {

  // player button

  JButton rockButton, scissorButton, papperButton;
  // display computer choice
  JLabel computerChoice;

  // will dispaly the score of the computer and the player
  JLabel computerScoreLabel, playerScoreLabel;

  // backend object
  RockScissorPapper rockScissorPapper;

  // constructor
  RockScissorPapperGui() {
    // invokes jfrane contructor and add tittle to the gui
    super("Rock Paper Scissor");

    // set the size of gui
    setSize(450, 574);

    // set layout to null to disable layout management , so we use absolute
    // positioning for the element
    // (i.e setting x/y coordinates and width/height values)
    setLayout(null);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLocationRelativeTo(null);

    // initilize backend object
    rockScissorPapper = new RockScissorPapper();

    // add Gui component
    addGuiComponent();
  }

  private void addGuiComponent() {

    computerScoreLabel = new JLabel("Computer: 0");

    // set x and y coordinates and width/ height values
    computerScoreLabel.setBounds(0, 43, 450, 30);

    // set the font family of dialog , font weight of bold , and the font size of 26
    computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
    // set letter to center
    computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

    // add to gui
    add(computerScoreLabel);

    // make computer choice
    computerChoice = new JLabel("?");
    computerChoice.setBounds(175, 185, 98, 81);
    computerChoice.setFont(new Font("Dialog", Font.PLAIN, 16));
    computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

    // create a black border around
    computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(computerChoice);

    // create player score abel
    playerScoreLabel = new JLabel("Player: 0");
    playerScoreLabel.setBounds(0, 317, 450, 30);
    playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
    playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(playerScoreLabel);

    // player buttons

    // rockButton

    rockButton = new JButton("Rock");
    rockButton.setBounds(40, 370, 105, 81);
    rockButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    rockButton.addActionListener(this);
    add(rockButton);

    // papper buttons
    papperButton = new JButton("Papper");
    papperButton.setBounds(165, 370, 105, 81);
    papperButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    papperButton.addActionListener(this);
    add(papperButton);

    // scissor button
    scissorButton = new JButton("Scissor");
    scissorButton.setBounds(290, 370, 105, 81);
    scissorButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    scissorButton.addActionListener(this);
    add(scissorButton);
  }

  // display some message sow who won the match and a try again button
  private void showDialog(String message) {

    JDialog resultDialog = new JDialog(this, "Result", true);
    resultDialog.setSize(227, 140);
    resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    resultDialog.setResizable(false);

    // message
    JLabel resultLabel = new JLabel(message);
    resultLabel.setFont(new Font("Dialog", Font.BOLD, 15));
    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
    resultDialog.add(resultLabel, BorderLayout.CENTER);

    // try again button
    JButton tryAgain = new JButton("tryAgain ?");
    tryAgain.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // reset computer choice
        computerChoice.setText("?");

        // close the dilog box
        resultDialog.dispose();
      }
    });
    resultDialog.add(tryAgain, BorderLayout.SOUTH);

    resultDialog.setLocationRelativeTo(this);
    resultDialog.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // get player choice
    String playerChoice = e.getActionCommand().toString();

    // play rock paper scissor and store the result into string var
    String result = rockScissorPapper.playRockPapperScissor(playerChoice);

    // load computer's choice
    computerChoice.setText(rockScissorPapper.getComputerChoice());

    // update score
    computerScoreLabel.setText("Computer: " + rockScissorPapper.getComputerScore());
    playerScoreLabel.setText("Player: " + rockScissorPapper.getPlayerScore());

    // display the result;
    showDialog(result);
  }

}
