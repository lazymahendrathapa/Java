import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AladdinUI
{

 JFrame mainFrame;
 JPanel controlPanel;
 JLabel resultLabel; 

 public AladdinUI()
 {
   prepareGUI();
 }

 public static void main(String [] args)
 {
   
    AladdinUI aladdinUI = new AladdinUI();
    aladdinUI.showUI();

 }

  private void  prepareGUI()
  {
     mainFrame = new JFrame("Aladdin");
     mainFrame.setSize(700,200);
     mainFrame.setResizable(false);
     mainFrame.setLayout(new GridLayout(1,1));

     resultLabel = new JLabel("result",JLabel.CENTER);

     mainFrame.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
          }
     });

    controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(1,1));

    mainFrame.add(controlPanel);
    mainFrame.setVisible(true);

  }

  private void showUI()
  {
    JPanel panel = new JPanel();

    GridBagLayout layout = new GridBagLayout();

    panel.setLayout(layout);
    GridBagConstraints  gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(new JLabel("Enter News Headling"),gbc);
 
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(new JLabel(" "),gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(new JTextField(45),gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(new JLabel("   "),gbc);


    gbc.gridx = 2;
    gbc.gridy = 2;
    panel.add(new JButton("Run"),gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(new JLabel(" "),gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 4;
    panel.add(resultLabel,gbc);
 
    controlPanel.add(panel);
    
    mainFrame.setVisible(true);
  
  }

}


