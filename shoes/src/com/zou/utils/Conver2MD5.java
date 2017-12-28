package com.zou.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Conver2MD5 {

	public static String getMD5(String str) {
        String reStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//��������ָ���㷨���Ƶ���ϢժҪ
            md.update(str.getBytes());//ʹ��ָ�����ֽڸ���ժҪ��
            byte ss[] = md.digest();//ͨ��ִ���������֮������ղ�����ɹ�ϣ����
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {

        }
        return reStr;
    }
	
	public static String getSHA(String str) {
        String reStr = null;
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");//��������ָ���㷨���Ƶ���ϢժҪ
            sha.update(str.getBytes());//ʹ��ָ�����ֽڸ���ժҪ��
            byte ss[] = sha.digest();//ͨ��ִ���������֮������ղ�����ɹ�ϣ����
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {

        }
        return reStr;

    }
    private static String bytes2String(byte[] aa) {//���ֽ�����ת��Ϊ�ַ���
        String hash = "";
        for (int i = 0; i < aa.length; i++) {//ѭ������
            int temp;
            if (aa[i] < 0)		//���С���㣬�����Ϊ����
                temp = 256 + aa[i];
            else
                temp = aa[i];
            if (temp < 16)
                hash += "0";
            hash += Integer.toString(temp, 16);//ת��Ϊ16����
        }
        hash = hash.toUpperCase();//ȫ��ת��Ϊ��д
        return hash;
    }
}
