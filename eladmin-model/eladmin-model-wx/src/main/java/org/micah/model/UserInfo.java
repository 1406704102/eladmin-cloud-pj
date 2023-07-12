/*
* Copyright 2020-2025 Micah
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.micah.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @description /
* @author pangjie
* @date 2023-07-11
**/
@Data
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;


        @TableId(value = "id",type = IdType.AUTO)

        @ApiModelProperty(value = "id")
        private Long id;
        @ApiModelProperty(value = "openid")
        private String openid;
        @ApiModelProperty(value = "nickname")
        private String nickname;
        @ApiModelProperty(value = "userAvatar")
        private String userAvatar;
        @ApiModelProperty(value = "userPhone")
        private String userPhone;
        @ApiModelProperty(value = "createTime")
        private Timestamp createTime;
}
