package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Chat;
import cn.wlmb.css.po.ChatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMapper {
    int countByExample(ChatExample example);

    int deleteByExample(ChatExample example);

    int deleteByPrimaryKey(String chatid);

    int insert(Chat record);

    int insertSelective(Chat record);

    List<Chat> selectByExample(ChatExample example);

    Chat selectByPrimaryKey(String chatid);

    int updateByExampleSelective(@Param("record") Chat record, @Param("example") ChatExample example);

    int updateByExample(@Param("record") Chat record, @Param("example") ChatExample example);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);
}