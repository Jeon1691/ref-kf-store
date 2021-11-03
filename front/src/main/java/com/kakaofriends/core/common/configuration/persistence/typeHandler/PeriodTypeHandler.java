package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.common.configuration.persistence.type.PeriodType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(PeriodType.class)
public class PeriodTypeHandler extends BaseTypeHandler<PeriodType> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PeriodType parameter, JdbcType jdbcType) throws SQLException {

	}

	@Override
	public PeriodType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public PeriodType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public PeriodType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
