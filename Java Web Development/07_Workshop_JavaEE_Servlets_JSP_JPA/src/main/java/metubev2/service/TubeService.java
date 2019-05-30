package metubev2.service;

import metubev2.domain.models.service.TubeServiceModel;

public interface TubeService {

    boolean uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeById(String id);

}
