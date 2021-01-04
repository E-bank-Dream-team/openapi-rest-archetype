package ${package}.kafka;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.TestOutputTopic;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import ${package}.models.Sample;

@SpringBootTest
public class KafkaStreamProcessorTests {
	
	private final static String INPUT_TOPIC = "input-topic";
	private final static String OUTPUT_TOPIC = "output-topic";
	
	private static TopologyTestDriver testDriver;
	
	@Autowired
	private KafkaTopologyFactory topologyFactory;
	
	@Test
	public void test() {
		
		Topology topology = topologyFactory.getTransactionsTopology();
		Properties props = topologyFactory.getConfig();
		
		testDriver = new TopologyTestDriver(topology, props);
		
		TestInputTopic<String, String> inputTopic = testDriver.createInputTopic(
				INPUT_TOPIC, new StringSerializer(), new StringSerializer());
		TestOutputTopic<String, List<Sample>> outputTopic = testDriver.createOutputTopic(
				OUTPUT_TOPIC, new StringDeserializer(), new JsonDeserializer<List<Sample>>());
		assertThat(outputTopic.isEmpty(), is(true));
		
		inputTopic.pipeInput("1", "1");
		assertThat(outputTopic.isEmpty(), is(false));
		assertThat(outputTopic.readValue(), equalTo(new ArrayList<>()));
	}
	
	@AfterAll
	public static void tearDown() {
		testDriver.close();
	}
	
}