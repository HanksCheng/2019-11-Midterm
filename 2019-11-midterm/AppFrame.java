import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class AppFrame extends JFrame{
     private Container cp;
     private JMenuBar mb=new JMenuBar();
     private JMenu menu1=new JMenu("Features");
     private JMenu menu2=new JMenu("Tools");
     private JMenu menu3=new JMenu("Games");
     private JMenuItem calcu=new JMenuItem("Calculator");
     private JMenuItem enc=new JMenuItem("Encryptor");
     private JMenuItem lgot=new JMenuItem("Logout");
     private JMenuItem exit=new JMenuItem("Exit");    
     private JMenuItem ham=new JMenuItem("Hamster");


     private JDesktopPane desktop=new JDesktopPane();
     private EncryptorFrame jintFrame=new EncryptorFrame();
     private HamsterFrame hamFrame=new HamsterFrame();

     public AppFrame(){
         init();
     }
     private void init(){
         cp=this.getContentPane();
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         cp.setLayout(new BorderLayout());
         this.setTitle("My Application");
         this.setSize(1024,768);
         this.setLocation(500,200);
         this.setJMenuBar(mb);

         this.add(desktop);
        //  jintFrame
         jintFrame.setLocation(0,0);
         desktop.add(jintFrame);
         jintFrame.setVisible(false);
         
        // hamFrame
         hamFrame.setLocation(0,0);
         desktop.add(hamFrame);
         hamFrame.setVisible(false);

         mb.add(menu1);
         mb.add(menu2);
         mb.add(menu3);
         menu1.add(lgot);
         menu1.add(exit);
         menu2.add(calcu);
         menu2.add(enc);
         menu3.add(ham);
         
         exit.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
         });
         lgot.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                LoginFrame lg=new LoginFrame();
                lg.setVisible(true);
                AppFrame.this.setVisible(false);
                AppFrame.this.dispose();
            }
         });
         calcu.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 Calcula calcufr=new Calcula();
                 calcufr.setVisible(true);
             }
         });
         enc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                jintFrame.setVisible(true);
            }
        });
        ham.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                hamFrame.setVisible(true);
            }
        });
     }
 }