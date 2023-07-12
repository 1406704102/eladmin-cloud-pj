package org.pangjie.wx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.micah.core.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.micah.core.web.page.PageResult;
import org.micah.model.UserInfo;
import org.micah.model.dto.UserInfoDto;
import org.micah.model.mapstruct.UserInfoMapStruct;
import org.micah.model.query.UserInfoQueryCriteria;
import org.pangjie.wx.mapper.UserInfoMapper;
import org.pangjie.wx.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.lang.IllegalArgumentException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.micah.mp.util.QueryHelpUtils;
import org.springframework.data.domain.Pageable;
import org.micah.mp.util.PageUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.micah.exception.global.CreateFailException;
import org.micah.exception.global.DeleteFailException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.*;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author pangjie
* @date 2023-07-11
**/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService {

    private final UserInfoMapper userInfoMapper;

    private final UserInfoMapStruct userInfoMapStruct;

    @Override
    public PageResult queryAll(UserInfoQueryCriteria userInfoCriteria, Pageable pageable){
        Page<UserInfo> page = PageUtils.startPageAndSort(pageable);
        QueryWrapper<UserInfo> wrapper = QueryHelpUtils.getWrapper(userInfoCriteria, UserInfo.class);
        Page<UserInfo> userInfoPage = this.userInfoMapper.selectPage(page, wrapper);
        return PageResult.success(userInfoPage.getTotal(), userInfoPage.getPages(),
                                    this.userInfoMapStruct.toDto(userInfoPage.getRecords()));
    }

    @Override
    public List<UserInfoDto> queryAll(UserInfoQueryCriteria criteria){
        QueryWrapper<UserInfo> wrapper = QueryHelpUtils.getWrapper(criteria, UserInfo.class);
        return this.userInfoMapStruct.toDto(this.list(wrapper));
    }

    @Override
    public UserInfoDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("参数为空");
        }
        UserInfo userInfo = Optional.ofNullable(this.userInfoMapper.selectById(id)).orElse(null);
        return this.userInfoMapStruct.toDto(userInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDto create(UserInfo resources) {
                                                                                if(!this.save(resources)) {
            log.warn("插入失败:{}", resources);
            throw new CreateFailException("插入一条数据失败,请联系管理员");
        }
        return userInfoMapStruct.toDto(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UserInfo resources) {
        if(!this.updateById(resources)){
            log.warn("更新失败:{}", resources);
            throw new CreateFailException("更新一条数据失败,请联系管理员");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Set<Long> ids) {
        if(!this.removeByIds(ids)){
            log.warn("删除失败:{}", ids);
            throw new DeleteFailException("批量删除失败,请联系管理员");
        }
    }

    @Override
    public void download(List<UserInfoDto> data, HttpServletResponse response) throws IOException {
        FileUtils.downloadFailedUsingJson(response, "userInfo-info", UserInfoDto.class, data, "userInfo-sheet");
    }
}