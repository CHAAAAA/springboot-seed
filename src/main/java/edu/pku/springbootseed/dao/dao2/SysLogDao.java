package edu.pku.springbootseed.dao.dao2;

import edu.pku.springbootseed.common.annotation.MainDs;
import edu.pku.springbootseed.common.model.ResultSetHashMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * desc
 *
 * @author wangyc
 * @since 2019/11/12
 */
@MainDs
@Mapper
public interface SysLogDao {

    @Select("select * from SYS_LOG")
    List<ResultSetHashMap> listLogs();
}
