package model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import db.DB;

import db.DbException;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller seller) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("insert into seller "
					+ "(Name,Email,BirthDate,BaseSalary,DepartmentId) "
					+ "values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					
			
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getEmail());
			ps.setDate(3,new java.sql.Date(seller.getBirthDate().getTime()));
			ps.setDouble(4, seller.getBaseSalary());
			ps.setInt(5, seller.getDepartment().getId());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected>0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					seller.setId(id);
				}
			}
			else {
				throw new DbException("Erro inesperado , nenhuma coluna afetada");
			}
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public void update(Seller seller) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("select seller.*,department.Name as DepName "
					+ "from seller inner join department "
					+ "ON seller.DepartmentId = department.Id\n"
					+ "WHERE seller.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Department department = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs,department);
				
				return seller;
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return null;
	}
	
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Seller> listSeller = new ArrayList<Seller>();
		Map<Integer,Department> map = new HashMap<Integer,Department>();
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			ps.setInt(1, department.getId());
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);
				listSeller.add(seller);
			
			}
			return listSeller;
			
			
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
	public List<Seller> findAll() {
		PreparedStatement ps= null;
		ResultSet rs = null;
		List<Seller> listSeller = new ArrayList<Seller>();
		Map<Integer,Department> map = new HashMap<Integer, Department>();
		
		
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("select seller.*,department.Name as depName "
					+"from seller inner join department "
					+"on seller.DepartmentId = department.Id "
					+"order by Name");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Department department = map.get(rs.getInt("DepartmentId"));
				
				if(department == null) {
					department = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), department);
				}
				
				Seller seller = instantiateSeller(rs, department);
				listSeller.add(seller);
				
				
			}
			return listSeller;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		
	}


	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(department);
		
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		
		return department;
	}

	

	
}
