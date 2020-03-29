package com.example.SampleAPI.testlib;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvURLDataSet;
import org.springframework.core.io.Resource;

import java.net.URL;

/**
 * This is a class for loading csv as test data.
 */
public class CsvDataSetLoader extends AbstractDataSetLoader {
    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        String path = resource.getURL().toString();

        path = path.replace("main", "test");
        return new CsvURLDataSet(new URL(path));
    }
}
