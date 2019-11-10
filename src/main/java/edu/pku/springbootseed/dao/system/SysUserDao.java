package edu.pku.springbootseed.dao.system;

import edu.pku.springbootseed.common.Constant;
import edu.pku.springbootseed.common.model.ResultSetHashMap;
import edu.pku.springbootseed.domain.SysUser;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * user 数据访问
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Mapper
public interface SysUserDao {
    /**
     * 获取数据对象
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Select("SELECT * from " + Constant.TABLE_SYS_USER + " where NAME like #{name}")
    List<SysUser> getUser(@Param("name") String name);

    /**
     * 获取多行数据
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Select("SELECT * from " + Constant.TABLE_SYS_USER + " ORDER BY ${orderBy}")
    List<SysUser> getUserList(@NotNull @Param("orderBy") String orderBy);

    /**
     * 获取数据，返回HashMap
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Select("SELECT NAME, xhzgh, BIRTH, AGE from " + Constant.TABLE_SYS_USER + " where NAME like #{name}")
    List<ResultSetHashMap> getUserInfo(@Param("name") String name);

    /**
     * 更新数据
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Update("update " + Constant.TABLE_SYS_USER + " set age=#{user.age} where xhzgh =#{user.xhzgh}")
    int updateUserByXhzgh(@Param("user") SysUser user);

    /**
     * 插入数据
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Insert("INSERT into " + Constant.TABLE_SYS_USER +
            " (ID,NAME,XHZGH,BIRTH,AGE,GENDER,CREATE_DATE,COMMENTS) " +
            " values " +
            " (to_char(sysdate,'YYYYMMDDHHMISS') || to_char((" + Constant.SEQ_SYS_USER + ".nextval), 'fm000000'), " +
            " #{user.name},#{user.xhzgh}, #{user.birth}, #{user.age}, #{user.gender}, sysdate, #{user.comments, jdbcType=CLOB})")
    int insertUser(@Param("user") SysUser user);

    /**
     * 删除数据
     *
     * @author wangyc
     * @since 2019/11/10
     */
    @Delete("delete from " + Constant.TABLE_SYS_USER + " where name=#{badName} ")
    int deleteUser(String badName);
}
