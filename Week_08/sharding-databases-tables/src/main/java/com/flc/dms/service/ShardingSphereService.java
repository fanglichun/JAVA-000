package com.flc.dms.service;

import java.sql.SQLException;
import java.util.List;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:51
 * @desc
 */
public interface ShardingSphereService {
    void initEnvironment() throws SQLException;

    void cleanEnvironment() throws SQLException;

    void processSuccess() throws SQLException;

    List<Long> insertData() throws SQLException;

    void processFailure() throws SQLException;

    void deleteData(final List<Long> userIds) throws SQLException;

    void printData() throws SQLException;
}
