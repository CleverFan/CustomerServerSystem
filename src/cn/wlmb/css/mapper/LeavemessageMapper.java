package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Leavemessage;
import cn.wlmb.css.po.LeavemessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavemessageMapper {
    int countByExample(LeavemessageExample example);

    int deleteByExample(LeavemessageExample example);

    int insert(Leavemessage record);

    int insertSelective(Leavemessage record);

    List<Leavemessage> selectByExample(LeavemessageExample example);

    int updateByExampleSelective(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);

    int updateByExample(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);
}