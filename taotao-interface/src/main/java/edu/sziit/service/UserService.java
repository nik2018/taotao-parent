package edu.sziit.service;

import com.github.pagehelper.PageInfo;
import edu.sziit.pojo.User;

import java.util.List;

public interface UserService {
    void save();
    List<User> selectAll();
    PageInfo<User> findbypage(int currentPage,int pageSize);
}
