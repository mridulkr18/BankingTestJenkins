package com.example.banking.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	public static final String BelowCodeComment = "temp";

//	@KafkaListener(topics = "transactions", groupId = "group_id")
//	public void consumeTransactionEvents(ConsumerRecord<String, String> record) {
//		System.out.println("Received transaction event " + record.value());
//		//Process the transaction event here...
//	}
//
//	@KafkaListener(topics = "account_activity", groupId = "group_id")
//	public void consumeAccountActivityEvents(ConsumerRecord<String, String> record) {
//		System.out.println("Received Account Activity event " + record.value());
//		// Process the account activity event here...
//	}

}
