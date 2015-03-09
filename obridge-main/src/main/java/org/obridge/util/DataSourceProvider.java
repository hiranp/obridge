package org.obridge.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fkarsany
 */
public class DataSourceProvider {

    private static Map<String, ComboPooledDataSource> dataSourcePool = null;

    public static DataSource getDataSource(String jdbcURL) throws PropertyVetoException {

        if (dataSourcePool == null) {
            dataSourcePool = new HashMap<String, ComboPooledDataSource>();
        }

        if (!dataSourcePool.containsKey(jdbcURL)) {

            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("oracle.jdbc.OracleDriver"); //loads the jdbc driver            
            dataSource.setJdbcUrl(jdbcURL);

            dataSourcePool.put(jdbcURL, dataSource);
        }

        return dataSourcePool.get(jdbcURL);
    }

}
