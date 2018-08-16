package com.swh.ami.highVersion.socket.server;


import com.swh.ami.highVersion.socket.client.ILearnService;

public class LearnServiceImpl implements ILearnService {


    @Override
    public String learn(String name) {
        return "我要学习," + name;
    }
}

