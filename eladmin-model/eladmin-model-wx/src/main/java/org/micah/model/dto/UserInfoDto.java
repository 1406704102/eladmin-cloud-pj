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

package org.micah.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @website https://el-admin.vip
* @description /
* @author pangjie
* @date 2023-07-11
**/
@Data
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String openid;

    private String nickname;

    private String userAvatar;

    private String userPhone;

    private Timestamp createTime;
}