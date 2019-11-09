package com.iot.raspi_client.MQService;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 控制树莓派上的GPIO实例
 * @author 亓根火柴
 */
@Service
public class ReceMQService {
    public void open(){
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.LOW);
        //设置高电平
        pin.high();
        System.out.println("打开继电器");
        pin.toggle();
        gpio.shutdown();
        gpio.unprovisionPin(pin);
    }
    public void close(){
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.HIGH);
        //设置高电平
        pin.low();
        System.out.println("关闭继电器");
        pin.toggle();
        gpio.shutdown();
        gpio.unprovisionPin(pin);
    }
    @RabbitListener(queues = "${queue.name}")
    public void LED_switch(String b){
        System.out.println("有消息进入");
        if (b.equals("false"))
            close();
        else
            open();
    }
}

