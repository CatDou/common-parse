package org.osource.scd.parse.consumer;

import org.osource.scd.parse.model.LargeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author James
 */
public class SaveService implements Consumer<List<LargeData>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveService.class);

    private int sum = 0;

    @Override
    public void accept(List<LargeData> largeDataList) {
        sum = sum + largeDataList.size();
        LOGGER.info("saved data size {}", largeDataList.size());
        System.out.println(largeDataList);
    }

    @Override
    public Consumer<List<LargeData>> andThen(Consumer<? super List<LargeData>> after) {
        return null;
    }

    public int getSum() {
        return sum;
    }
}
