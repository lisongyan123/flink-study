package com.tanghao.flink.demo.source;

import com.tanghao.flink.demo.common.ConstantKafka;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;

/**
 * Description： TODO
 * Created By tanghao on 2020/4/8
 */
public class KafkaSource {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.8.145:9082");
        SingleOutputStreamOperator<String> stream= env.addSource(new FlinkKafkaConsumer011(ConstantKafka.TRADE_MESSAGE_TOPIC, new SimpleStringSchema(), properties));
        stream.print();

        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
