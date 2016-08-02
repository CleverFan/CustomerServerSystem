package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Leavemsgdividebytime;
import cn.wlmb.css.po.LeavemsgdividebytimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavemsgdividebytimeMapper {
    int countByExample(LeavemsgdividebytimeExample example);

    int deleteByExample(LeavemsgdividebytimeExample example);

    int insert(Leavemsgdividebytime record);

    int insertSelective(Leavemsgdividebytime record);

    List<Leavemsgdividebytime> selectByExample(LeavemsgdividebytimeExample example);

    int updateByExampleSelective(@Param("record") Leavemsgdividebytime record, @Param("example") LeavemsgdividebytimeExample example);

    int updateByExample(@Param("record") Leavemsgdividebytime record, @Param("example") LeavemsgdividebytimeExample example);
}