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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mycat.test.config.SystemConfig;
import io.mycat.test.config.loader.ConfigLoader;
import io.mycat.test.config.loader.LocalFileConfigLoader;
import io.mycat.test.config.loader.SystemConfigLoader;
import io.mycat.test.config.result.DefaultResultComparator;

/**
 * 测试总入口
 * 
 * @author funnyAnt
 *
 */
public class TestMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        String systemConfigFilePath = null; 
        String  expectResultDir = null; //参照的标准结果目录
        
        if (args != null && args.length == 1) {
            systemConfigFilePath = args[0];
            expectResultDir = args[10];
        }

        LOGGER.info("starting test server......");

        ConfigLoader<SystemConfig> systemConfigLoader = new SystemConfigLoader(systemConfigFilePath);
        ConfigLoader<Object> testCaseConfigLoader = new LocalFileConfigLoader(systemConfigFilePath);
        ResultComparator resultComparator = new DefaultResultComparator(expectResultDir);
        TestCaseServer server = new TestCaseServer(systemConfigLoader, testCaseConfigLoader, resultComparator);
        server.start();
        LOGGER.info("test server stopped......");
    }
}
