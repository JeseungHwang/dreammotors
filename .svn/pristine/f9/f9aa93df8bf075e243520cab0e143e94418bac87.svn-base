package com.dreammotors.DBAdapter;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/** 
* @FileName		: SqlMapClient.java 
* @Project		: SmartStreetContentsHub 
* @Date			: 2015. 8. 20. 
* @작성자			: 
* @변경이력		: 초기 생성
* @프로그램 설명	: Mybatis 세션 연결
*/
public class SqlMapClient {
    private static SqlSession session;
     
    public SqlMapClient() {
    	try {
            String resource = "com/dreammotors/DBAdapter/mybatisConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
             
            session = sqlMapper.openSession();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
  
    public SqlSession getSqlSession() {
        return session;
    }
}
