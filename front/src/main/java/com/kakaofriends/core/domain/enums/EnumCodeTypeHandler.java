package com.kakaofriends.core.domain.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EnumCodeTypeHandler<E extends Enum<E> & Code> implements TypeHandler<E> {

	protected abstract E[] values();

	protected E getValue(String code) {
		if (code == null) {
			return null;
		}
		return EnumHelper.getValue(code, values());
	}

	@Override
	public void setParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
		String code = null;
		if (e != null) {
			code = e.getCode();
		}
		if (jdbcType != null) {
			preparedStatement.setObject(i, code, jdbcType.TYPE_CODE);
		} else {
			preparedStatement.setString(i, code);
		}
	}

	@Override
	public E getResult(ResultSet resultSet, String s) throws SQLException {
		return getValue(resultSet.getString(s));
	}

	@Override
	public E getResult(ResultSet resultSet, int i) throws SQLException {
		return getValue(resultSet.getString(i));
	}

	@Override
	public E getResult(CallableStatement callableStatement, int i) throws SQLException {
		return getValue(callableStatement.getString(i));
	}
}
