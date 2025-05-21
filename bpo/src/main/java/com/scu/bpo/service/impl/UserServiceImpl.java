package com.scu.bpo.service.impl;

import com.scu.bpo.dao.UserDao;
import com.scu.bpo.pojo.entity.MoneyNotification;
import com.scu.bpo.pojo.entity.User;
import com.scu.bpo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service //交给springIOC（容器管理），后续自动装配使用
public class UserServiceImpl implements UserService {

    @Resource
    UserDao dao;

    @Override
    public boolean login(User user) {
        User dbUser = dao.selectByUserName(user.getUserName());
        if(dbUser == null){ //数据库中没有该用户
            return false;
        }else{
            if(dbUser.getPassword()==null){ //数据库密码为空
                return false;
            }
            if(dbUser.getPassword().equals(user.getPassword())){ //密码一致
                return true;
            }
        }
        return false;
    }

    @Override
    public String register(User user,String rePassword){
        User dbUser = dao.selectByUserName(user.getUserName());
        if (dbUser != null){
            return "用户名已存在";
        } else if ("".equals(rePassword) || "".equals(user.getPassword())){
            return "请输入密码";
        } else if (!rePassword.equals(user.getPassword())){ //未创建
            return "两次密码不一样";
        } else{
            dao.insert(user);
            return "注册成功";
        }
    }

    @Override
    public User findUser(String userName){
        User user = dao.selectByUserName(userName);
        return user;
    }

    public void ChangeMoney(MoneyNotification notification){
        Integer userId = notification.getUserId();
        String moneyType = notification.getMoneyType();
        User user = dao.selectByPrimaryKey(userId);
        float money = 0;
        if ("支付定金".equals(moneyType) || "支付尾款".equals(moneyType)){
            money = user.getMoney() - notification.getAmount();
        } else if ("全额转付".equals(moneyType)){
            money = user.getMoney() + notification.getAmount();
        }
        user.setMoney(money);
        dao.updateByPrimaryKey(user);

    }

    public User SelectByUserId(Integer UserId){
        User user = dao.selectByPrimaryKey(UserId);
        return user;
    }

}
