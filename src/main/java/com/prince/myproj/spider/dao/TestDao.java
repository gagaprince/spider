package com.prince.myproj.spider.dao;

import com.prince.myproj.spider.model.TestModel;

/**
 * Created by gagaprince on 15-12-13.
 */
public interface TestDao {
    public void save(TestModel test);
    public void update(TestModel test);
    public int getAllCount();
}
