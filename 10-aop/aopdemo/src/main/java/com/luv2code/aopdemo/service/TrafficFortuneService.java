package com.luv2code.aopdemo.service;

public interface TrafficFortuneService {
    String getFortune() throws InterruptedException;

    String getFortune (boolean tripWired);
}
