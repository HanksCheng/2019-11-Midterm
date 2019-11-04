import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcu extends JFrame{
    private Container cp;
    private JButton num7=new JButton("7");
    private JButton num8=new JButton("8");
    private JButton num9=new JButton("9");
    private JButton op4=new JButton("/");

    private JButton num4=new JButton("4");
    private JButton num5=new JButton("5");
    private JButton num6=new JButton("6");
    private JButton op3=new JButton("*");

    private JButton num1=new JButton("1");
    private JButton num2=new JButton("2");
    private JButton num3=new JButton("3");
    private JButton op2=new JButton("-");

    private JButton num0=new JButton("0");
    private JButton clr=new JButton("AC");
    private JButton eq=new JButton("=");
    private JButton op1=new JButton("+");

    private JPanel num=new JPanel(new GridLayout(4,4,2,2));
    private JLabel scr=new JLabel("0",SwingConstants.RIGHT);
    public Calcu(){
        init();
    }
    public void init(){
        cp=this.getContentPane();
        scr.setFont(new Font("Arial",Font.PLAIN,40));
        num9.setFont(new Font("Arial",Font.PLAIN,40));
        num8.setFont(new Font("Arial",Font.PLAIN,40));
        num7.setFont(new Font("Arial",Font.PLAIN,40));
        num6.setFont(new Font("Arial",Font.PLAIN,40));
        num5.setFont(new Font("Arial",Font.PLAIN,40));
        num4.setFont(new Font("Arial",Font.PLAIN,40));
        num3.setFont(new Font("Arial",Font.PLAIN,40));
        num2.setFont(new Font("Arial",Font.PLAIN,40));
        num1.setFont(new Font("Arial",Font.PLAIN,40));
        num0.setFont(new Font("Arial",Font.PLAIN,40));
        clr.setFont(new Font("Arial",Font.PLAIN,40));
        eq.setFont(new Font("Arial",Font.PLAIN,40));
        op1.setFont(new Font("Arial",Font.PLAIN,40));
        op2.setFont(new Font("Arial",Font.PLAIN,40));
        op3.setFont(new Font("Arial",Font.PLAIN,40));
        op4.setFont(new Font("Arial",Font.PLAIN,40));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("CACULATOR");
        this.setSize(600,750);
        this.setLocation(600,300);
        cp.setLayout(new BorderLayout(2,2));
        cp.add(scr,BorderLayout.NORTH);
        cp.add(num,BorderLayout.CENTER);
        num.add(num7);
        num.add(num8);
        num.add(num9);
        num.add(op4);
        num.add(num4);
        num.add(num5);
        num.add(num6);
        num.add(op3);
        num.add(num1);
        num.add(num2);
        num.add(num3);
        num.add(op2);
        num.add(num0);
        num.add(clr);
        num.add(eq);
        num.add(op1);
    }
}