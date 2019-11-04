import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RdKeyboard extends JFrame{
    private Container cp;
    private JPasswordField jpf=new JPasswordField();
    private JButton btn[]=new JButton[12];
    private JPanel jpn=new JPanel(new GridLayout(2,6,2,2));
    private LoginFrame login;

    public RdKeyboard(LoginFrame loginfrm){
        login=loginfrm;
        init();
    }

    private void init(){
        int data[]=new int[10],j=0;
        Random rnd=new Random();
        boolean flag=false;
        cp=this.getContentPane();
        this.setSize(500,200);
        this.setLocation(200,200);
        cp.setLayout(new BorderLayout(3,3));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        while(j<10){
            data[j]=rnd.nextInt(10);
            flag=true;
            int k=0;
            while(k<j&&flag==true){
                if(data[k]==data[j]){
                    flag=false;
                }
                k++;
            }
            if(flag==true){
                j++;
            }
        }
        for(int i=0;i<10;i++){
            btn[i]=new JButton(Integer.toString(data[i]));
            jpn.add(btn[i]);
            btn[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    JButton jbtn=(JButton)ae.getSource();
                    String ps=new String(jpf.getPassword());
                    jpf.setText(ps+jbtn.getText());
                }
            });
        }
        btn[10]=new JButton("SUB");
        btn[11]=new JButton("EXIT");
        jpn.add(btn[10]);
        jpn.add(btn[11]);
        cp.add(jpf,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);

        btn[11].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RdKeyboard.this.dispose();
            }
        });
        btn[10].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                login.setPwData(new String(jpf.getPassword()));
                RdKeyboard.this.dispose();
            }
        });
    }
}