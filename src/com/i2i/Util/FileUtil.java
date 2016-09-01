package com.i2i.Util;

import java.lang.Exception; 
import java.util.Date;

/**
 * <p>
 * FileUtil used to save the error log
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-01
 */


public class FileUtil {
 
/**
  * <p>
  * ErrorLogger to save the error hapen during execution
  * </p>
  * @param error
  *      Contains error message
  */
 public static void ErrorLogger(String error) {
        try {
            Date date = new Date();
            System.out.println("Date : "+date + "- Error : " + error + "\n");              
        } catch (Exception e) {
            System.out.println(e);         
        }    
  }

}
