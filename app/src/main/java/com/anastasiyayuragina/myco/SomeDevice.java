package com.anastasiyayuragina.myco;

public class SomeDevice implements Device {
    private String name;

    public SomeDevice(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
