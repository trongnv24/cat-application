package Training_java_SpringBoot.Cat.controller;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;
import Training_java_SpringBoot.Cat.dto.response.CatResponse;
import Training_java_SpringBoot.Cat.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cats")
@Slf4j
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatResponse create(@RequestBody CatRequest request) {
        log.info(" === Start api create new cat === ");
        log.info(" === Request Body : {} === ", request);
        CatResponse response = service.create(request);
        log.info(" === Finish api create new cat, cat id {} : === ", response.getId());
        return response;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatResponse getById(@PathVariable("id") String id) {
        log.info(" === Start api getById new cat === ");
        log.info(" === String id : {} === ", id);
        CatResponse response = service.getById(id);
        log.info(" === Finish api getById cat. Cat id {} : === ", response.getId());
        return response;
    }
}
