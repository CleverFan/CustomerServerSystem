package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Servermsg;
import cn.wlmb.css.po.ServermsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServermsgMapper {
    int countByExample(ServermsgExample example);

    int deleteByExample(ServermsgExample example);

    int insert(Servermsg record);

    int insertSelective(Servermsg record);

    List<Servermsg> selectByExample(ServermsgExample example);

    int updateByExampleSelective(@Param("record") Servermsg record, @Param("example") ServermsgExample example);

    int updateByExample(@Param("record") Servermsg record, @Param("example") ServermsgExample example);
}