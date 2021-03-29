/*
 * Copyright (c) 2020, OpenCloudDB/MyCAT and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software;Designed and Developed mainly by many Chinese 
 * opensource volunteers. you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License version 2 only, as published by the
 * Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Any questions about this component can be directed to it's project Web address 
 * https://code.google.com/p/opencloudb/.
 *
 */
package io.mycat.test.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义数据库的连接配置和用例配置文件路径信息
 * @author funnyAnt
 *
 */
public class SystemConfig {
    private boolean isZK;
    private DbConfig dbConfig;
    private TestCaseConfig testCaseConfig;

    public SystemConfig(boolean isZK,DbConfig dbConfig, TestCaseConfig testCaseConfig) {
        this.isZK = isZK;
        this.dbConfig = dbConfig;
        this.testCaseConfig = testCaseConfig;
    }

    
    public boolean isZK() {
        return isZK;
    }


    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public TestCaseConfig getTestCaseConfig() {
        return testCaseConfig;
    }
    /**
     * 
     * 数据库（mysql,mycat)相关连接信息配置
     *
     */
    public static  class DbConfig {
        private String ip;
        private int serverPort;
        private int managerPort;
        private String userName;
        private String password;
        private String schemaName;

        public DbConfig(String url, int serverPort,int managerPort,String userName, String password,String schemaName) {
            super();
            this.ip = url;
            this.userName = userName;
            this.password = password;
            this.serverPort = serverPort;
            this.managerPort = managerPort;
            this.schemaName = schemaName;
        }

        public String getIp() {
            return ip;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public int getServerPort() {
            return serverPort;
        }

        public int getManagerPort() {
            return managerPort;
        }

        public String getSchemaName() {
            return schemaName;
        }
        
    }

    /**
     * 
     *测试用例配置
     *
     */
   public static class TestCaseConfig {
        List<String> configPath;

        public TestCaseConfig() {
            configPath = new ArrayList<>();
        }

        public void addConfigPath(String path) {
            configPath.add(path);
        }

        public List<String> getConfigPath() {
            return configPath;
        }
    }
}

