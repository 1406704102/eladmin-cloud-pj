package org.micah.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.micah.model.EmailConfig;

/**
 * @program: eladmin-cloud
 * @description:
 * @author: Micah
 * @create: 2020-09-08 18:35
 **/
@Mapper
public interface EmailMapper extends BaseMapper<EmailConfig> {
}
