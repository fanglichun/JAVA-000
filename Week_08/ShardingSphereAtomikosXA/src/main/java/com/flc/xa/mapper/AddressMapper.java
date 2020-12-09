package com.flc.xa.mapper;

import com.flc.xa.domain.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:33
 * @desc
 */
@Mapper
public interface AddressMapper extends CommonRepository<Address, Long> {
}
