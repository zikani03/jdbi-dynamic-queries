package me.zikani.labs.jdbi;

import java.util.List;
import org.skife.jdbi.v2.DBI;

/**
 * Dynamic queries with jdbi
 *
 */
public class Application {
    final DBI dbi;
    final DataItemDAO dao;
    
    public static void main(String... args) {
        new Application().run();
    }
    
    public Application() {
        dbi = new DBI("jdbc:hsqldb:mem:mymemdb", "sa", "");
        dao = dbi.onDemand(DataItemDAO.class);
    }
    
    public void run() {   
        createTables();
        
        insertRandomData();
        
        List<DataItem> itemsFromA = dao.findAll("source_a");
        List<DataItem> itemsFromB = dao.findAll("source_b");
        
        System.out.println(String.format("Got %s items from A", itemsFromA.size()));
        System.out.println(String.format("Got %s items from B", itemsFromB.size()));
    }
    
    private void createTables() {
        dao.createSourceA();
        dao.createSourceB();
    }
    
    private void insertRandomData() {
        for(int i = 0; i < 50; i++) {
            dao.insert("source_a", Math.random());
        }

        for(int i = 0; i < 20; i++) {
            dao.insert("source_b", Math.random());
        }
    }
}