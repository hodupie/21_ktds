package com.ktdsuniversity.edu.mv.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAutoDaoPoolSupport<T> extends AbstractDaoPoolSupport<T> {

	public List<T> selectByKey(String query, ParamMapper pm, Class<? extends Object> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			if (pm != null) {
				pm.map(pstmt);
			}
			rs = pstmt.executeQuery();
			List<T> t = new ArrayList<>();
			while (rs.next()) {
				AutoMapper.makeAllRowDatas(rs, t, cls);
			}
			return (List<T>) t;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeAll(connection, pstmt, rs);
		}
		
		return null;
	}

	public List<T> select(String query, ParamMapper pm, Class<? extends Object> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			if (pm != null) {
				pm.map(pstmt);
			}
			rs = pstmt.executeQuery();
			List<T> t = new ArrayList<>();
			
			while (rs.next()) {
				AutoMapper.makeAllRowDatas(rs, t, cls);
			}
			return t;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeAll(connection, pstmt, rs);
		}
		
		return null;
	}
	
	public T selectOneByKey(String query, ParamMapper pm, Class<? extends Object> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			if (pm != null) {
				pm.map(pstmt);
			}
			rs = pstmt.executeQuery();
			T result = null;
			
			while (rs.next()) {
				result = (T) AutoMapper.makeAllRowDatas(rs, result, cls);
			}
			return result;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeAll(connection, pstmt, rs);
		}
		
		return null;
	}
	
	public T selectOne(String query, ParamMapper pm, Class<? extends Object> cls) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			if (pm != null) {
				pm.map(pstmt);
			}
			rs = pstmt.executeQuery();
			T t = null;
			if (rs.next()) {
				t = (T) AutoMapper.makeOneRowDatas(rs, t, cls);
			}
			return (T) t;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			closeAll(connection, pstmt, rs);
		}
		
		return null;
	}
	
	
}
