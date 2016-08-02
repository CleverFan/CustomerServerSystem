package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Num;
import cn.wlmb.css.po.NumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NumMapper {
    int countByExample(NumExample example);

    int deleteByExample(NumExample example);

    int insert(Num record);

    int insertSelective(Num record);

    List<Num> selectByExample(NumExample example);

    int updateByExampleSelective(@Param("record") Num record, @Param("example") NumExample example);

    int updateByExample(@Param("record") Num record, @Param("example") NumExample example);
}