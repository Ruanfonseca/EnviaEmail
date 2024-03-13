package com.consumer.rabbitmq.listeners;

import com.consumer.rabbitmq.abstracts.Consumer;
import com.consumer.rabbitmq.templates.TemplateMSG;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumerWifi extends Consumer {

    @Autowired
    private final JavaMailSender javaMailSender;

    public RabbitConsumerWifi(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @RabbitListener(queues = "WIFI")
    public void consumeMessage(TemplateMSG msg)
    {
        System.out.println("Mensagem recebida! ");
        sendtoMail(msg);

    }

    public void sendtoMail(TemplateMSG msg){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("rookpawnletter@outlook.com");
            message.setTo(msg.getEMAIL());
            message.setSubject("Equipe de Apoio UERJ/ZO");
            message.setText(msg.getMSG());
            javaMailSender.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao enviar o e-mail: ");
            e.printStackTrace();

        }
    }
}
