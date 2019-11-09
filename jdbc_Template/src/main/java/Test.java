import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private JdbcTemplate jdbcTemplate;
     {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
     }
    @org.junit.Test
    public void testExecute(){
        jdbcTemplate.execute("create table user1(id int)");
    }
    @org.junit.Test
    public void testUpdate() {
        String sql = "insert into student(name,sex) values (?,?)";
        jdbcTemplate.update(sql, new Object[]{"项羽", "男"});
    }
    @org.junit.Test
    public void testUpdate2(){
        String sql = "update student set name = ? where id = ? ";
        jdbcTemplate.update(sql,"haha","1");
    }
    @org.junit.Test
    public void testBatchUpdate(){
         String[] sql = {
                 "insert into student(name,sex) values ('ee','sa')",
                 "insert into student(name,sex) values ('ww','sa')",
                 "update student set sex = 'ff' where id = 2"
         };
         jdbcTemplate.batchUpdate(sql);
    }
    @org.junit.Test
    public void testBatchUpdate2(){
         String sql = "insert into course(name) values(?)";
        List<Object[]> lists = new ArrayList<Object[]>() ;
        lists.add(new Object[]{"ss"});
        lists.add(new Object[]{"kk"});
        lists.add(new Object[]{"ll"});

        jdbcTemplate.batchUpdate(sql, lists);
    }

    @org.junit.Test
    public void testQuery(){
         String sql = "seiect count(*) from student";
         int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }


}
