package ${package}.kafka;

import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import ${package}.models.Sample;

@Component
public class KafkaTopologyFactory {
	
	@Value("${default.kafka.input.topic.name}")
	private String inputTopicName;
	
	@Value("${default.kafka.output.topic.name}")
	private String outputTopicName;
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapAddressName;
	
	public Topology getTransactionsTopology() {
		StreamsBuilder builder = new StreamsBuilder();
		
		Consumed<String, String> consumed = Consumed.with(Serdes.String(), Serdes.String());
		Produced<String, List<Sample>> produced = Produced.with(Serdes.String(), new JsonSerde<List<Sample>>(List.class));
		
		KStream<String, String> inputStream = builder.stream(inputTopicName, consumed);
		KStream<String, List<Sample>> outputStream = inputStream.mapValues((k, v) -> {
			return new ArrayList<Sample>();
		});
		
		outputStream.to(outputTopicName, produced);
		
		return builder.build();
	}
	
	public Properties getConfig() {
		Properties config = new Properties();
		config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddressName);
		config.put(StreamsConfig.APPLICATION_ID_CONFIG, "other-group");
		config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String()
				.getClass());
		config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonSerde.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "$package.models");
		return config;
	}
	
}