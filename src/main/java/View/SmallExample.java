package View;
import org.neo4j.driver.v1.*;

import Data.Connection;

import static org.neo4j.driver.v1.Values.parameters;

public class SmallExample
{
    // Driver objects are thread-safe and are typically made available application-wide.
    Driver driver;

    public SmallExample(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    private void run()
    {
        // Sessions are lightweight and disposable connection wrappers.
        try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
            try (Transaction tx = session.beginTransaction())
            {
            	tx.run("match (n) detach delete n");
                tx.run("CREATE (ee:Person { name: 'aa', from: 'Việt Nam', klout: 99 })");
                tx.run("CREATE (ef:Person { name: 'ab', from: 'Nga', klout: 52 })");
                tx.success();  // Mark this write as successful.
            }
        }
    }

    private void result(String initial)
    {
        try (Session session = driver.session())
        {
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (a:Person) WHERE a.name = {x} RETURN a.name AS name, a.from AS from",
                    parameters("x", initial));
            // Each Cypher execution returns a stream of records.
            while (result.hasNext())
            {
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                System.out.println(record.get("name").asString());
                System.out.println(record.get("from").asString());
            }
        }
    }

    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }

    public static void main(String... args)
    {
        SmallExample example = new SmallExample(Connection.host,Connection.username,Connection.password);
//        example.run();
        example.result("ab");
        example.close();
    }
}