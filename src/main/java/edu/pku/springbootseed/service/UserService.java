package edu.pku.springbootseed.service;

import edu.pku.springbootseed.common.model.ResultSetHashMap;
import edu.pku.springbootseed.domain.SysUser;

import java.util.List;

/**
 * UserService
 *
 * @author wangyc
 * @since 2019/11/10
 */
public interface UserService {
    List<SysUser> getUser(String name);

    List<SysUser> getUserList(String orderBy);

    List<ResultSetHashMap> getUserInfo(String name);

    int updateUserByXhzgh(SysUser user);

    int insertUser(SysUser user);

    int deleteUser(String badName);
}
