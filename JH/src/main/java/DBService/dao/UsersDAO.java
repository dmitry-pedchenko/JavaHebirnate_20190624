package DBService.dao;

import DBService.Executor.Executor;
import DBService.Executor.ResultHandler;
import DBService.dataSets.UsersDataSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UsersDataSet get(long id) throws SQLException {
        return executor.execQuery("select * from table1 where col1 =" + id,
                new ResultHandler<UsersDataSet>() {
                    @Override
                    public UsersDataSet handle(ResultSet resultSet) throws SQLException {
                        resultSet.next();
                        return new UsersDataSet(resultSet.getLong(1), resultSet.getString(2));
                    }
                }
//                result -> {
//                    result.next();
//                    return new UsersDataSet(result.getLong(1), result.getString(2));
//                }
        );
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from table1 where col2='" + name + "'",
                resultSet -> {
                    resultSet.next();
                    return resultSet.getLong(1);
                });
    }

    public void insertUser(String name, int val) throws SQLException {
        executor.execUpdate("insert into table1 (col1, col2) values (" + val + ",'" + name +  "')");
    }
}