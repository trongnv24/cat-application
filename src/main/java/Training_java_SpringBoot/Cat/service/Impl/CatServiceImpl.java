package Training_java_SpringBoot.Cat.service.Impl;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;
import Training_java_SpringBoot.Cat.dto.response.CatResponse;
import Training_java_SpringBoot.Cat.entity.CatEntity;
import Training_java_SpringBoot.Cat.repository.CatRepository;
import Training_java_SpringBoot.Cat.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.undo.CannotRedoException;
import java.util.Optional;

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
    @Override
    public CatResponse getById(String id) {
        log.info(" === Start api getById car");
        log.info(" === String id:{} === ", id);
        Optional<CatEntity> optionalCat = catRepository.findById(id);
        if (!optionalCat.isPresent()) {
            throw new RuntimeException();
        }
        CatEntity carEntity = optionalCat.get();
        CatResponse response = convertEntityToCatResponse(carEntity);
        log.info(" === Finish api getById car. Car id {} : === ", response.getId());
        return response;
    }
    @Override
    public CatResponse update(CatRequest request, String id) {
        log.info(" === Start api update cat === ");
        log.info(" === Request Body {} :, String id {}: ", request, id);
        Optional<CatEntity> optionalCat = catRepository.findById(id);
        if (!optionalCat.isPresent()) {
            throw new RuntimeException();
        }
        CatEntity catEntity = optionalCat.get();
        catEntity.setName(request.getName());
        catEntity.setBreed(request.getBreed());
        catEntity.setAge(request.getAge());
        catEntity.setColor(request.getColor());
        catEntity = catRepository.save(catEntity);
        CatResponse response = convertEntityToCatResponse(catEntity);
        log.info(" === Finish api update cat. Cat id {}: ", response.getId());
        return response;
    }
    @Override
    public void deleteById(String id){
        log.info(" === Start api update cat === ");
        log.info(" === String id {} : === ", id);
        Optional<CatEntity> optionalCat = catRepository.findById(id);
        if (!optionalCat.isPresent()){
            throw new CannotRedoException();
        }
        log.info(" === Finish api delete cat, Cat id {} : === ");
        catRepository.deleteById(id);

    }
}
