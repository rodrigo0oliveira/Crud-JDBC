package model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBIntegrityException;
import db.DbException;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("insert into department "
					+ "(Name) values (?)",Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, department.getName());
		
			
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected>0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					department.setId(id);
					
					
				}
			}
			else {
				throw new DbException("Erro inesperado , nenhuma coluna afetada");
			}
		
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}

	}

	@Override
	public void update(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("update department "
					+ "set Name = ? "
					+ "where Id = ?");
			
			ps.setString(1, department.getName());
			ps.setInt(2,department.getId());
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("delete from department "
					+ "where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("select * from department where Id = ?");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			Department department = new Department();
			if(rs.next()) {
				department = instantiateDepartment(rs);
			}
			return department;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		} 
		
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Department> listDepartment = new ArrayList<Department>();
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("select * from department");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Department department = instantiateDepartment(rs);
				listDepartment.add(department);
			
				
			}
			return listDepartment;
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		} 
		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("Id"));
		department.setName(rs.getString("Name"));
		return department;
	}

}
