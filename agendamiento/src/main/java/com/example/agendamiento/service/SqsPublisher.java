package com.example.agendamiento.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsPublisher {
    private static final Logger logger = LoggerFactory.getLogger(SqsPublisher.class);
    private final SqsClient sqsClient;
    private final ObjectMapper objectMapper;
    @Value("${aws.sqs.queue-url}")
    private String queueUrl;
    public SqsPublisher(SqsClient sqsClient, ObjectMapper objectMapper) {
        this.sqsClient = sqsClient;
        this.objectMapper = objectMapper;
    }
    public void publicarAgendamiento(Long idAgendamiento, Long idVehiculo,
                                     Long idTecnico, String fechaAgendamiento,
                                     String descripcion) {
        try {
            var mensaje = new java.util.HashMap<String, Object>();
            mensaje.put("idAgendamiento",    idAgendamiento);
            mensaje.put("idVehiculo",        idVehiculo);
            mensaje.put("idTecnico",         idTecnico);
            mensaje.put("fechaAgendamiento", fechaAgendamiento);
            mensaje.put("descripcion",       descripcion);

            String mensajeJson = objectMapper.writeValueAsString(mensaje);
            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(mensajeJson)
                    .build();

            sqsClient.sendMessage(request);
            logger.info("Mensaje publicado en SQS para agendamiento ID={}", idAgendamiento);

        } catch (Exception e) {
            logger.error("Error al publicar en SQS: {}", e.getMessage());
        }
    }
}

