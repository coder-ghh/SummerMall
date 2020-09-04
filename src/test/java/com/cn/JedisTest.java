package com.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    private Jedis jedis;

    @Before     //表示@Test执行之间@Before会先执行
    public void init(){
        jedis = new Jedis();
    }

    @After      //单元测试完成之后执行
    public void destory(){
        jedis.close();
    }


    @Test
    public void testSortedSet(){
       jedis.zadd("mysortedset",5,"法师");
        jedis.zadd("mysortedset",10,"猎人");
        jedis.zadd("mysortedset",6,"圣骑");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        for (String s : mysortedset) {
            System.out.print(s+"\t");
        }

//        Set<Tuple> mysortedset = jedis.zrangeWithScores("mysortedset", 0, -1);
//        for (Tuple tuple : mysortedset) {
//            System.out.println(tuple.getScore()+"\t"+tuple.getElement());
//        }

    }





    @Test
    public void testSet(){
        jedis.sadd("myset","dog","cat","dog","mouse","dog","tiger");
        jedis.sadd("myset","aa");

        Set<String> myset = jedis.smembers("myset");
        for (String s : myset) {
            System.out.print(s+"\t");
        }
        
    }





    @Test
    public void testList(){
        Jedis jedis = new Jedis();


        jedis.lpush("list1","a","b","c");
        String value1 = jedis.rpop("list1");
        System.out.println(value1);
        String value2 = jedis.rpop("list1");
        System.out.println(value2);
        String value3 = jedis.rpop("list1");
        System.out.println(value3);


/*        jedis.lpush("mylist","a","b","c");
        jedis.lpush("mylist","z");



        List<String> mylist = jedis.lrange("mylist", 0, -1);
        for (String s : mylist) {
            System.out.print(s+"\t");
        }*/
        
        jedis.close();
    }




    @Test
    public void testHash(){
        Jedis jedis = new Jedis("localhost",6379);

        //向hash里面存储数据
        jedis.hset("myhash","name","dabao");
        jedis.hset("myhash","age","20");

        //获取name对应的值
        String name = jedis.hget("myhash", "name");
        System.out.println(name);

        //获取所有的值
        Map<String, String> map = jedis.hgetAll("myhash");
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+"===>"+map.get(key));
        }

        //删除name和对应的值
        jedis.hdel("myhash","name");

        jedis.close();
    }



    @Test
    public void testString(){
        //创建程序和redis的连接,默认地址为本机，端口号为6379
        Jedis jedis = new Jedis("localhost",6379);

        //添加字符串数据类型
        //jedis.set("mystring","dabao");

        //获取字符串
        //String mystring = jedis.get("mystring");

        //添加字符串并指定过期时间
        //jedis.setex("mystring",20,"dabao");


        jedis.set("mystring","xiaobao"); //保存字符串类型的数据
        jedis.expire("mystring",20);  //设置过期时间


        jedis.close();

    }
}
