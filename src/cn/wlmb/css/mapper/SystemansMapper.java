package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Systemans;
import cn.wlmb.css.po.SystemansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemansMapper {
    int countByExample(SystemansExample example);

    int deleteByExample(SystemansExample example);

    int deleteByPrimaryKey(String syanid);

    int insert(Systemans record);

    int insertSelective(Systemans record);

    List<Systemans> selectByExample(SystemansExample example);

    Systemans selectByPrimaryKey(String syanid);

    int updateByExampleSelective(@Param("record") Systemans record, @Param("example") SystemansExample example);

    int updateByExample(@Param("record") Systemans record, @Param("example") SystemansExample example);

    int updateByPrimaryKeySelective(Systemans record);

    int updateByPrimaryKey(Systemans record);
}