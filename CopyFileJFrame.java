package CopyFile;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author cjz
 * 用来复制文件
 * version 1.0
 * 窗体类
 */
public class CopyFileJFrame extends JFrame {

    /**
     * Creates new form CopyFileJFrame
     */
    public CopyFileJFrame() {
        initComponents();
        init();
    }

    private void init()
    {
        this.setTitle("复制文件");
        Until.setFrameCenter(this);
    }

    private void initComponents() {

        lable1 = new java.awt.Label();
        label2 = new java.awt.Label();
        button1 = new java.awt.Button();
        checkbox1 = new java.awt.Checkbox();
        label3 = new java.awt.Label();
        jLabel1 = new JLabel();
        srcF3 = new JTextField();
        srcF2 = new JTextField();
        srcF1 = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lable1.setForeground(new java.awt.Color(0, 51, 51));
        lable1.setText("复制文件的位置");

        label2.setForeground(new java.awt.Color(0, 51, 51));
        label2.setText("需要复制文件的类型");


        button1.setLabel("确定");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        checkbox1.setLabel("是否删除源文件");

        label3.setForeground(new java.awt.Color(0, 51, 51));
        label3.setText("复制到的位置");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(checkbox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lable1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                                .addGap(30, 30, 30))
                                        .addComponent(srcF3)
                                        .addComponent(srcF2)
                                        .addComponent(srcF1))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(lable1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(srcF1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(srcF2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(srcF3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkbox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(48, Short.MAX_VALUE))
        );

        label2.getAccessibleContext().setAccessibleName("form1");

        pack();
    }
    //添加按钮事件
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        String s1=this.srcF1.getText().trim();
        String s2=this.srcF2.getText().trim();
        String s3=this.srcF3.getText().trim();
        boolean isdelete= this.checkbox1.getState();
        if (s1==null||s2==null||s1.equals("")||s2.equals(""))
        {
            JOptionPane.showMessageDialog(null, "请你输入路径！", "Warning",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (s3==null||s3.equals(""))
        {
            JOptionPane.showMessageDialog(null, "请你输入需要复制的文件/类型！", "Warning",JOptionPane.ERROR_MESSAGE);
            return;
        }
        CopyFile nf=new CopyFile();
        File srcFile = new File(s1);
        nf.copyFile(srcFile, s3,s2,isdelete);

    }


    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CopyFileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopyFileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopyFileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopyFileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopyFileJFrame().setVisible(true);
            }
        });
    }

    private java.awt.Button button1;
    private java.awt.Checkbox checkbox1;
    private JLabel jLabel1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label lable1;
    private JTextField srcF1;
    private JTextField srcF2;
    private JTextField srcF3;
}
