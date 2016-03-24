package me.zikani.labs.jdbi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class DataItemMapper implements ResultSetMapper<DataItem> {

    @Override
    public DataItem map(int index, ResultSet rs, StatementContext ctx)
            throws SQLException {
        DataItem dataItem = new DataItem();
        dataItem.id =  rs.getInt(1);
        dataItem.data_value =  rs.getDouble(2);
        return dataItem;
    }
}
