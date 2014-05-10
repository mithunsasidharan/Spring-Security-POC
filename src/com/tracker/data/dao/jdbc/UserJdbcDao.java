package com.tracker.data.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.GrantedAuthority;

import com.tracker.business.model.User;
import com.tracker.business.model.UserGrantedAuthority;
import com.tracker.data.dao.UserDao;

public class UserJdbcDao extends JdbcDaoSupport implements UserDao {

	public User loadUser(String username) {
		Object[] params = new Object[] { new String(username) };
		User user = null;
		String sql = "select " +
				"  user_id, " + 
				"  role_id, " + 
				"  status, " + 
				"  first_name, " + 
				"  last_name, " + 
				"	email, " +
				"	password," +
				"  username, " +
				"  project_id " + 
				"from " +
				"	users " +
				"where " +
				"	username = ? and " +
				"  role_id in (1,2,3)";
		try {
			user = (User) getJdbcTemplate().queryForObject(sql, params, new UserMapper());
			System.out.println("User Name: "+user.getUsername());
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
		List privs = this.loadUserPriviledges(username);

		user.setAuthorities(privs);
		UserGrantedAuthority userGrantedAuthority = (UserGrantedAuthority) user.getAuthorities().get(0);
		System.out.println("First Privilege : "+userGrantedAuthority.getAuthority().toString());

		return user;
	}

	protected List loadUserPriviledges(String username) {
		Object[] params = new Object[] { new String(username) };
		List privs = new ArrayList();

		String sql = "select " +
				"	user_priv_desc " +
				"from " +
				"	users bu, " +
				"	user_role ur, " +
				" 	user_role_privs urp, " +
				"	user_privs up " +
				"where bu.role_id = ur.user_role_id and " +
				"	ur.user_role_id = urp.user_role_id and " +
				"	urp.user_priv_id = up.user_priv_id and " +
				"	bu.username = ?";

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);		
		Iterator resultList = getJdbcTemplate().queryForList(sql, params).iterator();

		Map rMap = null;
		while(resultList.hasNext()) {
			rMap = (Map)resultList.next();
			GrantedAuthority auth = new UserGrantedAuthority((String)rMap.get("user_priv_desc"));
			authList.add(auth);			
		}

		return authList;
	}


	public class UserMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(new Long(rs.getLong("user_id")));
			user.setStatus(rs.getString("status").charAt(0));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRoleId(rs.getInt("role_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setProjectId(rs.getLong("project_id"));
			return user;
		}
	}

}
