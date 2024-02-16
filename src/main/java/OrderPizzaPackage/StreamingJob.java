package OrderPizzaPackage;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamingJob {

    public static void main(String[] args) throws Exception {

        // set up the streaming execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<PizzaOrder> orders = env.addSource(new PizzaOrderGenerator());
        DataStream<PizzaOrder> filteredOrders = orders
                // keep only those rides and both start and end in NYC
                .filter(new ShippedFilter());

        System.out.println("************************************************");
        filteredOrders.print();

        // execute program
        env.execute("Flink streaming Java API skeleton");
    }

    public static class ShippedFilter implements FilterFunction<PizzaOrder> {

        @Override
        public boolean filter(PizzaOrder Order) { return  Order.status.equals("Shipped"); }
    }
}
