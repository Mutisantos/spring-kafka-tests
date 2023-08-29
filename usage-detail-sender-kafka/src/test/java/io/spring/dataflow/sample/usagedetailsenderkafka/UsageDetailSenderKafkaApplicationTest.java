package io.spring.dataflow.sample.usagedetailsenderkafka;

import io.spring.dataflow.sample.usagedetailsenderkafka.model.UsageDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
public class UsageDetailSenderKafkaApplicationTest {

  @Test
  public void contextLoads() {}

  @Test
  public void testUsageDetailSender() {
    try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
        TestChannelBinderConfiguration.getCompleteConfiguration(UsageDetailSenderKafkaApplication.class))
            .web(WebApplicationType.NONE).run()) {

      final OutputDestination target = context.getBean(OutputDestination.class);
      final Message<byte[]> sourceMessage = target.receive(10000);

      final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
      final UsageDetail usageDetail =
          (UsageDetail) converter.fromMessage(sourceMessage, UsageDetail.class);

      then(usageDetail.getUserId()).isBetween("user1", "user5");
      then(usageDetail.getData()).isBetween(BigDecimal.valueOf(0), BigDecimal.valueOf(700));
      then(usageDetail.getDuration()).isBetween(BigDecimal.valueOf(0), BigDecimal.valueOf(300));
    }
  }
}
