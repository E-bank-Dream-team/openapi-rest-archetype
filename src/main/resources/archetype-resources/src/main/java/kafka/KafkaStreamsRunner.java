package ${package}.kafka;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.Topology;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamsRunner {
	
	private final KafkaTopologyFactory topologyFactory;
	
	public KafkaStreamsRunner(KafkaTopologyFactory topologyFactory) {
		this.topologyFactory = topologyFactory;
	}
	
	public void run() {
		Topology topology = topologyFactory.getTransactionsTopology();
		Properties config = topologyFactory.getConfig();
		KafkaStreams ks = new KafkaStreams(topology, config);
		ks.start();
	}
	
}