import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EventDemo
{
   JLabel jlab;
   JLabel heading;
   JTextField jtf;
  
   EventDemo()
   {
       JFrame jfrm = new JFrame("Aladdin");
       heading = new JLabel("Enter the news headling",SwingConstants.CENTER);
       jfrm.setLayout(new FlowLayout());
       jfrm.setSize(700,500);

       //to make the window size fixed
       jfrm.setResizable(false);
       jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JButton jbtnSearch = new JButton("Search");
       jtf = new JTextField(15);

       jbtnSearch.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                     jlab.setText("Searching");
                }
            });

         jfrm.add(heading);
         jfrm.add(jtf);
         jfrm.add(jbtnSearch);
         jlab = new JLabel("",SwingConstants.CENTER);
         jfrm.add(jlab);
       
         jfrm.setVisible(true);

    }

   public static void main(String args[])
   {
       SwingUtilities.invokeLater(new Runnable()
            {
                  public void run()
                    {
                        new EventDemo();
                    }
            });

   }
}
