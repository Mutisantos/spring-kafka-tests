package io.spring.dataflow.sample.usagecostloggerkafka;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import io.spring.dataflow.sample.usagecostloggerkafka.model.UsageCostDetail;

@ExtendWith(OutputCaptureExtension.class)
class UsageCostLoggerKafkaApplicationTests {


  private static final MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);

  @Test
  void contextLoads() {}

  @Test
  public void processCostDetailsTest(final CapturedOutput output) {
    try (ConfigurableApplicationContext context =
        new SpringApplicationBuilder(TestChannelBinderConfiguration
            .getCompleteConfiguration(UsageCostLoggerKafkaApplication.class))
                .web(WebApplicationType.NONE).run()) {

      final InputDestination source = context.getBean(InputDestination.class);

      final UsageCostDetail usageDetail = new UsageCostDetail();
      usageDetail.setUserId("user1");
      usageDetail.setDataCost(BigDecimal.valueOf(30.00).multiply(BigDecimal.ONE, mathContext));
      usageDetail.setCallCost(BigDecimal.valueOf(100.00).multiply(BigDecimal.ONE, mathContext));

      final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
      final Map<String, Object> headers = new HashMap<>();
      headers.put("contentType", "application/json");
      final MessageHeaders messageHeaders = new MessageHeaders(headers);
      final Message<?> message = converter.toMessage(usageDetail, messageHeaders);

      source.send(message);
      Awaitility.await().until(output::getOut,
          value -> value.contains("userId=user1, callCost=1.0E+2, dataCost=30"));
      System.out.println(output.getOut());

    }
  }
}
