package edu.sziit.controller;

import com.alibaba.dubbo.config.annotation.Reference;

//import edu.sziit.service.UserService;
import com.github.pagehelper.PageInfo;
import edu.sziit.pojo.User;
import edu.sziit.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference  //注意： 这里使用的是dubbo的注解
    private UserService userService;

    @RequestMapping("save")
    public String save(){
        System.out.println("save~!");

        userService.save();

        return "save success~!";
    }
    @RequestMapping("selectall")
    public String selectAll(){
        List<User> list = userService.selectAll();
        for (User user : list){
            System.out.println("user+" + user);
        }
        return "success";
    }
    @RequestMapping("findbypage")
    public String findBypage(int currentpage,int pagesize){
        PageInfo<User> userPageInfo = userService.findbypage(currentpage, pagesize);
        List<User> list = userPageInfo.getList();
        for (User user : list){
            System.out.println("user=" + user);

        }

        System.out.println("pagenum"+userPageInfo.getPageNum());
        System.out.println("total" + userPageInfo.getTotal());
        System.out.println("size" + userPageInfo.getSize());
        System.out.println("pages" + userPageInfo.getPages());
        System.out.println("pagesize" + userPageInfo.getPageSize());



        return "success";
    }

}