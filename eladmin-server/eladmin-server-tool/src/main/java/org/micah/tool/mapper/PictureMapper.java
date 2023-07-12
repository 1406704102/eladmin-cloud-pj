package org.micah.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.micah.model.Picture;

/**
 * @program: eladmin-cloud
 * @description:
 * @author: Micah
 * @create: 2020-09-16 17:03
 **/
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {
}
