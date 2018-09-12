package edu.sziit.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.sziit.mapper.UserMapper;
import edu.sziit.pojo.User;
import edu.sziit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service //注意，这个注解使用的是dubbo的注解，而不是Spring提供的@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void save() {
        System.out.println("调用了UserServiceImpl的save方法~！");
    }

    @Override
    public List<User> selectAll() {
        return  userMapper.selectAll();
    }

    @Override
    public PageInfo<User> findbypage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> list = userMapper.selectAll();
        PageInfo<User> PageInfo = new PageInfo<>(list);
        return PageInfo;
    }
}
