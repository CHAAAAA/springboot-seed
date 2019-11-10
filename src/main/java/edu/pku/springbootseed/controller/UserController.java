package edu.pku.springbootseed.controller;

import com.alibaba.fastjson.JSONObject;
import edu.pku.springbootseed.common.model.Result;
import edu.pku.springbootseed.common.model.ResultSetHashMap;
import edu.pku.springbootseed.domain.SysUser;
import edu.pku.springbootseed.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Result<?> getUser(String name) {
        List<SysUser> sysUser = userService.getUser(name);
        return Result.success(sysUser);
    }

    @GetMapping("/listUser")
    public Result<?> getUserList(@RequestParam(value = "order", required = true) String orderBy) {
        List<SysUser> sysUserList = userService.getUserList(orderBy);
        log.info(JSONObject.toJSONString(sysUserList));
        return Result.success(sysUserList);
    }

    @GetMapping("/userInfo")
    public Result<?> getUserInfo(String name) {
        List<ResultSetHashMap> userInfo = userService.getUserInfo(name);
        return Result.success(userInfo);
    }

    @PostMapping("/update")
    public Result<?> updateUserByXhzgh(@RequestBody SysUser user) {
        log.info(user.toString());
        int rows = userService.updateUserByXhzgh(user);
        if (rows < 1) {
            return Result.failure("更新失败");
        }
        return Result.success();
    }

    @PostMapping("/insert")
    public Result<?> insertUser(@RequestBody SysUser user) {
        int rows = userService.insertUser(user);
        if (rows < 1) {
            return Result.failure("创建失败");
        }
        return Result.success();
    }

    @PostMapping("/delete")
    public Result<?> deleteUser(String badName) {
        int rows = userService.deleteUser(badName);
        if (rows < 1) {
            return Result.failure("删除失败");
        }
        return Result.success();
    }
}
