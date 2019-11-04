import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame{
    private Container cp;
    private JPanel jpn=new JPanel(new GridLayout(2,3,3,3));
    private JLabel idl=new JLabel("     ID");
    private JLabel psl=new JLabel("     PASSWORD");
    private TextField id=new TextField();
    private JPasswordField pas=new JPasswordField();
    private JButton lgb=new JButton("LOGIN");
    private JButton exb=new JButton("EXIT");
    private JButton kb=new JButton("KEYBOARD");


    public LoginFrame(){
        init();
    }
    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setSize(500,120);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpn.add(idl);
        jpn.add(id);
        jpn.add(lgb);
        jpn.add(psl);
        jpn.add(pas);
        jpn.add(exb);
        cp.add(kb);
        cp.add(jpn,BorderLayout.NORTH);
        exb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        lgb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String ps=new String(pas.getPassword());
                if(id.getText().equals("hank")&&ps.equals("1204")){
                    JOptionPane.showMessageDialog(null,"WELCOME BACK HANK");
                    AppFrame app=new AppFrame();
                    app.setVisible(true);
                    LoginFrame.this.setVisible(false);
                    LoginFrame.this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"FUCK OUT THE WAY");
                }
            }
        });
        kb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                RdKeyboard rkb=new RdKeyboard(LoginFrame.this);
                rkb.setVisible(true);
            }
        });
    }
    public void setPwData(String pwStr){
        pas.setText(pwStr);
    }
}