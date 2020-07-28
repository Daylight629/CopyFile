package CopyFile;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author cjz
 */
public class Until {

    private Until(){}

    public static void setFrameImage(JFrame jf)
    {

    }

    public static void setFrameCenter(JFrame jf)
    {
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        double sceenw=d.getWidth();
        double sceenh=d.getHeight();
        int fw=jf.getWidth();
        int fh=jf.getHeight();

        int width=(int)(sceenw-fw)/2;
        int height=(int)(sceenh-fh)/2;

        jf.setLocation(width, height);



    }

}
