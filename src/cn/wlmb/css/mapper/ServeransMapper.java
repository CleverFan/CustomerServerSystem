package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Serverans;
import cn.wlmb.css.po.ServeransExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServeransMapper {
    int countByExample(ServeransExample example);

    int deleteByExample(ServeransExample example);

    int deleteByPrimaryKey(String sanid);

    int insert(Serverans record);

    int insertSelective(Serverans record);

    List<Serverans> selectByExample(ServeransExample example);

    Serverans selectByPrimaryKey(String sanid);

    int updateByExampleSelective(@Param("record") Serverans record, @Param("example") ServeransExample example);

    int updateByExample(@Param("record") Serverans record, @Param("example") ServeransExample example);

    int updateByPrimaryKeySelective(Serverans record);

    int updateByPrimaryKey(Serverans record);
}