package org.osource.scd.parse.consumer;

import java.util.List;

/**
 * @author James
 */
public interface DataConsumer {
    /**
     * 消费数据
     * @param resultList
     * @param sheet
     * @param <T>
     */
    <T> void accept(List<T> resultList, Integer sheet);
}
