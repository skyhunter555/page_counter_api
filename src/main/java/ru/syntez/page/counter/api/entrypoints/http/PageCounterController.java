package ru.syntez.page.counter.api.entrypoints.http;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.syntez.page.counter.api.entities.FilePageCountResult;
import ru.syntez.page.counter.api.entities.http.DocumentsCalculateRequest;
import ru.syntez.page.counter.api.entities.http.DocumentsCalculateResponse;
import ru.syntez.page.counter.api.usecase.PageCounterUsecase;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/page-counter/api/v1")
@Api(value = "hello")
public class PageCounterController {

    private final PageCounterUsecase pageCounterUsecase;

    public PageCounterController(PageCounterUsecase pageCounterUsecase) {
        this.pageCounterUsecase = pageCounterUsecase;
    }

    @PostMapping("calculate-documents")
    @ApiOperation(value = "Подсчитать количество страниц в документах", produces = "application/json")
    public DocumentsCalculateResponse calculate(
            @RequestHeader HttpHeaders header,
            @RequestBody DocumentsCalculateRequest request
    ) {

        try {
            List<FilePageCountResult> result = pageCounterUsecase.execute(request.getDocumentPath());
            return new DocumentsCalculateResponse(
                    result.size(),
                    result.stream().mapToInt(FilePageCountResult::getPageCount).sum()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DocumentsCalculateResponse(0,0);
    }
}
