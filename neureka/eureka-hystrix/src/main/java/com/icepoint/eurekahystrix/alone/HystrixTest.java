package com.icepoint.eurekahystrix.alone;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixTest extends HystrixCommand {

    private String name;

    public HystrixTest(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("GroupKey"));
        this.name = name;
    }

    @Override
    protected Object run() throws Exception {
        int i = 1 / 0; //这里如果打开，就会报异常，就会走降级方法。
        return "正常执行" + name;
    }

    @Override
    protected Object getFallback() {
        return "熔断执行" + name;
    }

}
