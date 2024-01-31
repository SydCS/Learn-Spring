import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.BlogMapper;
import org.example.domain.Blog;
import org.example.utils.State;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelect() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlogWithDetails(1);
            System.out.println(blog);
        }
    }

    @Test
    public void testSelectLazyLoading() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlog(1);
            System.out.println(blog.getTitle());
            System.out.println("--------------------------------------");
            System.out.println(blog.getAuthor());
            System.out.println(blog.getPosts());
        }
    }

    @Test
    public void testSelectDiscriminator() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlogWithDetails(1);
            System.out.println(blog.getPosts().get(0).getClass().getName());
            System.out.println(blog.getPosts().get(1).getClass().getName());
        }
    }

    @Test
    public void testSelectTypeHandler() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            System.out.println(blogMapper.selectBlogWithDetails(1).getState());
            System.out.println(blogMapper.selectBlogWithDetails(2).getState());
        }
    }

    @Test
    public void testEnum() {
        State state = State.fromValue(0);
        System.out.println(state);
    }
}
