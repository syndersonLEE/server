package org.sopt.artoo.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.artoo.dto.DisplayContent;
import org.sopt.artoo.model.DisplayReq;

import java.util.List;

@Mapper
public interface DisplayContentMapper {
    @Select("SELECT * FROM display_content WHERE a_idx = #{a_idx}")
    DisplayContent findByArtworkIdx(@Param("a_idx") final int a_idx);

    @Select("SELECT * FROM display_content WHERE dc_idx = #{dc_idx}")
    DisplayContent findByDisplayContentIdx(@Param("dc_idx") final int dc_idx);

    @Select("SELECT * FROM artwork, display_content WHERE art_work.a_idx=display_content.a_idx and " +
            "display_content.d_idx=#{d_idx}")
    List<DisplayContent> findArtworksByDisplayIdx(@Param("d_idx") final int d_idx);

    @Insert("INSERT INTO display_content(d_idx, a_idx, u_idx) VALUES(#{displayReq.d_idx}, #{displayReq.a_idx}, #{displayReq.u_idx})")
    void save(@Param("displayReq") final DisplayReq displayReq);

    @Delete("DELETE FROM display_content WHERE dc_idx=#{dc_idx}")
    void delete(@Param("dc_idx") final int dc_idx);
}