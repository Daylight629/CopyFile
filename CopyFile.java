package CopyFile;

import java.io.*;

public class CopyFile {
        //遍历获取文件
    public static void copyFile(File srcFile, String s, String lu, boolean isdelete) {

        //获取文件和文件夹数组
        File[] ff = srcFile.listFiles();

        for (File f : ff) {
            //判断是否为文件夹
            if (f.isDirectory()) {
                copyFile(f, s,lu,isdelete);
            } else {
                if (f.getName().endsWith(s))
                    copyFile(f,lu);
                if (isdelete)
                    deleteFile(f);

            }
        }
    }
    //复制文件
    private static void copyFile(File srcFile,String lu) {

        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {

            File destFile = new File(lu, srcFile.getName());
            bi = new BufferedInputStream(new FileInputStream(srcFile));
            bo = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] bys = new byte[1024 * 100];
            int len = 0;
            while ((len = bi.read(bys)) != -1) {
                bo.write(bys, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bo.close();
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        //删除文件
    private  static void deleteFile(File srcFile)
    {
        srcFile.deleteOnExit();
        srcFile.delete();
    }

}
