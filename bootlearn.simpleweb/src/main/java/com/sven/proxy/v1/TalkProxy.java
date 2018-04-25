package com.sven.proxy.v1;

/**
 * Created by sven on 2017/5/17.
 * 代理主题角色,内部包含对真实主题的应用,并且提供和真实主题角色相同的接口.
 */
public class TalkProxy implements ITalk {
    private ITalk iTalk;

    public TalkProxy(ITalk iTalk) {
        this.iTalk = iTalk;
    }

    @Override
    public void talk(String msg) {
        iTalk.talk(msg);
    }

    @Override
    public void eat() {
        iTalk.eat();
    }

    public void talk(String msg, String singname) {
        iTalk.talk(msg);
        sing(singname);
    }

    public void sing(String singname) {
        System.out.println(String.format("唱歌:%s", singname));
    }
}
