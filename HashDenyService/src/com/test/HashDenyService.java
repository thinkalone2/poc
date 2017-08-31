package com.test;
import java.io.*;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
/** 
 * 用来模拟HashMap的拒绝服务攻击，因为hash表存放数据的时候如果HashCode值相等， 
 * 首先用hash值确定tables的索引【index】，得到entry，然后将自己加入entry链的头部 
 * 原来的值就成为它的next，这也是为什么entry有Next 
 * 则这个相同的HashCode上用链表的形式去存放HashCode相等的值，如果相似的Code 
 * 太多，这个链表将很长，一个简单的查询将耗尽所有的CPU 
 * @author wb-zhangye 
 * 
 */  
public class HashDenyService {  
    /** 
     * 存放要放入hash表中hashcode相同的字符串 
     */  
    private static List<String> DEPOSITORY = new ArrayList<String>();  
      
    /** 
     * HashMap存放多个hashCode相同的键 
     */  
    private static Map<String, String> DENYMAP = new HashMap<String, String>();  
      
    /** 
     * 要放入hash表中的相同hashCode的个数，用 2 的POWER次幂表示， 
     * 例如 2^15 
     */  
    private static int POWER = 15;  
      
      
    public static void main(String[] args) {  
          
        /************************************************** 
         ***************构造多个hashCode相同的Map*********** 
         **************************************************/  
        System.out.println("-------------attack---------- ");  
        Long beginTime = System.currentTimeMillis();  
          
        String xx = "Aa", yy = "BB";    // xx 与 yy的hashCode值相同  
        String[] arrays = { xx, yy };  
        perm(arrays, null);  
          
        for(int i = 0; i < DEPOSITORY.size(); i++){  
            DENYMAP.put(DEPOSITORY.get(i), "xx" + i);  
        }  
          
        Long endTime = System.currentTimeMillis();  
        System.out.println("-------------cease fire---------- ");  
        System.out.println("一共耗时" + (endTime - beginTime));  
          
          
        /************************************************** 
         *************在Map中取出一个key对应的value********* 
         **************************************************/  
        System.out.println("-------------start get Service---------- ");  
        Long xstartTiem = System.currentTimeMillis();  
          
        String tempData = DENYMAP.get(DEPOSITORY.get(30));  
        int code = hash(tempData.hashCode());  
        int index = code & (64 - 1);  
        System.out.println("index is " + index);  
          
        System.out.println(DENYMAP.get(DEPOSITORY.get(30)));  
        Long xendTime = System.currentTimeMillis();  
        System.out.println("一共耗时" + (xendTime - xstartTiem));  
        System.out.println("-------------end end Service---------- ");  
    }  
      
    public static int hash(int h) {  
        h ^= (h >>> 20) ^ (h >>> 12);  
        return h ^ (h >>> 7) ^ (h >>> 4);  
    }  
  
    /** 
     * 构造多个hashcode相同的字符串，放入DEPOSITORY中 
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