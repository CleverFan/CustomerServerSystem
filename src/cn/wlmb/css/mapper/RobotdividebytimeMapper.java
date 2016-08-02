package cn.wlmb.css.mapper;

import cn.wlmb.css.po.Robotdividebytime;
import cn.wlmb.css.po.RobotdividebytimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RobotdividebytimeMapper {
    int countByExample(RobotdividebytimeExample example);

    int deleteByExample(RobotdividebytimeExample example);

    int insert(Robotdividebytime record);

    int insertSelective(Robotdividebytime record);

    List<Robotdividebytime> selectByExample(RobotdividebytimeExample example);

    int updateByExampleSelective(@Param("record") Robotdividebytime record, @Param("example") RobotdividebytimeExample example);

    int updateByExample(@Param("record") Robotdividebytime record, @Param("example") RobotdividebytimeExample example);
}