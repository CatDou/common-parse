package org.osource.scd.parse.consumer;

import org.osource.scd.parse.model.LargeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author James
 */
public class SaveService implements DataConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveService.class);

    private int sum = 0;

    public int getSum() {
        return sum;
    }

    @Override
    public <T> void accept(List<T> resultList, Integer sheet) {
        LOGGER.info("parse sheet {}", sheet);
        sum = sum + resultList.size();
        LOGGER.info("saved data size {}, sum {}", resultList.size(), sum);
    }
}
