package Training_java_SpringBoot.Cat.service.Impl;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;
import Training_java_SpringBoot.Cat.dto.response.CatResponse;
import Training_java_SpringBoot.Cat.entity.CatEntity;
import Training_java_SpringBoot.Cat.repository.CatRepository;
import Training_java_SpringBoot.Cat.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static Training_java_SpringBoot.Cat.service.mapping.CatMapping.convertDtoToEntity;
import static Training_java_SpringBoot.Cat.service.mapping.CatMapping.convertEntityToCatResponse;

@Service
@Slf4j
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public CatResponse create(CatRequest request) {
        log.info("=== Start api create new cat ===");
        log.info("=== Request body:{} === ", request);
        CatEntity catEntity = convertDtoToEntity(request);
        catEntity = catRepository.save(catEntity);
        CatResponse response = convertEntityToCatResponse(catEntity);
        log.info(" === Finish api create new cat . Cat id ===", response.getId());
        return response;
    }
}
