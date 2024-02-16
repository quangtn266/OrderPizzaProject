package OrderPizzaPackage;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.time.Instant;

public class PizzaOrder implements Comparable<PizzaOrder>, Serializable {

    /*
    *  Creates a new TaxiRide with now as start and end time.
    * */

    public PizzaOrder() {
    }

    /*
    *  Invents a TaxiRide
    * */
    public PizzaOrder(long orderId) {
        DataGenerator g = new DataGenerator(orderId);

        this.orderid = orderId;
        this.placeTime = g.placeTime();
        this.addrLon = g.startLon();
        this.addrLat = g.startLat();
        this.pizzaType = g.pizzaType();
        this.status = g.status();
    }

    /*
    *  Creates a TaxiRide with the given parameters
    * */

    public long orderid;
    public Instant placeTime;
    public float addrLon;
    public float addrLat;
    public short pizzaType;
    public String status;

    @Override
    public String toString() {
        return "Order ID: " + orderid + "," +
                "Place Time: " + placeTime.toString() + "," +
                "addrLon: " + addrLon + "," +
                "addrLat: " + addrLat + "," +
                "pizzaType: " + pizzaType + "," +
                status;
    }

    /*
    * Compares this TaxiRide with the given one
    *
    * <url>
    *       <li> sort by timestamp, </li>
    *       <li> putting START events before END events if they have the same timestamp </li>
    * </ul>
    * */
    public int compareTo(@Nullable PizzaOrder other) {
        if(other == null) {
            return 1;
        }
        if(this.orderid- other.orderid==0) return 0;
        return this.orderid-other.orderid>0? 1:-1;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PizzaOrder && this.orderid == ((PizzaOrder) other).orderid;
    }

    @Override
    public int hashCode() { return (int) this.orderid;}

    public long getPlaceTime() { return placeTime.toEpochMilli();}

}
