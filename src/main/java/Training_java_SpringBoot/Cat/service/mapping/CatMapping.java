package Training_java_SpringBoot.Cat.service.mapping;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;
import Training_java_SpringBoot.Cat.dto.response.CatResponse;
import Training_java_SpringBoot.Cat.entity.CatEntity;

public class CatMapping {
    public static CatEntity convertDtoToEntity(CatRequest dto){
       CatEntity entity = new CatEntity();
       entity.setName(dto.getName());
       entity.setBreed(dto.getBreed());
       entity.setAge(dto.getAge());
       entity.setColor(dto.getColor());
       return entity;
    }
    public static CatResponse convertEntityToCatResponse(CatEntity entity){
        CatResponse dto = new CatResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBreed(entity.getBreed());
        dto.setAge(entity.getAge());
        dto.setColor(entity.getColor());
        return dto;
    }
}
