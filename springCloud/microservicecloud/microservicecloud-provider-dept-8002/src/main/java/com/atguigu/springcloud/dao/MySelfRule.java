package com.atguigu.springcloud.dao;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * @auther hu  .
 * @create 2019/9/13
 */
public class MySelfRule implements IRule {
    @Override
    public Server choose(Object o) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
