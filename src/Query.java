/**
 * Created by Helson Taveras on 4/23/15.
 */
public class Query {

    public String query;
    public int count;

    public Query(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Query{" +
                "query='" + query + '\'' +
                ", count=" + count +
                '}';
    }
}
