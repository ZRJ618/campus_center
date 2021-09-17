package com.demo;

import java.io.*;

public class ImageDownload {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        File file = new File("F:\\图片\\头像\\0.jpg");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try{
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(new File("F:\\图片"));
            int i = bis.read(bytes);

            while(i != -1) {
                System.out.println(i);
                fos.write(bytes, 0, i);
                i = bis.read(bytes);
            }
        }catch(Exception e){

        }finally {
            try {
                //fos.close();
                bis.close();
                fis.close();
            }catch(IOException e) {

            }
        }
    }
}
