package org.example.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateTypeHandler extends BaseTypeHandler<State> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, State parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public State getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return State.fromValue(rs.getInt(columnName));
    }

    @Override
    public State getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return State.fromValue(rs.getInt(columnIndex));
    }

    @Override
    public State getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return State.fromValue(cs.getInt(columnIndex));
    }
}
