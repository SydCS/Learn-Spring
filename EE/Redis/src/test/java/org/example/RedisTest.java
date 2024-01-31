package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApp.class)
public class RedisTest {
    static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void setGet() {
        // set
        redisTemplate.opsForValue().set("title", "Spring 中文网", Duration.ofMinutes(5));

        // get
        String val = redisTemplate.opsForValue().get("title");

        logger.info("value={}", val);
    }

    // 注入 JsonRedisTemplate
    @Autowired
    JsonRedisTemplate jsonRedisTemplate;

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        // Map
        Map<String, Object> map = new HashMap<>();
        map.put("title", "spring 中文网");
        map.put("url", "https://springdoc.cn");
        map.put("createAt", LocalDateTime.now());

        // 设置 key/value
        this.jsonRedisTemplate.opsForValue().set("key1-string", map, Duration.ofMinutes(5));
        // 读取 key/value
        map = (Map<String, Object>) this.jsonRedisTemplate.opsForValue().get("key1-string");
        logger.info("map={}", map);

        // 设置 Hash Value
        this.jsonRedisTemplate.opsForHash().put("key2-hash", "app", map);
        // 读取 Hash Value
        map = (Map<String, Object>) this.jsonRedisTemplate.opsForHash().get("key2-hash", "app");

        logger.info("map={}", map);
    }
}
