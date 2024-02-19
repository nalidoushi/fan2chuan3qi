package exec.service;

import exec.dao.MySqlUserDao;
import exec.dao.UserDao;
import exec.domain.User;
import exec.exception.MsgException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new MySqlUserDao();

    /**
     * 实现用户注册功能
     * @param user 封装了用户信息的bean
     */
    public void regist(User user) throws MsgException{
        //1.检查id是否重复，如果重复报错
        User findUser = userDao.findUserById(user.getId());
        if(findUser!=null){
            throw new MsgException("注册的id已存在,注册失败!");
        }
        //2.将用户信息写入
        userDao.insertUser(user);
    }
}
