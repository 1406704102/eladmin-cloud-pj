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
package org.pangjie.wx.controller;

import org.micah.log.annotation.Log;
import org.micah.core.web.page.PageResult;
import org.micah.model.UserInfo;
import org.micah.model.query.UserInfoQueryCriteria;
import org.pangjie.wx.service.IUserInfoService;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.lang.IllegalArgumentException;

import java.util.Set;

/**
* @author pangjie
* @date 2023-07-11
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "微信用户信息管理")
@RequestMapping("/userInfo")
public class UserInfoController {

    private final IUserInfoService userInfoService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('userInfo:list')")
    public void download(HttpServletResponse response, UserInfoQueryCriteria userInfoCriteria) throws IOException {
        this.userInfoService.download(this.userInfoService.queryAll(userInfoCriteria), response);
    }

    @GetMapping
    @Log("查询微信用户信息")
    @ApiOperation("查询微信用户信息")
    @PreAuthorize("@el.check('userInfo:list')")
    public ResponseEntity<PageResult> query(UserInfoQueryCriteria userInfoCriteria, Pageable pageable){
        return new ResponseEntity<>(this.userInfoService.queryAll(userInfoCriteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增微信用户信息")
    @ApiOperation("新增微信用户信息")
    @PreAuthorize("@el.check('userInfo:add')")
    public ResponseEntity<Void> create(@Validated @RequestBody UserInfo resources){
        if(resources.getId() != null){
            throw new IllegalArgumentException("新的数据id不为空");
        }
        this.userInfoService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改微信用户信息")
    @ApiOperation("修改微信用户信息")
    @PreAuthorize("@el.check('userInfo:edit')")
    public ResponseEntity<Void> updateUserInfo(@Validated @RequestBody UserInfo resources){
        this.userInfoService.updateUserInfo(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除微信用户信息")
    @ApiOperation("删除微信用户信息")
    @PreAuthorize("@el.check('userInfo:del')")
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Set<Long> ids) {
        this.userInfoService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}