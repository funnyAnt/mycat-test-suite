/*
 * Copyright (c) 2020, OpenCloudDB/MyCAT and/or its affiliates. All rights
 * reserved. DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software;Designed and Developed mainly by many Chinese
 * opensource volunteers. you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 2 only, as published by the
 * Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License version 2 for more
 * details (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version 2
 * along with this work; if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Any questions about this component can be directed to it's project Web
 * address https://code.google.com/p/opencloudb/.
 *
 */
package io.mycat.test;

import java.sql.Connection;

import io.mycat.test.config.SystemConfig;
import io.mycat.test.config.SystemConfig.DbConfig;
import io.mycat.test.config.loader.ConfigLoader;
import io.mycat.test.utils.JDBCUtil;

public class TestCaseServer {
    private ConfigLoader<Object> testCaseConfigLoader;
    private ConfigLoader<SystemConfig> systemConfigLoader;
    private ResultComparator resultComparator;
    
    private SystemConfig systemConfig;

    public TestCaseServer(ConfigLoader<SystemConfig> systemConfigLoader, ConfigLoader<Object> testCaseConfigLoader,
            ResultComparator resultComparator) {
        this.systemConfigLoader = systemConfigLoader;
        this.testCaseConfigLoader = testCaseConfigLoader;
        this.resultComparator = resultComparator;
    }

    public void start() {
        // TODO Auto-generated method stub
        //1 加载配置
        systemConfig = systemConfigLoader.load();
        
        //2 同步配置文件，并重载到Mycat内存
        
        
        //3 执行用例，保存到本地
        String  factResultDir = null;
        String expectResultDir = null;
        
        //4 和标准结果比较，输出测试报告
        resultComparator.compare(factResultDir, expectResultDir);
        return;
        // configLoader.load();
    }
    
    private void getConnection() {
        DbConfig dbConfig = systemConfig.getDbConfig();
        Connection serverConn = JDBCUtil.getConnection(dbConfig.getIp(),dbConfig.getServerPort(), dbConfig.getUserName(), dbConfig.getPassword(),dbConfig.getSchemaName());
        Connection managerConn = JDBCUtil.getConnection(dbConfig.getIp(),dbConfig.getManagerPort(), dbConfig.getUserName(), dbConfig.getPassword(),dbConfig.getSchemaName());
        
    }

}
