# [批处理(batch)](https://www.cnblogs.com/java-zmj/p/8000605.html)
## 一、批处理介绍
#### 1、 批处理指的是一次操作中执行多条SQL语句
#### 2、 批处理相比于一次一次执行效率会提高很多
#### 3、 批处理主要是分两步：
#####       3.1.将要执行的SQL语句保存
##### 　     3.2.执行SQL语句
#### 4、Statement和PreparedStatement都支持批处理操作，这里我们只需要掌握PreparedStatement的批处理方式：
1) 方法：

`void addBatch()`

   - 将要执行的SQL先保存起来，先不执行

   - 这个方法在设置完所有的占位符之后调用

    int[] executeBatch()

   - 这个方法用来执行SQL语句，这个方法会将批处理中所有SQL语句执行

2) mysql默认批处理是关闭的，所以我们还需要去打开mysql的批处理：

    ? rewriteBatchedStatements=true

我们需要将以上的参数添加到mysql的url地址中

3)  注意：低版本的mysql-jdbc驱动也不支持批处理

## 二、批处理的实现
　　在连接数据库的url后面添加? rewriteBatchedStatements=true，开启批处理

```java
    package com.chentx.tables.module04.utils.DBUtil;
    public void insertUser() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;

        String sql = "insert into t_user values(null,?)";
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < 10000; i++) {
            ps.setString(1, "user" + i);
            ps.addBatch();  //将sql语句保存起来，先不执行
        }
        long start = System.currentTimeMillis();
        ps.executeBatch();  //执行批处理中所有的sql语句
        long end = System.currentTimeMillis();
        System.out.println("It costs" + (end - start) + "milliSeconds");
}

```




测试代码：

```java
    @Test
    public void testBatch() throws Exception {
        Dao dao = new Dao();
        dao.insertUser();
    }
```
测试结果：

使用批处理只需要200多毫秒，而不开启批处理需要十几分钟，由此可见，使用批处理可以大大缩短sql语句执行时间



# [java批处理教程](https://blog.csdn.net/dnc8371/article/details/106701790)
# [Spring Batch完整入门实践](https://segmentfault.com/a/1190000016278038)
# [廖雪峰JDBC Batch](https://www.liaoxuefeng.com/wiki/1252599548343744/1322290857902113)
# [java Batch类代码示例](https://vimsky.com/examples/detail/java-class-org.apache.hadoop.hbase.client.coprocessor.Batch.html)
# [JDBC 插入数据到数据库的四种姿势](https://huaweicloud.csdn.net/63355f74d3efff3090b548e4.html?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-1-125930870-blog-79742718.pc_relevant_vip_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-1-125930870-blog-79742718.pc_relevant_vip_default&utm_relevant_index=2#devmenu8)
# [Java Code Greeks JavaBatchTutorial](https://www.javacodegeeks.com/2018/05/java-batch-tutorial.html)

