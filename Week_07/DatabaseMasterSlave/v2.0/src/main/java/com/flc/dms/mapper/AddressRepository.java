package com.flc.dms.mapper;

import com.flc.dms.domain.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:33
 * @desc
 */
@Mapper
public interface AddressRepository extends CommonRepository<Address, Long> {
}
