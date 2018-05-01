import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartC{

   private static final String table_name1 = "powers"; 
    
   public static void main(String[] args) throws IOException {

       //TODO
       Configuration config = HBaseConfiguration.create();
       
       // Instantiating HTable class
       HTable hTable = new HTable(config, table_name1);
       
       // Put data
       Put p = new Put(Bytes.toBytes("row1"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("batman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("100"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("black"));
       hTable.put(p);
       
       
       // 2nd row
       p = new Put(Bytes.toBytes("row2"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("run"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("superman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("10"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row3"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("eat"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("bananaman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("30"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("yellow"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row4"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("spiderman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("45"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row5"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("run"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("superman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("10"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row6"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("maybe"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fight"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("brave"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("45"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("blue"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row7"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("wash"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("cinderella"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("12"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("pink"));
       hTable.put(p);

       p = new Put(Bytes.toBytes("row8"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("freeze"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("elisa"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("34"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("white"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row9"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("steal"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("robinhood"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("67"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("green"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row10"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("think"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("gandalf"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("86"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("grey"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row11"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("run"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("catman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("84"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("brown"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row12"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("catch"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("dogman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("47"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("brown"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row13"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("maybe"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("stink"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("eggman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("58"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("white"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row14"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("maybe"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("swim"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("fishman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("58"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("blue"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row15"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("birdman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("2"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("grey"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row16"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("fly"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("flyman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("32"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("black"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row17"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("stay"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("sofaman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("77"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row18"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("maybe"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("scream"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("beast"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("33"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("brown"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row19"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("hide"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("goblin"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("67"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("green"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row20"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("smile"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("charming"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("97"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("white"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row21"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("stink"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("shrek"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("32"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("green"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row22"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("eat"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("appleman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("25"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("red"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row23"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("maybe"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("grow"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("spinachman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("65"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("green"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row24"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("no"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("hide"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("antman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("37"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("black"));
       hTable.put(p);
       
       p = new Put(Bytes.toBytes("row25"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("hero"),Bytes.toBytes("yes"));
       p.add(Bytes.toBytes("personal"),Bytes.toBytes("power"),Bytes.toBytes("steal"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),Bytes.toBytes("mouseman"));
       p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),Bytes.toBytes("76"));
       p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),Bytes.toBytes("grey"));
       hTable.put(p);
       
       
       System.out.println("Inserted data");
       
       hTable.close();
   }
}

