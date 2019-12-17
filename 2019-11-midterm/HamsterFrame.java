import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class HamsterFrame extends JInternalFrame{
    private Container cp;
    private ImageIcon monster = new ImageIcon("monster.png");
    private ImageIcon boom = new ImageIcon("boom.png");
    private JLabel jlb = new JLabel();
    private JButton jbtn=new JButton("ADD");
    private Random rnd= new Random();
    private Timer t1, t2;
    private int labx = 0;
    private int laby = 0;
    public HamsterFrame(){
        init();
    }
    private void init(){
        cp=this.getContentPane();
        cp.setLayout(null);
        this.setBounds(0,0,500,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        labx =rnd.nextInt(HamsterFrame.this.getWidth());
        laby =rnd.nextInt(HamsterFrame.this.getHeight());
        jlb.setBounds(labx,laby,120,120);
        jbtn.setBounds(0,420,490,50);
        cp.add(jlb);
        cp.add(jbtn);

        Image img=monster.getImage();
        Image newimg=img.getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
        monster=new ImageIcon(newimg);

        img=boom.getImage();
        newimg=img.getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
        boom=new ImageIcon(newimg);

        

        jlb.addMouseListener(new MouseListener(){
            public void mouseEntered (MouseEvent me){
            }
            public void mouseClicked (MouseEvent me){
                
            }
            public void mouseExited (MouseEvent me){
            }
            public void mouseReleased (MouseEvent me){
            }
            public void mousePressed (MouseEvent me){
                t1.stop();
                t2.start();
                jlb.setIcon(boom);
            }
        });
        t1=new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                labx =rnd.nextInt(HamsterFrame.this.getWidth()-120);
                laby =rnd.nextInt(HamsterFrame.this.getHeight()-120);
                jlb.setLocation(labx,laby);
            }
        });

        t2=new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jlb.setIcon(null);
                jlb=null;
                t2.stop();
            }
        });
        jbtn.addActionListener(new ActionListener(){
            // public void actionPerformed (ActionEvent ae){
            //     labx =rnd.nextInt(HamsterFrame.this.getWidth()-120);
            //     laby =rnd.nextInt(HamsterFrame.this.getHeight()-120);
            //     jlb.setLocation(labx,laby);
                
            // }
        });
        t1.start();
    }
}

