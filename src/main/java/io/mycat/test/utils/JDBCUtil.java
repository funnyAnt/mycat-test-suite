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
package io.mycat.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCUtil.class);

    public static Connection getConnection(String ip, int port, String user, String password, String schema) {
        return getConnection(ip, port, user, password, schema, null);
    }

    public static Connection getConnection(String ip, int port, String user, String password, String schema,
            Map<String, String> params) {
        String driver = "com.mysql.jdbc.Driver";
        StringBuilder sbUrl = new StringBuilder("jdbc:mysql://");
        sbUrl.append(ip).append("/").append(schema).append("?");
        if (params != null) {
            for (Entry<String, String> item : params.entrySet()) {
                sbUrl.append(item.getKey()).append("=").append(item.getValue()).append("&");
            }
            // 删除多余的&
            sbUrl.deleteCharAt(sbUrl.length() - 1);
        }
        String url = sbUrl.toString();

        // 加载驱动程序
        try {
            Class.forName(driver);
            // System.out.println("驱动程序加载成功");
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.toString(), e);
        }

        // 链接数据库
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                LOGGER.error("连接数据库成功");
            }
        } catch (SQLException e) {
            LOGGER.error("连接数据库失败:{} ", e.getMessage());
        }

        return conn;
    }

}
