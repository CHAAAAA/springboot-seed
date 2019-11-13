package edu.pku.springbootseed.service.impl;

import edu.pku.springbootseed.common.model.ResultSetHashMap;
import edu.pku.springbootseed.dao.dao1.SysUserDao;
import edu.pku.springbootseed.domain.SysUser;
import edu.pku.springbootseed.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> getUser(String name) {
        return sysUserDao.getUser(name);
    }

    @Override
    public List<SysUser> getUserList(String orderBy) {
        return sysUserDao.getUserList(orderBy);
    }

    @Override
    public List<ResultSetHashMap> getUserInfo(String name) {
        return sysUserDao.getUserInfo(name);
    }

    @Override
    public int updateUserByXhzgh(SysUser user) {
        return sysUserDao.updateUserByXhzgh(user);
    }

    @Override
    public int insertUser(SysUser user) {
        return sysUserDao.insertUser(user);
    }

    @Override
    public int deleteUser(String badName) {
        return sysUserDao.deleteUser(badName);
    }
}
