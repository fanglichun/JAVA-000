package com.flc.dms.mapper;

import com.flc.dms.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:41
 * @desc
 */
@Mapper
public interface UserMapper extends CommonRepository<User, Long> {
}
