# OrderPizzaProject

a Flink demo shows datastream of Order Pizza.

## Steps for running.

1. build .jar package.

```
mvn clean package
```

2. Download flink (https://nightlies.apache.org/flink/flink-docs-release-1.13/docs/try-flink/local_installation/)


3. Go to the above flink directory. 

```
./bin/start-cluster.sh
```

4. Running flink .jar
```
./bin/flink run target/original-orderpizza-flink-1.0-SNAPSHOT.jar
```

5. Check the output
```
tail log/flink-quangtn-*.out
```

6. Stop cluster
```
./bin/stop-cluster.sh
```
