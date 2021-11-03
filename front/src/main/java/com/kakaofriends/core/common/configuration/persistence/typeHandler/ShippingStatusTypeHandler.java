package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@MappedTypes(ShippingStatusType.class)
public class ShippingStatusTypeHandler extends BaseTypeHandler<ShippingStatusType> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, ShippingStatusType parameter, JdbcType jdbcType) throws SQLException {

	}

	@Override
	public ShippingStatusType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		Integer code = rs.getInt(columnName);
		return Lists.newArrayList(ShippingStatusType.values()).stream().filter(e -> e.getCode().equals(code)).findFirst().get();
	}

	@Override
	public ShippingStatusType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public ShippingStatusType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}

	public ShippingStatusType findShippingStatusTypeByCode(int maxOsStatusCode) {
		return Lists.newArrayList(ShippingStatusType.values()).stream().filter(e -> e.getOrderStatusTypeCodes().contains(maxOsStatusCode)).findFirst().get();
	}

	public OrderStatusType[] getCancelListViewConditionArr() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_CANCEL_APPLICATION,
				OrderStatusType.PARTIAL_RETURN_APPLICATION,
				OrderStatusType.PARTIAL_EXCHANGE_APPLICATION,
				OrderStatusType.CANCEL_APPLICATION,
				OrderStatusType.RETURN_APPLICATION,
				OrderStatusType.EXCHANGE_APPLICATION,
				OrderStatusType.PARTIAL_CANCEL_COMPLETED,
				OrderStatusType.PARTIAL_RETURN_COMPLETED,
				OrderStatusType.PARTIAL_EXCHANGE_COMPLETED,
				OrderStatusType.CANCEL_COMPLETED,
				OrderStatusType.RETURN_COMPLETED,
				OrderStatusType.EXCHANGE_COMPLETED};
	}

	public OrderStatusType[] getCancel() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_CANCEL_APPLICATION,
				OrderStatusType.CANCEL_APPLICATION,
		};
	}

	public OrderStatusType[] getReturn() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_RETURN_APPLICATION,
				OrderStatusType.RETURN_APPLICATION,
		};
	}

	public OrderStatusType[] getExchange() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_EXCHANGE_APPLICATION,
				OrderStatusType.EXCHANGE_APPLICATION,
		};
	}

	public OrderStatusType[] getCancelComplete() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_CANCEL_COMPLETED,
				OrderStatusType.CANCEL_COMPLETED,
		};
	}

	public OrderStatusType[] getReturnComplete() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_RETURN_COMPLETED,
				OrderStatusType.RETURN_COMPLETED,
		};
	}

	public OrderStatusType[] getExchangeComplete() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_EXCHANGE_COMPLETED,
				OrderStatusType.EXCHANGE_COMPLETED
		};
	}

	public Map<String, OrderStatusType[]> getCancelListViewConditionMap() {
		Map<String, OrderStatusType[]> cancelListViewConditionMap = new HashMap<>();
		cancelListViewConditionMap.put("cancelListViewConditionArr", getCancelListViewConditionArr());
		cancelListViewConditionMap.put("cancelApplicationConditionArr", getCancel());
		cancelListViewConditionMap.put("returnApplicationConditionArr", getReturn());
		cancelListViewConditionMap.put("exchangeApplicationConditionArr", getExchange());
		cancelListViewConditionMap.put("cancelCompleteConditionArr", getCancelComplete());
		cancelListViewConditionMap.put("returnCompleteConditionArr", getReturnComplete());
		cancelListViewConditionMap.put("exchangeCompleteConditionArr", getExchangeComplete());

		return cancelListViewConditionMap;
	}
	//마이페이지 상단 배송중 조회 조건 2017.11.26
	public OrderStatusType[] getShippingCount() {
		return new OrderStatusType[]{
				OrderStatusType.RECEIVING_ORDER,
				OrderStatusType.SHIPPING_PREPARATION,
				OrderStatusType.INPUT_INVOICES,
				OrderStatusType.IN_SHIPPING,};
	}

	//마이페이지 상단 취소 및 교환 조회 조건 2017.10.23
	public OrderStatusType[] getCancelingCount() {
		return new OrderStatusType[]{
				OrderStatusType.PARTIAL_CANCEL_APPLICATION,
				OrderStatusType.PARTIAL_RETURN_APPLICATION,
				OrderStatusType.PARTIAL_EXCHANGE_APPLICATION,
				OrderStatusType.CANCEL_APPLICATION,
				OrderStatusType.RETURN_APPLICATION,
				OrderStatusType.EXCHANGE_APPLICATION};
	}
}
