package com.demo.dao;

import com.demo.entity.Users;
import com.demo.utils.SqlsessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UsersDao {
    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;

    public SqlSession getSqlSession() {
        sqlSession = SqlsessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    public List<Users> findAll() {
        try {
            list = getSqlSession().selectList("findUsers");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public Users findById(Integer id) {
        try {
            user = getSqlSession().selectOne("findUsers", new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }
    public Users addUsers(Users users) {
        try {
            getSqlSession().insert("addUsers", users);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return users;
    };
    public Users updateUser(Users users) {
        try {
            getSqlSession().update("updateUser", users);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return users;
    }
    public void deleteUser(Integer id) {
        try {
            getSqlSession().delete("deleteUser", id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    };
}


