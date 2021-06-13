package com.HuangHanxiao.dao;

import com.HuangHanxiao.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dbRequire="update usertable set username='"+user.getUsername()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',sex='"+user.getSex()+"',birthdate='"+simpleDateFormat.format(user.getBirthdate())+"' where id="+user.getId();
            createDbStatement.executeUpdate(dbRequire);
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("update "+user.getId()+"success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="select * from usertable where id="+id.toString();
            ResultSet resultDb=createDbStatement.executeQuery(dbRequire);
            while(resultDb.next()) {
                return new User(resultDb.getInt("id"),resultDb.getString("username"),resultDb.getString("password"),resultDb.getString("email"),resultDb.getString("sex"),resultDb.getDate("birthdate"));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return  user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
