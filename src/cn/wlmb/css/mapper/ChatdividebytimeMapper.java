package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Chatdividebytime;
import cn.wlmb.css.po.ChatdividebytimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatdividebytimeMapper {
    int countByExample(ChatdividebytimeExample example);

    int deleteByExample(ChatdividebytimeExample example);

    int insert(Chatdividebytime record);

    int insertSelective(Chatdividebytime record);

    List<Chatdividebytime> selectByExample(ChatdividebytimeExample example);

    int updateByExampleSelective(@Param("record") Chatdividebytime record, @Param("example") ChatdividebytimeExample example);

    int updateByExample(@Param("record") Chatdividebytime record, @Param("example") ChatdividebytimeExample example);
}