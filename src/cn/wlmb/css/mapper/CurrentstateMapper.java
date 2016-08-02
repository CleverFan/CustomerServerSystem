package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Currentstate;
import cn.wlmb.css.po.CurrentstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrentstateMapper {
    int countByExample(CurrentstateExample example);

    int deleteByExample(CurrentstateExample example);

    int insert(Currentstate record);

    int insertSelective(Currentstate record);

    List<Currentstate> selectByExample(CurrentstateExample example);

    int updateByExampleSelective(@Param("record") Currentstate record, @Param("example") CurrentstateExample example);

    int updateByExample(@Param("record") Currentstate record, @Param("example") CurrentstateExample example);
}