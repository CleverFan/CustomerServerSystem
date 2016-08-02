package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Server;
import cn.wlmb.css.po.ServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerMapper {
    int countByExample(ServerExample example);

    int deleteByExample(ServerExample example);

    int deleteByPrimaryKey(String serverid);

    int insert(Server record);

    int insertSelective(Server record);

    List<Server> selectByExample(ServerExample example);

    Server selectByPrimaryKey(String serverid);

    int updateByExampleSelective(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByExample(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);
}