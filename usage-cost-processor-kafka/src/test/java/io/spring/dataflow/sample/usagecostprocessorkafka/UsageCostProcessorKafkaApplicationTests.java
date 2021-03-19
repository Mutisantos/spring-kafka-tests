package io.spring.dataflow.sample.usagecostprocessorkafka;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import io.spring.dataflow.sample.usagecostprocessorkafka.model.UsageCostDetail;
import io.spring.dataflow.sample.usagecostprocessorkafka.model.UsageDetail;

@SpringBootTest
class UsageCostProcessorKafkaApplicationTests {

  @Test
  public void contextLoads() {}

  @Test
  public void testUsageCostProcessor() {
    try (ConfigurableApplicationContext context =
        new SpringApplicationBuilder(TestChannelBinderConfiguration
            .getCompleteConfiguration(UsageCostProcessorKafkaApplication.class))
                .web(WebApplicationType.NONE).run()) {

      final InputDestination source = context.getBean(InputDestination.class);

      final UsageDetail usageDetail = new UsageDetail();
      usageDetail.setUserId("user1");
      usageDetail.setDuration(BigDecimal.valueOf(30L));
      usageDetail.setData(BigDecimal.valueOf(100L));

      final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
      final Map<String, Object> headers = new HashMap<>();
      headers.put("contentType", "application/json");
      final MessageHeaders messageHeaders = new MessageHeaders(headers);
      final Message<?> message = converter.toMessage(usageDetail, messageHeaders);

      source.send(message);

      final OutputDestination target = context.getBean(OutputDestination.class);
      final Message<byte[]> sourceMessage = target.receive(10000);

      final UsageCostDetail usageCostDetail =
          (UsageCostDetail) converter.fromMessage(sourceMessage, UsageCostDetail.class);

      then(usageCostDetail.getCallCost()).isEqualTo(BigDecimal.valueOf(3.00));
      then(usageCostDetail.getDataCost()).isEqualTo(BigDecimal.valueOf(5.00));
    }
  }

}
