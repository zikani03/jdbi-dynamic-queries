package me.zikani.labs.jdbi;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.StringTemplate3StatementLocator;

@RegisterMapper(DataItemMapper.class)
@OverrideStatementLocatorWith(StringTemplate3StatementLocator.class)
public interface DataItemDAO {
    @SqlUpdate
    void createSourceA();

    @SqlUpdate
    void createSourceB();
    
    @SqlQuery
    List<DataItem> findAll(@Define("source")final String source);
    
    @SqlUpdate
    void insert(@Define("source")String source, @Bind("value") double value);
}