package Training_java_SpringBoot.Cat.dto.response;

import Training_java_SpringBoot.Cat.dto.request.CatRequest;

public class CatResponse extends CatRequest {
    private String id;

    public CatResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CatResponse{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", age=" + getAge() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
