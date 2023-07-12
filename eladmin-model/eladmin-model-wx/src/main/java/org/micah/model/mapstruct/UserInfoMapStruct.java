package org.micah.model.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.micah.core.base.BaseMapStruct;
import org.micah.model.UserInfo;
import org.micah.model.dto.UserInfoDto;

/**
* @author pangjie
* @date 2023-07-11
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapStruct extends BaseMapStruct<UserInfoDto, UserInfo> {

}