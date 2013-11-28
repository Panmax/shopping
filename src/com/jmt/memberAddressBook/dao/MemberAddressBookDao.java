package com.jmt.memberAddressBook.dao;

import com.jmt.memberAddressBook.po.MemberAddressBook;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-24
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public interface MemberAddressBookDao {
    public boolean addMemberAddressBook(MemberAddressBook memberAddressBook);
    public boolean updateMemberAddressBook(MemberAddressBook memberAddressBook);
    public boolean deleteMemberAddressBook(int id);
    public MemberAddressBook getMemberAddressBook(int memberID);
}
