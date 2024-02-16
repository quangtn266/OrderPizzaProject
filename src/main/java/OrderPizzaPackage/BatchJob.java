package OrderPizzaPackage;

import org.apache.flink.api.java.ExecutionEnvironment;

public class BatchJob {

    public static void main(String[] args) throws Exception {

        // setup the btach execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // execute the program
        env.execute("Flink Btach Java API skeleton");
    }
}
