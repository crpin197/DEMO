package com.example.demo;

public class device_and_state {
    private state_device state_bedroom;
    private name_device device_bedroom;
    private String text_state_device_bedroom;

    device_and_state ()
    {
        state_bedroom = state_device.RELAY_NOPULL;
        device_bedroom = name_device.NO_NAME;
    }

    public state_device setState_bedroom(state_device state_bedroom)
    {
        this.state_bedroom = state_bedroom;
        return state_bedroom;
    }

    public state_device getState_bedroom ()
    {
        return state_bedroom;
    }

    public name_device setName_bedroom(name_device device_bedroom)
    {
        this.device_bedroom = device_bedroom;
        return this.device_bedroom;
    }

    public name_device getName_bedroom ()
    {
        return device_bedroom;
    }

    public String setText_state_device_bedroom(String text_state_device_bedroom)
    {
        this.text_state_device_bedroom = text_state_device_bedroom;
        return text_state_device_bedroom;
    }
    public String getText_state_device_bedroom()
    {
        return text_state_device_bedroom;
    }
}
