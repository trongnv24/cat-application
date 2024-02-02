package Training_java_SpringBoot.Cat.service;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;
import Training_java_SpringBoot.Cat.dto.response.CatResponse;

public interface CatService {
    CatResponse create(CatRequest request);

    CatResponse getById(String id);

    CatResponse update(CatRequest request, String id);

    void deleteById(String id);
}
