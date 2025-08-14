/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class MailOTP {
    public static String NhanOTP(){
    Random rd = new Random();
    int otp = 100000 + rd.nextInt(900000);
    return String.valueOf(otp);
    }
}
