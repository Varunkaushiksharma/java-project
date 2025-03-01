import javax.swing.*;

public class App {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        // instantiate a rockpappersisscer gui
        RockScissorPapperGui rockScissorPapperGui = new RockScissorPapperGui();

        // display the gui
        rockScissorPapperGui.setVisible(true);
      }
    });
  }
}