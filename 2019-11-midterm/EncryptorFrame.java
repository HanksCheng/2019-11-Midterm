import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EncryptorFrame extends JInternalFrame{
    private Container cp;
    private JTextArea jta =new JTextArea();
    private JScrollPane jsp=new JScrollPane(jta);

    private JPanel jpnN=new JPanel(new BorderLayout());   
    private JLabel jlb=new JLabel("File");
    private JTextField jtf=new JTextField();
    private JButton jbtnBrowse=new JButton("Browse");

    private JPanel jpnE=new JPanel(new GridLayout(10,1,2,2));
    private JLabel jlbk=new JLabel("KEY");
    private JTextField jtfk=new JTextField("4");
    private JLabel jlba=new JLabel("Algorithm");
    private JComboBox<String> jcb=new JComboBox<String>();
    private ButtonGroup gp=new ButtonGroup();
    private JRadioButton jrb1=new JRadioButton("Encrypt");
    private JRadioButton jrb2=new JRadioButton("Decrypt");
    private JButton start=new JButton("START");
    private JButton clean=new JButton("CLEAN");
    private JButton save=new JButton("SAVE");
    private JButton exit=new JButton("EXIT");
    public EncryptorFrame(){
        init();
    }
    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(0,0,600,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cp.add(jsp,BorderLayout.CENTER);
        cp.add(jpnN,BorderLayout.NORTH);
        jpnN.add(jlb,BorderLayout.WEST);
        jpnN.add(jtf,BorderLayout.CENTER);
        jpnN.add(jbtnBrowse,BorderLayout.EAST);
        cp.add(jpnE,BorderLayout.EAST);
        jcb.addItem("Caesar");
        jcb.addItem("XOR");
        jpnE.add(jlbk);
        jpnE.add(jtfk);
        jpnE.add(jlba);
        jpnE.add(jcb);
        jpnE.add(jrb1);
        jpnE.add(jrb2);
        gp.add(jrb1);
        gp.add(jrb2);
        // gp.add(jrb2);
        // gp.add(jrb2);
        jrb1.setSelected(true);
        jpnE.add(start);
        jpnE.add(clean);
        jpnE.add(save);
        jpnE.add(exit);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EncryptorFrame.this.setVisible(false);
            }
        });
        jbtnBrowse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFileChooser jfc=new JFileChooser();
                jfc.setCurrentDirectory(new File("./"));
                int fileState=jfc.showOpenDialog(EncryptorFrame.this);
                if(fileState==JFileChooser.APPROVE_OPTION){
                    try {
                        File selectFile=jfc.getSelectedFile();
                        jtf.setText(selectFile.getPath());

                        FileInputStream fis=new FileInputStream(selectFile.getPath());
                        InputStreamReader isr=new InputStreamReader(fis,"UTF8");
                        BufferedReader br=new BufferedReader(isr);
                        String line;
                        while((line =br.readLine())!=null){
                            jta.append(line+"\n");
                        }
                        br.close();
                        fis.close();
                        isr.close();

                    }catch(IOException ioe) {
                        JOptionPane.showMessageDialog(EncryptorFrame.this, ioe.toString());
                    }catch(Exception err){
                        JOptionPane.showMessageDialog(EncryptorFrame.this, err.toString());
                    } 
                }
            }
        });
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
              if(jrb1.isSelected()){
                switch(jcb.getSelectedIndex()){
                    case 0:
                        char data[]=jta.getText().toCharArray();
                        int key=Integer.parseInt(jtfk.getText());
                        for(int i=0;i<data.length;i++){
                            data[i]=(char)(data[i]+key);
                        }
                        jta.setText(new String(data));
                        break;


                    case 1:
                        char datax[]=jta.getText().toCharArray();
                        char xorkey[]=jtfk.getText().toCharArray();
                        int j=0;
                        for(int i=0;i<datax.length;i++){
                            datax[i]=(char)(datax[i]^xorkey[j%xorkey.length]);
                            j++;
                        }
                        jta.setText(new String(datax));
                        break;
                }
                
              }else{
                switch(jcb.getSelectedIndex()){
                    case 0:
                        char data[]=jta.getText().toCharArray();
                        int key=Integer.parseInt(jtfk.getText());
                        for(int i=0;i<data.length;i++){
                            data[i]=(char)(data[i]-key);
                        }
                        jta.setText(new String(data));
                        break;
                    case 1:
                        char datax[]=jta.getText().toCharArray();
                        char xorkey[]=jtfk.getText().toCharArray();
                        int j=0;
                        for(int i=0;i<datax.length;i++){
                            datax[i]=(char)(datax[i]^xorkey[j%xorkey.length]);
                            j++;
                        }
                        jta.setText(new String(datax));
                        break;
                }
              }  
            }
        });
        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jfc =new JFileChooser();
                    int filestate =jfc.showSaveDialog(EncryptorFrame.this);
                    if (filestate==jfc.APPROVE_OPTION){
                        File write = jfc.getSelectedFile();
                        if(!write.exists()){
                        write.createNewFile();
                        }
                    FileWriter fw =new FileWriter(write);
                    BufferedWriter bfw =new BufferedWriter(fw);
                    bfw.write(jta.getText());
                    bfw.close();
                    fw.close();

                    }
                } catch (IOException ioe) {

                } catch (Exception err) {
                    JOptionPane.showMessageDialog(EncryptorFrame.this, err.toString());
                }
            }
        });
        clean.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jtf.setText("");
            }
        });
    }
}