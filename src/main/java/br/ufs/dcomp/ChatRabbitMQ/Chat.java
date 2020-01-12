package br.ufs.dcomp.ChatRabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;

import java.util.Scanner;

public class Chat {

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    Scanner ler = new Scanner(System.in);
    
    String host = "";
    String user = "";
    String pass = "";
    
    System.out.println("================= | BEM-VINDO AO CHAT-NET | =================");
    System.out.println("HOST:");
    host = ler.nextLine();
    System.out.println("USERNAME:");
    user = ler.nextLine();
    System.out.println("PASSWORD:");
    pass = ler.nextLine();

    
    factory.setHost(host); // Alterar
    factory.setUsername(user); // Alterar
    factory.setPassword(pass); // Alterar
    
    
    // factory.setHost("52.90.219.23"); // Alterar
    // factory.setUsername("admin"); // Alterar
    // factory.setPassword("admin"); // Alterar
    factory.setVirtualHost("/");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    
    String QUEUE_NAME = "queue";
                      //(queue-name, durable, exclusive, auto-delete, params); 
    //channel.queueDeclare(QUEUE_NAME, false,   false,     false,       null);
    
    // Consumer consumer = new DefaultConsumer(channel) {
    //   public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)           throws IOException {

    //     String message = new String(body, "UTF-8");
    //     System.out.println(message);

    //   }
    // };
    //                   //(queue-name, autoAck, consumer);    
    // channel.basicConsume(QUEUE_NAME, true,    consumer);
    
    
    
    
    
    
    //AQUI
    
    // channel.queueDeclare(QUEUE_NAME, false,   false,     false,       null);
    
    // String message = "";
    
    // while(true){
    //   System.out.print("@"+user+":");
    //   message = ler.nextLine();
      
    //   channel.basicPublish("",       QUEUE_NAME, null,  message.getBytes("UTF-8"));
    // }
    
    
    
    
    
    channel.queueDeclare(QUEUE_NAME, false,   false,     false,       null);
    System.out.println(" [*] Esperando recebimento de mensagens...");

    Consumer consumer = new DefaultConsumer(channel) {
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)           throws IOException {
        String message1 = new String(body, "UTF-8");
        System.out.println("@alguem: '" + message1 + "'");

                        //(deliveryTag,               multiple);
        //channel.basicAck(envelope.getDeliveryTag(), false);
      }
    };
                      //(queue-name, autoAck, consumer);    
    channel.basicConsume(QUEUE_NAME, true,    consumer);
    
    
    channel.queueDeclare(QUEUE_NAME, false,   false,     false,       null);
    
    String message = "";
    
    while(true){
      System.out.print("@"+user+":");
      message = ler.nextLine();
      
      channel.basicPublish("",       QUEUE_NAME, null,  message.getBytes("UTF-8"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                    //  (exchange, routingKey, props, message-body             ); 
    //channel.basicPublish("",       QUEUE_NAME, null,  message.getBytes("UTF-8"));
    //System.out.println(" [x] Mensagem enviada: '" + message + "'");
    
    
    // ConnectionFactory factory1 = new ConnectionFactory();
    // factory1.setHost("54.87.18.50"); // Alterar
    // factory1.setUsername("jmsal"); // Alterar
    // factory1.setPassword("2105"); // Alterar
    // factory1.setVirtualHost("/");
    // Connection connection1 = factory1.newConnection();
    // Channel channel1 = connection1.createChannel();
    
    
    // System.out.println(" [*] Esperando recebimento de mensagens...");

    // Consumer consumer = new DefaultConsumer(channel) {
    //   public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)           throws IOException {

    //     String message1 = new String(body, "UTF-8");
    //     System.out.println(" [x] Mensagem recebida: '" + message1 + "'");

    //                     //(deliveryTag,               multiple);
    //     //channel.basicAck(envelope.getDeliveryTag(), false);
    //   }
    // };
    //                   //(queue-name, autoAck, consumer);    
    // channel.basicConsume(QUEUE_NAME, true,    consumer);
    
    

    
  }
}