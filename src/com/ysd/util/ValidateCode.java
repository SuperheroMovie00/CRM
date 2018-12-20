package com.ysd.util;

import javax.imageio.ImageIO;  
import java.awt.*;  
import java.awt.image.BufferedImage;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.util.Date;  
import java.util.Random;  

/** 
 * ��֤�������� 
 * 
 * @author  
 */  
public class ValidateCode {  
    // ͼƬ�Ŀ�ȡ�  
    private int width = 160;  
    // ͼƬ�ĸ߶ȡ�  
    private int height = 40;  
    // ��֤���ַ�����  
    private int codeCount = 5;  
    // ��֤���������  
    private int lineCount = 150;  
    // ��֤��  
    private String code = null;  
    // ��֤��ͼƬBuffer  
    private BufferedImage buffImg = null;  

    // ��֤�뷶Χ,ȥ��0(����)��O(ƴ��)���׻�����(Сд��1��LҲ����ȥ��,��д������)  
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};  

    /** 
     * Ĭ�Ϲ��캯��,����Ĭ�ϲ��� 
     */  
    public ValidateCode() {  
        this.createCode();  
    }  

    /** 
     * @param width  ͼƬ�� 
     * @param height ͼƬ�� 
     */  
    public ValidateCode(int width, int height) {  
        this.width = width;  
        this.height = height;  
        this.createCode();  
    }  

    /** 
     * @param width     ͼƬ�� 
     * @param height    ͼƬ�� 
     * @param codeCount �ַ����� 
     * @param lineCount ���������� 
     */  
    public ValidateCode(int width, int height, int codeCount, int lineCount) {  
        this.width = width;  
        this.height = height;  
        this.codeCount = codeCount;  
        this.lineCount = lineCount;  
        this.createCode();  
    }  

    public void createCode() {  
        int x = 0, fontHeight = 0, codeY = 0;  
        int red = 0, green = 0, blue = 0;  

        x = width / (codeCount + 2);//ÿ���ַ��Ŀ��(���Ҹ��ճ�һ���ַ�)  
        fontHeight = height - 2;//����ĸ߶�  
        codeY = height - 4;  

        // ͼ��buffer  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = buffImg.createGraphics();  
        // ���������  
        Random random = new Random();  
        // ��ͼ�����Ϊ��ɫ  
        g.setColor(Color.WHITE);  
        g.fillRect(0, 0, width, height);  
        // ��������,�����޸�Ϊ������  
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);  
//        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);  
        g.setFont(font);  

        for (int i = 0; i < lineCount; i++) {  
            // ���������ʼ�ͽ�������  
            int xs = random.nextInt(width);//x���꿪ʼ  
            int ys = random.nextInt(height);//y���꿪ʼ  
            int xe = xs + random.nextInt(width / 8);//x�������  
            int ye = ys + random.nextInt(height / 8);//y�������  

            // �����������ɫֵ���������ÿ�������ߵ���ɫֵ������ͬ��  
            red = random.nextInt(255);  
            green = random.nextInt(255);  
            blue = random.nextInt(255);  
            g.setColor(new Color(red, green, blue));  
            g.drawLine(xs, ys, xe, ye);  
        }  

        // randomCode��¼�����������֤��  
        StringBuffer randomCode = new StringBuffer();  
        // �������codeCount���ַ�����֤�롣  
        for (int i = 0; i < codeCount; i++) {  
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);  
            // �����������ɫֵ���������ÿ���ַ�����ɫֵ������ͬ��  
            red = random.nextInt(255);  
            green = random.nextInt(255);  
            blue = random.nextInt(255);  
            g.setColor(new Color(red, green, blue));  
            g.drawString(strRand, (i + 1) * x, codeY);  
            // ���������ĸ�����������һ��  
            randomCode.append(strRand);  
        }  
        // ����λ���ֵ���֤�뱣�浽Session�С�  
        code = randomCode.toString();  
    }  

    public void write(String path) throws IOException {  
        OutputStream sos = new FileOutputStream(path);  
        this.write(sos);  
    }  

    public void write(OutputStream sos) throws IOException {  
        ImageIO.write(buffImg, "png", sos);  
        sos.close();  
    }  

    public BufferedImage getBuffImg() {  
        return buffImg;  
    }  

    public String getCode() {  
        return code;  
    }  

    /** 
     * ���Ժ���,Ĭ�����ɵ�d�� 
     * @param args 
     */  
    public static void main(String[] args) {  
        ValidateCode vCode = new ValidateCode(160,40,5,150);  
        try {  
            String path="D:/"+new Date().getTime()+".png";  
            System.out.println(vCode.getCode()+" >"+path);  
            vCode.write(path);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  