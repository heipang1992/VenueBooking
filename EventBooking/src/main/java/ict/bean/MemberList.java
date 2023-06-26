/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;
import java.util.*;

public class MemberList {
    
    ArrayList<AccountBean> list;
    
    public MemberList() {
        ArrayList<AccountBean> list = new ArrayList<AccountBean>();
    }
    
    public void addList(AccountBean bean){
        list.add(bean);
    }
    
    public ArrayList<AccountBean> getList() {
        return list;
    }
}
