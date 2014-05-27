package com.github.jwickard.cloudbitspringboot.config
import com.github.jwickard.cloudbitspringboot.messaging.ProfileReceiver
import com.github.jwickard.cloudbitspringboot.messaging.ProfileReceiverImpl
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
/**
 * <p>RabbitConfig</p>
 * <p>
 *  <description/>
 * </p>
 * @author Joel Wickard (Object Partners Inc.)
 */
@Configuration
class RabbitConfig {
    final static String queueName = 'fit-bit-profile-synch'

    @Autowired
    Environment env

    @Autowired
    RabbitTemplate rabbitTemplate

    @Bean
    Queue queue(){
        return new Queue(queueName, false)
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange('fit-bit-profile-synch-exchange')
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(queueName)
    }

    @Bean
    ConnectionFactory connectionFactory(){
        //environmental: amqp://<user>:<password>@<host>/<vhost>
        String amqpurl = env.getProperty('CLOUDAMQP_URL').substring(7)

        String user = amqpurl.substring(0, amqpurl.indexOf(':'))
        String password = amqpurl.substring(amqpurl.indexOf(':')+1, amqpurl.indexOf('@'))
        String host = amqpurl.substring(amqpurl.indexOf('@')+1, amqpurl.lastIndexOf('/'))
        String vhost = amqpurl.substring(amqpurl.lastIndexOf('/')+1)

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host)
        connectionFactory.setUsername(user)
        connectionFactory.setPassword(password)
        connectionFactory.setVirtualHost(vhost)

        return connectionFactory
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer()
        container.setConnectionFactory(connectionFactory)
        container.setQueueNames(queueName)
        container.setMessageListener(listenerAdapter)
        return container
    }

    @Bean
    ProfileReceiver receiver(){
        return new ProfileReceiverImpl()
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(ProfileReceiver receiver){
        return new MessageListenerAdapter(receiver, 'receiveMessage')
    }
}
