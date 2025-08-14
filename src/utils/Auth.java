/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Entity.NhanVien;

public class Auth {

    public static NhanVien user = null;

    public static void clear() {
        // khi đăng xuất sẽ xóa thông tin người đăng nhập
        Auth.user = null;
    }

    public static boolean isLogin() {
        // nếu có người đăng nhập thì user sẽ là thông tin tài khoản người đăng nhập
        return Auth.user != null;
    }

    public static boolean isManager() {
        // phân quyền giữa nhân viên và admin
        return Auth.isLogin() && user.isVaiTro();
    }
}
