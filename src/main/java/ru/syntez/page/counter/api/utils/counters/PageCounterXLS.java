package ru.syntez.page.counter.api.utils.counters;

import ru.syntez.page.counter.api.exceptions.PageCounterException;

/**
 * Page counter for XLS file
 *
 * @author Skyhunter
 * @date 12.12.2020
 */
public class PageCounterXLS implements IPageCounter {

    @Override
    public Integer calculatePages(String fileName) throws PageCounterException {
        throw new UnsupportedOperationException("Method is under construction...");
    }
}
