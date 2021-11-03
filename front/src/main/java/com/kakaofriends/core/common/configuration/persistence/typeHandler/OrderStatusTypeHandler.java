package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(OrderStatusType.class)
public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatusType> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, OrderStatusType parameter, JdbcType jdbcType) throws SQLException {
		Integer code = null;
		if (parameter != null) {
			code = parameter.getCode();
		}
		if (jdbcType != null) {
			preparedStatement.setObject(i, code, jdbcType.TYPE_CODE);
		} else {
			preparedStatement.setString(i, String.valueOf(code));
		}
	}

	@Override
	public OrderStatusType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		Integer code = rs.getInt(columnName);
		return Lists.newArrayList(OrderStatusType.values()).stream().filter(e -> e.getCode().equals(code)).findFirst().get();
	}

	@Override
	public OrderStatusType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public OrderStatusType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
