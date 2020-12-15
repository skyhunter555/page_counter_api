package ru.syntez.page.counter.api.usecase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.syntez.page.counter.api.entities.FilePageCountResult;
import ru.syntez.page.counter.api.exceptions.PageCounterException;
import ru.syntez.page.counter.api.utils.counters.IPageCounter;
import ru.syntez.page.counter.api.utils.counters.PageCounterFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Async calculate page count
 *
 * @author Skyhunter
 * @date 12.12.2020
 */
@Service
public class FilePageCounterUsecase {

    private static Logger LOG = LogManager.getLogger(FilePageCounterUsecase.class);

    @Async
    public CompletableFuture<FilePageCountResult> execute(String documentFileName) {

        PageCounterFactory factory = new PageCounterFactory();
        IPageCounter counter;
        try {
            counter = factory.buildParser(documentFileName);
        } catch (PageCounterException e) {
            LOG.error(e.getMessage());
            return CompletableFuture.completedFuture(null);
        }
        try {
            Integer pageCount = counter.calculatePages(documentFileName);
            return CompletableFuture.completedFuture(new FilePageCountResult(documentFileName, pageCount));
        } catch (IOException e) {
            LOG.error(String.format("Error read file %s", documentFileName));
            return CompletableFuture.completedFuture(null);
        } catch (UnsupportedOperationException e) {
            LOG.error(e.getMessage());
            return CompletableFuture.completedFuture(null);
        }
    }

}
