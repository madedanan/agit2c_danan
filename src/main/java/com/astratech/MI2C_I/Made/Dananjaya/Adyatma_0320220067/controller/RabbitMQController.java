package com.astratech.MI2C_I.Made.Dananjaya.Adyatma_0320220067.controller;

import com.astratech.MI2C_I.Made.Dananjaya.Adyatma_0320220067.response.DtoResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String routingKey = "dananQueue";
    private static final String routingKey2 = "RizkyQueue";

    private static final String exchange = "polmanExternalExchange";

    @RequestMapping(value = "/publishMessage", method = RequestMethod.POST)
    public DtoResponse publishMessage(@RequestBody String pesan){
        rabbitTemplate.convertAndSend(exchange, routingKey, pesan);
        return new DtoResponse(200, "Pesan yang anda kirim ke RabbitMQ : " + pesan,"Suskes");
    }

    @RabbitListener(queues = routingKey)
    public void processMessage(String message) {
        System.out.println("Pesan dari RabbitMQ : " + message);
    }

    @RabbitListener(queues = routingKey2)
    public void processMessage2(String message) {
        System.out.println("Pesan dari RabbitMQ : " + routingKey2 +" : " + message);
    }

}
