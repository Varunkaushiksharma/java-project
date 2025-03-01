import java.util.Random;

//backend 
public class RockScissorPapper {
  // all the choice that computer can choose
  public static final String[] computerChoices = { "Rock", "Paper", "Scissor" };

  public String getComputerChoice() {
    return computerChoice;
  }

  public int getComputerScore() {
    return computerScore;
  }

  public int getPlayerScore() {
    return playerScore;
  }

  // store the choice so that we canb retevire the data to dipaly in the frontend
  private String computerChoice;

  // store the score to give or show to the frontend
  private int computerScore, playerScore;
  // use the random class responsible to generate random option for the choice
  private Random random;

  // constructor to initialize the random obj
  public RockScissorPapper() {
    random = new Random();
  }

  // call this function before playing rock paper scissor
  // playerChoice -> the choice made by the player (i.e rock paper scissor)
  // this method return the result of the match like computer wins or palyer wins
  // or draw
  public String playRockPapperScissor(String playerChoice) {

    computerChoice = computerChoices[random.nextInt(computerChoices.length)];
    // will contain the returning message indicating teh result of the game
    String result;

    // evaluate the winner
    if (computerChoice.equals("Rock")) {
      if (playerChoice.equals("Paper")) {
        result = "Player Wins";
        playerScore++;

      } else if (playerChoice.equals("Scissor")) {
        result = "Computer Wins";
        computerScore++;
      } else {
        result = "Draw";
      }

    } else if (computerChoice.equals("Paper")) {
      if (playerChoice.equals("Rock")) {
        result = "Computer Wins";
        computerScore++;

      } else if (playerChoice.equals("Scissor")) {
        result = "Player Wins";
        playerScore++;
      } else {
        result = "Draw";
      }
    } else {
      // computer chooses Scissor
      if (playerChoice.equals("Rock")) {
        result = "Player Wins";
        playerScore++;
      } else if (playerChoice.equals("Paper")) {
        result = "Computer Wins";
        computerScore++;
      } else {
        result = "Draw";
      }
    }
    return result;
  }
}