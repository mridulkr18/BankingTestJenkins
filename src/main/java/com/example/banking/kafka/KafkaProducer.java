package com.example.banking.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

	public static final String TRANSACTION_LOGIC = "transactions";
	public static final String ACCOUNT_ACTIVITY_LOGIC = "account_activity";

//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	public void publishTransactionEvent(String tranasctionDetails) {
//		kafkaTemplate.send(TRANSACTION_LOGIC, tranasctionDetails);
//	}
//
//	public void publishAccountActivityEvents(String activityDetails) {
//		kafkaTemplate.sendDefault(ACCOUNT_ACTIVITY_LOGIC, activityDetails);
//	}

}
